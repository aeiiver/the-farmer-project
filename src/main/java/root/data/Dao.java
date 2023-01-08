package root.data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe abstraite encapsule les opératons CRUD pour la base de données.
 *
 * @param <T> Le type du modèle.
 * @param <U> Le type de l'identifiant du modèle.
 */
public abstract class Dao<T, U> {

  /**
   * Connexion à la base de données.
   */
  Connection connexion;

  /**
   * Constructeur.
   *
   * @param connexion Connection à la base de données
   */
  public Dao(Connection connexion) {
    this.connexion = connexion;
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param t Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  public abstract boolean insert(T t);

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  public abstract T get(U id);

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  public abstract ArrayList<T> getAll();


  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param t Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  public abstract boolean update(T t);


  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param t Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  public abstract boolean delete(T t);

  public void discnonect() {
    connexion = null;
  }
  
}
