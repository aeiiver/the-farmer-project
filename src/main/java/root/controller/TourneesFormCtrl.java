package root.controller;

import java.net.URL;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
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
import javafx.util.StringConverter;
import root.StageUtil;
import root.model.Commande;
import root.model.ListeCommandes;
import root.model.ListeTournees;
import root.model.Producteur;
import root.model.SessionProducteur;
import root.model.SingleSession;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une tournée.
 */
public class TourneesFormCtrl implements Initializable, FormCtrl<Tournee> {

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

  private Optional<Integer> numero = Optional.empty();

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

    /* Validation de la saisie */
    // Vérifie si champs invalides
    if (libelleSaisi.isEmpty() || heureMinSaisie.isEmpty() || heureMaxSaisie.isEmpty()
        || vehiculeChoisi == null || commandesSelectionnees.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
          StageUtil.getFenetre(root));
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    if (!validerHeure(heureMinSaisie)) {
      messageErreur += "L'heure minimale saisie n'est pas une heure valide.\n";
    }
    if (!validerHeure(heureMaxSaisie)) {
      messageErreur += "L'heure maximale saisie n'est pas une heure valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, StageUtil.getFenetre(root));
      return;
    }

    // Convertit les types valides
    Time heureMinValide = Time.valueOf(heureMinSaisie + ":00:00");
    Time heureMaxValide = Time.valueOf(heureMaxSaisie + ":00:00");

    if (heureMinValide.equals(heureMaxValide) || heureMinValide.after(heureMaxValide)) {
      StageUtil.afficheAlerte("L'heure minimale est égale ou supérieure à l'heure maximale.",
          StageUtil.getFenetre(root));
      return;
    }

    /* Après validation de la saisie */
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeTournees listeTournees = session.getListeTournees();
    ListeCommandes listeCommandes = session.getListeCommandes();

    Tournee tournee =
        new Tournee(libelleSaisi, heureMinValide, heureMaxValide, producteur, vehiculeChoisi);
    tournee.getCommandes().addAll(commandesSelectionnees);

    if (!tournee.estValide()) {
      StageUtil.afficheAlerte(
          "La tournée n'est pas valide. Le poids des commandes est supérieure à "
              + "la capacité maximale de transport du véhicule.", StageUtil.getFenetre(root));
      return;
    }

    // Persiste la tournée dans la base de données
    numero.ifPresentOrElse(numero -> {
      tournee.setNumTournee(numero);
      listeTournees.editer(tournee);

    }, () -> listeTournees.ajouter(tournee));

    commandesSelectionnees.forEach(listeCommandes::editer);

    StageUtil.getFenetre(root).close();
  }

  private boolean validerHeure(String texte) {
    if (!texte.matches("^\\d{1,2}$")) {
      return false;
    }
    int nombre = Integer.parseInt(texte);

    return 0 <= nombre && nombre <= 23;
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  @FXML
  private void annuler() {
    StageUtil.getFenetre(root).close();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
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
    la ListView

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
        setGraphic(new Text(String.format("%s (%d)", item.getLibelle(), item.getPoids())));
      }

    });
  }

  /**
   * Charge des valeurs dans les champs.
   *
   * @param tournee Le modèle qui contient les données à charger.
   */
  public void chargeChamps(Tournee tournee) {
    numero = Optional.of(tournee.getNumTournee());

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
    commandes.getSelectionModel().selectIndices(indices[0], indices);
  }

}
