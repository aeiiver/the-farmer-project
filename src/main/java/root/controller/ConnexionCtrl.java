package root.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import root.view.ConnexionView;
import root.view.TableaudebordView;

import java.io.IOException;

/**
 * Classe contrôleuse pour la vue sur l'écran de connexion utilisateur.
 *
 * <p>Cette classe n'a pas de modèles en champs privés car il n'y a pas besoin
 * de mémoriser les saisies de l'utilisateur.</p>
 */
public class ConnexionCtrl {

  /**
   * Vue de l'écran de connexion utilisateur.
   *
   */
  private ConnexionView connexionView;

  /**
   * Vue du tableau de bord.
   *
   */
  private TableaudebordView tableaudebordView;

  /**
   * Stage de la fenêtre.
   */
  private Stage primaryStage;
  private final Parent ROOT = FXMLLoader.load(getClass().getResource("/root/controller/fxml/Connection.fxml"));

  /**
   * Constructeur de la classe.
   */
  public ConnexionCtrl(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
  }

  /**
   * Vérifie que les identifiants saisis ont une correspondance dans la base de
   * données.
   *
   * <p>
   * La vérification commence par la validation des champs avant d'établir une
   * connexion à la base. Si les champs ne sont pas valides, la vérification
   * s'arrête et on indiquera à l'utilisateur que les champs sont invalides.
   * </p>
   *
   * <p>Après validation des champs, le travail de vérification est délégué à un objet
   * "Producteur" ou "Admin" (selon si la case "Administrateur" est coché ou non), créé avec
   * les valeurs des champs. L'objet créé peut nous renvoyer un boolean, indiquant si oui ou non
   * les identifiants sont correctes et qu'il y a correspondance.
   * </p>
   *
   * <p>S'il y a bien une correspondance (les mots de passes sont les mêmes),
   * l'utilisateur est redirigé vers le tableau de bord (pour les producteurs)
   * ou vers la liste des producteurs (pour les admins).</p>
   *
   * <p>S'il n'y a pas de correspondance (les mots de passe ne sont pas les mêmes
   * ou la base a retourné un résultat vide), on indiquera à l'utilisateur que
   * les saisies sont incorrectes.</p>
   */
  public void verifieIdentifiants() {
  }

  /**
   * Valide les champs saisis.
   *
   * <p> La logique de validation dépend de si la case "Administrateur"
   * (pour se connecter en tant que administrateur) a été cochée ou non.
   * </p>
   *
   * <p>Si elle est cochée, l'identifiant doit être une chaîne de caractères
   * alphanumérique (pseudo) ou suivre le format d'une adresse email.
   * </p>
   *
   * <p>
   * Si elle n'est pas cochée, l'identifiant doit être un numéro de SIRET, ou
   * une adresse email.
   * </p>
   *
   * @return true si les identifiants sont valides, false sinon.
   */
  public boolean valideIdentifiants() {
    // dummy return
    return false;
  }

  /**
   * Retourne la vue de l'écran de connexion associée à ce contrôleur.
   *
   * @return La vue de l'écran de connexion.
   */
  public ConnexionView getConnexionView() {
    return connexionView;
  }

  /**
   * Change la vue courante de l'écran de connexion avec une nouvelle.
   *
   * @param connexionView La vue nouvelle.
   */
  public void setConnexionView(ConnexionView connexionView) {
    this.connexionView = connexionView;
  }

  /**
   * Retourne la vue du tableau de bord associée à ce contrôleur.
   *
   * @return La vue du tableau de bord.
   */
  public TableaudebordView getTableaudebordView() {
    return tableaudebordView;
  }

  /**
   * Change la vue courante du tableau de bord avec une nouvelle.
   *
   * @param tableaudebordView La vue nouvelle.
   */
  public void setTableaudebordView(TableaudebordView tableaudebordView) {
    this.tableaudebordView = tableaudebordView;
  }

  public void showConnexionView() {
    Scene scene = new Scene(this.ROOT);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
