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
 * Contrôleur associé à la barre de menus producteur.
 */
public class MenubarProducteurCtrl implements Initializable {

  public MenuBar root;
  private Stage fenetre;

  public void gotoTableaudebord() {
    SceneChanger.voirTableaudebord(fenetre);
  }

  public void gotoListeCommandes() {
    SceneChanger.voirListeCommandes(fenetre);
  }

  public void gotoListeTournees() {
    SceneChanger.voirListeTournees(fenetre);
  }

  public void gotoListeVehicules() {
    SceneChanger.voirListeVehicules(fenetre);
  }

  public void gotoListeClients() {
    SceneChanger.voirListeClients(fenetre);
  }

  public void gotoFormCommande() {
    SceneChanger.voirFormCommande(fenetre);
  }

  public void gotoFormTournee() {
    SceneChanger.voirFormTournee(fenetre);
  }

  public void gotoFormVehicule() {
    SceneChanger.voirFormVehicule(fenetre);
  }

  public void gotoFormClient() {
    SceneChanger.voirFormClient(fenetre);
  }

  public void gotoCompte() {
    SceneChanger.voirCompteProducteur(fenetre);
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
