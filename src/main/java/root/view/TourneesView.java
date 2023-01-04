package root.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.CommandesCtrl;
import root.controller.TourneesCtrl;
import root.model.Commande;
import root.model.ListeCommandes;
import root.model.ListeTournees;
import root.model.SessionProducteur;
import root.model.SingleSession;
import root.model.Tournee;

/**
 * Classe de vue pour la liste des tournées.
 */
public class TourneesView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Tournee> tableau;

  /**
   * Le contrôleur de la vue.
   */
  private TourneesCtrl ctrl;

  @FXML
  private void ajouter() {
    ctrl.ajouterTournee();
  }

  @FXML
  private void supprimer() {
    Tournee modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerTournee(modele);
  }

  @FXML
  private void editer() {
    Tournee modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerTournee(modele);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeTournees modele = ((SessionProducteur) SingleSession.getSession()).getListeTournees();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TourneesCtrl(fenetreCourante, modele);
    });

    ObservableList<Tournee> tournees = (ObservableList<Tournee>) modele.getTournees();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(tournees);
  }

  public List<TableColumn<Tournee, String>> colonnes() {

    // On définit les colonnes qu'on veut afficher...
    final TableColumn<Tournee, String> numero = new TableColumn<>("Numéro");
    final TableColumn<Tournee, String> libelle = new TableColumn<>("Libellé");
    final TableColumn<Tournee, String> heureMin = new TableColumn<>("Heure minimale");
    final TableColumn<Tournee, String> heureMax = new TableColumn<>("Heure maximale");
    final TableColumn<Tournee, String> nombreCommandes = new TableColumn<>("Nombre de commandes");
    final TableColumn<Tournee, String> vehicule = new TableColumn<>("Véhicule");

    // On définit pour chaque colonne quelle partie de l'objet "Commande" on veut afficher...
    numero.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNumTournee())));
    libelle.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getLibelle())));
    heureMin.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureMin())));
    heureMax.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureMax())));
    nombreCommandes.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getCommandes().size())));
    vehicule.setCellValueFactory(
        cell -> new SimpleStringProperty(cell.getValue().getVehicule().getImmat()));

    return List.of(numero, libelle, heureMin, heureMax, nombreCommandes, vehicule);
  }

}
