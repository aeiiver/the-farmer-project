package root.view;

import javafx.event.ActionEvent;
import root.controller.CommandesCtrl;
import root.controller.CompteCtrl;
import root.controller.MainCtrl;
import root.controller.TableaudebordCtrl;
import root.controller.TourneesCtrl;

/**
 * Classe de vue mère.
 */
public class MainView {
  MainCtrl ctrl;

  public MainView(MainCtrl ctrl) {
    this.ctrl = ctrl;
  }

  private void menuCommandes(ActionEvent event) {
    event.consume();
    ctrl.showCommandesView(new CommandesView((CommandesCtrl) ctrl));
  }

  private void menuTableaudebord(ActionEvent event) {
    event.consume();
    ctrl.showTableaudebordView(new TableaudebordView((TableaudebordCtrl) ctrl));
  }

  private void menuTournees(ActionEvent event) {
    event.consume();
    ctrl.showTourneesView(new TourneesView((TourneesCtrl) ctrl));
  }

  private void menuComptes(ActionEvent event) {
    event.consume();
    ctrl.showComptesView(new CompteView((CompteCtrl) ctrl));
  }
}
