package root.controller.list;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.Vehicule;
import root.model.list.ListeVehicules;
import root.view.form.VehiculesFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des véhicules.
 */
public class VehiculesCtrl {

  private Stage fenetre;
  private  ListeVehicules modele;

  /**
   * Constructeur.
   *
   * @param fenetre La fenêtre principale de l'application.
   * @param modele Le modèle de la liste des véhicules.
   */
  public VehiculesCtrl(Stage fenetre, ListeVehicules modele) {
    this.fenetre = fenetre;
    this.modele = modele;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'un véhicule.
   */
  public void ajouterVehicule() {
    SceneChanger.voirFormVehicule(fenetre);
  }

  /**
   * Supprime un véhicule du modèle.
   *
   * @param vehicule Le véhicule à supprimer
   */
  public void supprimerVehicule(Vehicule vehicule) {
    VehiculeDao dao = new VehiculeDao(SingleConnection.getInstance());

    boolean reponse = StageUtil.afficheConfirmation(fenetre);
    System.out.println(reponse);
    if (reponse) {
      dao.delete(vehicule);
      modele.supprimer(vehicule);
    }
  }

  /**
   * Affiche la vue du formulaire de modification d'un véhicule.
   *
   * @param vehicule Le véhicule à éditer
   */
  public void editerVehicule(Vehicule vehicule) {
    VehiculesFormView vue = (VehiculesFormView) SceneChanger.voirFormVehicule(fenetre);
    vue.chargeChamps(vehicule);
  }

}
