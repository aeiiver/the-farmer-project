package root.view.form;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.form.ClientsFormCtrl;
import root.model.Adresse;
import root.model.Client;

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
   * Champ de texte pour écrire le numéro de l'adresse du client.
   */
  @FXML
  private TextField numeroAdresse;
  /**
   * Champ de texte pour écrire la mention de l'adresse du client.
   */
  @FXML
  private TextField mention;
  /**
   * Champ de texte pour écrire le type de voie de l'adresse du client.
   */
  @FXML
  private TextField typeVoie;
  /**
   * Champ de texte pour écrire le nom de la voie de l'adresse du client.
   */
  @FXML
  private TextField nomVoie;
  /**
   * Champ de texte pour écrire le complément de l'adresse du client.
   */
  @FXML
  private TextField complementAdresse;

  private Client client = null;

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
    int numeroAdresseSaisi = 0;
    try {
      numeroAdresseSaisi = Integer.parseInt(numeroAdresse.getText().trim());
    } catch (Exception e) {
      numeroAdresseSaisi = 0;
    }
    String mentionSaisi = mention.getText().trim();
    String typeVoieSaisi = typeVoie.getText().trim();
    String nomVoieSaisi = nomVoie.getText().trim();
    String complementAdresseSaisi = complementAdresse.getText().trim();

    ctrl.enregistrer(nomSaisi, prenomSaisi, numTelSaisi, gpsSaisi,
            paysSaisi, villeSaisi, codePostalSaisi, numeroAdresseSaisi,
            mentionSaisi, typeVoieSaisi, nomVoieSaisi, complementAdresseSaisi,
            client);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  @FXML
  private void annuler() {
    ctrl.annuler();
  }

  /**
   * Initialise la vue.
   *
   * @param url L'URL utilisée pour localiser le fichier FXML.
   * @param resourceBundle La ressource utilisée pour localiser le fichier FXML.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new ClientsFormCtrl(fenetreCourante);
    });

  }

  /**
   * Charge les données d'un client dans les champs du formulaire.
   *
   * @param client Le client à charger.
   */
  public void chargeChamps(Client client) {
    this.client = client;
    nom.setText(client.getNom());
    prenom.setText(client.getPrenom());
    numTel.setText(client.getNumTel());
    gps.setText(client.getGps());
    pays.setText(client.getAdresse().getPays());
    ville.setText(client.getAdresse().getVille());
    codePostal.setText(client.getAdresse().getCodePost());
    numeroAdresse.setText(String.valueOf(client.getAdresse().getNumero()));
    mention.setText(client.getAdresse().getMention());
    typeVoie.setText(client.getAdresse().getVoie());
    nomVoie.setText(client.getAdresse().getNom());
    complementAdresse.setText(client.getAdresse().getComplement());
  }

}
