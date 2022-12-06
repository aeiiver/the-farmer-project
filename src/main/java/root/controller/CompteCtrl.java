package root.controller;

import root.model.Utilisateur;
import root.view.CompteView;

/**
 * Classe contrôleuse pour la vue et modèle du compte de l'utilisateur.
 */
public class CompteCtrl {

  private Utilisateur model;
  private CompteView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public CompteCtrl(Utilisateur model, CompteView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Reflète les modifications du compte dans le modêle.
   */
  public void updateUtilisateur() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public Utilisateur getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(Utilisateur model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public CompteView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(CompteView view) {
    this.view = view;
  }
}
