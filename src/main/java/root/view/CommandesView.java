package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;

/**
 * Classe de vue pour la liste des commandes.
 */
public class CommandesView {
  private MenuBar menu;
  private ListView listeCommandes;
  private Button ajouterCommande;
  private Button supprimerCommande;
  private Button editerCommande;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeCommandes() {
    return listeCommandes;
  }

  private Button getAjouterCommande() {
    return ajouterCommande;
  }

  private Button getSupprimerCommande() {
    return supprimerCommande;
  }

  private Button getEditerCommande() {
    return editerCommande;
  }

  private void setMenu(MenuBar menu) {
    this.menu = menu;
  }

  private void setListeCommandes(ListView listeCommandes) {
    this.listeCommandes = listeCommandes;
  }

  private void setAjouterCommande(Button ajouterCommande) {
    this.ajouterCommande = ajouterCommande;
  }

  private void setSupprimerCommande(Button supprimerCommande) {
    this.supprimerCommande = supprimerCommande;
  }

  private void setEditerCommande(Button editerCommande) {
    this.editerCommande = editerCommande;
  }
}