package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.ProducteursCtrl;

/**
 * Classe de vue pour la liste des producteurs.
 */
public class ProducteursView {

  private MenuBar menu;
  private ListView listeProducteurs;
  private Button ajouterProducteur;
  private Button supprimerProducteur;
  private Button editerProducteur;

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
