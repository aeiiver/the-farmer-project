package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.ClientsCtrl;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView {

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
   * Contrôleur gérant la vue de la liste des clients.
   * 
   * @see ClientsCtrl
   * @see ClientsView#ClientsView(ClientsCtrl, MenuBar) 
   */
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
