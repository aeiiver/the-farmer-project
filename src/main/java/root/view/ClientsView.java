package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.ClientsCtrl;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView {

  private MenuBar menu;
  private ListView listeClients;
  private Button ajouterClient;
  private Button supprimerClient;
  private Button editerClient;

  private ClientsCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public ClientsView(ClientsCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
