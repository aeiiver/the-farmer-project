package root.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import root.controller.ConnexionCtrl;

/**
 * Classe de vue pour la connexion.
 */
public class ConnexionView extends MainView {

  /**
   * Text d'indication pour la saisie de l'identifiant.
   */
  private Label identifiantLabel;
  /**
   * Zone de saisie de l'identifiant.
   */
  @FXML
  private TextField identifiant;

  /**
   * Zone de saisie du mot de passe.
   */
  @FXML
  private PasswordField motdepasse;

  /**
   * Selectionneur du mode de connexion.
   * Soit Producteur, soit administrateur.
   */
  @FXML
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
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public ConnexionView(ConnexionCtrl ctrl) {
    super(ctrl);
  }

  /**
   * Retourne l'identifiant saisi.
   *
   * @return identifiant saisi
   */
  public String getIdentifiant() {
    String retour = "";
    if (identifiant != null) {
      retour = identifiant.getText();
    }
    return retour;
  }

  /**
   * Retourne le mot de passe saisi.
   *
   * @return mot de passe saisi
   */
  public String getMdp() {
    String retour = "";
    if (motdepasse != null) {
      retour = motdepasse.getText();
    }
    return retour;
  }

  /**
   * Retourne le mode de connexion.
   *
   * @return mode de connexion
   */
  public boolean getConnexionMode() {
    boolean retour = false;
    if (mode != null) {
      retour = mode.isSelected();
    }
    return retour;
  }

  /**
   * Change le contenu du message à afficher en cas d'erreur.
   *
   * @param msg Le message à afficher.
   */
  public void setMessage(String msg) {
    this.message.setText(msg);
  }

  /**
   * Méthode appelée lors du clic sur le bouton de connexion.
   *
   * @param actionEvent Evènement de clic.
   */
  public void connexion(ActionEvent actionEvent) {
    actionEvent.consume();
    ((ConnexionCtrl) ctrl).verifieIdentifiants();
  }
}
