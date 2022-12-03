package root.controller;

import root.model.ListeProducteurs;
import root.view.ProducteursView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des producteurs.
 */
public class ProducteursCtrl {

  private ListeProducteurs model;
  private ProducteursView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public ProducteursCtrl(ListeProducteurs model, ProducteursView view) {
    this.model = model;
    this.view = view;
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
  private ListeProducteurs getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  private void setModel(ListeProducteurs model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  private ProducteursView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  private void setView(ProducteursView view) {
    this.view = view;
  }

}
