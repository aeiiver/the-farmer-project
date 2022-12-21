package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Commandes.
 */
public class ListeCommandes {

  /**
   * Liste des commandes.
   *
   * @see ListeCommandes#ListeCommandes()
   * @see ListeCommandes#getCommandes()
   * @see ListeCommandes#ajouter(Commande)
   * @see ListeCommandes#supprimer(Commande)
   * @see Commande
   */
  private ArrayList<Commande> commandes;

  /**
   * Constructeur.
   */
  public ListeCommandes() {
    commandes = new ArrayList<>();
  }

  /**
   * Getter de la liste des commandes.
   *
   * @return La liste des commandes.
   */
  public ArrayList<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Méthode pour ajouter une commande à la liste des commandes.
   *
   * @param commande commande à ajouter
   */
  public void ajouter(Commande commande) {
    commandes.add(commande);
  }

  /**
   * Méthode pour supprimer une commande de la liste des commandes.
   *
   * @param commande commande à supprimer
   */
  public void supprimer(Commande commande) {
    commandes.remove(commande);
  }

  /**
   * Méthode pour modifier une commande de la liste des commandes.
   *
   * @param commande commande à modifier
   */
  public void editer(Commande commande) {
  }

}
