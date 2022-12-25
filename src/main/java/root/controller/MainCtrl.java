package root.controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.Main;
import root.view.ClientsFormView;
import root.view.ClientsView;
import root.view.CommandesFormView;
import root.view.CommandesView;
import root.view.CompteView;
import root.view.ConnexionView;
import root.view.TableaudebordView;
import root.view.TourneesView;
import root.view.VehiculesView;


/**
 * Classe contrôleuse mère.
 */
public class MainCtrl {

  /**
   * Vue mère.
   */
  Stage primaryStage;

  /**
   * Constructeur de classe.
   *
   * @param primaryStage La fenêtre principale.
   */
  public MainCtrl(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  /**
   * Getter de l'attribut primaryStage.
   *
   * @return primaryStage L'attribut primaryStage.
   */
  public Stage getPrimaryStage() {
    return primaryStage;
  }

  /**
   * Affichage de la page de connexion.
   */
  public void voirConnexion(ConnexionView connexionView) {
    FXMLLoader root = new FXMLLoader(Main.class
        .getResource("/root/controller/fxml/Connexion.fxml"));
    root.setController(connexionView);
    changeScene(root);
  }

  /**
   * Affichage du tableau de bord.
   */
  public void voirTableaudebord(TableaudebordView tableaudebordView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/MainPage.fxml"));
    root.setController(tableaudebordView);
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void voirCommandesListes(CommandesView commandesView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/ListeData.fxml"));
    root.setController(new CommandesView(new CommandesCtrl(primaryStage)));
    changeScene(root);
    commandesView.initialize();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void voirTourneesListes(TourneesView tourneesView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/ListeData.fxml"));
    root.setController(new TourneesCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur son compte.
   */
  public void voirCompte(CompteView compteView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/ListeData.fxml"));
    root.setController(new CompteCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void voirClientsListes(ClientsView clientsView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/ListeData.fxml"));
    root.setController(new ClientsCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void voirVehiculesListes(VehiculesView vehiculesView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/ListeData.fxml"));
    root.setController(new VehiculesCtrl(primaryStage));
    changeScene(root);
  }

  public void voirComptesListes(CompteView compteView) {

  }

  /**
   * Redirige l'utilisateur vers la vue d'ajout de commande (formulaire).
   *
   * @param commandesFormView La vue du formulaire.
   */
  public void voirCommandesForm(CommandesFormView commandesFormView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/FormCommand.fxml"));
    root.setController(new CommandesFormCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Redirige l'utilisateur vers la vue d'ajout de client (formulaire).
   *
   * @param clientsFormView La vue du formulaire.
   */
  public void voirClientsForm(ClientsFormView clientsFormView) {
    FXMLLoader root = new FXMLLoader(
        Main.class.getResource("/root/controller/fxml/FormClient.fxml"));
    root.setController(new ClientsFormCtrl(primaryStage));
    changeScene(root);
  }

  /**
   * Méthode permettant de changer la scène JavaFX. Cette méthode est utilisée pour changer de vue.
   *
   * @param root Le FXMLLoader de la vue à afficher.
   */
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
