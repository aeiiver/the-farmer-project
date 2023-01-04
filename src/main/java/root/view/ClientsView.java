package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.ClientsCtrl;
import root.model.Client;

/**
 * Classe de vue pour la liste des clients.
 */
public class ClientsView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Client> tableau;

  private ClientsCtrl ctrl;

  @FXML
  private void ajouter() {
  }

  @FXML
  private void supprimer() {
  }

  @FXML
  private void editer() {
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new ClientsCtrl(fenetre);
    });
  }

}
