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
import root.controller.list.ClientsCtrl;
import root.model.Client;
import root.model.list.ListeClients;
import root.model.session.SessionProducteur;
import root.model.session.SingleSession;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Client> tableau;

  private ClientsCtrl ctrl;

  @FXML
  private void ajouter() {
    ctrl.ajouterClient();
  }

  @FXML
  private void supprimer() {
    Client modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerClient(modele);
  }

  @FXML
  private void editer() {
    Client modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerClient(modele);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeClients modele = ((SessionProducteur) SingleSession.getSession()).getListeClients();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new ClientsCtrl(fenetreCourante, modele);
    });

    ObservableList<Client> clients = (ObservableList<Client>) modele.getClients();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(clients);
  }

  /**
   * Retourne les colonnes du tableau.
   *
   * @return Les colonnes du tableau.
   */
  public List<TableColumn<Client, String>> colonnes() {

    // On définit les colonnes qu'on veut afficher...
    final TableColumn<Client, String> nom = new TableColumn<>("Nom");
    final TableColumn<Client, String> prenom = new TableColumn<>("Prénom");
    final TableColumn<Client, String> numTel = new TableColumn<>("Numéro de Téléphone");
    final TableColumn<Client, String> gps = new TableColumn<>("Coordonnées GPS");
    final TableColumn<Client, String> adresse = new TableColumn<>("Adresse");

    // On définit pour chaque colonne quelle partie de l'objet "Commande" on veut afficher...
    nom.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNom())));
    prenom.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPrenom())));
    numTel.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNumTel())));
    gps.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getGps())));
    adresse.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(
                cell.getValue().getAdresse().toString())));

    return List.of(nom, prenom, numTel, gps, adresse);
  }

}
