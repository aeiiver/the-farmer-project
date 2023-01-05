package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Cette classe est utilisée pour accéder à la table Tournee.
 */
public class TourneeDao extends Dao<Tournee, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public TourneeDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param tournee Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Tournee tournee) {
    try {
      connexion.setAutoCommit(false);

      // Insère la tournée
      String query = "INSERT INTO Tournee "
          + "(libelle, heureMin, heureMax, immat) "
          + "VALUES (?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query,
          Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, tournee.getLibelle());
      preparedStatement.setTime(2, tournee.getHeureMin());
      preparedStatement.setTime(3, tournee.getHeureMax());
      preparedStatement.setString(4, tournee.getVehicule().getImmat());
      preparedStatement.executeUpdate();

      // Met à jour le numéro de la tournée insérée
      ResultSet key = preparedStatement.getGeneratedKeys();
      if (!key.next()) {
        return false;
      }
      int idInsere = key.getInt(1);
      tournee.setNumTournee(idInsere);

      // Met à jour les commandes qui ont été associées à la tournée dans la base
      query = "UPDATE Commande SET numTournee = ? WHERE numCom = ?;";
      preparedStatement = connexion.prepareStatement(query);

      for (Commande commande : tournee.getCommandes()) {
        preparedStatement.setInt(1, tournee.getNumTournee());
        preparedStatement.setInt(2, commande.getNumCom());
        preparedStatement.addBatch();
      }
      preparedStatement.executeBatch();
      connexion.commit();

      connexion.setAutoCommit(true);
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
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Tournee get(Integer id) {
    try {
      String query = "SELECT * FROM Tournee WHERE numTournee = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet resultat = preparedStatement.executeQuery();

      if (!resultat.next()) {
        return null;
      }

      Vehicule vehicule = new VehiculeDao(connexion).get(resultat.getString("immat"));

      Tournee tournee = new Tournee(
          resultat.getInt("numTournee"),
          resultat.getString("libelle"),
          resultat.getTime("heureMin"),
          resultat.getTime("heureMax"),
          vehicule.getProprietaire(),
          vehicule);
      tournee.setCommandes(new CommandeDao(connexion).getAllByNumTournee(id));

      return tournee;

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
  public ArrayList<Tournee> getAll() {
    try {
      String query = "SELECT * FROM Tournee";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Tournee> tournees = new ArrayList<>();

      while (resultat.next()) {
        int id = resultat.getInt("numTournee");
        Vehicule vehicule = new VehiculeDao(connexion).get(resultat.getString("immat"));

        Tournee tournee = new Tournee(
            id,
            resultat.getString("libelle"),
            resultat.getTime("heureMin"),
            resultat.getTime("heureMax"),
            vehicule.getProprietaire(),
            vehicule);
        tournee.setCommandes(new CommandeDao(connexion).getAllByNumTournee(id));

        tournees.add(tournee);
      }
      return tournees;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param tournee Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Tournee tournee) {
    try {
      connexion.setAutoCommit(false);

      // Met à jour la tournée dans la base
      String query = "UPDATE Tournee SET "
          + "libelle = ?, heureMin = ?, heureMax = ?, immat = ? "
          + "WHERE numTournee = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);

      preparedStatement.setString(1, tournee.getLibelle());
      preparedStatement.setTime(2, tournee.getHeureMin());
      preparedStatement.setTime(3, tournee.getHeureMax());
      preparedStatement.setString(4, tournee.getVehicule().getImmat());
      preparedStatement.setInt(5, tournee.getNumTournee());
      preparedStatement.executeUpdate();

      // Supprime les associations entre la tournée et les commandes qui lui ont été associées.
      query = "UPDATE Commande SET numTournee = NULL WHERE numTournee = ?;";
      preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, tournee.getNumTournee());
      preparedStatement.executeUpdate();

      // Met à jour les commandes qui ont été associées à la tournée dans la base
      query = "UPDATE Commande SET numTournee = ? WHERE numCom = ?;";
      preparedStatement = connexion.prepareStatement(query);

      for (Commande commande : tournee.getCommandes()) {
        preparedStatement.setInt(1, tournee.getNumTournee());
        preparedStatement.setInt(2, commande.getNumCom());
        preparedStatement.addBatch();
      }
      preparedStatement.executeBatch();
      connexion.commit();

      connexion.setAutoCommit(true);
      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param tournee Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Tournee tournee) {
    try {
      // Supprime les associations entre la tournée et les commandes qui lui ont été associées.
      String query = "UPDATE Commande SET numTournee = NULL WHERE numTournee = ?;";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, tournee.getNumTournee());
      preparedStatement.executeUpdate();

      // Supprime la tournée de la base
      query = "DELETE FROM Tournee WHERE numTournee = ?";
      preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, tournee.getNumTournee());
      preparedStatement.executeUpdate();

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Récupération de toutes les tournées d'un producteur.
   *
   * @param producteur Producteur dont on veut récupérer les tournées
   * @return Liste des tournées du producteur
   */
  public ArrayList<Tournee> getAllByProducteur(Producteur producteur) {
    try {
      String query = "SELECT * FROM Tournee INNER JOIN Commande USING(numTournee) WHERE SIRET = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getSiret());
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Tournee> tournees = new ArrayList<>();

      while (resultat.next()) {
        int id = resultat.getInt("numTournee");
        Vehicule vehicule = new VehiculeDao(connexion).get(resultat.getString("immat"));

        Tournee tournee = new Tournee(
            id,
            resultat.getString("libelle"),
            resultat.getTime("heureMin"),
            resultat.getTime("heureMax"),
            producteur,
            vehicule);
        tournee.setCommandes(new CommandeDao(connexion).getAllByNumTournee(id));

        tournees.add(tournee);
      }
      return tournees;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Récupération de toutes les tournées futures d'un producteur.
   *
   * @param producteur Producteur dont on veut récupérer les tournées futures
   * @return Liste des tournées futures du producteur
   */
  public ArrayList<Tournee> getTourneeCourante(Producteur producteur) {
    try {
      String query = "SELECT * FROM Tournee INNER JOIN Commande "
          + "USING(numTournee) WHERE SIRET = ? AND dateCom > CURDATE() - 1";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getSiret());
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Tournee> tournees = new ArrayList<>();

      while (resultat.next()) {
        int id = resultat.getInt("numTournee");
        Vehicule vehicule = new VehiculeDao(connexion).get(resultat.getString("immat"));

        Tournee tournee = new Tournee(
            id,
            resultat.getString("libelle"),
            resultat.getTime("heureMin"),
            resultat.getTime("heureMax"),
            producteur,
            vehicule);
        tournee.setCommandes(new CommandeDao(connexion).getAllByNumTournee(id));

        tournees.add(tournee);
      }
      return tournees;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
