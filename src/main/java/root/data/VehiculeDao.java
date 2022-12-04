package root.data;

import java.sql.Connection;
import java.util.ArrayList;
import root.model.Vehicule;

/**
 * Cette classe est utilisée pour accéder à la table Véhicule.
 */
public class VehiculeDao extends Dao<Vehicule, String> {

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
   * @param vehicule Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Vehicule vehicule) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param immat Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Vehicule get(String immat) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Vehicule> getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param vehicule Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Vehicule vehicule) {
    return false;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param vehicule Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Vehicule vehicule) {
    return false;
  }

}
