package root.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import root.controller.VehiculesCtrl;

/**
 * Classe de vue pour la liste des véhicules.
 */
public class VehiculesView extends MainView {

  /**
   * Menu de navigation sur la fênetre.
   */
  private MenuBar menu;
  /**
   * Liste pour afficher la liste des véhicules existants.
   */
  private ListView listeVehicules;
  /**
   * Bouton pour ajouter un nouveau véhicule.
   */
  @FXML
  private Button ajouter;
  /**
   * Bouton pour supprimer un véhicule déjà existant.
   */
  @FXML
  private Button supprimer;
  /**
   * Bouton pour modifier un véhicule déjà existant.
   */
  @FXML
  private Button editer;

  /**
   * Contrôleur gérant la vue de la liste des véhicules.
   *
   * @see VehiculesView#VehiculesView(VehiculesCtrl)
   * @see VehiculesCtrl
   */
  private VehiculesCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public VehiculesView(VehiculesCtrl ctrl) {
    super(ctrl);
    this.ctrl = ctrl;
  }

}
