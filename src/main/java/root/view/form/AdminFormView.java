package root.view.form;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.form.AdminFormCtrl;
import root.model.Admin;


/**
 * Classe de vue pour l'ajout de producteurs.
 */
public class AdminFormView implements Initializable, FormView<Admin> {

  @FXML
  private Pane root;
  @FXML
  private PasswordField mdp;
  @FXML
  private TextField mail;

  @FXML
  private TextField pseudo;


  private Admin admin;


  private AdminFormCtrl ctrl;

  /**
   * Méthode appelée par l'appui sur le bouton "Valider".
   * Permet de valider le formulaire.
   */
  @FXML
  private void enregistrer() {

    String mdpSaisi = mdp.getText();
    String mailSaisi = mail.getText();
    String pseudoSaisi = pseudo.getText();


    ctrl.enregistrer(mdpSaisi, mailSaisi, pseudoSaisi);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  @FXML
  private void annuler() {
    ctrl.annuler();
  }

  /**
   * Méthode initialisant la vue.
   *
   * @param url L'URL du fichier FXML.
   * @param resourceBundle La ressource.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new AdminFormCtrl(fenetre);
    });

  }

  /**
   * Méthode permettant de charger les données d'un producteur dans le formulaire.
   *
   * @param modele Le modèle à charger dans le formulaire.
   */
  @Override
  public void chargeChamps(Admin modele) {
    this.admin = modele;
    pseudo.setText(modele.getPseudo());
    mail.setText(modele.getMail());
  }

}
