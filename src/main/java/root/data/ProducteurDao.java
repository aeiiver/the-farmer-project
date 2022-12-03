package root.data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est utilisée pour accéder à la table Producteur.
 *
 * @param <Model> Modèle utilisé pour la table
 * @param <IdType> Type de l'identifiant de la table
 */
public class ProducteurDao<Model, IdType> extends Dao {

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
   * @param o Modèle à insérer
   */
  @Override
  public boolean insert(Object o) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   */
  @Override
  public Object get(Object id) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param o Modèle à mettre à jour
   */
  @Override
  public boolean update(Object o) {
    return false;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param o Modèle à supprimer
   * @return true si la suppression a réussi, false sinon
   */
  @Override
  public boolean delete(Object o) {
    return false;
  }

}