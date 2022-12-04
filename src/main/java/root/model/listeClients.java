package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Clients.
 */
public class listeClients {
  private ArrayList<Client> clients;

  /**
   * Setter de la liste des clients.
   *
   * @param clients la liste des clients
   */
  private void setClients(ArrayList<Client> clients) {
    this.clients = clients;
  }

  /**
   * Constructeur.
   */
  public listeClients() {
  }

  public ArrayList<Client> getClients() {
    return clients;
  }

  /**
   * Méthode pour ajouter un client à la liste des clients.
   *
   * @param c client à ajouter
   */
  public void ajouter(Client c) {
  }

  /**
   * Méthode pour supprimer un client de la liste des clients.
   *
   * @param c client à supprimer
   */
  public void supprimer(Client c) {
  }

  /**
   * Méthode pour modifier un client de la liste des clients.
   *
   * @param c client à modifier
   */
  public void editer(Client c) {
  }
}
