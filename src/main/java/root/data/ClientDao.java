package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import root.model.Client;

/**
 * Cette classe est utilisée pour accéder à la classe Client.
 */
public class ClientDao extends Dao<Client, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public ClientDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param client Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Client client) {
    try {
      String query = "INSERT INTO Client "
          + "(idClient, nomClient, prenomClient, numTel, gps, idAdresse) "
          + "VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, client.getIdClient());
      preparedStatement.setString(2, client.getNom());
      preparedStatement.setString(3, client.getPrenom());
      preparedStatement.setString(4, client.getGps());
      preparedStatement.setString(5, client.getNumTel());
      preparedStatement.setInt(6, client.getAdresse().getIdAdresse());
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
  public Client get(Integer id) {
    try {
      String query = "SELECT * FROM Client WHERE idClient = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, id);
      return new Client(
          preparedStatement.executeQuery().getInt("idClient"),
          preparedStatement.executeQuery().getString("nomClient"),
          preparedStatement.executeQuery().getString("prenomClient"),
          preparedStatement.executeQuery().getString("numTel"),
          preparedStatement.executeQuery().getString("gps"),
          new AdresseDao(connexion).get(preparedStatement.executeQuery().getInt("idAdresse")));
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
  public ArrayList<Client> getAll() {
    try {
      String query = "SELECT * FROM Client";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ArrayList<Client> clients = new ArrayList<>();
      while (preparedStatement.executeQuery().next()) {
        clients.add(new Client(
            preparedStatement.executeQuery().getInt("idClient"),
            preparedStatement.executeQuery().getString("nomClient"),
            preparedStatement.executeQuery().getString("prenomClient"),
            preparedStatement.executeQuery().getString("numTel"),
            preparedStatement.executeQuery().getString("gps"),
            new AdresseDao(connexion).get(preparedStatement.executeQuery().getInt("idAdresse"))));
      }
      return clients;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param client Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Client client) {
    try {
      String query = "UPDATE Client SET nomClient = ?, prenomClient = ?, "
          + "numTel = ?, gps = ?, idAdresse = ? WHERE idClient = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, client.getNom());
      preparedStatement.setString(2, client.getPrenom());
      preparedStatement.setString(3, client.getNumTel());
      preparedStatement.setString(4, client.getGps());
      preparedStatement.setInt(5, client.getAdresse().getIdAdresse());
      preparedStatement.setInt(6, client.getIdClient());
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
   * @param client Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Client client) {
    try {
      String query = "DELETE FROM Client WHERE idClient = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, client.getIdClient());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
