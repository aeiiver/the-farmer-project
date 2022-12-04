package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 * Classe de vue pour la liste des véhicules.
 */
public class VehiculesView {
  private MenuBar menu;
  private ListView listeVehicules;
  private Button ajouterVehicule;
  private Button supprimerVehicule;
  private Button editerVehicule;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeVehicules() {
    return listeVehicules;
  }

  private Button getAjouterVehicule() {
    return ajouterVehicule;
  }

  private Button getSupprimerVehicule() {
    return supprimerVehicule;
  }

  private Button getEditerVehicule() {
    return editerVehicule;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setListeVehicules(ListView listeVehicules) {
    this.listeVehicules = listeVehicules;
  }

  private void setAjouterVehicule(Button ajouterVehicule) {
    this.ajouterVehicule = ajouterVehicule;
  }

  private void setSupprimerVehicule(Button supprimerVehicule) {
    this.supprimerVehicule = supprimerVehicule;
  }

  private void setEditerVehicule(Button editerVehicule) {
    this.editerVehicule = editerVehicule;
  }
}