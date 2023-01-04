package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.model.Commande;
import root.model.ListeProducteurs;
import root.model.Producteur;
import root.view.CommandesFormView;
import root.view.ProducteursFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des producteurs.
 */
public class ProducteursCtrl {

  private Stage fenetre;

  private ListeProducteurs model;

  public ProducteursCtrl(Stage fenetre, ListeProducteurs model) {
    this.fenetre = fenetre;
    this.model = model;
  }

  /**
   * Affiche la vue du formulaire d'ajout de producteur.
   */
  public void ajouterProducteur() {
    SceneChanger.voirFormProducteur(fenetre);
  }

  /**
   * Supprime un producteur du modèle.
   */
  public void supprimerProducteur(Producteur producteur) {
    boolean estDaccord = StageUtil.afficheConfirmation(fenetre);

    if (estDaccord) {
      model.supprimer(producteur);
    }
  }

  /**
   * Affiche la vue du formulaire de modification d'un producteur.
   */
  public void editerProducteur(Producteur producteur) {
    ProducteursFormView vue = (ProducteursFormView) SceneChanger.voirFormProducteur(fenetre);
    vue.chargeChamps(producteur);
  }

}
