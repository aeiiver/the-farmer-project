package root.controller;

import javafx.stage.Stage;
import root.model.ListeClients;
import root.view.ClientsFormView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un client.
 */
public class ClientsFormCtrl extends MainCtrl {

  /**
   * Modèle de la liste des clients.
   *
   * @see ClientsFormCtrl#getModel()
   */
  private ListeClients model;

  /**
   * Vue du formulaire d'ajout et modification d'un client.
   *
   * @see ClientsFormCtrl#getView()
   */
  private ClientsFormView view;

  /**
   * Constructeur de la classe.
   */
  public ClientsFormCtrl(Stage primaryStage) {
    super(primaryStage);
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
