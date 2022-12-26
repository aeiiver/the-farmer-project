package root.controller;

import javafx.stage.Stage;
import root.model.ListeProducteurs;
import root.view.ProducteursFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un producteur.
 */
public class ProducteursFormCtrl extends MainCtrl {

  /**
   * Modèle du formulaire d'ajout et modification d'un producteur.
   *
   * @see ProducteursFormCtrl#getModel()
   */
  private ListeProducteurs model;

  /**
   * Vue du formulaire d'ajout et modification d'un producteur.
   *
   * @see ProducteursFormCtrl#getView()
   */
  private ProducteursFormView view;

  /**
   * Constructeur vide de la classe.
   */
  public ProducteursFormCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void enregistrer() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void cancel() {
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
  public ProducteursFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(ProducteursFormView view) {
    this.view = view;
  }
  
}
