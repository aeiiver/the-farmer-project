package root.controller;

import javafx.stage.Stage;
import root.model.ListeProducteurs;
import root.view.ProducteursView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des producteurs.
 */
public class ProducteursCtrl {

  /**
   * Modèle de la liste des producteurs.
   *
   * @see ProducteursCtrl#getModel()
   */
  private ListeProducteurs model;

  /**
   * Vue de la liste des producteurs.
   *
   * @see ProducteursCtrl#getView()
   */
  private ProducteursView view;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  /**
   * Constructeur vide de la classe.
   */
  public ProducteursCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Affiche la vue du formulaire d'ajout de producteur.
   */
  public void ajouterProducteur() {
  }

  /**
   * Supprime un producteur du modèle.
   */
  public void supprimerProducteur() {
  }

  /**
   * Affiche la vue du formulaire de modification d'un producteur.
   */
  public void editerProducteur() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeProducteurs getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeProducteurs model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public ProducteursView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(ProducteursView view) {
    this.view = view;
  }

}
