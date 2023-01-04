package root.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import root.controller.ClientsFormCtrl;
import root.model.*;

/**
 * Classe de vue pour le formulaire d'ajout d'un client.
 */
public class ClientsFormView implements Initializable, FormView<Client> {

  /**
   * L'élément racine du fichier FXML chargé.
   */
  @FXML
  private Pane root;
  /**
   * Champ de texte pour écrire le nom du client.
   */
  @FXML
  private TextField nom;
  /**
   * Champ de texte pour écrire le prénom du client.
   */
  @FXML
  private TextField prenom;
  /**
   * Champ de texte pour écrire le numéro de téléphone du client.
   */
  @FXML
  private TextField numTel;
  /**
   * Champ de texte pour écrire la latitude des coordonnées du client.
   */
  @FXML
  private TextField gps;
  /**
   * Champ de texte pour écrire le pays du client.
   */
  @FXML
  private TextField pays;
  /**
   * Champ de texte pour écrire le nom de la ville du client.
   */
  @FXML
  private TextField ville;
  /**
   * Champ de texte pour écrire le code postal du client.
   */
  @FXML
  private TextField codePostal;
  /**
   * Champ de texte pour écrire l'adresse du client.
   */
  @FXML
  private TextField adresse;

  /**
   * Contrôleur de la vue.
   */
  private ClientsFormCtrl ctrl;

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des clients.
   */
  @FXML
  private void enregistrer() {
    String nomSaisi = nom.getText().trim();
    String prenomSaisi = prenom.getText().trim();
    String numTelSaisi = numTel.getText().trim();
    String gpsSaisi = gps.getText().trim();
    String paysSaisi = pays.getText().trim();
    String villeSaisi = ville.getText().trim();
    String codePostalSaisi = codePostal.getText().trim();
    String adresseSaisi = adresse.getText().trim();

    ctrl.enregistrer(nomSaisi, prenomSaisi, numTelSaisi, gpsSaisi,
            paysSaisi, villeSaisi, codePostalSaisi, adresseSaisi);
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
    // TODO
  }

  /**
   * Charge les données d'un client dans les champs du formulaire.
   *
   * @param client Le client à charger.
   */
  public void chargeChamps(Client client) {

    // Nom
    nom.setText(client.getNom());

    // Prénom
    prenom.setText(client.getPrenom());

    // Numéro de téléphone
    numTel.setText(client.getNumTel());

    // Coordonnées GPS
    gps.setText(client.getGps());

    // Pays
    pays.setText(client.getAdresse().getPays());

    // Ville
    ville.setText(client.getAdresse().getVille());

    // Code Postal
    codePostal.setText(client.getAdresse().getCodePost());

    // Adresse
    adresse.setText(client.getAdresse().getNumero() + " " + client.getAdresse().getMention() + " " +
            client.getAdresse().getVoie() + " " + client.getAdresse().getNom() + " " + client.getAdresse().getComplement());
  }

}
