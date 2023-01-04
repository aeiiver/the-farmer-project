package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.VehiculesFormCtrl;
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
  private TextField immatriculation;
  /**
   * Champ de texte pour écrire le poids maximum du véhicule.
   */
  @FXML
  private TextField poidsMax;

  private VehiculesFormCtrl ctrl;

  public void valider() {
    String immatriculationSaisie = immatriculation.getText().trim();
    String poidsMaxSaisi = poidsMax.getText().trim();

    ctrl.enregistrer(immatriculationSaisie, poidsMaxSaisi);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new VehiculesFormCtrl(fenetre);
    });

  }

  @Override
  public void chargeChamps(Vehicule modele) {
    immatriculation.setText(modele.getImmat());
    poidsMax.setText(String.valueOf(modele.getPoidsMax()));
  }

}
