package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.ProducteursCtrl;

/**
 * Classe de vue pour la liste des producteurs.
 */
public class ProducteursView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des producteurs existants.
   */
  private ListView listeProducteurs;
  /**
   * Bouton pour ajouter un nouveau producteur.
   */
  private Button ajouterProducteur;
  /**
   * Bouton pour supprimer un producteur déjà existant.
   */
  private Button supprimerProducteur;
  /**
   * Bouton pour modifier un producteur déjà existant.
   */
  private Button editerProducteur;

  /**
   * Controlleur gérant la vue de la liste des producteurs.
   *
   * @see ProducteursView#ProducteursView(ProducteursCtrl, MenuBar)
   * @see ProducteursCtrl
   */
  private ProducteursCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public ProducteursView(ProducteursCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
