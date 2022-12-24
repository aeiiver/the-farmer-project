package root.view;

import javafx.event.ActionEvent;
import root.controller.CommandesCtrl;
import root.controller.CompteCtrl;
import root.controller.MainCtrl;
import root.controller.TableaudebordCtrl;
import root.controller.TourneesCtrl;
import root.controller.CommandesFormCtrl;


/**
 * Classe de vue mère.
 */
public class MainView {
  MainCtrl ctrl;

  public MainView(MainCtrl ctrl) {
    this.ctrl = ctrl;
  }

  public void menuCommandes(ActionEvent event) {
    event.consume();
    ctrl.showCommandesView(new CommandesView(new CommandesCtrl(ctrl.getPrimaryStage())));
  }

  public void menuTableaudebord(ActionEvent event) {
    event.consume();
    ctrl.showTableaudebordView(new TableaudebordView(new TableaudebordCtrl(ctrl.getPrimaryStage())));
  }

  public void menuTournees(ActionEvent event) {
    event.consume();
    ctrl.showTourneesView(new TourneesView(new TourneesCtrl(ctrl.getPrimaryStage())));
  }

  public void menuComptes(ActionEvent event) {
    event.consume();
    ctrl.showComptesView(new CompteView(new CompteCtrl(ctrl.getPrimaryStage())));
  }

  public void menuNouvelleCommande(ActionEvent event) {
    event.consume();
    ctrl.showCommandFormView(new CommandesFormView(new CommandesFormCtrl(ctrl.getPrimaryStage())));
  }
}
