package root.controller;

import root.model.ListeTournees;
import root.view.TourneesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une tournée.
 */
public class TourneesFormCtrl {

  /**
   * Modèle de la liste des tournées.
   *
   * @see TourneesFormCtrl#TourneesFormCtrl(ListeTournees, TourneesFormView)
   */
  private ListeTournees model;

  /**
   * Vue du formulaire d'ajout et modification d'une tournée.
   *
   * @see TourneesFormCtrl#TourneesFormCtrl(ListeTournees, TourneesFormView)
   */
  private TourneesFormView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public TourneesFormCtrl(ListeTournees model, TourneesFormView view) {
    this.model = model;
    this.view = view;
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
   * @param model Le modèle nouveau.
   */
  public void setModel(ListeTournees model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return Le vue.
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
