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
  private TextField ville;
  @FXML
  private TextField codePost;
  @FXML
  private TextField pays;
  @FXML
  private PasswordField mdp;
  @FXML
  private TextField mail;

  @FXML
  private TextField numeroAdresse;

  @FXML
  private TextField mention;

  @FXML
  private TextField typeVoie;

  @FXML
  private TextField nomVoie;

  @FXML
  private TextField complementAdresse;


  private ProducteursFormCtrl ctrl;

  @FXML
  private void enregistrer() {
    String siretSaisi = siret.getText();
    String nomSaisi = nom.getText();
    String prenomSaisi = prenom.getText();
    String numTelSaisi = numTel.getText();
    String codePostSaisi = codePost.getText();
    String paysSaisi = pays.getText();
    String mdpSaisi = mdp.getText();
    String mailSaisi = mail.getText();
    String villeSaisi = ville.getText();
    String numAdresseSaisi = numeroAdresse.getText();
    String mentionSaisi = mention.getText();
    String typeVoieSaisi = typeVoie.getText();
    String nomVoieSaisi = nomVoie.getText();
    String complementAdresseSaisi = complementAdresse.getText();

    ctrl.enregistrer(siretSaisi, nomSaisi, prenomSaisi, numTelSaisi, codePostSaisi,
        paysSaisi, mdpSaisi, mailSaisi, villeSaisi, numAdresseSaisi, mentionSaisi,
            typeVoieSaisi, nomVoieSaisi, complementAdresseSaisi);
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
    siret.setText(modele.getSiret());
    nom.setText(modele.getNom());
    prenom.setText(modele.getPrenom());
    numTel.setText(modele.getNumTel());
    codePost.setText(modele.getAdresse().getCodePost());
    pays.setText(modele.getAdresse().getPays());
    mdp.setText(modele.getMdp());
    mail.setText(modele.getMail());
    ville.setText(modele.getAdresse().getVille());
    numeroAdresse.setText(String.valueOf(modele.getAdresse().getNumero()));
    mention.setText(modele.getAdresse().getMention());
    typeVoie.setText(modele.getAdresse().getVoie());
    nomVoie.setText(modele.getAdresse().getNom());
    complementAdresse.setText(modele.getAdresse().getMention());
  }

}
