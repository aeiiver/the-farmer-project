package root.view;

import java.io.IOException;
import javafx.event.ActionEvent;
import root.controller.ClientsCtrl;
import root.controller.ClientsFormCtrl;
import root.controller.CommandesCtrl;
import root.controller.CommandesFormCtrl;
import root.controller.CompteCtrl;
import root.controller.ConnexionCtrl;
import root.controller.MainCtrl;
import root.controller.TableaudebordCtrl;
import root.controller.TourneesCtrl;

/**
 * Classe de vue mère.
 */
public class MainView {
  /**
   * Contrôleur de cette vue.
   */
  MainCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public MainView(MainCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Redirige l'utilisateur vers le tableau de bord. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void lienTableaudebord(ActionEvent event) {
    event.consume();
    System.out.println("lienTableaudebord: got commented out");
    //ctrl.voirTableaudebord(new TableaudebordView(new TableaudebordCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   *
   * @param event L'événement déclencheur.
   */
  public void lienCommandes(ActionEvent event) {
    event.consume();
    System.out.println("lienCommandes: got commented out");
    //ctrl.voirCommandesListes(new CommandesView(new CommandesCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   *
   * @param event L'événement déclencheur.
   */
  public void lienClients(ActionEvent event) {
    event.consume();
    ctrl.voirClientsListes(new ClientsView(new ClientsCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void lienTournees(ActionEvent event) {
    event.consume();
    ctrl.voirTourneesListes(new TourneesView(new TourneesCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur les paramètres de comptes. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void lienComptes(ActionEvent event) {
    event.consume();
    ctrl.voirComptesListes(new CompteView(new CompteCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers le formulaire d'ajout de clients.
   *
   * @param event L'événement déclencheur.
   */
  public void lienClientsForm(ActionEvent event) {
    event.consume();
    ctrl.voirClientsForm(new ClientsFormView(new ClientsFormCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue de formulaire d'ajout de commande.
   * Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void lienFormCommande(ActionEvent event) {
    event.consume();
    System.out.println("lienFormCommande: got commented out");
    //ctrl.voirCommandesForm(new CommandesFormView(new CommandesFormCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la page de connexion.
   *
   * @param event L'événement déclencheur.
   * @throws IOException Si le fichier fxml n'est pas trouvé.
   */
  public void deconnexion(ActionEvent event) throws IOException {
    event.consume();
    System.out.println("deconnexion: got commented out");
    //ctrl.voirConnexion(new ConnexionCtrl(ctrl.getPrimaryStage()).getConnexionView());
  }

}
