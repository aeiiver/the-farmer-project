package root.view;

import javafx.event.ActionEvent;
import root.controller.CommandesCtrl;
import root.controller.CommandesFormCtrl;
import root.controller.CompteCtrl;
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
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   *
   * @param event L'événement déclencheur.
   */
  public void menuCommandes(ActionEvent event) {
    event.consume();
    ctrl.showCommandesView(new CommandesView(new CommandesCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers le tableau de bord. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void menuTableaudebord(ActionEvent event) {
    event.consume();
    ctrl.showTableaudebordView(new TableaudebordView(
        new TableaudebordCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void menuTournees(ActionEvent event) {
    event.consume();
    ctrl.showTourneesView(new TourneesView(new TourneesCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue sur les paramètres de comptes. Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void menuComptes(ActionEvent event) {
    event.consume();
    ctrl.showComptesView(new CompteView(new CompteCtrl(ctrl.getPrimaryStage())));
  }

  /**
   * Redirige l'utilisateur vers la vue de formulaire d'ajout de commande.
   * Lors du clic dans le menu.
   *
   * @param event L'événement qui a déclenché l'action.
   */
  public void menuNouvelleCommande(ActionEvent event) {
    event.consume();
    ctrl.showCommandFormView(new CommandesFormView(new CommandesFormCtrl(ctrl.getPrimaryStage())));
  }
}
