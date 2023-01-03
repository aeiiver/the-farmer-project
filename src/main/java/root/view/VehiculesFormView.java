package root.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import root.controller.VehiculesFormCtrl;

import java.beans.EventHandler;

/**
 * Classe de vue pour l'ajout de véhicules.
 */
public class VehiculesFormView {

  @FXML
  private Pane root;
  /**
   * Champ de texte pour écrire la plaque d'immatriculation du véhicule.
   */
  @FXML
  private TextField immatriculation;
  /**
   * Champ de texte pour écrire le poids maximum du véhicule.
   */
  @FXML
  private TextField poidsMax;
  /**
   * Bouton pour enregistrer les champs du formulaire.
   */
  private Button enregistrer;
  /**
   * Bouton pour annuler le formulaire.
   */
  private Button annuler;

  private VehiculesFormCtrl controller = new VehiculesFormCtrl();

  /**
   * Retourne le numéro d'immatriculation saisi.
   *
   * @return Le numéro d'immatriculation saisi.
   */
  private String getImmat() {
    return immatriculation.getText();
  }

  /**
   * Retourne la capacité maximale de transport saisie.
   *
   * @return La capacité saisie.
   */
  private String getCapacitePoids() {
    return poidsMax.getText();
  }

  public void setImmat(String immat) {
    this.immatriculation.setText(immat);
  }

  public void setCapacitePoids(double capacitePoids) {
    this.poidsMax.setText(String.valueOf(capacitePoids));
  }

  public void valider() {
    System.out.println(getImmat());
    controller.enregistrer(getImmat(), getCapacitePoids(), root);
  }
}
