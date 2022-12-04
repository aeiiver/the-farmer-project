package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Classe de vue pour la liste des producteurs.
 */
public class ProducteursView {
  private MenuBar menu;
  private ListView listeProducteurs;
  private Button ajouterProducteur;
  private Button supprimerProducteur;
  private Button editerProducteur;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeProducteurs() {
    return listeProducteurs;
  }

  private Button getAjouterProducteur() {
    return ajouterProducteur;
  }

  private Button getSupprimerProducteur() {
    return supprimerProducteur;
  }

  private Button getEditerProducteur() {
    return editerProducteur;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setListeProducteurs(ListView listeProducteurs) {
    this.listeProducteurs = listeProducteurs;
  }

  private void setAjouterProducteur(Button ajouterProducteur) {
    this.ajouterProducteur = ajouterProducteur;
  }

  private void setSupprimerProducteur(Button supprimerProducteur) {
    this.supprimerProducteur = supprimerProducteur;
  }

  private void setEditerProducteur(Button editerProducteur) {
    this.editerProducteur = editerProducteur;
  }
}