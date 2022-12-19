package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import root.model.Adresse;

/**
 * Cette classe est utilisée pour accéder à la classe Adresse.
 */
public class AdresseDao extends Dao<Adresse, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public AdresseDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param adresse Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Adresse adresse) {
    try {
      String query = "INSERT INTO Adresse "
          + "(pays, codePost, ville, voie, nom, numero, mention, complement) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, adresse.getPays());
      preparedStatement.setString(2, adresse.getCodePost());
      preparedStatement.setString(3, "");
      preparedStatement.setString(4, adresse.getVoie());
      preparedStatement.setString(5, adresse.getNom());
      preparedStatement.setInt(6, adresse.getNumero());
      preparedStatement.setString(7, adresse.getMention());
      preparedStatement.setString(8, adresse.getComplement());
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
  public Adresse get(Integer id) {
    try {
      String query = "SELECT * FROM Adresse WHERE idAdresse = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, id);
      return preparedStatement.executeQuery().next() ? new Adresse(
          preparedStatement.executeQuery().getInt("idAdresse"),
          preparedStatement.executeQuery().getString("pays"),
          preparedStatement.executeQuery().getString("codePost"),
          preparedStatement.executeQuery().getString("voie"),
          preparedStatement.executeQuery().getString("nom"),
          preparedStatement.executeQuery().getInt("numero"),
          preparedStatement.executeQuery().getString("mention"),
          preparedStatement.executeQuery().getString("complement")
      ) : null;
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
  public ArrayList<Adresse> getAll() {
    try {
      String query = "SELECT * FROM Adresse";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ArrayList<Adresse> adresses = new ArrayList<>();
      while (preparedStatement.executeQuery().next()) {
        adresses.add(new Adresse(
            preparedStatement.executeQuery().getInt("idAdresse"),
            preparedStatement.executeQuery().getString("pays"),
            preparedStatement.executeQuery().getString("codePost"),
            preparedStatement.executeQuery().getString("voie"),
            preparedStatement.executeQuery().getString("nom"),
            preparedStatement.executeQuery().getInt("numero"),
            preparedStatement.executeQuery().getString("mention"),
            preparedStatement.executeQuery().getString("complement")
        ));
      }
      return adresses;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param adresse Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Adresse adresse) {
    try {
      String query = "DELETE FROM Adresse WHERE idAdresse = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, adresse.getIdAdresse());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param adresse Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Adresse adresse) {
    try {
      String query = "UPDATE Adresse SET "
          + "pays = ?, codePost = ?, voie = ?, nom = ?, numero = ?, "
          + "mention = ?, complement = ? WHERE idAdresse = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, adresse.getPays());
      preparedStatement.setString(2, adresse.getCodePost());
      preparedStatement.setString(3, adresse.getVoie());
      preparedStatement.setString(4, adresse.getNom());
      preparedStatement.setInt(5, adresse.getNumero());
      preparedStatement.setString(6, adresse.getMention());
      preparedStatement.setString(7, adresse.getComplement());
      preparedStatement.setInt(8, adresse.getIdAdresse());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
}
