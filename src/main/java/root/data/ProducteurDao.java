package root.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import root.model.Producteur;

/**
 * Cette classe est utilisée pour accéder à la table Producteur.
 */
public class ProducteurDao extends Dao<Producteur, String> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public ProducteurDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param producteur Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Producteur producteur) {
    String sel = BCrypt.gensalt();
    String mdpChiffre = BCrypt.hashpw(producteur.getMdp(), sel);

    try {
      String query = "INSERT INTO Producteur "
          + "(SIRET, mail, nomProd, prenomProd, numTel, mdp, idAdresse) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connexion.prepareStatement(query,
          PreparedStatement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, producteur.getSiret());
      preparedStatement.setString(2, producteur.getMail());
      preparedStatement.setString(3, producteur.getNom());
      preparedStatement.setString(4, producteur.getPrenom());
      preparedStatement.setString(5, producteur.getNumTel());
      preparedStatement.setString(6, mdpChiffre);
      preparedStatement.setInt(7, producteur.getAdresse().getIdAdresse());

      preparedStatement.executeUpdate();

      ResultSet key = preparedStatement.getGeneratedKeys();
      if (!key.next()) {
        return false;
      }
      int idInsere = key.getInt(1);
      producteur.setSiret(String.valueOf(idInsere));
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * <p>'id' peut être un SIRET ou une adresse email.</p>
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Producteur get(String id) {
    try {
      String query = "SELECT * FROM Producteur WHERE SIRET = ? OR mail = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, id);
      preparedStatement.setString(2, id);

      ResultSet result = preparedStatement.executeQuery();

      return (result.next()) ? new Producteur(
          result.getString("SIRET"), result.getString("mail"),
          result.getString("nomProd"), result.getString("prenomProd"), result.getString("numTel"),
          result.getString("mdp"),
          new AdresseDao(connexion).get(result.getInt("idAdresse"))
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
  public ArrayList<Producteur> getAll() {
    try {
      String query = "SELECT * FROM Producteur";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      ResultSet rs = preparedStatement.executeQuery();
      ArrayList<Producteur> producteurs = new ArrayList<>();

      while (rs.next()) {
        producteurs.add(new Producteur(
            rs.getString("SIRET"),
            rs.getString("mail"),
            rs.getString("nomProd"),
            rs.getString("prenomProd"),
            rs.getString("numTel"),
            rs.getString("mdp"),
            new AdresseDao(connexion).get(rs.getInt("idAdresse"))
        ));
      }
      return producteurs;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param producteur Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Producteur producteur) {
    try {
      String query = "UPDATE Producteur SET "
          + "mail = ?, nomProd = ?, prenomProd = ?, numTel = ?, mdp = ?, idAdresse = ? "
          + "WHERE SIRET = ?";
      PreparedStatement preparedStatement = connexion.prepareStatement(query);
      preparedStatement.setString(1, producteur.getMail());
      preparedStatement.setString(2, producteur.getNom());
      preparedStatement.setString(3, producteur.getPrenom());
      preparedStatement.setString(4, producteur.getNumTel());
      preparedStatement.setString(5, producteur.getMdp());
      preparedStatement.setInt(6, producteur.getAdresse().getIdAdresse());
      preparedStatement.setString(7, producteur.getSiret());
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
   * @param producteur Modèle à supprimer
   * @return true si la suppression a réussi, false sinon
   */
  @Override
  public boolean delete(Producteur producteur) {
    return false;
  }

  @Override
  public void discnonect() {
    super.connexion = null;
  }

}
