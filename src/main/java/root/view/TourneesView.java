package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TourneesCtrl;

/**
 * Classe de vue pour la liste des tournées.
 */
public class TourneesView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des tournées existantes.
   */
  private ListView listeTournees;
  /**
   * Bouton pour ajouter une nouvelle tournée.
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
   * TODO
   */
  private TourneesCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public TourneesView(TourneesCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
