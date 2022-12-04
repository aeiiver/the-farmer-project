package root.data;

import java.sql.Connection;
import java.util.ArrayList;
import root.model.Commande;

/**
 * Cette classe est utilisée pour accéder à la table Commande.
 */
public class CommandeDao extends Dao<Commande, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public CommandeDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param o Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Commande o) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   */
  @Override
  public Commande get(Integer id) {
    return null;
  }


  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Commande> getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param o Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Commande o) {
    return false;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param o Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Commande o) {
    return false;
  }
  
}
