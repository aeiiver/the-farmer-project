package root.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Classe contrôleuse pour la vue et modèle du tableau de bord.
 */
public class TableaudebordCtrl {

  @FXML
  private VBox root;
  @FXML
  private ListView<String> listeCommandesTourneeSelectionee;
  @FXML
  private ListView<String> listeTourneesCourantes;

  @FXML
  private void ajouterTournee() {
  }

  @FXML
  private void supprimerTournee() {
  }

  @FXML
  private void editerTournee() {
  }

}
