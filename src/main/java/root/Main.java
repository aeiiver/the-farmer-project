package root;

import javafx.application.Application;
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
  public void start(Stage fenetre) {
    System.setProperty("javafx.platform", "desktop");
    System.setProperty("http.agent", "Gluon Mobile/1.0.3");

    SceneChanger.voirConnexion(fenetre);

    fenetre.setTitle("Betteraves et Potimarrons");
    fenetre.show();
  }

}
