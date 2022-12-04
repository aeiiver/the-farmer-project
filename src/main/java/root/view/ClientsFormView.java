package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

  public ClientsFormView() {

  }

  public String getNom() {
    return null;
  }

  public String getPrenom() {
    return null;
  }

  public String getNumTel() {
    return null;
  }

  public String getLatitude() {
    return null;
  }

  public String getLongitude() {
    return null;
  }

  public String getAdresse() {
    return null;
  }

  public String getVille() {
    return null;
  }

  public String getCodePost() {
    return null;
  }

  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
