package root;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe représentant le point d'entrée principale de l'application.
 */
public class Main extends Application {

  /**
   * Point d'entrée principale de l'application.
   *
   * @param args Les arguments passés à l'application.
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Lancement du logiciel.
   *
   * @param fenetre La fenêtre principale de l'application.
   */
  @Override
  public void start(Stage fenetre) throws IOException {
    String ressource = "/root/controller/fxml/Connexion.fxml";
    FXMLLoader loader = new FXMLLoader(getClass().getResource(ressource));
    Parent ecranConnexion = loader.load();

    fenetre.setTitle("Betteraves et Potimarrons");
    fenetre.setScene(new Scene(ecranConnexion));
    fenetre.show();
  }

}
