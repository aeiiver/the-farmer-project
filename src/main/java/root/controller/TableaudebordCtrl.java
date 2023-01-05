package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.model.Tournee;
import root.model.list.ListeTournees;
import root.view.form.TourneesFormView;

/**
 * Classe contrôleuse pour la vue et modèle du tableau de bord.
 */
public class TableaudebordCtrl {

  private Stage fenetre;

  private ListeTournees modele;

  /**
   * Constructeur.
   *
   * @param fenetre La fenêtre principale.
   */
  public TableaudebordCtrl(Stage fenetre, ListeTournees modele) {
    this.fenetre = fenetre;
    this.modele = modele;
  }

  /**
   * Ouvre la fenêtre de création d'une tournée.
   */
  public void ajouterTournee() {
    SceneChanger.voirFormTournee(fenetre);
  }

  /**
   * Ouvre la fenêtre de validation de suppression d'une tournée.
   */
  public void supprimerTournee(Tournee tournee) {
    boolean estDaccord = StageUtil.afficheConfirmation(fenetre);

    if (estDaccord) {
      modele.supprimer(tournee);
    }
  }


  /**
   * Ouvre la fenêtre de modification d'une tournée.
   */
  public void editerTournee(Tournee tournee) {
    TourneesFormView vue = (TourneesFormView) SceneChanger.voirFormTournee(fenetre);
    vue.chargeChamps(tournee);
  }

}
