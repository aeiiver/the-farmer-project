package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Commandes.
 */
public class listeCommandes {
  private ArrayList<Commande> commandes;

  private void setCommandes(ArrayList<Commande> commandes) {
    this.commandes = commandes;
  }

  public listeCommandes() {
  }

  public ArrayList<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Méthode pour ajouter une commande à la liste des commandes.
   *
   * @param c commande à ajouter
   */
  public void ajouter(Commande c) {
  }

  /**
   * Méthode pour supprimer une commande de la liste des commandes.
   *
   * @param c commande à supprimer
   */
  public void supprimer(Commande c) {
  }

  /**
   * Méthode pour modifier une commande de la liste des commandes.
   *
   * @param c commande à modifier
   */
  public void editer(Commande c) {
  }
}
