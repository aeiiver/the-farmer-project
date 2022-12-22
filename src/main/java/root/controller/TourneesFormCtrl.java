package root.controller;

import javafx.stage.Stage;
import root.model.ListeTournees;
import root.view.TourneesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une tournée.
 */
public class TourneesFormCtrl {

  /**
   * Modèle de la liste des tournées.
   *
   */
  private ListeTournees model;

  /**
   * Vue du formulaire d'ajout et modification d'une tournée.
   *
   */
  private TourneesFormView view;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  /**
   * Constructeur de la classe.
   */
  public TourneesFormCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des tournées.
   */
  public void enregistrer() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void cancel() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeTournees getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeTournees model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public TourneesFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(TourneesFormView view) {
    this.view = view;
  }

}
