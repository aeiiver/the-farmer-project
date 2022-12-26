package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TourneesCtrl;

/**
 * Classe de vue pour la liste des tournées.
 */
public class TourneesView extends MainView {

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
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public TourneesView(TourneesCtrl ctrl) {
    super(ctrl);
  }

}
