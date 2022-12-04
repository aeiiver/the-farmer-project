package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView {

  private MenuBar menu;
  private ListView listeClients;
  private Button ajouterClient;
  private Button supprimerClient;
  private Button editerClient;

  public ClientsView(MenuBar menu) {
    this.menu = menu;
  }

}
