package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.VehiculesCtrl;
import root.model.Vehicule;

/**
 * Classe de vue pour la liste des véhicules.
 */
public class VehiculesView implements Initializable {

  public VBox root;
  public TableView<Vehicule> tableau;

  private VehiculesCtrl ctrl;

  @FXML
  private void ajouter() {
    ctrl.ajouterVehicule();
  }

  @FXML
  private void supprimer() {
    Vehicule modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerVehicule(modele);
  }

  @FXML
  private void editer() {
    Vehicule modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerVehicule(modele);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new VehiculesCtrl(fenetre);
    });

  }

}
