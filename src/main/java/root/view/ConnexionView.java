package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import root.controller.ConnexionCtrl;

/**
 * Classe de vue pour la connexion.
 */
public class ConnexionView {

  /**
   * Text d'indication pour la saisie de l'identifiant.
   */
  private Label identifiantLabel;

  /**
   * Zone de saisie de l'identifiant.
   */
  private TextField identifiant;

  /**
   * Text d'indication pour la saisie du mot de passe.
   */
  private Label motdepasseLabel;

  /**
   * Zone de saisie du mot de passe.
   */
  private PasswordField motdepasse;

  /**
   * Text d'indication pour la selection du mode de connexion.
   */
  private Label modeLabel;

  /**
   * Selectionneur du mode de connexion.
   * Soit Producteur soit administrateur.
   */
  private CheckBox mode;

  /**
   * Text des messages d'erreurs.
   * Sera modifier en cas d'échec de la connexion.
   *
   * @see ConnexionView#setMessage(String)
   */
  private Label message;

  /**
   * Bouton permettant de lancer la tentative de connexion.
   */
  private Button connexionButton;

  /**
   * Contrôleur gérant la vue de la connexion.
   *
   * @see ConnexionView#ConnexionView(ConnexionCtrl)
   * @see ConnexionCtrl
   */
  private ConnexionCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ConnexionView(ConnexionCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne l'identifiant saisi.
   *
   * @return identifiant saisi
   */
  public String getIdentifiant() {
    return null;
  }

  /**
   * Retourne le mot de passe saisi.
   *
   * @return mot de passe saisi
   */
  public String getMdp() {
    return null;
  }

  /**
   * Retourne le mode de connexion.
   *
   * @return mode de connexion
   */
  public String getConnexionMode() {
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
