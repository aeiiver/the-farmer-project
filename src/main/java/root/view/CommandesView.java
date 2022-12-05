package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.CommandesCtrl;

/**
 * Classe de vue pour la liste des commandes.
 */
public class CommandesView {

  private MenuBar menu;
  private ListView listeCommandes;
  private Button ajouterCommande;
  private Button supprimerCommande;
  private Button editerCommande;

  private CommandesCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public CommandesView(CommandesCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
