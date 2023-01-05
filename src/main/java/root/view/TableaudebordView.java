package root.view;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordCtrl;
import root.model.Commande;
import root.model.list.ListeCommandes;
import root.model.list.ListeTournees;
import root.model.PoiLayer;
import root.model.session.SessionProducteur;
import root.model.session.SingleSession;
import root.model.Tournee;

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
  @FXML
  private MapView carte;

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

    /* Charge quand la fenêtre est chargée */
    StageUtil.onWindowLoad(root, () -> {
      // Charge le contrôleur
      fenetre = StageUtil.getFenetre(root);
      ctrl = new TableaudebordCtrl(fenetre);
    });

    /* Remplis les listes */
    ListeCommandes modeleListeCommandes =
        ((SessionProducteur) SingleSession.getSession()).getListeCommandes();
    ListeTournees modeleListeTournees =
        ((SessionProducteur) SingleSession.getSession()).getListeTournees();

    ObservableList<Commande> commandes =
        (ObservableList<Commande>) modeleListeCommandes.getCommandes();
    ObservableList<Tournee> tournees = (ObservableList<Tournee>) modeleListeTournees.getTournees();

    if (!(commandes == null)) {
      listeCommandesTourneeSelectionee.setItems(commandes);
    }
    if (!(tournees == null)) {
      listeTourneesCourantes.setItems(tournees);
    }

    /* Carte */
    // Prépare la carte
    carte.setCenter(46.8332, 2.76008); // Centre la carte au niveau de la France
    carte.setZoom(6);

    // Prépare une couche de marqueurs
    PoiLayer poiLayer = new PoiLayer();
    poiLayer.addMarqueur(new MapPoint(46.8332, 2.76008), new Circle(5, Color.BLUE));
    poiLayer.addMarqueur(new MapPoint(46.5332, 2.66008), new Circle(5, Color.RED));
    poiLayer.addMarqueur(new MapPoint(46.7332, 2.86008), new Circle(5, Color.DARKBLUE));
    poiLayer.addMarqueur(new MapPoint(46.8312, 2.56008), new Circle(5, Color.DARKRED));

    // Ajoute la couche à la carte
    carte.addLayer(poiLayer);
  }

}
