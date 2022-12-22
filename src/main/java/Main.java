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
public class Main{

  /**
   * Point d'entrée principale de l'application.
   *
   * @param args Les arguments passés à l'application.
   */
  public static void main(String[] args) {
    Stage primaryStage = new Stage();

    ConnexionCtrl connexionCtrl = new ConnexionCtrl(primaryStage);
    TableaudebordCtrl tableaudebordCtrl = new TableaudebordCtrl(primaryStage);
    connexionCtrl.setConnexionView(new ConnexionView(connexionCtrl));
    connexionCtrl.setTableaudebordView(new TableaudebordView(tableaudebordCtrl));
  }

}
