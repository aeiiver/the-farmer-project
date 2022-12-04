package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 * Classe de vue pour la liste des tournées.
 */
public class TourneesView {
  private MenuBar menu;
  private ListView listeTournees;
  private Button ajouterTournee;
  private Button supprimerTournee;
  private Button editerTournee;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeTournees() {
    return listeTournees;
  }

  private Button getAjouterTournee() {
    return ajouterTournee;
  }

  private Button getSupprimerTournee() {
    return supprimerTournee;
  }

  private Button getEditerTournee() {
    return editerTournee;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setListeTournees(ListView listeTournees) {
    this.listeTournees = listeTournees;
  }

  private void setAjouterTournee(Button ajouterTournee) {
    this.ajouterTournee = ajouterTournee;
  }

  private void setSupprimerTournee(Button supprimerTournee) {
    this.supprimerTournee = supprimerTournee;
  }

  private void setEditerTournee(Button editerTournee) {
    this.editerTournee = editerTournee;
  }
}