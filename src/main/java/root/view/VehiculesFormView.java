package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.VehiculesFormCtrl;

/**
 * Classe de vue pour l'ajout de véhicules.
 */
public class VehiculesFormView {

  /**
   * Texte à côté du champ de texte pour la plaque d'immatriculation du véhicule.
   */
  private Label immatLabel;
  /**
   * Champ de texte pour écrire la plaque d'immatriculation du véhicule.
   */
  private TextField immat;
  /**
   * Texte à côté du champ de texte pour la poids maximum du véhicule.
   */
  private Label capacitePoidsLabel;
  /**
   * Champ de texte pour écrire la poids maximum du véhicule.
   */
  private TextField capacitePoids;
  /**
   * Permet d'afficher le message d'erreur.
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
   * TODO
   */
  private VehiculesFormCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public VehiculesFormView(VehiculesFormCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne le numéro d'immatriculation saisi.
   *
   * @return Le numéro d'immatriculation saisi.
   */
  public String getImmat() {
    return null;
  }

  /**
   * Retourne la capacité maximale de transport saisie.
   *
   * @return La capacité saisie.
   */
  public double getCapacitePoids() {
    return 0;
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
