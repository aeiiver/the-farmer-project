package root.controller;

import javafx.stage.Stage;
import root.model.ListeCommandes;
import root.view.CommandesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une commande.
 */
public class CommandesFormCtrl {

  /**
   * Modèle de la commande.
   *
   * @see CommandesFormCtrl#getModel()
   */
  private ListeCommandes model;

  /**
   * Vue du formulaire d'ajout et modification d'une commande.
   *
   * @see CommandesFormCtrl#getView()
   */
  private CommandesFormView view;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  /**
   * Constructeur de la classe.
   */
  public CommandesFormCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des commandes.
   */
  public void enregistrer() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void cancel() {
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
  public CommandesFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(CommandesFormView view) {
    this.view = view;
  }

}
