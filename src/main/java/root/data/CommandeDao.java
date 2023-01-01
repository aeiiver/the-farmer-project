package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import root.model.Commande;

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
      return new Commande(
          preparedStatement.executeQuery().getInt("numCom"),
          preparedStatement.executeQuery().getString("libelle"),
          preparedStatement.executeQuery().getInt("poids"),
          preparedStatement.executeQuery().getDate("dateCom"),
          preparedStatement.executeQuery().getTime("heureDeb"),
          preparedStatement.executeQuery().getTime("heureFin"),
          new ProducteurDao(connexion).get(preparedStatement.executeQuery().getString("SIRET")),
          new ClientDao(connexion).get(preparedStatement.executeQuery().getInt("idClient")));
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
            new ClientDao(connexion).get(resultat.getInt("idClient"))));
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
          + "heureDeb = ?, heureFin = ?, SIRET = ?, idClient = ? WHERE numCom = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, commande.getLibelle());
      preparedStatement.setDouble(2, commande.getPoids());
      preparedStatement.setDate(3, commande.getDateCom());
      preparedStatement.setTime(4, commande.getHeureDeb());
      preparedStatement.setTime(5, commande.getHeureFin());
      preparedStatement.setString(6, commande.getProducteur().getSiret());
      preparedStatement.setInt(7, commande.getClient().getIdClient());
      preparedStatement.setInt(8, commande.getNumCom());
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
  
}
