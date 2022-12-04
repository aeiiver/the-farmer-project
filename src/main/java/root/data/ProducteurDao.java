package root.data;

import java.sql.Connection;
import java.util.ArrayList;
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
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Producteur get(String id) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Producteur> getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param producteur Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Producteur producteur) {
    return false;
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

}
