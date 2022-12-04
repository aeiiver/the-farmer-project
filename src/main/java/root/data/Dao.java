package root.data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est utilisée pour accéder aux tables de la base de données.
 *
 * @param <Model> Modèle général
 * @param <IdType> Identifiant général
 */
public abstract class Dao<Model, IdType> {
  private Connection connexion;

  /**
   * Getter de connexion.
   *
   * @return connexion Connection à la base de données
   */
  private Connection getConnexion() {
    return connexion;
  }

  /**
   * Setter de connexion.
   *
   * @param connexion Connection à la base de données
   */
  private void setConnexion(Connection connexion) {
    this.connexion = connexion;
  }

  /**
   * Constructeur.
   *
   * @param connexion Connection à la base de données
   */
  public Dao(Connection connexion) {
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param model Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  public abstract boolean insert(Model model);

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  public abstract Model get(IdType id);

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  public abstract ArrayList<Model> getAll();


  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param model Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */

  public abstract boolean update(Model model);


  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param model Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  public abstract boolean delete(Model model);


}