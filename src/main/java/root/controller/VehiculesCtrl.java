package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.ListeVehicules;
import root.model.Vehicule;
import root.view.VehiculesFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des véhicules.
 */
public class VehiculesCtrl {

  private Stage fenetre;

  public VehiculesCtrl(Stage fenetre) {
    this.fenetre = fenetre;
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
    // TODO: Supprimer un véhicule du modèle
    VehiculeDao dao = new VehiculeDao(SingleConnection.getInstance());
    ListeVehicules listeVehicules = new ListeVehicules();
    boolean reponse = StageUtil.afficheConfirmation(fenetre);
    System.out.println(reponse);
    if (reponse) {
      dao.delete(vehicule);
      listeVehicules.supprimer(vehicule);
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
