package root.view.menubar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.menubar.MenubarProducteurCtrl;

/**
 * Classe de vue pour la barre de menus producteur.
 */
public class MenubarProducteurView implements Initializable {
  @FXML
  MenuBar root;

  private MenubarProducteurCtrl ctrl;

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Tableau de bord".
   * Permet d'afficher le tableau de bord.
    */
  public void gotoTableaudebord() {
    ctrl.gotoTableaudebord();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Mes commandes".
   * Permet d'afficher la liste des commandes du producteur.
   */
  public void gotoListeCommandes() {
    ctrl.gotoListeCommandes();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Nouvelle commande".
   * Permet d'afficher le formulaire de création d'une commande.
   */
  public void gotoFormCommande() {
    ctrl.gotoFormCommande();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Mes tournées".
   * Permet d'afficher la liste des tournées du producteur.
   */
  public void gotoListeTournees() {
    ctrl.gotoListeTournees();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Nouvelle tournée".
   * Permet d'afficher le formulaire de création d'une tournée.
   */
  public void gotoFormTournee() {
    ctrl.gotoFormTournee();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Mes véhicules".
   * Permet d'afficher la liste des véhicules du producteur.
   */
  public void gotoListeVehicules() {
    ctrl.gotoListeVehicules();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Nouveau véhicule".
   * Permet d'afficher le formulaire de création d'un véhicule.
   */
  public void gotoFormVehicule() {
    ctrl.gotoFormVehicule();
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
   * Méthode déclenchée lors de l'appui sur le bouton "Mon compte".
   * Permet d'afficher le formulaire de modification du compte du producteur.
   */
  public void gotoCompte() {
    ctrl.gotoCompte();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Déconnexion".
   * Permet de déconnecter le producteur.
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
      ctrl = new MenubarProducteurCtrl(fenetre);
    });
  }
}
