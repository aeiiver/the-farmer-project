package root.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * Classe contrôleuse de la barre de menu administateur.
 */
public class MenubarAdminCtrl extends MainCtrl {

  @FXML
  private MenuBar root;

  /**
   * Constructeur de classe.
   *
   * @param primaryStage La fenêtre principale.
   */
  public MenubarAdminCtrl(Stage primaryStage) {
    super(primaryStage);
  }


  public void gotoTableaudebord(ActionEvent actionEvent) {
    voirTableauDeBordAdmin();
  }

  public void gotoListeProducteurs(ActionEvent actionEvent) {
    voirProducteurListe();
  }

  public void gotoFormProducteur(ActionEvent actionEvent) {
    voirProducteurForm();
  }
}
