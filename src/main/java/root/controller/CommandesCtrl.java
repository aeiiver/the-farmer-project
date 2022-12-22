package root.controller;


import javafx.stage.Stage;
import root.model.ListeCommandes;
import root.view.CommandesView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des commandes.
 */
public class CommandesCtrl {

  /**
   * Modèle de la liste des commandes.
   *
   * @see CommandesCtrl#getModel()
   */
  private ListeCommandes model;

  /**
   * Vue de la liste des commandes.
   *
   * @see CommandesCtrl#getView()
   */
  private CommandesView view;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  /**
   * Constructeur de la classe.
   */
  public CommandesCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
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
  public ListeCommandes getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeCommandes model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public CommandesView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(CommandesView view) {
    this.view = view;
  }

}
