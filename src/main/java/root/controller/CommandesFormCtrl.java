package root.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import root.StageUtil;
import root.model.Client;
import root.model.Commande;
import root.model.ListeCommandes;
import root.model.Producteur;
import root.model.SessionProducteur;
import root.model.SingleSession;


/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une commande.
 */
public class CommandesFormCtrl implements Initializable {

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

  private Optional<Integer> numero = Optional.empty();

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des commandes.
   */
  @FXML
  private void enregistrer() {
    String libelleSaisi = libelle.getText();
    String poidsSaisi = poids.getText();
    Client clientChoisi = clients.getSelectionModel().getSelectedItem();
    LocalDate dateChoisie = date.getValue();
    String heureDebSaisie = heureDeb.getText();
    String heureFinSaisie = heureFin.getText();

    /* Validation de la saisie */
    // Vérifie si champs vides
    if (libelleSaisi.isEmpty() || poidsSaisi.isEmpty() || clientChoisi == null
        || dateChoisie == null || heureDebSaisie.isEmpty() || heureFinSaisie.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
          StageUtil.getFenetre(root));
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    if (!validerNombre(poidsSaisi)) {
      messageErreur += "Le poids saisi n'est pas un nombre entier.\n";
    }
    if (!validerHeure(heureDebSaisie)) {
      messageErreur += "L'heure de départ saisie n'est pas une heure valide.\n";
    }
    if (!validerHeure(heureFinSaisie)) {
      messageErreur += "L'heure de fin saisie n'est pas une heure valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, StageUtil.getFenetre(root));
      return;
    }

    // Tous les types de valeur sont corrects
    int poidsValide = Integer.parseInt(poidsSaisi);
    Date dateValide = Date.valueOf(dateChoisie);
    Time heureDebValide = Time.valueOf(heureDebSaisie + ":00:00");
    Time heureFinValide = Time.valueOf(heureFinSaisie + ":00:00");

    if (heureDebValide.equals(heureFinValide) || heureDebValide.after(heureFinValide)) {
      StageUtil.afficheAlerte("L'heure de départ est égale ou supérieure à l'heure de fin.",
          StageUtil.getFenetre(root));
      return;
    }

    // Après validation de la saisie
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeCommandes listeCommandes = session.getListeCommandes();

    Commande com =
        new Commande(-1, libelleSaisi, poidsValide, dateValide, heureDebValide, heureFinValide,
            producteur, clientChoisi);

    numero.ifPresentOrElse(numero -> {
      com.setNumCom(numero);
      listeCommandes.editer(com);

    }, () -> {
      listeCommandes.ajouter(com);
    });

    StageUtil.getFenetre(root).close();
  }

  private boolean validerNombre(String texte) {
    return texte.matches("^\\d+$");
  }

  private boolean validerHeure(String texte) {
    if (!texte.matches("^\\d{1,2}$")) {
      return false;
    }
    int nombre = Integer.parseInt(texte);

    return 0 <= nombre && nombre <= 23;
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  @FXML
  private void annuler() {
    StageUtil.getFenetre(root).close();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
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
   * Charge des valeurs dans les champs.
   *
   * @param modeleObj Le modèle qui contient les données à charger.
   */
  public void chargeChamps(Object modeleObj) {
    Commande modele = (Commande) modeleObj;

    numero = Optional.of(modele.getNumCom());

    libelle.setText(modele.getLibelle());
    poids.setText(String.valueOf(modele.getPoids()));

    int index = clients.getItems().indexOf(modele.getClient());
    clients.getSelectionModel().select(index);

    date.setValue(modele.getDateCom().toLocalDate());

    Calendar calendrier = Calendar.getInstance();
    calendrier.setTime(modele.getHeureDeb());
    heureDeb.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));

    calendrier.setTime(modele.getHeureFin());
    heureFin.setText(String.valueOf(calendrier.get(Calendar.HOUR_OF_DAY)));
  }

}
