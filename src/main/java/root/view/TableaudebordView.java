package root.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import root.controller.ConnexionCtrl;
import root.controller.MainCtrl;
import root.controller.TableaudebordCtrl;
import root.model.Commande;
import root.model.Tournee;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView extends MainView {

  /**
   * Menu de navigation sur la fênetre.
   */
  @FXML
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des tournées.
   */
  @FXML
  private ListView listeTournees;
  /**
   * Liste pour afficher la liste des commandes.
   */

  @FXML
  private ListView listeCommandes;
  /**
   * Bouton pour ajouter une tournée.
   */

  @FXML
  private Button ajouterTournee;
  /**
   * Bouton pour supprimer une tournée déjà existante.
   */

  @FXML
  private Button supprimerTournee;
  /**
   * Bouton pour modifier une tournée déjà existante.
   */

  @FXML
  private Button editerTournee;
  /**
   * Bouton pour ajouter une commande.
   */

  @FXML
  private Button ajouterCommande;
  /**
   * Bouton pour supprimer une commande déjà existante.
   */

  @FXML
  private Button supprimerCommande;
  /**
   * Bouton pour modifier une commande déjà existante.
   */

  @FXML
  private Button editerCommande;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public TableaudebordView(ConnexionCtrl ctrl) {
    super(new MainCtrl(new Stage()));
  }

  /**
   * Méthode permettant de récupérer la commande sélectionnée dans la liste des commandes.
   *
   * @return La commande sélectionnée.
   */
  public Commande getSelectedCommande() {
    return (Commande) listeCommandes.getSelectionModel().getSelectedItem();
  }

  /**
   * Méthode permettant de récupérer la tournée sélectionnée dans la liste des tournées.
   *
   * @return La tournée sélectionnée.
   */
  public Tournee getSelectedTournee() {
    return (Tournee) listeTournees.getSelectionModel().getSelectedItem();
  }

  /**
   * Méthode permettant de remplir la liste des commandes.
   *
   * @param commandes La liste des commandes à afficher.
   */
  public void setListeCommandes(Commande[] commandes) {
    listeCommandes.getItems().clear();
    for (Commande commande : commandes) {
      listeCommandes.getItems().add(commande);
    }
  }

  /**
   * Méthode permettant de remplir la liste des tournées.
   *
   * @param tournees La liste des tournées à afficher.
   */
  public void setListeTournees(Tournee[] tournees) {
    listeTournees.getItems().clear();
    for (Tournee tournee : tournees) {
      listeTournees.getItems().add(tournee);
    }
  }

  /**
   * Méthode permettant d'ajouter un élément à la liste des commandes.
   *
   * @param commande La commande à ajouter.
   */
  public void ajouterCommandeListe(Commande commande) {
    listeCommandes.getItems().add(commande);
  }

  /**
   * Méthode permettant d'ajouter un élément à la liste des tournées.
   *
   * @param tournee La tournée à ajouter.
   */
  public void ajouterTourneeListe(Tournee tournee) {
    listeTournees.getItems().add(tournee);
  }



}
