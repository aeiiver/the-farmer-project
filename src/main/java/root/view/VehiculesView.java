package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.VehiculesCtrl;

/**
 * Classe de vue pour la liste des véhicules.
 */
public class VehiculesView {

  private MenuBar menu;
  private ListView listeVehicules;
  private Button ajouterVehicule;
  private Button supprimerVehicule;
  private Button editerVehicule;

  private VehiculesCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   * @param menu Le menu de navigation.
   */
  public VehiculesView(VehiculesCtrl ctrl, MenuBar menu) {
    this.ctrl = ctrl;
    this.menu = menu;
  }

}
