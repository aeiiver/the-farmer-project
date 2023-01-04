package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.model.Commande;
import root.model.ListeCommandes;
import root.view.CommandesFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des commandes.
 */
public class CommandesCtrl {

  private Stage fenetre;
  private ListeCommandes modele;

  public CommandesCtrl(Stage fenetre, ListeCommandes modele) {
    this.fenetre = fenetre;
    this.modele = modele;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'une commande.
   */
  public void ajouterCommande() {
    SceneChanger.voirFormCommande(fenetre);
  }

  /**
   * Supprime une commande du modèle.
   */
  public void supprimerCommande(Commande commande) {
    modele.supprimer(commande);
  }

  /**
   * Affiche la vue du formulaire de modification d'une commande.
   */
  public void editerCommande(Commande commande) {
    CommandesFormView vue = (CommandesFormView) SceneChanger.voirFormCommande(fenetre);
    vue.chargeChamps(commande);
  }

}
