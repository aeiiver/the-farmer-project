package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.model.ListeVehicules;
import root.view.VehiculesView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des véhicules.
 */
public class VehiculesCtrl {

  /**
   * Modèle de la liste des véhicules.
   *
   * @see VehiculesCtrl#getModel()
   */
  private ListeVehicules model;

  /**
   * Vue de la liste des véhicules.
   *
   * @see VehiculesCtrl#getView()
   */
  private VehiculesView view;

  /**
   * Affiche la vue du formulaire d'ajout d'un véhicule.
   */
  public void ajouterVehicules() {
    // TODO refaire
    SceneChanger.voirFormVehicule(new Stage());
  }

  /**
   * Supprime un véhicule du modèle.
   */
  public void supprimerVehicules() {
    //TODO: Supprimer un véhicule du modèle
    //valideSuppression(view.getClass(), view);
  }

  /**
   * Affiche la vue du formulaire de modification d'un véhicule.
   */
  public void editerVehicules() {
    // TODO refaire
    SceneChanger.voirFormVehicule(new Stage());
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
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeVehicules model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
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
