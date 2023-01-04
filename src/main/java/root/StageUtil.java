package root;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Classe utilitaire qui regroupe toutes les opérations liées aux fenêtres.
 */
public class StageUtil {

  /**
   * Ouvre une fenêtre de dialogue par-dessus la fenêtre courante que l'utilisateur
   * devra traiter pour continuer.
   *
   * @param ressourceFxml  Chemin vers la ressource FXML.
   * @param fenetreParente La fenêtre sur laquelle faire apparaître la nouvelle fenêtre.
   * @return Le contrôleur qui a été associé à la vue.
   */
  public static Object afficheDialogue(String ressourceFxml, Stage fenetreParente) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource(ressourceFxml));

    Parent newRoot;
    try {
      newRoot = loader.load();

    } catch (IOException e) {
      System.out.println("Quelque chose de très fondamentale vient de casser...");
      System.out.println("Voir : MenubarProducteur.changeScene()");
      throw new RuntimeException(e);
    }

    // Changement de scène sur une nouvelle fenêtre qui bloque toutes interactions
    // qui visent la fenêtre parente.
    Stage fenetre = new Stage();
    fenetre.setScene(new Scene(newRoot));
    fenetre.initOwner(fenetreParente);
    fenetre.initModality(Modality.APPLICATION_MODAL);

    fenetre.show();

    return loader.getController();
  }

  /**
   * Affiche une fenêtre de dialogue avertissant l'utilisateur de ce qu'il devrait savoir.
   *
   * <p>L'utilisateur est obligé de cliquer sur le bouton "OK" pour continuer.</p>
   *
   * @param message        Le message à afficher.
   * @param fenetreParente La fenêtre parente depuis laquelle la fenêtre s'affichera.
   */
  public static void afficheAlerte(String message, Stage fenetreParente) {
    Alert alerte = new Alert(Alert.AlertType.ERROR);

    alerte.setTitle("Erreur de saisie");
    alerte.setHeaderText(null);
    alerte.setContentText(message);
    alerte.initOwner(fenetreParente);

    alerte.showAndWait();
  }

  /**
   * Affiche une fenêtre de dialogue demandant à l'utilisateur de confirmer avant de continuer.
   *
   * <p>L'utilisateur est obligé de cliquer sur le bouton "Oui" ou "Non" pour continuer.</p>
   *
   * @param fenetreParente La fenêtre parente depuis laquelle la fenêtre s'affichera.
   * @return true si l'utlisateur clique sur "Oui", false s'il clique sur "Non".
   */
  public static boolean afficheConfirmation(Stage fenetreParente) {
    Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);

    alerte.setTitle("Suppression");
    alerte.setHeaderText(null);
    alerte.setContentText("Voulez-vous vraiment supprimer cet élément ?");
    alerte.initOwner(fenetreParente);

    ButtonType oui = new ButtonType("Oui", ButtonBar.ButtonData.YES);
    ButtonType non = new ButtonType("Non", ButtonBar.ButtonData.NO);
    alerte.getButtonTypes().set(0, non);
    alerte.getButtonTypes().set(1, oui);

    Optional<ButtonType> reponse = alerte.showAndWait();

    return reponse.orElse(non).equals(oui);
  }

  /**
   * Retourne la fenêtre à laquelle un élément FXML appartient.
   *
   * @param root L'élément FXML.
   * @return La fenêtre.
   */
  public static Stage getFenetre(Parent root) {
    return (Stage) root.getScene().getWindow();
  }

  /**
   * Exécute une fonction après le chargement d'une fenêtre à laquelle un élément FXML appartient.
   *
   * @param root L'élément FXML.
   * @param fonction Le code à exécuter.
   */
  public static void onWindowLoad(Parent root, Runnable fonction) {
    root.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
      if (oldScene == null && newScene != null) {
        newScene.windowProperty()
            .addListener((observableWindow, oldWindow, newWindow) -> fonction.run());
      }
    });
  }

}
