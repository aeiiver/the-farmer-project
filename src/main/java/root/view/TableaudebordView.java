package root.view;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import root.model.PoiLayer;
import root.model.Producteur;
import root.model.Tournee;
import root.model.list.ListeTournees;
import root.model.session.SingleSession;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private ListView<Commande> listeCommandes;
  @FXML
  private ListView<Tournee> listeTourneesCourantes;
  @FXML
  private MapView carte;

  //private final CalendrierView calendrierView = new CalendrierView();

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
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new TableaudebordCtrl(fenetre);
    });

    /* Carte */
    // Prépare la carte
    carte.setCenter(46.8332, 2.76008); // Centre la carte au niveau de la France
    carte.setZoom(6);

    // Prépare une couche de marqueurs
    PoiLayer coucheMarqueur = new PoiLayer();

    // Ajoute la couche à la carte
    carte.addLayer(coucheMarqueur);

    /* Initilise les listes */
    Producteur producteur = (Producteur) SingleSession.getSession().getUtilisateur();
    ListeTournees modeleListeTournees = new ListeTournees(producteur);

    ObservableList<Tournee> tournees = (ObservableList<Tournee>) modeleListeTournees.getTournees();
    listeTourneesCourantes.setItems(tournees);
    listeCommandes.setItems(FXCollections.observableArrayList());

    // Détecte quand une tournée est sélectionnée
    listeTourneesCourantes.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldSelection, tourneeSelectionnee) -> {

          // Change la liste des commandes courantes
          ObservableList<Commande> commandesTournee =
              FXCollections.observableArrayList(tourneeSelectionnee.getCommandes());
          listeCommandes.setItems(commandesTournee);

          // Met à jour les marqueurs sur la carte
          coucheMarqueur.effacerMarqueurs();

          commandesTournee.forEach(commande -> {
            double[] gpsClient = Arrays.stream(commande.getClient().getGps().split(";"))
                .mapToDouble(Double::valueOf)
                .toArray();

            double latitude = gpsClient[0];
            double longitude = gpsClient[1];

            coucheMarqueur.addMarqueur(new MapPoint(latitude, longitude),
                new Circle(7.5, Color.RED));
          });
        });

  }

}
