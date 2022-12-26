package root.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TableaudebordCtrl;

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
  public TableaudebordView(TableaudebordCtrl ctrl) {
    super(ctrl);
  }



}
