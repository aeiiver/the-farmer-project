package root.controller.list;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Producteur;
import root.model.list.ListeProducteurs;
import root.view.form.ProducteursFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des producteurs.
 */
public class ProducteursCtrl {

  private final Stage fenetre;

  private final ListeProducteurs model;

  /**
   * Constructeur.
   *
   * @param fenetre La fenêtre principale de l'application.
   * @param model Le modèle de la liste des producteurs.
   */
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
    ProducteurDao dao = new ProducteurDao(SingleConnection.getInstance());
    boolean reponse = StageUtil.afficheConfirmation(fenetre);

    if (reponse) {
      dao.delete(producteur);
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
