package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour la modification des informations du compte.
 */
public class CompteView {
  private MenuBar menu;
  private TextField email;
  private Label emailLabel;
  private Label motdepasseLabel;
  private PasswordField motdepasse;
  private Button enregistrer;
  private Button annuler;

  private MenuBar getMenu() {
    return menu;
  }

  private TextField getEmail() {
    return email;
  }

  private Label getEmailLabel() {
    return emailLabel;
  }

  private Label getMotdepasseLabel() {
    return motdepasseLabel;
  }

  private PasswordField getMotdepasse() {
    return motdepasse;
  }

  private Button getEnregistrer() {
    return enregistrer;
  }

  private Button getAnnuler() {
    return annuler;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setEmail(TextField email) {
    this.email = email;
  }

  private void setEmailLabel(Label emailLabel) {
    this.emailLabel = emailLabel;
  }

  private void setMotdepasseLabel(Label motdepasseLabel) {
    this.motdepasseLabel = motdepasseLabel;
  }

  private void setMotdepasse(PasswordField motdepasse) {
    this.motdepasse = motdepasse;
  }

  private void setEnregistrer(Button enregistrer) {
    this.enregistrer = enregistrer;
  }

  private void setAnnuler(Button annuler) {
    this.annuler = annuler;
  }
}