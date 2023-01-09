package root.view.form;

import java.net.URL;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import root.StageUtil;
import root.controller.form.TourneesFormCtrl;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;
import root.model.list.ListeCommandes;
import root.model.list.ListeVehicules;
import root.model.session.SingleSession;

/**
 * Classe de vue pour le formulaire d'ajout d'une tournée.
 */
public class TourneesFormView implements Initializable, FormView<Tournee> {

  @FXML
  private VBox root;
  @FXML
  private TextField libelle;
  @FXML
  private ComboBox<Vehicule> vehicules;
  @FXML
  private Label info;
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
    Vehicule vehiculeChoisi = vehicules.getSelectionModel().getSelectedItem();
    List<Commande> commandesSelectionnees = commandes.getSelectionModel().getSelectedItems();

    ctrl.enregistrer(libelleSaisi, vehiculeChoisi, commandesSelectionnees, numTournee);
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

    /* Lister tous les véhicules dans la ChoiceBox */
    List<Vehicule> vehiculesStockes = new ListeVehicules().getVehicules();
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

    Producteur producteur = (Producteur) SingleSession.getSession().getUtilisateur();
    Date aujourdhui = Calendar.getInstance().getTime();

    List<Commande> commandesStockeesLibres = new ListeCommandes(producteur).getCommandes().stream()
        .filter(commande -> commande.getNumTournee() <= 0
            && commande.getDateCom().compareTo(aujourdhui) >= 0).toList();
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
        setGraphic(new Text(String.format("%s : %s (%d kg) - %s/%s", item.getDateCom(),
                item.getLibelle(), item.getPoids(), item.getHeureDeb(), item.getHeureFin())));
      }
    });

    /* Afficher dynamiquement le poids total des commandes et l'heure minimale/maximale */
    commandes.getSelectionModel().getSelectedItems()
        .addListener((ListChangeListener<? super Commande>) selection -> {
          ObservableList<? extends Commande> commandesSelectionnees = selection.getList();

          // Ne rien faire si on n'a pas de sélection
          if (commandesSelectionnees.isEmpty()) {
            return;
          }

          // On peut assurément get() puisque la sélection n'est pas vide
          Date heureMin =
              commandesSelectionnees.stream()
                  .min(Comparator.comparing(Commande::getHeureDeb))
                  .get()
                  .getHeureDeb();
          Date heureMax =
              commandesSelectionnees.stream()
                  .max(Comparator.comparing(Commande::getHeureFin))
                  .get()
                  .getHeureFin();

          int poidsTotal = commandesSelectionnees.stream().mapToInt(Commande::getPoids).sum();

          info.setText(String.format("%s → %s | %d kg", heureMin, heureMax, poidsTotal));
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

    // Véhicule
    int index = vehicules.getItems().indexOf(tournee.getVehicule());
    vehicules.getSelectionModel().select(index);

    // Commandes de la tournée
    ObservableList<Commande> itemsFromListView = commandes.getItems();
    itemsFromListView.addAll(tournee.getCommandes());

    int[] indices = IntStream.range(0, itemsFromListView.size()).filter(i -> {
      List<Commande> commandesStockees = tournee.getCommandes();

      return commandesStockees.contains(itemsFromListView.get(i));
    }).toArray();
    if (indices.length > 0) {
      commandes.getSelectionModel().selectIndices(indices[0], indices);
    }
  }

}
