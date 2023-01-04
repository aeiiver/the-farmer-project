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
public class MenubarAdminCtrl {
  private Stage fenetre;

  public MenubarAdminCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

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

}
