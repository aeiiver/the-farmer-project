package root.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.model.SingleSession;

/**
 * Contrôleur associé à la barre de menus administrateur.
 */
public class MenubarAdminCtrl implements Initializable {

  public MenuBar root;
  private Stage fenetre;

  public void gotoTableaudebord() {
    SceneChanger.voirTableaudebordAdmin(fenetre);
  }

  public void gotoListeProducteurs() {
    SceneChanger.voirListeProducteurs(fenetre);
  }

  public void gotoFormProducteur() {
    SceneChanger.voirFormProducteur(fenetre);
  }

  public void gotoCompte() {
    SceneChanger.voirCompteAdmin(fenetre);
  }

  public void deconnexion() {
    SingleSession.fermeSession();
    SceneChanger.voirConnexion(fenetre);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      fenetre = StageUtil.getFenetre(root);
    });
  }

}
