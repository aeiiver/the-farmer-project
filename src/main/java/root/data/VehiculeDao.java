package root.data;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Cette classe est utilisée pour accéder à la table Véhicule.
 *
 * @param <Model> Modèle utilisé pour la table
 * @param <IdType> Type de l'identifiant de la table
 */
public class VehiculeDao<Model, IdType> extends Dao {
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

  @Override
  public ArrayList<Model> getAll() {
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
   */
  @Override
  public boolean delete(Object o) {
    return false;
  }
}