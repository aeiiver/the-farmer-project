package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TableaudebordCtrl;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des tournées.
   */
  private ListView listeTournees;
  /**
   * Liste pour afficher la liste des commandes.
   */
  private ListView listeCommandes;
  /**
   * Bouton pour ajouter une tournée.
   */
  private Button ajouterTournee;
  /**
   * Bouton pour supprimer une tournée déjà existante.
   */
  private Button supprimerTournee;
  /**
   * Bouton pour modifier une tournée déjà existante.
   */
  private Button editerTournee;
  /**
   * Bouton pour ajouter une commande.
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
   * TODO
   */
  private TableaudebordCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public TableaudebordView(TableaudebordCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
