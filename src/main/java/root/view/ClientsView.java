package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView {
  private MenuBar menu;
  private ListView listeClients;
  private Button ajouterClient;
  private Button supprimerClient;
  private Button editerClient;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeClients() {
    return listeClients;
  }

  private Button getAjouterClient() {
    return ajouterClient;
  }

  private Button getSupprimerClient() {
    return supprimerClient;
  }

  private Button getEditerClient() {
    return editerClient;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setListeClients(ListView listeClients) {
    this.listeClients = listeClients;
  }

  private void setAjouterClient(Button ajouterClient) {
    this.ajouterClient = ajouterClient;
  }

  private void setSupprimerClient(Button supprimerClient) {
    this.supprimerClient = supprimerClient;
  }

  private void setEditerClient(Button editerClient) {
    this.editerClient = editerClient;
  }
}