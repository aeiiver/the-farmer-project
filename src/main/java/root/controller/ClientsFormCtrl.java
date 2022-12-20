package root.controller;

import root.model.ListeClients;
import root.view.ClientsFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un client.
 */
public class ClientsFormCtrl {

  /**
   * Modèle de la liste des clients.
   *
   * @see ClientsFormCtrl#ClientsFormCtrl(ListeClients, ClientsFormView)
   * @see ClientsFormCtrl#getModel()
   */
  private ListeClients model;

  /**
   * Vue du formulaire d'ajout et modification d'un client.
   *
   * @see ClientsFormCtrl#ClientsFormCtrl(ListeClients, ClientsFormView)
   * @see ClientsFormCtrl#getView()
   */
  private ClientsFormView view;

  /**
   * Constructeur de classe.
   *
   * @param model Le modèle à associer.
   * @param view  La vue à associer.
   */
  public ClientsFormCtrl(ListeClients model, ClientsFormView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des clients.
   */
  public void enregistrer() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void cancel() {
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
  public ClientsFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(ClientsFormView view) {
    this.view = view;
  }

}
