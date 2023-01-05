package root.view.list;

import java.net.URL;
import java.text.SimpleDateFormat;
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
import root.controller.list.CommandesCtrl;
import root.model.Commande;
import root.model.Producteur;
import root.model.list.ListeCommandes;
import root.model.session.SingleSession;

/**
 * Classe de vue pour la liste des commandes.
 */
public class CommandesView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Commande> tableau;

  /**
   * Le contrôleur de la vue.
   */
  private CommandesCtrl ctrl;

  @FXML
  private void ajouter() {
    ctrl.ajouterCommande();
  }

  @FXML
  private void supprimer() {
    Commande modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.supprimerCommande(modele);
  }

  @FXML
  private void editer() {
    Commande modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    ctrl.editerCommande(modele);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeCommandes listeCommandes = new ListeCommandes((Producteur) SingleSession.getSession().getUtilisateur());

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new CommandesCtrl(fenetreCourante, listeCommandes);
    });

    ObservableList<Commande> commandes = (ObservableList<Commande>) listeCommandes.getCommandes();
    tableau.getColumns().setAll(colonnes());
    tableau.setItems(commandes);
  }

  private List<TableColumn<Commande, String>> colonnes() {
    final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    // On définit les colonnes qu'on veut afficher...
    final TableColumn<Commande, String> numero = new TableColumn<>("Numéro");
    final TableColumn<Commande, String> libelle = new TableColumn<>("Libellé");
    final TableColumn<Commande, String> poids = new TableColumn<>("Poids");
    final TableColumn<Commande, String> date = new TableColumn<>("Date");
    final TableColumn<Commande, String> heureDeb = new TableColumn<>("Heure de départ");
    final TableColumn<Commande, String> heureFin = new TableColumn<>("Heure de fin");
    final TableColumn<Commande, String> client = new TableColumn<>("Client");

    // On définit pour chaque colonne quelle partie de l'objet "Commande" on veut afficher...
    numero.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNumCom())));
    libelle.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getLibelle())));
    poids.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPoids())));
    date.setCellValueFactory(
        cell -> new SimpleStringProperty(dateFormatter.format(cell.getValue().getDateCom())));
    heureDeb.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureDeb())));
    heureFin.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureFin())));
    client.setCellValueFactory(
        cell -> new SimpleStringProperty(cell.getValue().getClient().getPrenomNom()));

    return List.of(numero, libelle, poids, date, heureDeb, heureFin, client);
  }

}
