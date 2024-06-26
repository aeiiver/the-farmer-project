package root.view.form;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.form.VehiculesFormCtrl;
import root.model.Vehicule;

/**
 * Classe de vue pour l'ajout de véhicules.
 */
public class VehiculesFormView implements Initializable, FormView<Vehicule> {

  @FXML
  private Pane root;
  /**
   * Champ de texte pour écrire la plaque d'immatriculation du véhicule.
   */

  @FXML
  private Label labelImmatriculation;

  @FXML
  private TextField immatriculation;
  /**
   * Champ de texte pour écrire le poids maximum du véhicule.
   */
  @FXML
  private TextField poidsMax;

  private VehiculesFormCtrl ctrl;

  /**
   * Méthode réagissant à l'appui sur le bouton de validation du formulaire
   * d'ajout ou d'édition de véhicules.
   */
  public void valider() {
    String immatriculationSaisie = immatriculation.getText().trim();
    String poidsMaxSaisi = poidsMax.getText().trim();

    ctrl.enregistrer(immatriculationSaisie, poidsMaxSaisi);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  @FXML
  private void annuler() {
    ctrl.annuler();
  }

  /**
   * Méthode initialisant la vue.
   *
   * @param url URL
   * @param resourceBundle ResourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new VehiculesFormCtrl(fenetre);
    });

  }

  /**
   * Méthode permettant de charger les données d'un véhicule dans le formulaire.
   *
   * @param modele Le modèle à charger dans le formulaire.
   */
  @Override
  public void chargeChamps(Vehicule modele) {
    immatriculation.setText(modele.getImmat());
    immatriculation.setVisible(false);
    labelImmatriculation.setVisible(false);
    poidsMax.setText(String.valueOf(modele.getPoidsMax()));
  }

}
