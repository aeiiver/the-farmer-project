package root.view;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import root.StageUtil;
import root.controller.TourneesFormCtrl;
import root.model.Commande;
import root.model.SessionProducteur;
import root.model.SingleSession;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Classe de vue pour le formulaire d'ajout d'une tournée.
 */
public class TourneesFormView implements Initializable, FormView<Tournee> {

  @FXML
  private VBox root;
  @FXML
  private TextField libelle;
  @FXML
  private TextField heureMin;
  @FXML
  private TextField heureMax;
  @FXML
  private ChoiceBox<Vehicule> vehicules;
  @FXML
  private ListView<Commande> commandes;

  private int numTournee = -1;

  private TourneesFormCtrl ctrl;

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des tournées.
   */
  @FXML
  private void enregistrer() {
    String libelleSaisi = libelle.getText().trim();
    String heureMinSaisie = heureMin.getText().trim();
    String heureMaxSaisie = heureMax.getText().trim();
    Vehicule vehiculeChoisi = vehicules.getSelectionModel().getSelectedItem();
    List<Commande> commandesSelectionnees = commandes.getSelectionModel().getSelectedItems();

    ctrl.enregistrer(libelleSaisi, heureMinSaisie, heureMaxSaisie, vehiculeChoisi,
        commandesSelectionnees, numTournee);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  @FXML
  private void annuler() {
    ctrl.annuler();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TourneesFormCtrl(fenetreCourante);
    });

    SessionProducteur session = (SessionProducteur) SingleSession.getSession();

    /* Lister tous les véhicules dans la ChoiceBox */
    List<Vehicule> vehiculesStockes = session.getListeVehicules().getVehicules();
    vehicules.getItems().addAll(vehiculesStockes);

    // On définit comment on veut afficher un objet "Vehicule" dans la ChoiceBox.
    vehicules.setConverter(new StringConverter<>() {
      @Override
      public String toString(Vehicule vehicule) {
        if (vehicule == null) {
          return "";
        }
        return String.format("%s (%d kg)", vehicule.getImmat(), vehicule.getPoidsMax());
      }

      @Override
      public Vehicule fromString(String s) {
        return null;
      }
    });

    /* Lister toutes les commandes dans la ListView */

    /*
    TODO
    Comportement attendu: Retirer une commande d'une tournée devrait la faire apparaître parmi dans
    la ListView quand on ajoute ou édite une autre tournée.

    Bug: Quand on supprime ou modifie une tournée, l'état de l'application n'est pas au
    courant des changements faits aux commandes (leur champ "numTournee" est muté).
    Résultat après le filtre: les commandes qu'on retire d'une tournée ne s'affichent pas
    dans la ListView alors qu'elles devraient.
    */
    // List<Commande> commandesStockeesLibres = session.getListeCommandes().getCommandes()
    //        .stream()
    //        .filter(commande -> commande.getNumTournee() <= 0)
    //        .toList();

    List<Commande> commandesStockeesLibres = session.getListeCommandes().getCommandes();
    commandes.getItems().addAll(commandesStockeesLibres);

    commandes.prefHeight(commandes.getFixedCellSize() * 3);
    commandes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    // On définit comment on veut afficher un objet "Commande" dans la ListView.
    commandes.setCellFactory(listview -> new ListCell<>() {
      @Override
      protected void updateItem(Commande item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
          setGraphic(null);
          return;
        }
        setGraphic(new Text(String.format("%s (%d kg)", item.getLibelle(), item.getPoids())));
      }

    });
  }

  /**
   * Charge les données d'une tournée dans les champs du formulaire.
   *
   * @param tournee La tournée à charger.
   */
  public void chargeChamps(Tournee tournee) {
    numTournee = tournee.getNumTournee();

    // Libellé
    libelle.setText(tournee.getLibelle());

    // Heure minimale
    Calendar calendrier = Calendar.getInstance();
    calendrier.setTime(tournee.getHeureMin());
    heureMin.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));

    // Heure maximale
    calendrier.setTime(tournee.getHeureMax());
    heureMax.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));

    // Véhicule
    int index = vehicules.getItems().indexOf(tournee.getVehicule());
    vehicules.getSelectionModel().select(index);

    // Commandes de la tournée
    ObservableList<Commande> itemsFromListView = commandes.getItems();

    int[] indices = IntStream.range(0, itemsFromListView.size()).filter(i -> {
      List<Commande> commandesStockees = tournee.getCommandes();

      return commandesStockees.contains(itemsFromListView.get(i));
    }).toArray();
    if (indices.length > 0) {
      commandes.getSelectionModel().selectIndices(indices[0], indices);
    }
  }

}
