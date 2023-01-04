package root.controller;

import javafx.stage.Stage;
import root.SceneChanger;
import root.model.Client;
import root.model.ListeClients;
import root.view.ClientsFormView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des clients.
 */
public class ClientsCtrl {

  private Stage fenetre;
  private ListeClients modele;

  public ClientsCtrl(Stage fenetre, ListeClients modele) {
    this.fenetre = fenetre;
    this.modele = modele;
  }

  /**
   * Affiche la vue du formulaire d'ajout d'un client.
   */
  public void ajouterClient() {
    SceneChanger.voirFormClient(fenetre);
  }

  /**
   * Supprime un client du modèle.
   *
   * @param client Le client à supprimer.
   */
  public void supprimerClient(Client client) {
    modele.supprimer(client);
  }

  /**
   * Affiche la vue du formulaire de modification d'un client.
   *
   * @param client Le client à éditer.
   */
  public void editerClient(Client client) {
    ClientsFormView vue = (ClientsFormView) SceneChanger.voirFormClient(fenetre);
    vue.chargeChamps(client);
  }

}
