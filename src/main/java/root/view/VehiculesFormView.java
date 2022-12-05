package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.VehiculesFormCtrl;

/**
 * Classe de vue pour l'ajout de véhicules.
 */
public class VehiculesFormView {

  private Label immatLabel;
  private TextField immat;
  private Label capacitePoidsLabel;
  private TextField capacitePoids;
  private Label message;
  private Button enregistrer;
  private Button annuler;

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
