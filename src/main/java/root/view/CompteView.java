package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import root.controller.CompteCtrl;

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

  private CompteCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public CompteView(CompteCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
