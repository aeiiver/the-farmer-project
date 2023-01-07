package root;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe statique qui groupe les méthodes permettant de changer la scène affichée dans une fenêtre.
 */
public class SceneChanger {

  private static final String CONNEXION = "/root/controller/fxml/Connexion.fxml";

  private static final String TABLEAU_DE_BORD = "/root/controller/fxml/Tableaudebord.fxml";
  private static final String TABLEAU_DE_BORD_ADMIN =
      "/root/controller/fxml/TableaudebordAdmin.fxml";

  private static final String COMPTE_PRODUCTEUR = "/root/controller/fxml/CompteProducteur.fxml";
  private static final String COMPTE_ADMIN = "/root/controller/fxml/Form/FormAdmin.fxml";

  private static final String LISTE_COMMANDES = "/root/controller/fxml/Liste/ListeCommandes.fxml";
  private static final String LISTE_TOURNEES = "/root/controller/fxml/Liste/ListeTournees.fxml";
  private static final String LISTE_VEHICULES = "/root/controller/fxml/Liste/ListeVehicules.fxml";
  private static final String LISTE_CLIENTS = "/root/controller/fxml/ListeClients.fxml";
  private static final String LISTE_PRODUCTEURS =
      "/root/controller/fxml/Liste/ListeProducteurs.fxml";

  private static final String LISTE_CLIENTS_ADMIN =
      "/root/controller/fxml/Liste/ListeClientsAdmin.fxml";
  private static final String FORM_COMMANDE = "/root/controller/fxml/Form/FormCommande.fxml";
  private static final String FORM_TOURNEE = "/root/controller/fxml/Form/FormTournee.fxml";
  private static final String FORM_VEHICULE = "/root/controller/fxml/Form/FormVehicule.fxml";
  private static final String FORM_CLIENT = "/root/controller/fxml/Form/FormClient.fxml";
  private static final String FORM_PRODUCTEUR = "/root/controller/fxml/Form/FormProducteur.fxml";

  /**
   * Affichage de la page de connexion.
   */
  public static void voirConnexion(Stage fenetre) {
    changeScene(CONNEXION, fenetre);
  }

  /**
   * Affichage du tableau de bord.
   */
  public static void voirTableaudebord(Stage fenetre) {
    changeScene(TABLEAU_DE_BORD, fenetre);
  }

  /**
   * Affichage du tableau de bord administrateur.
   */
  public static void voirTableaudebordAdmin(Stage fenetre) {
    changeScene(TABLEAU_DE_BORD_ADMIN, fenetre);
  }

  /**
   * Redirige l'administrateur vers la vue sur son compte.
   */
  public static Object voirCompteAdmin(Stage fenetre) {
    return StageUtil.afficheDialogue(COMPTE_ADMIN, fenetre);
  }

  public static void voirListeClientsAdmin(Stage fenetre) {
    changeScene(LISTE_CLIENTS_ADMIN, fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public static void voirListeCommandes(Stage fenetre) {
    changeScene(LISTE_COMMANDES, fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public static void voirListeTournees(Stage fenetre) {
    changeScene(LISTE_TOURNEES, fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public static void voirListeVehicules(Stage fenetre) {
    changeScene(LISTE_VEHICULES, fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public static void voirListeClients(Stage fenetre) {
    changeScene(LISTE_CLIENTS, fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  public static void voirListeProducteurs(Stage fenetre) {
    changeScene(LISTE_PRODUCTEURS, fenetre);
  }

  /**
   * Redirige l'utilisateur vers le formulaire de la commande.
   */
  public static Object voirFormCommande(Stage fenetre) {
    return StageUtil.afficheDialogue(FORM_COMMANDE, fenetre);
  }

  /**
   * Redirige l'utilisateur vers le formulaire de la tournée.
   */
  public static Object voirFormTournee(Stage fenetre) {
    return StageUtil.afficheDialogue(FORM_TOURNEE, fenetre);
  }

  /**
   * Redirige l'utilisateur vers le formulaire véhicule.
   */
  public static Object voirFormVehicule(Stage fenetre) {
    return StageUtil.afficheDialogue(FORM_VEHICULE, fenetre);
  }

  /**
   * Redirige l'utilisateur vers le formulaire client.
   */
  public static Object voirFormClient(Stage fenetre) {
    return StageUtil.afficheDialogue(FORM_CLIENT, fenetre);
  }

  /**
   * Redirige l'utilisateur vers le formulaire producteur.
   */
  public static Object voirFormProducteur(Stage fenetre) {
    return StageUtil.afficheDialogue(FORM_PRODUCTEUR, fenetre);
  }

  /**
   * Change la scène courante d'une fenêtre et retourne le contrôleur associé à la vue chargée.
   *
   * <p>Le contrôleur associé à la vue est retourné pour permettre d'agir dessus si besoin.</p>
   *
   * @param ressourceFxml Chemin vers la ressource FXML.
   * @param fenetre       La fenêtre dont on veut changer la scène.
   * @return Le contrôleur associé à la vue.
   */
  public static Object changeScene(String ressourceFxml, Stage fenetre) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource(ressourceFxml));

    Parent root;
    try {
      root = loader.load();

    } catch (IOException e) {
      System.out.println("Quelque chose de très fondamental vient de casser...");
      throw new RuntimeException(e);
    }

    // Changement de scène de la fenêtre
    fenetre.setScene(new Scene(root));

    return loader.getController();
  }

}
