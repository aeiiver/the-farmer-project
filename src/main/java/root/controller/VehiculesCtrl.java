package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.model.Vehicule;

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
    boolean reponse = StageUtil.afficheConfirmation(fenetre);
  }

  /**
   * Affiche la vue du formulaire de modification d'un véhicule.
   *
   * @param vehicule Le véhicule à éditer
   */
  public void editerVehicule(Vehicule vehicule) {
    // TODO: Modifier un véhicule
  }

}
