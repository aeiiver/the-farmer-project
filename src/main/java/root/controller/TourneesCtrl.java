package root.controller;

import root.model.ListeTournees;
import root.view.TourneesView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des tournées.
 */
public class TourneesCtrl {

  /**
   * Contrôleur de la vue du formulaire d'ajout et modification d'une tournée.
   */
  private ListeTournees model;

  /**
   * Vue de la liste des tournées.
   */
  private TourneesView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public TourneesCtrl(ListeTournees model, TourneesView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'une tournée.
   */
  public void ajouterTournee() {
  }

  /**
   * Supprime une commande du modèle.
   */
  public void supprimerTournee() {
  }

  /**
   * Affiche la vue du formulaire de modification d'une tournée.
   */
  public void editerTournee() {
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
  public TourneesView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(TourneesView view) {
    this.view = view;
  }

}
