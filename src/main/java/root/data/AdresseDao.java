package root.data;

import java.sql.Connection;
import java.util.ArrayList;
import root.model.Adresse;

/**
 * Cette classe est utilisée pour accéder à la classe Adresse.
 */
public class AdresseDao extends Dao<Adresse, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public AdresseDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param adresse Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Adresse adresse) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Adresse get(Integer id) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Adresse> getAll() {
    return null;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param adresse Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Adresse adresse) {
    return false;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param adresse Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Adresse adresse) {
    return false;
  }
  
}
