package root.view;

import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.TableaudebordCtrl;
import root.data.CommandeDao;
import root.data.SingleConnection;
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

    listeTourneesCourantes.setCellFactory(lv -> {
      ListCell<Tournee> cell = new ListCell<>();
      cell.textProperty().bind(cell.itemProperty().asString());
      cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      StackPane stackPane = new StackPane();
      Label label = new Label();
      label.textProperty().bind(cell.itemProperty().asString());
      stackPane.getChildren().add(label);
      cell.setGraphic(stackPane);
      cell.itemProperty().addListener((observable, oldValue, newValue)
          -> {
            if (newValue != null && newValue.estValide()) {
              stackPane.setStyle("-fx-border-color: green; "
                  + "-fx-border-width: 2px; "
                  + "-fx-border-radius: 5px");
            } else {
              stackPane.setStyle("-fx-border-color: red; "
                    + "-fx-border-width: 2px; "
                    + "-fx-border-radius: 5px;");
            }
          });
      return cell;
    });

    // Détecte quand une tournée est sélectionnée
    listeTourneesCourantes.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldSelection, tourneeSelectionnee) -> {

          // Change la liste des commandes courantes
          ObservableList<Commande> commandesTournee =
              FXCollections.observableArrayList(tourneeSelectionnee.getCommandes());

          listeCommandes.setFixedCellSize(120);

          listeCommandes.setCellFactory(lv -> {
            ListCell<Commande> cell = new CommandeCell();
            cell.textProperty().bind(cell.itemProperty().asString());

            cell.setOnDragDetected(event -> {
              if (cell.getItem() == null) {
                return;
              }
              Dragboard db =
                  cell.startDragAndDrop(javafx.scene.input.TransferMode.MOVE);
              ClipboardContent content = new ClipboardContent();
              content.putString(String.valueOf(cell.getItem().getNumCom()));
              db.setContent(content);
              event.consume();
            });
            return cell;
          });

          listeCommandes.setOnDragOver(event -> {
            if (event.getGestureSource() != listeCommandes
                && event.getDragboard().hasString()) {
              event.acceptTransferModes(javafx.scene.input.TransferMode.MOVE);
            }
            event.consume();
          });

          listeCommandes.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
              int draggedIndex = listeCommandes.getItems().indexOf(
                  new CommandeDao(SingleConnection.getInstance())
                      .get(Integer.parseInt(db.getString()))
              );
              int dropIndex;
              if (listeCommandes.getSelectionModel().isSelected(draggedIndex)) {
                listeCommandes.getSelectionModel().clearSelection();
              }
              if (event.getX() > listeCommandes.getWidth() - listeCommandes.getFixedCellSize()) {
                dropIndex = listeCommandes.getItems().size() - 1;
              } else {
                dropIndex = (int) (event.getX() / listeCommandes.getFixedCellSize());
              }
              System.out.println(draggedIndex + " " + dropIndex+ " " + db.getString());
              for (int i = 0; i < listeCommandes.getItems().size(); i++) {
                Commande commande = listeCommandes.getItems().get(i);
                int ordreTournee = commande.getOrdreTournee();
                if (ordreTournee == draggedIndex) {
                  ordreTournee = dropIndex;
                } else if (draggedIndex < dropIndex) {
                  if (ordreTournee > draggedIndex && ordreTournee <= dropIndex) {
                    ordreTournee--;
                  }
                } else {
                  if (ordreTournee < draggedIndex && ordreTournee >= dropIndex) {
                    ordreTournee++;
                  }
                }
                commande.setOrdreTournee(ordreTournee);
                new CommandeDao(SingleConnection.getInstance()).update(commande);
              }
              listeCommandes.setItems(commandesTournee.sorted(Comparator.comparing(Commande::getOrdreTournee)));
              event.setDropCompleted(true);
            }
            event.consume();
          });
          listeCommandes.setItems(commandesTournee.sorted(Comparator.comparing(Commande::getOrdreTournee)));
          //.sorted(Comparator.comparing(Commande::getOrdreTournee))

          // Met à jour les marqueurs sur la carte
          coucheMarqueur.effacerMarqueurs();



          commandesTournee.forEach(commande -> {
            double[] gpsClient = Arrays.stream(commande.getClient().getGps().split(","))
                .mapToDouble(Double::valueOf)
                .toArray();

            double longitude = gpsClient[0];
            double latitude = gpsClient[1];

            coucheMarqueur.addMarqueur(new MapPoint(latitude, longitude),
                new Circle(7.5, Color.RED));
          });
        });

  }

  /**
   * Classe permettant de gérer l'affichage des commandes dans la liste.
   */
  private static class CommandeCell extends ListCell<Commande> {
    /**
     * Méthode permettant de gérer la mise à jour des cellules de la liste.
     *
     * @param item Commande à afficher
     * @param empty Booléen indiquant si la cellule est vide
     */
    protected void updateItems(Commande item, boolean empty) {
      super.updateItem(item, empty);
      if (empty || item == null) {
        setText("");
      } else {
        setText(item.toString());
      }
    }
  }

}
