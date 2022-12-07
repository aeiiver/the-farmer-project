package root.controller;

import root.model.ListeCommandes;
import root.view.CommandesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une commande.
 */
public class CommandesFormCtrl {

  /**
   * Modèle de la commande.
   *
   * @see CommandesFormCtrl#CommandesFormCtrl(ListeCommandes, CommandesFormView)
   * @see CommandesFormCtrl#getModel()
   */
  private ListeCommandes model;

  /**
   * Vue du formulaire d'ajout et modification d'une commande.
   *
   * @see CommandesFormCtrl#CommandesFormCtrl(ListeCommandes, CommandesFormView)
   * @see CommandesFormCtrl#getView()
   */
  private CommandesFormView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public CommandesFormCtrl(ListeCommandes model, CommandesFormView view) {
    this.model = model;
    this.view = view;
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
   * @param model Le modèle nouveau.
   */
  public void setModel(ListeCommandes model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return Le vue.
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
