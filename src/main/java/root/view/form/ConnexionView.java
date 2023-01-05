package root.view.form;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.ConnexionCtrl;

/**
 * Classe de vue pour la connexion.
 */
public class ConnexionView implements Initializable {

  /**
   * L'élément racine du fichier FXML.
   */
  @FXML
  private VBox root;
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
   * Selection du mode de connexion.
   * Si la case est cochée, l'utilisateur se connecte en tant qu'administrateur.
   */
  @FXML
  private CheckBox modeAdmin;

  /**
   * Le contrôleur de la vue.
   */
  private ConnexionCtrl ctrl;

  /**
   * Méthode permettant de valider la connexion.
   *
   */
  @FXML
  private void verifieIdentifiants() {
    String identifiantSaisi = identifiant.getText().trim();
    String motdepasseSaisi = motdepasse.getText().trim();
    boolean estAdmin = modeAdmin.isSelected();

    ctrl.verifieIdentifiants(identifiantSaisi, motdepasseSaisi, estAdmin);
  }

  /**
   * Méthode permettant d'intialiser la vue.
   *
   * @param url L'URL de la vue.
   * @param resourceBundle La ressource de la vue.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new ConnexionCtrl(fenetreCourante);
    });

    // Quand on appuie sur la touche Entrée, on lance la tentative de connexion.
    root.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER) {
        verifieIdentifiants();
      }
    });
  }

}
