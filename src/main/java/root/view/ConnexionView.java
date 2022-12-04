package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour la connexion.
 */
public class ConnexionView {

  private Label identifiantLabel;
  private TextField identifiant;
  private Label motdepasseLabel;
  private PasswordField motdepasse;
  private Label modeLabel;
  private CheckBox mode;
  private Label message;
  private Button connexionButton;

  public ConnexionView() {

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

  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
