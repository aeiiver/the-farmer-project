package root.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import root.model.Tournee;

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
      String query = "INSERT INTO Tournee "
          + "(numTournee, libelle, heureMin, heureMax, immat) "
          + "VALUES (?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, tournee.getNumTournee());
      preparedStatement.setString(2, tournee.getLibelle());
      preparedStatement.setTime(3, tournee.getHeureMin());
      preparedStatement.setTime(4, tournee.getHeureMin());
      preparedStatement.setString(5, tournee.getVehicule().getImmat());
      preparedStatement.executeUpdate();
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
      return new Tournee(
          preparedStatement.executeQuery().getInt("numTournee"),
          preparedStatement.executeQuery().getString("libelle"),
          preparedStatement.executeQuery().getTime("heureMin"),
          preparedStatement.executeQuery().getTime("heureMax"),
          new ProducteurDao(connexion).get(preparedStatement.executeQuery().getString("SIRET")),
          new VehiculeDao(connexion).get(preparedStatement.executeQuery().getString("immat")));
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
      ArrayList<Tournee> tournees = new ArrayList<>();
      while (preparedStatement.executeQuery().next()) {
        tournees.add(new Tournee(
            preparedStatement.executeQuery().getInt("numTournee"),
            preparedStatement.executeQuery().getString("libelle"),
            preparedStatement.executeQuery().getTime("heureMin"),
            preparedStatement.executeQuery().getTime("heureMax"),
            new ProducteurDao(connexion).get(preparedStatement.executeQuery().getString("SIRET")),
            new VehiculeDao(connexion).get(preparedStatement.executeQuery().getString("immat"))));
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
      String query = "UPDATE Tournee SET "
          + "libelle = ?, heureMin = ?, heureMax = ?, immat = ? "
          + "WHERE numTournee = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, tournee.getLibelle());
      preparedStatement.setTime(2, tournee.getHeureMin());
      preparedStatement.setTime(3, tournee.getHeureMin());
      preparedStatement.setString(4, tournee.getVehicule().getImmat());
      preparedStatement.setInt(5, tournee.getNumTournee());
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
   * @param tournee Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Tournee tournee) {
    try {
      String query = "DELETE FROM Tournee WHERE numTournee = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, tournee.getNumTournee());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
