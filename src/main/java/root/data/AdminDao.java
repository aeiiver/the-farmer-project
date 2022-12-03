package root.data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est utilisée pour accéder à la table Admin.
 *
 * @param <Model> Model utilisé pour la table
 * @param <IdType> Type de l'identifiant de la table
 */
public class AdminDao<Model, IdType> extends Dao<Model, IdType> {
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
   */

  @Override
  public boolean insert(Model model) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   */

  @Override
  public Model get(IdType id) {
    return null;
  }

  @Override
  public ArrayList<Model> getAll() {
    return null;
  }
  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param model Modèle à mettre à jour
   */

  @Override
  public boolean update(Model model) {
    return false;
  }
  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param model Modèle à supprimer
   */

  @Override
  public boolean delete(Model model) {
    return false;
  }
}