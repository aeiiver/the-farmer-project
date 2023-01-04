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
import root.controller.form.ProducteursFormCtrl;
import root.model.Producteur;

/**
 * Classe de vue pour l'ajout de producteurs.
 */
public class ProducteursFormView implements Initializable, FormView<Producteur> {

  @FXML
  private Pane root;
  @FXML
  private TextField siret;
  @FXML
  private TextField nom;
  @FXML
  private TextField prenom;
  @FXML
  private TextField numTel;
  @FXML
  private TextField adresse;
  @FXML
  private TextField ville;
  @FXML
  private TextField codePost;
  @FXML
  private TextField pays;
  @FXML
  private PasswordField mdp;
  @FXML
  private TextField mail;

  private ProducteursFormCtrl ctrl;

  @FXML
  private void enregistrer() {
    String siretSaisi = siret.getText();
    String nomSaisi = nom.getText();
    String prenomSaisi = prenom.getText();
    String numTelSaisi = numTel.getText();
    String adresseSaisi = adresse.getText();
    String codePostSaisi = codePost.getText();
    String paysSaisi = pays.getText();
    String mdpSaisi = mdp.getText();
    String mailSaisi = mail.getText();
    String villeSaisi = ville.getText();

    ctrl.enregistrer(siretSaisi, nomSaisi, prenomSaisi, numTelSaisi, adresseSaisi, codePostSaisi,
        paysSaisi, mdpSaisi, mailSaisi, villeSaisi);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new ProducteursFormCtrl(fenetre);
    });

  }

  @Override
  public void chargeChamps(Producteur modele) {

  }

}
