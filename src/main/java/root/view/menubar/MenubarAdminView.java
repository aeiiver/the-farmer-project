package root.view.menubar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.menubar.MenubarAdminCtrl;


/**
 * Classe de vue de la barre de menu administrateur.
 */
public class MenubarAdminView implements Initializable {
  @FXML
  MenuBar root;

  private MenubarAdminCtrl ctrl;

  public void gotoTableaudebord() {
    ctrl.gotoTableaudebord();
  }

  public void gotoListeProducteurs() {
    ctrl.gotoListeProducteurs();
  }

  public void gotoFormProducteur() {
    ctrl.gotoFormProducteur();
  }

  public void gotoCompte() {
    ctrl.gotoCompte();
  }

  public void deconnexion() {
    ctrl.deconnexion();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new MenubarAdminCtrl(fenetre);
    });
  }
}