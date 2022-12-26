package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.ClientsCtrl;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView extends MainView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des clients existants.
   */
  private ListView listeClients;
  /**
   * Bouton pour ajouter un nouveau client.
   */
  private Button ajouterClient;
  /**
   * Bouton pour supprimer un client déjà existant.
   */
  private Button supprimerClient;
  /**
   * Bouton pour modifier un client déjà existant.
   */
  private Button editerClient;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ClientsView(ClientsCtrl ctrl) {
    super(ctrl);
  }

}
