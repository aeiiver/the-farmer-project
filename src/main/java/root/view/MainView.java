package root.view;

import javafx.event.ActionEvent;
import root.controller.*;

public class MainView {
  MainCtrl ctrl;

  public MainView(MainCtrl ctrl) {
    this.ctrl = ctrl;
  }
  private void MenuCommandes(ActionEvent event) {
    event.consume();
    ctrl.showCommandesView(new CommandesView((CommandesCtrl) ctrl));
  }

  private void MenuTableaudebord(ActionEvent event) {
    event.consume();
    ctrl.showTableaudebordView(new TableaudebordView((TableaudebordCtrl) ctrl));
  }

  private void MenuTournees(ActionEvent event) {
    event.consume();
    ctrl.showTourneesView(new TourneesView((TourneesCtrl) ctrl));
  }

  private void MenuComptes(ActionEvent event) {
    event.consume();
    ctrl.showComptesView(new CompteView((CompteCtrl) ctrl));
  }
}
