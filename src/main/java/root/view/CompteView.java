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

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Texte à côté du champ de texte pour modifier l'adresse mail.
   */
  private Label emailLabel;
  /**
   * Champ de texte pour modifier l'adresse mail.
   */
  private TextField email;
  /**
   * Texte à côté du champ à mot de passe pour modifier le mot de passe.
   */
  private Label motdepasseLabel;
  /**
   * Champ à mot de passe pour modifier le mot de passe.
   */
  private PasswordField motdepasse;
  /**
   * Bouton pour enregistrer les données.
   */
  private Button enregistrer;
  /**
   * Bouton pour annuler les modifications.
   */
  private Button annuler;

  /**
   * Contrôleur gérant la vue de la modification des informations du compte.
   *
   * @see CompteView#CompteView(CompteCtrl)
   * @see CompteCtrl
   */
  private CompteCtrl ctrl;



}
