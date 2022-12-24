package root.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Main;
import root.view.ClientsFormView;
import root.view.ClientsView;
import root.view.CommandesView;
import root.view.CompteView;
import root.view.ConnexionView;
import root.view.MainView;
import root.view.TableaudebordView;
import root.view.TourneesView;
import root.view.VehiculesView;

/**
 * Classe contrôleuse mère.
 */
public class MainCtrl {

  Stage primaryStage;


  public MainCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Affichage de la page de connexion.
   */
  public void showConnexionView(ConnexionView connexionView) {
    FXMLLoader root = new FXMLLoader(Main.class
        .getResource("/root/controller/fxml/Connection.fxml"));
    root.setController(connexionView);

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Affichage du tableau de bord.
   */
  public void showTableaudebordView(TableaudebordView tableaudebordView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/MainPage.fxml"));
    root.setController(tableaudebordView);

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void showCommandesView(CommandesView commandesView) {
    System.out.println("showCommandesView");
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new CommandesView(new CommandesCtrl(primaryStage)));

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    commandesView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void showTourneesView(TourneesView tourneesView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new TourneesCtrl(primaryStage));

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    tourneesView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Redirige l'utilisateur vers la vue sur son compte.
   */
  public void showCompteView(CompteView compteView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new CompteCtrl(primaryStage));

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    compteView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void showClientsView(ClientsView clientsView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new ClientsCtrl(primaryStage));

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    clientsView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void showVehiculesView(VehiculesView vehiculesView) {
    FXMLLoader root = new FXMLLoader(Main.class.getResource("/root/controller/fxml/Listes.fxml"));
    root.setController(new VehiculesCtrl(primaryStage));

    Parent node = null;
    try {
      node = root.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    vehiculesView = root.getController();
    Scene scene = new Scene(node);
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
  }

  public void showComptesView(CompteView compteView) {

  }
}
