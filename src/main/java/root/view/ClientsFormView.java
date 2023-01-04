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

  /**
   * Texte à côté du champ de texte pour le nom du client.
   */
  private Label nomLabel;
  /**
   * Champ de texte pour écrire le nom du client.
   *
   * @see ClientsFormView#getNom()
   */
  private TextField nom;
  /**
   * Texte à côté du champ de texte pour le prénom du client.
   */
  private Label prenomLabel;
  /**
   * Champ de texte pour écrire le prénom du client.
   *
   * @see ClientsFormView#getPrenom()
   */
  private TextField prenom;
  /**
   * Texte à côté du champ de texte pour le numéro téléphone du client.
   */
  private Label numTelLabel;
  /**
   * Champ de texte pour écrire le numéro de téléphone du client.
   *
   * @see ClientsFormView#getNumTel()
   */
  private TextField numTel;
  /**
   * Texte à côté des champs de textes pour les coordonnées du client.
   */
  private Label coordonneesLabel;
  /**
   * Champ de texte pour écrire la latitude des coordonnées du client.
   *
   * @see ClientsFormView#getLatitude()
   */
  private TextField latitude;
  /**
   * Champ de texte pour écrire la longitude des coordonnées du client.
   *
   * @see ClientsFormView#getLongitude()
   */
  private TextField longitude;
  /**
   * Ensemble des information liée à l'adresse du client.
   *
   * @see Adresse
   * @see ClientsFormView#getAdresse()
   */
  private Adresse adresseLabel;
  /**
   * Champ de texte pour écrire l'adresse du client.
   *
   * @see ClientsFormView#getAdresse()
   */
  private TextField adresse;
  /**
   * Texte à côté du champ de texte pour la ville du client.
   */
  private Label villeLabel;
  /**
   * Champ de texte pour écrire le nom de la ville du client.
   *
   * @see ClientsFormView#getVille()
   */
  private TextField ville;
  /**
   * Texte à côté du champ de texte pour le code postal du client.
   */
  private Label codePostLabel;
  /**
   * Champ de texte pour écrire le code postal du client.
   *
   * @see ClientsFormView#getCodePost()
   */
  private TextField codePost;
  /**
   * Contenu du message d'erreur.
   */
  private Label message;
  /**
   * Bouton pour enregistrer les champs du formulaire.
   */
  private Button enregistrer;
  /**
   * Bouton pour annuler le formulaire.
   */
  private Button annuler;



  /**
   * Retourne la saisie du nom.
   *
   * @return Le nom saisi.
   */
  public String getNom() {
    return nom.getText();
  }

  /**
   * Retourne la saisie du prénom.
   *
   * @return Le prénom saisi.
   */
  public String getPrenom() {
    return prenom.getText();
  }

  /**
   * Retourne la saisie du numéro de téléphone.
   *
   * @return Le numéro de téléphone saisi.
   */
  public String getNumTel() {
    return numTel.getText();
  }

  /**
   * Retourne la saisie de la latitude.
   *
   * @return La latitude saisie.
   */
  public double getLatitude() {
    return Double.parseDouble(latitude.getText());
  }

  /**
   * Retourne la saisie de la longitude.
   *
   * @return La longitude saisie.
   */
  public double getLongitude() {
    return Double.parseDouble(longitude.getText());
  }

  /**
   * Retourne la saisie de l'adresse.
   *
   * @return L'adresse saisie.
   */
  public String getAdresse() {
    return adresse.getText();
  }

  /**
   * Retourne la saisie du nom de la ville.
   *
   * @return Le nom de la ville saisi.
   */
  public String getVille() {
    return ville.getText();
  }

  /**
   * Retourne la saisie du code postal.
   *
   * @return Le code postal saisi.
   */
  public String getCodePost() {
    return codePost.getText();
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
