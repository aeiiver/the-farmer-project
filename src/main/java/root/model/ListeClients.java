package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Clients.
 */
public class ListeClients {

  /**
   * Liste des clients.
   *
   * @see ListeClients#ListeClients()
   * @see ListeClients#getClients()
   * @see ListeClients#ajouter(Client)
   * @see ListeClients#supprimer(Client)
   * @see Client
   */
  private ArrayList<Client> clients;

  /**
   * Constructeur.
   */
  public ListeClients() {
    clients = new ArrayList<>();
  }

  /**
   * Getter de la liste des clients.
   *
   * @return La liste des clients.
   */
  public ArrayList<Client> getClients() {
    return clients;
  }

  /**
   * Méthode pour ajouter un client à la liste des clients.
   *
   * @param client client à ajouter
   */
  public void ajouter(Client client) {
  }

  /**
   * Méthode pour supprimer un client de la liste des clients.
   *
   * @param client client à supprimer
   */
  public void supprimer(Client client) {
  }

  /**
   * Méthode pour modifier un client de la liste des clients.
   *
   * @param client client à modifier
   */
  public void editer(Client client) {
  }

}
