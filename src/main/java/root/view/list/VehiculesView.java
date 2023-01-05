package root.view.list;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.list.VehiculesCtrl;
import root.model.Vehicule;
import root.model.list.ListeVehicules;

/**
 * Classe de vue pour la liste des véhicules.
 */
public class VehiculesView implements Initializable {

  @FXML
  public VBox root;

  @FXML
  public TableView<Vehicule> tableau;

  private VehiculesCtrl ctrl;

  /**
   * Méthode s'exécutant lors de l'appui sur le bouton "ajouter" afin d'ajouter
   * un des véhicules.
   *
   */
  @FXML
  private void ajouter() {
    ctrl.ajouterVehicule();
  }

  /**
   * Méthode s'exécutant lors de l'appui sur le bouton "supprimer" afin de supprimer
   * un des véhicules.
   *
   */
  @FXML
  private void supprimer() {
    Vehicule modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerVehicule(modele);
  }

  /**
   * Méthode s'exécutant lors de l'appui sur le bouton "éditer" afin de modifier
   * un des véhicules.
   *
   */
  @FXML
  private void editer() {
    Vehicule modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerVehicule(modele);
  }

  /**
   * Initialise la vue de la liste des véhicules.
   *
   * @param url url de la vue
   * @param resourceBundle ressource de la vue.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeVehicules listeVehicules = new ListeVehicules();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new VehiculesCtrl(fenetre, listeVehicules);
    });

    ObservableList<Vehicule> vehicules =
        (ObservableList<Vehicule>) listeVehicules.getVehicules();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(vehicules);
    tableau.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  }

  /**
   * Crée les colonnes du tableau.
   *
   * @return les colonnes du tableau.
   */
  private List<TableColumn<Vehicule, String>> colonnes() {
    final TableColumn<Vehicule, String> Immat = new TableColumn<>("Immatriculation");
    final TableColumn<Vehicule, String> PoidsMax = new TableColumn<>("Charge maximale supportée");

    Immat.setCellValueFactory(
        cell -> new SimpleStringProperty(cell.getValue().getImmat()));
    PoidsMax.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPoidsMax())));

    return List.of(Immat, PoidsMax);
  }

}
