package root.data;

import java.sql.Connection;
import java.util.ArrayList;
import root.model.Client;

/**
 * Cette classe est utilisée pour accéder à la classe Client.
 */
public class ClientDao extends Dao<Client, Integer> {

  /**
   * Constructeur.
   *
   * @param connexion Connexion à la base de données
   */
  public ClientDao(Connection connexion) {
    super(connexion);
  }

  /**
   * Insertion d'un nouvel enregistrement dans la table.
   *
   * @param o Modèle à insérer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean insert(Client o) {
    return false;
  }

  /**
   * Récupération d'un enregistrement de la table.
   *
   * @param id Identifiant de l'enregistrement à récupérer
   * @return Modèle correspondant à l'enregistrement
   */
  @Override
  public Client get(Integer id) {
    return null;
  }

  /**
   * Récupération de tous les enregistrements de la table.
   *
   * @return Liste des enregistrements
   */
  @Override
  public ArrayList<Client> getAll() {
    return null;
  }

  /**
   * Mise à jour d'un enregistrement de la table.
   *
   * @param o Modèle à mettre à jour
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean update(Client o) {
    return false;
  }

  /**
   * Suppression d'un enregistrement de la table.
   *
   * @param o Modèle à supprimer
   * @return true si la mise à jour a réussi, false sinon
   */
  @Override
  public boolean delete(Client o) {
    return false;
  }

}
