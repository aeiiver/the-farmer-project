package root.controller;

import root.model.ListeClients;
import root.view.ClientsView;

/**
 * Classe contrôleuse pour la vue et modèle de la liste des clients.
 */
public class ClientsCtrl {

  /**
   * Modèle de la liste des clients.
   *
   * @see ClientsCtrl#ClientsCtrl(ListeClients, ClientsView)
   * @see ClientsCtrl#getModel()
   */
  private ListeClients model;

  /**
   * Vue de la liste des clients.
   *
   * @see ClientsCtrl#ClientsCtrl(ListeClients, ClientsView)
   * @see ClientsCtrl#getView()
   */
  private ClientsView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public ClientsCtrl(ListeClients model, ClientsView view) {
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
  public ListeClients getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeClients model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public ClientsView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(ClientsView view) {
    this.view = view;
  }

}
