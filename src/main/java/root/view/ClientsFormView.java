package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.ClientsFormCtrl;
import root.model.Adresse;

/**
 * Classe de vue pour le formulaire d'ajout d'un client.
 */
public class ClientsFormView {

  private Label nomLabel;
  private TextField nom;
  private Label prenomLabel;
  private TextField prenom;
  private Label numTelLabel;
  private TextField numTel;
  private Label coordonneesLabel;
  private TextField latitude;
  private TextField longitude;
  private Adresse adresseLabel;
  private TextField adresse;
  private Label villeLabel;
  private TextField ville;
  private Label codePostLabel;
  private TextField codePost;
  private Label message;
  private Button enregistrer;
  private Button annuler;

  private ClientsFormCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ClientsFormView(ClientsFormCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne la saisie du nom.
   *
   * @return Le nom saisi.
   */
  public String getNom() {
    return null;
  }

  /**
   * Retourne la saisie du prénom.
   *
   * @return La prénom saisi.
   */
  public String getPrenom() {
    return null;
  }

  /**
   * Retourne la saisie du numéro de téléphone.
   *
   * @return Le numéro de téléphone saisi.
   */
  public String getNumTel() {
    return null;
  }

  /**
   * Retourne la saisie de la latitude.
   *
   * @return La latitude saisie.
   */
  public double getLatitude() {
    return 0;
  }

  /**
   * Retourne la saisie de la longitude.
   *
   * @return La longitude saisie.
   */
  public double getLongitude() {
    return 0;
  }

  /**
   * Retourne la saisie de l'adresse.
   *
   * @return L'adresse saisie.
   */
  public String getAdresse() {
    return null;
  }

  /**
   * Retourne la saisie du nom de la ville.
   *
   * @return Le nom de la ville saisi.
   */
  public String getVille() {
    return null;
  }

  /**
   * Retourne la saisie du code postal.
   *
   * @return Le code postal saisi.
   */
  public String getCodePost() {
    return null;
  }

  /**
   * Change le contenu du message à afficher en cas d'erreur.
   *
   * @param msg Le message à afficher.
   */
  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
