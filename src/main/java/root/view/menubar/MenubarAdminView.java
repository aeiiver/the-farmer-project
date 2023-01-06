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

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Tableau de bord".
   * Permet d'afficher le tableau de bord.
   */
  public void gotoTableaudebord() {
    ctrl.gotoTableaudebord();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Producteurs".
   * Permet d'afficher la liste des producteurs.
   */
  public void gotoListeProducteurs() {
    ctrl.gotoListeProducteurs();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "nouveau producteur".
   * Permet d'afficher le formulaire de création d'un producteur.
   */
  public void gotoFormProducteur() {
    ctrl.gotoFormProducteur();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Mes clients".
   * Permet d'afficher la liste des clients du producteur.
   */
  public void gotoListeClients() {
    ctrl.gotoListeClients();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Nouveau client".
   * Permet d'afficher le formulaire de création d'un client.
   */
  public void gotoFormClient() {
    ctrl.gotoFormClient();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "mon compte".
   * Permet d'afficher le formulaire de modification du compte administrateur.
   */
  public void gotoCompte() {
    ctrl.gotoCompte();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "déconnexion".
   * Permet de se déconnecter.
   */
  public void deconnexion() {
    ctrl.deconnexion();
  }

  /**
   * Méthode initialisant la vue.
   *
   * @param url URL
   * @param resourceBundle ResourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new MenubarAdminCtrl(fenetre);
    });
  }
}
