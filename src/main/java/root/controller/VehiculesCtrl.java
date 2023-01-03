package root.controller;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import root.model.ListeVehicules;
import root.view.VehiculesView;

import static root.StageUtil.valideSuppression;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des véhicules.
 */
public class VehiculesCtrl extends MainCtrl  {

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
   * Constructeur de la classe.
   */
  public VehiculesCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Affiche la vue du formulaire d'ajout d'un véhicule.
   */
  public void ajouterVehicules() {
    changeScene(new FXMLLoader(getClass().getResource("/root/controller/FormVehicule.fxml")));

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
    changeScene(new FXMLLoader(getClass().getResource("/root/controller/FormVehicule.fxml")));
    //TODO récupérer l'élément sélectionné.
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
