package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordAdminCtrl;
import root.model.Client;
import root.model.Producteur;
import root.model.list.ListeClients;
import root.model.list.ListeProducteurs;
import root.model.session.SessionAdmin;
import root.model.session.SingleSession;

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
    ListeProducteurs modeleProducteurs =
        ((SessionAdmin) SingleSession.getSession()).getListeProducteurs();
    ListeClients modeleClients =
        ((SessionAdmin) SingleSession.getSession()).getListeClients();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetreCourante = StageUtil.getFenetre(root);
      ctrl = new TableaudebordAdminCtrl(fenetreCourante);
    });

    ObservableList<Producteur> producteurs =
        (ObservableList<Producteur>) modeleProducteurs.getProducteurs();
    ObservableList<Client> clients = (ObservableList<Client>) modeleClients.getClients();

    if (!(producteurs == null)) {
      listeProducteurs.setItems(producteurs);
    }
    if (!(clients == null)) {
      listeClients.setItems(clients);
    }
  }

}
