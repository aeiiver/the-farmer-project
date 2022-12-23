package root.controller;

import javafx.stage.Stage;
import root.model.Utilisateur;
import root.view.CompteView;

/**
 * Classe contrôleuse pour la vue et modèle du compte de l'utilisateur.
 */
public class CompteCtrl {

  /**
   * Modèle de l'utilisateur.
   *
   * @see CompteCtrl#getModel()
   */
  private Utilisateur model;

  /**
   * Vue du compte de l'utilisateur.
   *
   * @see CompteCtrl#getView()
   */
  private CompteView view;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  /**
   * Constructeur de la classe.
   */
  public CompteCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Reflète les modifications du compte dans le modèle.
   */
  public void updateUtilisateur() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public Utilisateur getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(Utilisateur model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public CompteView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(CompteView view) {
    this.view = view;
  }
}
