package root.controller.menubar;

import javafx.stage.Stage;
import root.SceneChanger;
import root.model.Admin;
import root.model.session.SingleSession;
import root.view.form.AdminFormView;

/**
 * Contrôleur associé à la barre de menus administrateur.
 */
public class MenubarAdminCtrl {
  private Stage fenetre;

  /**
   * Constructeur.
   *
   * @param fenetre La fenêtre principale.
   */
  public MenubarAdminCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Méthode appelée lors du clic sur le bouton "tableau de bord".
   * Affiche le tableau de bord.
   */
  public void gotoTableaudebord() {
    SceneChanger.voirTableaudebordAdmin(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Producteurs".
   * Affiche la liste des producteurs.
   */
  public void gotoListeProducteurs() {
    SceneChanger.voirListeProducteurs(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Nouveau producteur".
   * Affiche le formulaire de création d'un nouveau producteur.
   */
  public void gotoFormProducteur() {
    SceneChanger.voirFormProducteur(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mes clients".
   * Affiche la liste des clients du producteur connecté.
   */
  public void gotoListeClients() {
    SceneChanger.voirListeClientsAdmin(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Ajouter un client".
   * Affiche le formulaire de création d'un nouveau client.
   */
  public void gotoFormClient() {
    SceneChanger.voirFormClient(fenetre);
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Mon Compte".
   * Affiche le formulaire de modification du compte de l'utilisateur connecté.
   */
  public void gotoCompte() {

    AdminFormView vue = (AdminFormView) SceneChanger.voirCompteAdmin(fenetre);
    vue.chargeChamps((Admin) SingleSession.getSession().getUtilisateur());
  }

  /**
   * Méthode appelée lors du clic sur le bouton "Déconnexion".
   * Déconnecte l'utilisateur et affiche la page de connexion.
   */
  public void deconnexion() {
    SingleSession.fermeSession();
    SceneChanger.voirConnexion(fenetre);
  }

}
