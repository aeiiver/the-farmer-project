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
  private Label messageErreur;
  private Button seConnecter;

  private Label getIdentifiantLabel() {
    return identifiantLabel;
  }

  private TextField getIdentifiantForm() {
    return identifiant;
  }

  private Label getMotdepasseLabel() {
    return motdepasseLabel;
  }

  private PasswordField getMotdepasse() {
    return motdepasse;
  }

  private Label getModeLabel() {
    return modeLabel;
  }

  private CheckBox getMode() {
    return mode;
  }

  private Label getMessageErreur() {
    return messageErreur;
  }

  private Button getSeConnecter() {
    return seConnecter;
  }

  private void setIdentifiantLabel(Label identifiantLabel) {
    this.identifiantLabel = identifiantLabel;
  }

  private void setIdentifiant(TextField identifiant) {
    this.identifiant = identifiant;
  }

  private void setMotdepasseLabel(Label motdepasseLabel) {
    this.motdepasseLabel = motdepasseLabel;
  }

  private void setMotdepasse(PasswordField motdepasse) {
    this.motdepasse = motdepasse;
  }

  private void setModeLabel(Label modeLabel) {
    this.modeLabel = modeLabel;
  }

  private void setMode(CheckBox mode) {
    this.mode = mode;
  }

  private void setMessageErreur(Label messageErreur) {
    this.messageErreur = messageErreur;
  }

  private void setSeConnecter(Button seConnecter) {
    this.seConnecter = seConnecter;
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
}