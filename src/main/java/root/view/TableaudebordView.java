package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordCtrl;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private ListView<String> listeCommandesTourneeSelectionee;
  @FXML
  private ListView<String> listeTourneesCourantes;

  /**
   * La fenêtre dans laquelle la vue a été chargée.
   */
  private Stage fenetre;
  /**
   * Le contrôleur de la vue.
   */
  private TableaudebordCtrl ctrl;

  @FXML
  private void ajouterTournee() {
    // TODO
  }

  @FXML
  private void supprimerTournee() {
    // TODO
  }

  @FXML
  private void editerTournee() {
    // TODO
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    // Quand on détecte que 'root' est attaché à une scène et que cette scène est attachée
    // à une fenêtre, on peut initialiser 'fenetre' et 'ctrl' sans obtenir de null pointer.
    root.sceneProperty().addListener((observableScene, oldScene, newScene) -> {

      if (oldScene == null && newScene != null) {
        newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {

          fenetre = StageUtil.getFenetre(root);
          ctrl = new TableaudebordCtrl(fenetre);

        });
      }
    });

  }

}
