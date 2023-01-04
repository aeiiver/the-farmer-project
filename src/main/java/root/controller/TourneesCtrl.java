package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.model.ListeTournees;
import root.model.Tournee;
import root.view.TourneesFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des tournées.
 */
public class TourneesCtrl {

  private Stage fenetre;
  private ListeTournees modele;

  public TourneesCtrl(Stage fenetre, ListeTournees modele) {
    this.fenetre = fenetre;
    this.modele = modele;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'une tournée.
   */
  public void ajouterTournee() {
    SceneChanger.voirFormTournee(fenetre);
  }

  /**
   * Supprime une commande du modèle.
   */
  public void supprimerTournee(Tournee tournee) {
    modele.supprimer(tournee);
  }

  /**
   * Affiche la vue du formulaire de modification d'une tournée.
   */
  public void editerTournee(Tournee tournee) {
    TourneesFormView vue = (TourneesFormView) SceneChanger.voirFormTournee(fenetre);
    vue.chargeChamps(tournee);
  }

}
