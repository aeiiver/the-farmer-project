package root.controller;

import root.model.listeClients;
import root.view.ClientsView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des clients.
 */
public class ClientsCtrl {

  private listeClients model;
  private ClientsView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public ClientsCtrl(listeClients model, ClientsView view) {
  }

  /**
   * Affiche la vue du formulaire d'ajout d'un client.
   */
  public void ajouterClient() {
  }

  /**
   * Supprime un client du modèle.
   */
  public void supprimerClient() {
  }

  /**
   * Affiche la vue du formulaire de modification d'un client.
   */
  public void editerClient() {
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  private listeClients getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  private void setModel(listeClients model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  private ClientsView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  private void setView(ClientsView view) {
    this.view = view;
  }

}
