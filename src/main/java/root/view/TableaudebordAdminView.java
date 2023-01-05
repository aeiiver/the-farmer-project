package root.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordAdminCtrl;
import root.model.Client;
import root.model.Producteur;
import root.model.list.ListeClients;
import root.model.list.ListeProducteurs;
import root.model.session.SessionAdmin;
import root.model.session.SingleSession;

/**
 * Classe de vue pour le tableau de bord administrateur.
 */
public class TableaudebordAdminView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Producteur> listeProducteurs;
  @FXML
  private TableView<Client> listeClients;

  TableaudebordAdminCtrl ctrl;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeProducteurs modeleProducteurs =
        ((SessionAdmin) SingleSession.getSession()).getListeProducteurs();
    ListeClients modeleClients =
        ((SessionAdmin) SingleSession.getSession()).getListeClients();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TableaudebordAdminCtrl(fenetreCourante);
    });

    ObservableList<Producteur> producteurs =
        (ObservableList<Producteur>) modeleProducteurs.getProducteurs();
    ObservableList<Client> clients = (ObservableList<Client>) modeleClients.getClients();

    if (!(producteurs == null)) {
      listeProducteurs.getColumns().setAll(colonnesProd());
      listeProducteurs.setItems(producteurs);
    }
    if (!(clients == null)) {
      listeClients.getColumns().setAll(colonnesCli());
      listeClients.setItems(clients);
    }
  }

  private List<TableColumn<Producteur, String>> colonnesProd() {
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

  public List<TableColumn<Client, String>> colonnesCli() {

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
