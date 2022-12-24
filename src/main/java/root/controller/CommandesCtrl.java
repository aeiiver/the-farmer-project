package root.controller;


import javafx.stage.Stage;
import root.model.Commande;
import root.model.ListeCommandes;
import root.view.CommandesView;

import java.util.ArrayList;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des commandes.
 */
public class CommandesCtrl extends MainCtrl {

  /**
   * Modèle de la liste des commandes.
   *
   * @see CommandesCtrl#getModel()
   */
  private ListeCommandes model;

  /**
   * Vue de la liste des commandes.
   *
   * @see CommandesCtrl#getView()
   */
  private CommandesView view;

  /**
   * Constructeur de la classe.
   */
  public CommandesCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Affiche la vue du formulaire d'ajout d'une commande.
   */
  public void ajouterCommande() {
  }

  /**
   * Supprime une commande du modèle.
   */
  public void supprimerCommande() {
  }

  /**
   * Affiche la vue du formulaire de modification d'une commande.
   */
  public void editerCommande() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeCommandes getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeCommandes model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public CommandesView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(CommandesView view) {
    this.view = view;
  }

}
