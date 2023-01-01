package root;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
   * Retourne la fenêtre à laquelle un élément FXML appartient.
   *
   * @param root L'élément FXML.
   * @return La fenêtre.
   */
  public static Stage getFenetre(Parent root) {
    return (Stage) root.getScene().getWindow();
  }

}
