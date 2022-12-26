package root.controller;

import javafx.stage.Stage;
import root.model.ListeVehicules;
import root.view.VehiculesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un véhicule.
 */
public class VehiculesFormCtrl extends MainCtrl  {

  /**
   * Modèle de la liste des véhicules.
   *
   * @see VehiculesFormCtrl#getModel()
   */
  private ListeVehicules model;

  /**
   * Vue du formulaire d'ajout et modification d'un véhicule.
   *
   * @see VehiculesFormCtrl#getView()
   */
  private VehiculesFormView view;

  /**
   * Constructeur de la classe.
   */
  public VehiculesFormCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void enregistrer() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void cancel() {
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
  public VehiculesFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(VehiculesFormView view) {
    this.view = view;
  }

}
