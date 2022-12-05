package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.ProducteursFormCtrl;

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

  private ProducteursFormCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ProducteursFormView(ProducteursFormCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne le numéro SIRET  saisi.
   *
   * @return Le numéro SIRET  saisi.
   */
  public String getSiret() {
    return null;
  }

  /**
   * Retourne le nom saisi.
   *
   * @return Le nom saisi.
   */
  public String getNom() {
    return null;
  }

  /**
   * Retourne le prénom saisi.
   *
   * @return Le prénom saisi.
   */
  public String getPrenom() {
    return null;
  }

  /**
   * Retourne le numéro de téléphone saisi.
   *
   * @return Le numéro de téléphone saisi.
   */
  public String getNumTel() {
    return null;
  }

  /**
   * Retourne l'adresse saisie.
   *
   * @return L'adresse saisie.
   */
  public String getAdresse() {
    return null;
  }

  /**
   * Retourne la ville saisie.
   *
   * @return La ville saisie.
   */
  public String getVille() {
    return null;
  }

  /**
   * Retourne le code postal saisi.
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
