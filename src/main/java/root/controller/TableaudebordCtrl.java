package root.controller;

import java.beans.EventHandler;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Main;
import root.model.ListeCommandes;
import root.model.ListeTournees;
import root.view.ClientsView;
import root.view.CommandesView;
import root.view.CompteView;
import root.view.TableaudebordView;
import root.view.TourneesView;
import root.view.VehiculesView;

/**
 * Classe contrôleuse pour la vue et modèle du tableau de bord.
 */
public class TableaudebordCtrl extends MainCtrl {

  /**
   * Listes des tournées sur le tableau de bord.
   *
   */
  private ListeTournees listeTournees;

  /**
   * Liste des commandes sur le tableau de bord.
   *
   */
  private ListeCommandes listeCommandes;

  /**
   * Vue du tableau de bord.
   *
   */
  private TableaudebordView tableaudebordView;

  /**
   * Vue de la liste des commandes.
   */
  private CommandesView commandesView;

  /**
   * Vue de la liste des tournées.
   */
  private TourneesView tourneesView;

  /**
   * Vue du compte.
   */
  private CompteView compteView;

  /**
   * Vue de la liste des clients.
   */
  private ClientsView clientsView;

  /**
   * Vue de la liste des véhicules.
    */
  private VehiculesView vehiculesView;

  /**
   * Deuxième Constructeur de la classe.
   */
  public TableaudebordCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire d'ajout d'une tournée.
   */
  public void ajouterTournee() {
  }

  /**
   * Reflète la suppression d'une tournée dans le modèle correspondant.
   */
  public void supprimerTournee() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire de modification d'une tournée.
   */
  public void editerTournee() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire d'ajout d'une commande.
   */
  public void ajouterCommande() {
  }

  /**
   * Reflète la suppression d'une commande dans le modèle correspondant.
   */
  public void supprimerCommande() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire de modification d'une commande.
   */
  public void editerCommande() {
  }

  /**
   * Affiche la vue du tableau de bord.
   */
  public void showTableaudebordView() {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/MainPage.fxml"));
    root.setController(this.tableaudebordView);

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.tableaudebordView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

}
