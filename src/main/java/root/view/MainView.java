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

  public void menuCommandes(ActionEvent event) {
    event.consume();
    ctrl.showCommandesView(new CommandesView((CommandesCtrl) ctrl));
  }

  public void menuTableaudebord(ActionEvent event) {
    event.consume();
    ctrl.showTableaudebordView(new TableaudebordView((TableaudebordCtrl) ctrl));
  }

  public void menuTournees(ActionEvent event) {
    event.consume();
    ctrl.showTourneesView(new TourneesView((TourneesCtrl) ctrl));
  }

  public void menuComptes(ActionEvent event) {
    event.consume();
    ctrl.showComptesView(new CompteView((CompteCtrl) ctrl));
  }
}
