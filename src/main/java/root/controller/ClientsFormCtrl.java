package root.controller;

import javafx.stage.Stage;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un client.
 */
public class ClientsFormCtrl {

  private Stage fenetre;

  public ClientsFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des clients.
   */
  public void enregistrer(String nom, String prenom, String numTel, String gps,
                          String pays, String ville, String codePostal, String adresse) {
    // TODO
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void annuler() {
    // TODO
  }

}
