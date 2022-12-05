package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.TourneesCtrl;

/**
 * Classe de vue pour la liste des tournées.
 */
public class TourneesView {

  private MenuBar menu;
  private ListView listeTournees;
  private Button ajouterTournee;
  private Button supprimerTournee;
  private Button editerTournee;

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
