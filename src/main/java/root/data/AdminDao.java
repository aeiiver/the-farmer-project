package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import root.model.Admin;

/**
 * Cette classe est utilisée pour accéder à la table Admin.
 */
public class AdminDao extends Dao<Admin, String> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public AdminDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param admin Modèle à insérer
   * @return True si l'insertion a réussi, false sinon
   */
  @Override
  public boolean insert(Admin admin) {
    try {
      String query = "INSERT INTO Admin (mail, pseudo, mdp) VALUES (?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, admin.getMail());
      preparedStatement.setString(2, admin.getPseudo());
      preparedStatement.setString(3, admin.getMdp());
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
   * <p>'id' peut être un pseeudo ou une adresse email.</p>
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Admin get(String id) {
    try {
      String query = "SELECT * FROM Admin WHERE mail = ? OR pseudo = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, id);
      preparedStatement.setString(2, id);

      ResultSet result = preparedStatement.executeQuery();

      return result.next() ? new Admin(
          result.getInt("idAdmin"), result.getString("mail"),
          result.getString("pseudo"), result.getString("mdp")
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
  public ArrayList<Admin> getAll() {
    try {
      String query = "SELECT * FROM Admin";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ArrayList<Admin> admins = new ArrayList<>();
      while (preparedStatement.executeQuery().next()) {
        admins.add(new Admin(
            preparedStatement.executeQuery().getInt("idAdmin"), preparedStatement.executeQuery().getString("mail"),
            preparedStatement.executeQuery().getString("pseudo"), preparedStatement.executeQuery().getString("mdp")
        ));
      }
      return admins;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param admin Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Admin admin) {
    try {
      String query = "UPDATE Admin SET mail = ?, pseudo = ?, mdp = ? WHERE idAdmin = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, admin.getMail());
      preparedStatement.setString(2, admin.getPseudo());
      preparedStatement.setString(3, admin.getMdp());
      preparedStatement.setInt(4, admin.getIdAdmin());
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
   * @param admin Modèle à supprimer
   * @return true si la suppression a réussi, false sinon
   */
  @Override
  public boolean delete(Admin admin) {
    try {
      String query = "DELETE FROM Admin WHERE idAdmin = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setInt(1, admin.getIdAdmin());
      preparedStatement.executeUpdate();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
