package root.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.CommandesCtrl;

/**
 * Classe de vue pour la liste des commandes.
 */
public class CommandesView extends MainView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des commandes existantes.
   */
  private ListView listeCommandes;
  /**
   * Bouton pour ajouter une nouvelle commande.
   */
  private Button ajouterCommande;
  /**
   * Bouton pour supprimer une commande déjà existante.
   */
  private Button supprimerCommande;
  /**
   * Bouton pour modifier une commande déjà existante.
   */
  private Button editerCommande;

  @FXML
  private Label titre;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public CommandesView(CommandesCtrl ctrl) {
    super(ctrl);
  }

  @FXML
  public void initialize() {
    assert this.titre != null : "Liste des commandes";
  }

}
