package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TableaudebordCtrl;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView {

  private MenuBar menu;
  private ListView listeTournees;
  private ListView listeCommandes;
  private Button ajouterTournee;
  private Button supprimerTournee;
  private Button editerTournee;
  private Button ajouterCommande;
  private Button supprimerCommande;
  private Button editerCommande;

  private TableaudebordCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public TableaudebordView(TableaudebordCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
