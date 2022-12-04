package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour l'ajout de producteurs.
 */
public class ProducteursFormView {

  private Label siretLabel;
  private TextField siret;
  private Label nomLabel;
  private TextField nom;
  private Label prenomLabel;
  private TextField prenom;
  private Label numTelLabel;
  private TextField numTel;
  private Label adresseLabel;
  private TextField adresse;
  private Label villeLabel;
  private TextField ville;
  private Label codePostLabel;
  private TextField codePost;
  private Label message;
  private Button enregistrer;
  private Button annuler;

  public ProducteursFormView() {

  }

  public String getSiret() {
    return null;
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
