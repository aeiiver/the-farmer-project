package root.view.list;

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
import root.controller.list.TourneesCtrl;
import root.model.Producteur;
import root.model.Tournee;
import root.model.list.ListeTournees;
import root.model.session.SingleSession;

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

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "Ajouter".
   * Permettant d'ouvrir la fenêtre d'ajout d'une tournée.
   */
  @FXML
  private void ajouter() {
    ctrl.ajouterTournee();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "supprimer".
   * Permettant de supprimer la tournée sélectionnée.
   */
  @FXML
  private void supprimer() {
    Tournee modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerTournee(modele);
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "modifier".
   * Permettant de modifier la tournée sélectionnée.
   */
  @FXML
  private void editer() {
    Tournee modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerTournee(modele);
  }

  /**
   * Méthode initialisant la vue.
   *
   * @param url L'URL de la vue.
   * @param resourceBundle Le fichier de ressources de la vue.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeTournees listeTournees = new ListeTournees(
        (Producteur) SingleSession.getSession().getUtilisateur());

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TourneesCtrl(fenetreCourante, listeTournees);
    });

    ObservableList<Tournee> tournees = (ObservableList<Tournee>) listeTournees.getTournees();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(tournees);
  }

  /**
   * Retourne les colonnes de la table.
   *
   * @return les colonnes de la table
   */
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
