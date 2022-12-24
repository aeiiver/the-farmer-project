package root.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Main;
import root.view.*;

/**
 * Classe contrôleuse mère.
 */
public class MainCtrl {

  Stage primaryStage;


  public MainCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }

  /**
   * Affichage de la page de connexion.
   */
  public void showConnexionView(ConnexionView connexionView) {
    FXMLLoader root = new FXMLLoader(Main.class
        .getResource("/root/controller/fxml/Connection.fxml"));
    root.setController(connexionView);
    changeScene(root);
  }

  /**
   * Affichage du tableau de bord.
   */
  public void showTableaudebordView(TableaudebordView tableaudebordView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/MainPage.fxml"));
    root.setController(tableaudebordView);
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void showCommandesView(CommandesView commandesView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new CommandesView(new CommandesCtrl(primaryStage)));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void showTourneesView(TourneesView tourneesView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new TourneesCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur son compte.
   */
  public void showCompteView(CompteView compteView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new CompteCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void showClientsView(ClientsView clientsView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new ClientsCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void showVehiculesView(VehiculesView vehiculesView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new VehiculesCtrl(primaryStage));
    changeScene(root);
  }

  public void showComptesView(CompteView compteView) {

  }

  public void showCommandFormView(CommandesFormView commandesFormView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/AddCommand.fxml"));
    root.setController(new CommandesFormCtrl(primaryStage));
    changeScene(root);
  }

  public void changeScene(FXMLLoader root) {
    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }
}
