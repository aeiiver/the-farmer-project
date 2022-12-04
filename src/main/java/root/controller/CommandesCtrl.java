package root.controller;


import root.model.listeCommandes;
import root.view.CommandesView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des commandes.
 */
public class CommandesCtrl {

  private listeCommandes model;
  private CommandesView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public CommandesCtrl(listeCommandes model, CommandesView view) {
  }

  /**
   * Affiche la vue du formulaire d'ajout d'une commande.
   */
  public void ajouterCommande() {
  }

  /**
   * Supprime une commande du modèle.
   */
  public void supprimerCommande() {
  }

  /**
   * Affiche la vue du formulaire de modification d'une commande.
   */
  public void editerCommande() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  private listeCommandes getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  private void setModel(listeCommandes model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  private CommandesView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  private void setView(CommandesView view) {
    this.view = view;
  }

}
