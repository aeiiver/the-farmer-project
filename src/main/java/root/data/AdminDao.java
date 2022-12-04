package root.data;

import java.sql.Connection;
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
   * @param model Modèle à insérer
   * @return True si l'insertion a réussi, false sinon
   */

  @Override
  public boolean insert(Admin model) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Admin get(String id) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Admin> getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param model Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Admin model) {
    return false;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param model Modèle à supprimer
   * @return true si la suppression a réussi, false sinon
   */
  @Override
  public boolean delete(Admin model) {
    return false;
  }

}
