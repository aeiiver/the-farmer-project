package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.ProducteursFormCtrl;

/**
 * Classe de vue pour l'ajout de producteurs.
 */
public class ProducteursFormView extends MainView {

  /**
   * Texte à côté du champ de texte pour le numéro SIRET du producteur.
   */
  private Label siretLabel;
  /**
   * Champ de texte pour écrire le numéro SIRET du producteur.
   *
   * @see ProducteursFormView#getSiret()
   */
  private TextField siret;
  /**
   * Texte à côté du champ de texte pour le nom du producteur.
   */
  private Label nomLabel;
  /**
   * Champ de texte pour écrire le nom du producteur.
   *
   * @see ProducteursFormView#getNom()
   */
  private TextField nom;
  /**
   * Texte à côté du champ de texte pour le prénom du producteur.
   */
  private Label prenomLabel;
  /**
   * Champ de texte pour écrire le prénom du producteur.
   *
   * @see ProducteursFormView#getPrenom()
   */
  private TextField prenom;
  /**
   * Texte à côté du champ de texte pour le numéro de téléphone du producteur.
   */
  private Label numTelLabel;
  /**
   * Champ de texte pour écrire le numéro téléphone du producteur.
   *
   * @see ProducteursFormView#getNumTel()
   */
  private TextField numTel;
  /**
   * Texte à côté du champ de texte pour l'adresse du producteur.
   */
  private Label adresseLabel;
  /**
   * Champ de texte pour écrire l'adresse du producteur.
   *
   * @see ProducteursFormView#getAdresse()
   */
  private TextField adresse;
  /**
   * Texte à côté du champ de texte pour la ville du producteur.
   */
  private Label villeLabel;
  /**
   * Champ de texte pour écrire la ville du producteur.
   *
   * @see ProducteursFormView#getVille()
   */
  private TextField ville;
  /**
   * Texte à côté du champ de texte pour le code postal du producteur.
   */
  private Label codePostLabel;
  /**
   * Champ de texte pour écrire le code postal du producteur.
   *
   * @see ProducteursFormView#getCodePost()
   */
  private TextField codePost;
  /**
   * Contenue du message d'erreur.
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
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ProducteursFormView(ProducteursFormCtrl ctrl) {
    super(ctrl);
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
