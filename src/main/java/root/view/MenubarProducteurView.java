package root.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.MenubarAdminCtrl;
import root.controller.MenubarProducteurCtrl;

import java.net.URL;
import java.util.ResourceBundle;

public class MenubarProducteurView implements Initializable {
  @FXML
  MenuBar root;

  private MenubarProducteurCtrl ctrl;

  public void gotoTableaudebord() {
    ctrl.gotoTableaudebord();
  }

  public void gotoListeCommandes() {
    ctrl.gotoListeCommandes();
  }

  public void gotoFormCommande() {
    ctrl.gotoFormCommande();
  }

  public void gotoListeTournees() {
    ctrl.gotoListeTournees();
  }

  public void gotoFormTournee() {
    ctrl.gotoFormTournee();
  }

  public void gotoListeVehicules() {
    ctrl.gotoListeVehicules();
  }

  public void gotoFormVehicule() {
    ctrl.gotoFormVehicule();
  }

  public void gotoListeClients() {
    ctrl.gotoListeClients();
  }

  public void gotoFormClient() {
    ctrl.gotoFormClient();
  }

  public void gotoCompte() {
    ctrl.gotoCompte();
  }

  public void deconnexion() {
    ctrl.gotoCompte();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new MenubarProducteurCtrl(fenetre);
    });
  }
}
