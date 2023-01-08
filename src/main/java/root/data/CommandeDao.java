package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import root.model.Commande;
import root.model.Producteur;

/**
 * Cette classe est utilisée pour accéder à la table Commande.
 */
public class CommandeDao extends Dao<Commande, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public CommandeDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param commande Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Commande commande) {
    try {
      String query = "INSERT INTO Commande "
          + "(libelle, poids, dateCom, heureDeb, heureFin, SIRET, idClient) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query,
          Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, commande.getLibelle());
      preparedStatement.setDouble(2, commande.getPoids());
      preparedStatement.setDate(3, commande.getDateCom());
      preparedStatement.setTime(4, commande.getHeureDeb());
      preparedStatement.setTime(5, commande.getHeureFin());
      preparedStatement.setString(6, commande.getProducteur().getSiret());
      preparedStatement.setInt(7, commande.getClient().getIdClient());

      preparedStatement.executeUpdate();

      // Met à jour l'id du modèle inséré
      ResultSet key = preparedStatement.getGeneratedKeys();
      if (!key.next()) {
        return false;
      }
      int idInsere = key.getInt(1);
      commande.setNumCom(idInsere);

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   */
  @Override
  public Commande get(Integer id) {
    try {
      String query = "SELECT * FROM Commande WHERE numCom = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet resultat = preparedStatement.executeQuery();

      return resultat.next() ? new Commande(
          resultat.getInt("numCom"),
          resultat.getString("libelle"),
          resultat.getInt("poids"),
          resultat.getDate("dateCom"),
          resultat.getTime("heureDeb"),
          resultat.getTime("heureFin"),
          new ProducteurDao(connexion).get(resultat.getString("SIRET")),
          new ClientDao(connexion).get(resultat.getInt("idClient")))
          : null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Commande> getAll() {
    try {
      String query = "SELECT * FROM Commande";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Commande> commandes = new ArrayList<>();

      while (resultat.next()) {
        commandes.add(new Commande(
            resultat.getInt("numCom"),
            resultat.getString("libelle"),
            resultat.getInt("poids"),
            resultat.getDate("dateCom"),
            resultat.getTime("heureDeb"),
            resultat.getTime("heureFin"),
            new ProducteurDao(connexion).get((resultat.getString("SIRET"))),
            new ClientDao(connexion).get(resultat.getInt("idClient")),
            resultat.getInt("numTournee")));
      }
      return commandes;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Récupération de tous les enregistrements de la table qui font partie d'une tournée.
   *
   * @param numTournee Le numéro de la tournée dont sont associées les commandes.
   * @return Les commandes associées à la tournée.
   */
  public ArrayList<Commande> getAllByNumTournee(int numTournee) {
    try {
      String query = "SELECT * FROM Commande WHERE numTournee = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, numTournee);
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Commande> commandes = new ArrayList<>();

      while (resultat.next()) {
        commandes.add(new Commande(
            resultat.getInt("numCom"),
            resultat.getString("libelle"),
            resultat.getInt("poids"),
            resultat.getDate("dateCom"),
            resultat.getTime("heureDeb"),
            resultat.getTime("heureFin"),
            new ProducteurDao(connexion).get((resultat.getString("SIRET"))),
            new ClientDao(connexion).get(resultat.getInt("idClient")),
            numTournee,
            resultat.getInt("ordreTournee")));
      }
      return commandes;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param commande Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Commande commande) {
    try {
      String query = "UPDATE Commande SET libelle = ?, poids = ?, dateCom = ?, "
          + "heureDeb = ?, heureFin = ?, SIRET = ?, idClient = ?, numTournee = ?, "
          + "ordreTournee = ? WHERE numCom = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, commande.getLibelle());
      preparedStatement.setDouble(2, commande.getPoids());
      preparedStatement.setDate(3, commande.getDateCom());
      preparedStatement.setTime(4, commande.getHeureDeb());
      preparedStatement.setTime(5, commande.getHeureFin());
      preparedStatement.setString(6, commande.getProducteur().getSiret());
      preparedStatement.setInt(7, commande.getClient().getIdClient());
      if (commande.getNumTournee() > 0) {
        preparedStatement.setInt(8, commande.getNumTournee());
        if (commande.getOrdreTournee() > 0) {
          preparedStatement.setInt(9, commande.getOrdreTournee());
        } else {
          preparedStatement.setNull(9, Types.INTEGER);
        }
      } else {
        preparedStatement.setNull(8, Types.INTEGER);
        preparedStatement.setNull(9, Types.INTEGER);
      }
      preparedStatement.setInt(10, commande.getNumCom());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param commande Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Commande commande) {
    try {
      String query = "DELETE FROM Commande WHERE numCom = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, commande.getNumCom());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public void disconect() {
    super.connexion = null;
  }

  /**
   * Récupération de toutes les commandes d'un producteur.
   *
   * @param producteur Le producteur dont on veut récupérer les commandes.
   * @return La liste des commandes du producteur.
   */
  public ArrayList<Commande> getAllByProducteur(Producteur producteur) {
    try {
      String query = "SELECT * FROM Commande WHERE SIRET = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getSiret());
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Commande> commandes = new ArrayList<>();

      while (resultat.next()) {
        commandes.add(new Commande(
            resultat.getInt("numCom"),
            resultat.getString("libelle"),
            resultat.getInt("poids"),
            resultat.getDate("dateCom"),
            resultat.getTime("heureDeb"),
            resultat.getTime("heureFin"),
            new ProducteurDao(connexion).get((resultat.getString("SIRET"))),
            new ClientDao(connexion).get(resultat.getInt("idClient")),
            resultat.getInt("numTournee")));
      }
      return commandes;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Récupération de toutes les commandes futures d'un producteur.
   *
   * @param producteur Le producteur dont on veut récupérer les commandes futures.
   * @return La liste des commandes futures du producteur.
   */
  public ArrayList<Commande> getCommandeCourante(Producteur producteur) {
    try {
      String query = "SELECT * FROM Commande WHERE SIRET = ? AND dateCom = CURDATE() - 1";
      ;
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getSiret());
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Commande> commandes = new ArrayList<>();

      while (resultat.next()) {
        commandes.add(new Commande(
            resultat.getInt("numCom"),
            resultat.getString("libelle"),
            resultat.getInt("poids"),
            resultat.getDate("dateCom"),
            resultat.getTime("heureDeb"),
            resultat.getTime("heureFin"),
            new ProducteurDao(connexion).get((resultat.getString("SIRET"))),
            new ClientDao(connexion).get(resultat.getInt("idClient")),
            resultat.getInt("numTournee"),
            resultat.getInt("ordreTournee")));
      }
      return commandes;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
