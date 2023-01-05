package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
      /*String query = "INSERT INTO Client "
          + "(idClient, nomClient, prenomClient, numTel, gps, idAdresse) "
          + "VALUES (?, ?, ?, ?, ?, ?)";*/
      String query = "INSERT INTO Client "
              + "(nomClient, prenomClient, numTel, gps, idAdresse) "
              + "VALUES (?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      /*
      preparedStatement.setInt(1, client.getIdClient());
      preparedStatement.setString(2, client.getNom());
      preparedStatement.setString(3, client.getPrenom());
      preparedStatement.setString(4, client.getNumTel());
      preparedStatement.setString(5, client.getGps());
      preparedStatement.setInt(6, client.getAdresse().getIdAdresse());
      */
      preparedStatement.setString(1, client.getNom());
      preparedStatement.setString(2, client.getPrenom());
      preparedStatement.setString(3, client.getNumTel());
      preparedStatement.setString(4, client.getGps());
      preparedStatement.setInt(5, client.getAdresse().getIdAdresse());
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
      ResultSet resultat = preparedStatement.executeQuery();

      return !resultat.next() ? null : new Client(
          resultat.getInt("idClient"),
          resultat.getString("nomClient"),
          resultat.getString("prenomClient"),
          resultat.getString("numTel"),
          resultat.getString("gps"),
          new AdresseDao(connexion).get(resultat.getInt("idAdresse")));

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
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Client> clients = new ArrayList<>();

      while (resultat.next()) {
        clients.add(
            new Client(
                resultat.getInt("idClient"),
                resultat.getString("nomClient"),
                resultat.getString("prenomClient"),
                resultat.getString("numTel"),
                resultat.getString("gps"),
                new AdresseDao(connexion).get(resultat.getInt("idAdresse"))));
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
