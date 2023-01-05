package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import root.model.Producteur;
import root.model.Vehicule;

/**
 * Cette classe est utilisée pour accéder à la table Véhicule.
 */
public class VehiculeDao extends Dao<Vehicule, String> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public VehiculeDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param vehicule Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Vehicule vehicule) {
    try {
      String query = "INSERT INTO Vehicule (immat, poidsMax, SIRET) VALUES (?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, vehicule.getImmat());
      preparedStatement.setInt(2, vehicule.getPoidsMax());
      preparedStatement.setString(3, vehicule.getProprietaire().getSiret());
      preparedStatement.executeUpdate();

      ResultSet key = preparedStatement.getGeneratedKeys();
      if (!key.next()) {
        return false;
      }
      String immatInsere = key.getString(1);
      vehicule.setImmat(immatInsere);

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param immat Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Vehicule get(String immat) {
    try {
      String query = "SELECT * FROM Vehicule WHERE immat = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, immat);

      ResultSet resultat = preparedStatement.executeQuery();

      return (resultat.next()) ? new Vehicule(
          resultat.getString("immat").isEmpty() ? null : resultat.getString("immat"),
          resultat.getInt("poidsMax") == 0 ? null : resultat.getInt("poidsMax"),
          new ProducteurDao(connexion).get(resultat.getString("SIRET")))
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
  public ArrayList<Vehicule> getAll() {
    try {
      String query = "SELECT * FROM Vehicule";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Vehicule> vehicules = new ArrayList<>();

      while (resultat.next()) {
        vehicules.add(new Vehicule(
            resultat.getString("immat"),
            resultat.getInt("poidsMax"),
            new ProducteurDao(connexion).get(resultat.getString("SIRET"))));
      }
      return vehicules;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param vehicule Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Vehicule vehicule) {
    try {
      String query = "UPDATE Vehicule SET poidsMax = ?, SIRET = ? WHERE immat = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, vehicule.getPoidsMax());
      preparedStatement.setString(2, vehicule.getProprietaire().getSiret());
      preparedStatement.setString(3, vehicule.getImmat());
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
   * @param vehicule Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Vehicule vehicule) {
    try {
      String query = "DELETE FROM Vehicule WHERE immat = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, vehicule.getImmat());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Récupération de tous les véhicules d'un producteur.
   *
   * @param producteur Producteur dont on veut récupérer les véhicules
   * @return Liste des véhicules
   */
  public ArrayList<Vehicule> getAllByProducteur(Producteur producteur) {
    try {
      String query = "SELECT * FROM Vehicule WHERE SIRET = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getSiret());
      ResultSet resultat = preparedStatement.executeQuery();

      ArrayList<Vehicule> vehicules = new ArrayList<>();

      while (resultat.next()) {
        vehicules.add(new Vehicule(
            resultat.getString("immat"),
            resultat.getInt("poidsMax"),
            new ProducteurDao(connexion).get(resultat.getString("SIRET"))));
      }
      return vehicules;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
