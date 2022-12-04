package root.controller;

import root.model.ListeProducteurs;
import root.view.ProducteursFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un producteur.
 */
public class ProducteursFormCtrl {

  private ListeProducteurs model;
  private ProducteursFormView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public ProducteursFormCtrl(ListeProducteurs model, ProducteursFormView view) {
    this.model = model;
    this.view = view;
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
   * @param model Le modèle nouveau.
   */
  public void setModel(ListeProducteurs model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return Le vue.
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
