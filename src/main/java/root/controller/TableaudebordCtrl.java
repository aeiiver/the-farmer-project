package root.controller;

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
public class TableaudebordCtrl {

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
   * Stage de la fenêtre.
   */
  private Stage primaryStage;

  private final FXMLLoader root = new FXMLLoader(
      Main.class.getResource("/root/controller/fxml/MainPage.fxml"));

  /**
   * Deuxième Constructeur de la classe.
   */
  public TableaudebordCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void goToMenuCommandes() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void goToMenuTournees() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur son compte.
   */
  public void goToMenuCompte() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void goToMenuClients() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void goToMenuVehicules() {
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
    this.root.setController(this.tableaudebordView);
    Parent root = null;
    try {
      root = this.root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.tableaudebordView = this.root.getController();
    Scene scene = new Scene(root);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

}
