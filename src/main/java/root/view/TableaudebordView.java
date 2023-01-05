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

  private final CalendrierView calendrierView = new CalendrierView();

  /**
   * Le contrôleur de la vue.
   */
  private TableaudebordCtrl ctrl;

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "ajouter".
   * Permet d'ajouter une tournée.
   */
  @FXML
  private void ajouterTournee() {
    ctrl.ajouterTournee();
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "supprimer".
   * Permet de supprimer une tournée.
   */
  @FXML
  private void supprimerTournee() {
    Tournee modele = listeTourneesCourantes.getSelectionModel().getSelectedItem();

    if (modele == null) {
      return;
    }
    ctrl.supprimerTournee(modele);
  }

  /**
   * Méthode déclenchée lors de l'appui sur le bouton "modifier".
   * Permet de modifier une tournée.
   */
  @FXML
  private void editerTournee() {
    Tournee modele = listeTourneesCourantes.getSelectionModel().getSelectedItem();

    if (modele == null) {
      return;
    }
    ctrl.editerTournee(modele);
  }

  /**
   * Méthode permettant d'initialiser la vue.
   *
   * @param url L'url.
   * @param resourceBundle Le bundle.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    /* Initialise les listes */
    Producteur producteur = (Producteur) SingleSession.getSession().getUtilisateur();
    ListeTournees modeleListeTournees = new ListeTournees(producteur);

    /* Charge quand la fenêtre est chargée */
    StageUtil.onWindowLoad(root, () -> {
      // Charge le contrôleur
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new TableaudebordCtrl(fenetre, modeleListeTournees);
    });

    /* Carte */
    // Prépare la carte
    carte.setCenter(46.8332, 2.76008); // Centre la carte au niveau de la France
    carte.setZoom(6);

    // Prépare une couche de marqueurs
    PoiLayer coucheMarqueur = new PoiLayer();

    // Ajoute la couche à la carte
    carte.addLayer(coucheMarqueur);

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
            double[] gpsClient = Arrays.stream(commande.getClient().getGps().split(","))
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
