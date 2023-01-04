package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.ProducteursCtrl;
import root.model.*;

/**
 * Classe de vue pour la liste des producteurs.
 */
public class ProducteursView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TableView<Producteur> tableau;

  /**
   * Contrôleur gérant la vue de la liste des producteurs.
   *
   * @see ProducteursCtrl
   */
  private ProducteursCtrl ctrl;

  @FXML
  private void ajouter() {
    // TODO cliquer sur "ajouter" devrait ouvrir le formulaire
  }

  @FXML
  private void supprimer() {
    // TODO cliquer sur "supprimer" devrait supprimer le producteur sélectionné
  }

  @FXML
  private void editer() {
    // TODO cliquer sur "supprimer" devrait modifier le producteur sélectionné
    // et ouvrir le formulaire
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ListeProducteurs modele = ((SessionAdmin) SingleSession.getSession()).getListeProducteurs();

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new ProducteursCtrl(fenetre,modele);
    });

  }

}
