package root;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
  @Override
  public void start(Stage stage) throws Exception {
    ConnexionCtrl connexionCtrl = new ConnexionCtrl(stage);
    TableaudebordCtrl tableaudebordCtrl = new TableaudebordCtrl(stage);
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
