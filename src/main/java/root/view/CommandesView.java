package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.CommandesCtrl;

/**
 * Classe de vue pour la liste des commandes.
 */
public class CommandesView {

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

  /**
   * Contrôleur gérant la vue de la liste des commandes.
   *
   * @see CommandesView#CommandesView(CommandesCtrl, MenuBar)
   * @see CommandesCtrl
   */
  private CommandesCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public CommandesView(CommandesCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
