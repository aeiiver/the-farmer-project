package root.controller.menubar;

import javafx.stage.Stage;
import root.SceneChanger;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Producteur;
import root.model.list.ListeClients;
import root.model.list.ListeCommandes;
import root.model.list.ListeProducteurs;
import root.model.list.ListeTournees;
import root.model.list.ListeVehicules;
import root.model.session.SingleSession;
import root.view.form.ProducteursFormView;

/**
 * Contrôleur associé à la barre de menus producteur.
 */
public class MenubarProducteurCtrl {

  public Stage fenetre;

  /**
   * Constructeur.
   *
   * @param fenetre La fenêtre principale.
   */
  public MenubarProducteurCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Méthode appelée lors du clic sur le bouton "tableau de bord".
   * Affiche le tableau de bord.
   */
  public void gotoTableaudebord() {
    SceneChanger.voirTableaudebord(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mes commandes".
   * Affiche la liste des commandes du producteur connecté.
   */
  public void gotoListeCommandes() {
    SceneChanger.voirListeCommandes(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mes tournées".
   * Affiche la liste des tournées du producteur connecté.
   */
  public void gotoListeTournees() {
    SceneChanger.voirListeTournees(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mes véhicules".
   * Affiche la liste des véhicules du producteur connecté.
   */
  public void gotoListeVehicules() {
    SceneChanger.voirListeVehicules(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mes clients".
   * Affiche la liste des clients du producteur connecté.
   */
  public void gotoListeClients() {
    SceneChanger.voirListeClients(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Ajouter une commande".
   * Affiche le formulaire de création d'une nouvelle commande.
   */
  public void gotoFormCommande() {
    SceneChanger.voirFormCommande(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Ajouter une tournée".
   * Affiche le formulaire de création d'une nouvelle tournée.
   */
  public void gotoFormTournee() {
    SceneChanger.voirFormTournee(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Ajouter un véhicule".
   * Affiche le formulaire de création d'un nouveau véhicule.
   */
  public void gotoFormVehicule() {
    SceneChanger.voirFormVehicule(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Ajouter un client".
   * Affiche le formulaire de création d'un nouveau client.
   */
  public void gotoFormClient() {
    SceneChanger.voirFormClient(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mon compte".
   * Affiche le formulaire de modification du compte du producteur connecté.
   */
  public void gotoCompte() {
    ProducteursFormView vue = (ProducteursFormView) SceneChanger.voirFormProducteur(fenetre);
    vue.chargeChamps((Producteur) SingleSession.getSession().getUtilisateur());
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Déconnexion".
   * Déconnecte le producteur connecté et affiche la page de connexion.
   */
  public void deconnexion() {

    new ProducteurDao(SingleConnection.getInstance()).discnonect();
    new ListeCommandes().clear();
    new ListeProducteurs().clear();
    new ListeClients().clear();
    new ListeTournees().clear();
    new ListeVehicules().clear();
    SingleSession.fermeSession();



    SceneChanger.voirConnexion(fenetre);
  }

}
