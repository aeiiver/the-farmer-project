package root.controller;

import root.model.ListeVehicules;
import root.view.VehiculesView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des véhicules.
 */
public class VehiculesCtrl {

  /**
   * Modèle de la liste des véhicules.
   *
   * @see VehiculesCtrl#VehiculesCtrl(ListeVehicules, VehiculesView)
   * @see VehiculesCtrl#getModel()
   */
  private ListeVehicules model;

  /**
   * Vue de la liste des véhicules.
   *
   * @see VehiculesCtrl#VehiculesCtrl(ListeVehicules, VehiculesView)
   * @see VehiculesCtrl#getView()
   */
  private VehiculesView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public VehiculesCtrl(ListeVehicules model, VehiculesView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'un véhicule.
   */
  public void ajouterVehicules() {
  }

  /**
   * Supprime une véhicule du modèle.
   */
  public void supprimerVehicules() {
  }

  /**
   * Affiche la vue du formulaire de modification d'une véhicule.
   */
  public void editerVehicules() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeVehicules getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le modèle nouveau.
   */
  public void setModel(ListeVehicules model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return Le vue.
   */
  public VehiculesView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(VehiculesView view) {
    this.view = view;
  }

}
