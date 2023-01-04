package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordCtrl;
import root.model.Commande;
import root.model.Tournee;
import root.model.list.ListeCommandes;
import root.model.list.ListeTournees;
import root.model.session.SessionProducteur;
import root.model.session.SingleSession;


/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private ListView<Commande> listeCommandesTourneeSelectionee;
  @FXML
  private ListView<Tournee> listeTourneesCourantes;

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
    ListeCommandes modeleCommande =
        ((SessionProducteur) SingleSession.getSession()).getListeCommandes();
    ListeTournees modeleTournee =
        ((SessionProducteur) SingleSession.getSession()).getListeTournees();

    // Quand on détecte que 'root' est attaché à une scène et que cette scène est attachée
    // à une fenêtre, on peut initialiser 'fenetre' et 'ctrl' sans obtenir de null pointer.
    root.sceneProperty().addListener((observableScene, oldScene, newScene) -> {

      if (oldScene == null && newScene != null) {
        newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {

          fenetre = StageUtil.getFenetre(root);
          ctrl = new TableaudebordCtrl(fenetre);

        });
      }
      ObservableList<Commande> commandes = (ObservableList<Commande>) modeleCommande.getCommandes();
      ObservableList<Tournee> tournees = (ObservableList<Tournee>) modeleTournee.getTournees();
      if (!(commandes == null)) {
        listeCommandesTourneeSelectionee.setItems(commandes);
        listeCommandesTourneeSelectionee.setOrientation(Orientation.HORIZONTAL);
      }
      if (!(tournees == null)) {
        listeTourneesCourantes.setItems(tournees);
      }
    });

  }

}
