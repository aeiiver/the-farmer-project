package root.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import root.StageUtil;
import root.controller.CommandesFormCtrl;
import root.model.Client;
import root.model.Commande;
import root.model.SessionProducteur;
import root.model.SingleSession;

/**
 * Classe de vue pour le formulaire d'ajout d'une commande.
 */
public class CommandesFormView implements Initializable, FormView<Commande> {

  @FXML
  private VBox root;
  @FXML
  private TextField libelle;
  @FXML
  private TextField poids;
  @FXML
  private ChoiceBox<Client> clients;
  @FXML
  private DatePicker date;
  @FXML
  private TextField heureDeb;
  @FXML
  private TextField heureFin;

  private int numCom = -1;

  private CommandesFormCtrl ctrl;

  @FXML
  private void enregistrer() {
    String libelleSaisi = libelle.getText();
    String poidsSaisi = poids.getText();
    Client clientChoisi = clients.getSelectionModel().getSelectedItem();
    LocalDate dateChoisie = date.getValue();
    String heureDebSaisie = heureDeb.getText();
    String heureFinSaisie = heureFin.getText();

    ctrl.enregistrer(libelleSaisi, poidsSaisi, clientChoisi, dateChoisie, heureDebSaisie,
        heureFinSaisie, numCom);
  }

  @FXML
  private void annuler() {
    ctrl.annuler();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new CommandesFormCtrl(fenetreCourante);
    });

    /* Lister tous les clients dans la ChoiceBox */
    List<Client> clientsStockes =
        ((SessionProducteur) SingleSession.getSession()).getListeClients().getClients();
    clients.getItems().addAll(clientsStockes);

    // On définit comment on veut afficher un objet Client dans la ChoiceBox.
    clients.setConverter(new StringConverter<>() {
      @Override
      public String toString(Client client) {
        if (client == null) {
          return "";
        }
        return client.getPrenomNom();
      }

      @Override
      public Client fromString(String s) {
        return null;
      }
    });
  }

  /**
   * Charge les données d'une commande dans les champs du formulaire.
   *
   * @param commande La commande à charger.
   */
  @Override
  public void chargeChamps(Commande commande) {
    numCom = commande.getNumCom();

    libelle.setText(commande.getLibelle());
    poids.setText(String.valueOf(commande.getPoids()));

    int index = clients.getItems().indexOf(commande.getClient());
    clients.getSelectionModel().select(index);

    date.setValue(commande.getDateCom().toLocalDate());

    Calendar calendrier = Calendar.getInstance();
    calendrier.setTime(commande.getHeureDeb());
    heureDeb.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));

    calendrier.setTime(commande.getHeureFin());
    heureFin.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));
  }

}
