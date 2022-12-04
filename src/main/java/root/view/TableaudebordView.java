package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Classe de vue pour le tableau de bord.
 */
public class TableaudebordView {
  private MenuBar menu;
  private ListView listeTournees;
  private ListView listeCommandes;
  private Button ajouterTournee;
  private Button supprimerTournee;
  private Button editerTournee;
  private Button ajouterCommande;
  private Button supprimerCommande;
  private Button editerCommande;

  private MenuBar getMenu() {
    return menu;
  }

  private ListView getListeTournees() {
    return listeTournees;
  }

  private ListView getListeCommandes() {
    return listeCommandes;
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

  private void setListeTournees(ListView listeTournees) {
    this.listeTournees = listeTournees;
  }

  private void setListeCommandes(ListView listeCommandes) {
    this.listeCommandes = listeCommandes;
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