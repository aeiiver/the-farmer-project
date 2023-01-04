package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.CommandesCtrl;
import root.controller.TableaudebordAdminCtrl;
import root.model.Client;
import root.model.Producteur;

/**
 * Classe de vue pour le tableau de bord administrateur.
 */
public class TableaudebordAdminView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private ListView<Producteur> listeProducteurs;
  @FXML
  private ListView<Client> listeClients;

  TableaudebordAdminCtrl ctrl;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TableaudebordAdminCtrl(fenetreCourante);
    });
  }

}
