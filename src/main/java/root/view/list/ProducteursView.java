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
import root.controller.list.ProducteursCtrl;
import root.model.Producteur;
import root.model.list.ListeProducteurs;

/**
 * Classe de vue pour la liste des producteurs.
 */
public class ProducteursView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Producteur> tableau;

  /**
   * Contrôleur gérant la vue de la liste des producteurs.
   *
   * @see ProducteursCtrl
   */
  private ProducteursCtrl ctrl;

  @FXML
  private void ajouter() {
    ctrl.ajouterProducteur();
  }

  @FXML
  private void supprimer() {
    Producteur model = tableau.getSelectionModel().getSelectedItem();
    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (model == null) {
      return;
    }
    ctrl.supprimerProducteur(model);
  }

  @FXML
  private void editer() {
    Producteur model = tableau.getSelectionModel().getSelectedItem();
    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (model == null) {
      return;
    }
    ctrl.editerProducteur(model);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeProducteurs modele = new ListeProducteurs();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new ProducteursCtrl(fenetre, modele);
    });

    ObservableList<Producteur> producteurs = (ObservableList<Producteur>) modele.getProducteurs();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(producteurs);

  }

  private List<TableColumn<Producteur, String>> colonnes() {
    // On définit les colonnes qu'on veut afficher...
    final TableColumn<Producteur, String> siret = new TableColumn<>("Siret");
    final TableColumn<Producteur, String> nom = new TableColumn<>("Nom");
    final TableColumn<Producteur, String> prenom = new TableColumn<>("Prénom");
    final TableColumn<Producteur, String> mail = new TableColumn<>("Adresse mail");
    final TableColumn<Producteur, String> numTel = new TableColumn<>("Numéro de téléphone");
    final TableColumn<Producteur, String> adresse = new TableColumn<>("Adresse");

    // On définit pour chaque colonne quelle partie de l'objet "Commande" on veut afficher...
    siret.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getSiret()));
    nom.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getNom()));
    prenom.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getPrenom()));
    mail.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getMail()));
    numTel.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getNumTel()));
    adresse.setCellValueFactory(
            cell -> new SimpleStringProperty(cell.getValue().getAdresse().toString()));

    return List.of(siret, nom, prenom, mail, numTel, adresse);
  }

}
