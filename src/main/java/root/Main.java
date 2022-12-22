package root;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import root.controller.ConnexionCtrl;
import root.controller.TableaudebordCtrl;
import root.view.ConnexionView;
import root.view.TableaudebordView;

/**
 * Classe représentant le point d'entrée principale de l'application.
 */
public class Main extends Application {
  /**
   * Lancement du logiciel.
   *
   * @param stage Le stage principal de l'application.
   * @throws Exception Si une erreur survient lors du chargement de la vue.
   */
  @FXML
  @Override
  public void start(Stage stage) throws Exception {
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/root/controller/fxml/Connection.fxml"));
    Parent content = loader.load();


    ConnexionCtrl connexionCtrl = new ConnexionCtrl(primaryStage);
    TableaudebordCtrl tableaudebordCtrl = new TableaudebordCtrl(primaryStage);
    connexionCtrl.setConnexionView(new ConnexionView(connexionCtrl));
    connexionCtrl.setTableaudebordView(new TableaudebordView(tableaudebordCtrl));
    connexionCtrl.showConnexionView();
    System.out.println("test");
  }

  /**
   * Point d'entrée principale de l'application.
   *
   * @param args Les arguments passés à l'application.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
