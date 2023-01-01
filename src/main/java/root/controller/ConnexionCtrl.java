package root.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import root.StageUtil;
import root.model.Admin;
import root.model.Producteur;
import root.model.SingleSession;
import root.model.Utilisateur;

/**
 * Classe contrôleuse pour la vue sur l'écran de connexion utilisateur.
 *
 * <p>Cette classe n'a pas de modèles en champs privés car il n'y a pas besoin
 * de mémoriser les saisies de l'utilisateur.</p>
 */
public class ConnexionCtrl implements Initializable {

  @FXML
  private VBox root;
  @FXML
  private TextField identifiant;
  @FXML
  private TextField motdepasse;
  @FXML
  private CheckBox modeAdmin;

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
  @FXML
  private void verifieIdentifiants() throws IOException {
    String identifiantSaisi = identifiant.getText();
    String motdepasseSaisi = motdepasse.getText();
    boolean estAdmin = modeAdmin.isSelected();

    // Valide les champs
    if (identifiantSaisi.isEmpty() || motdepasseSaisi.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
          StageUtil.getFenetre(root));
      return;
    }
    if (!valideIdentifiants(identifiantSaisi, estAdmin)) {
      StageUtil.afficheAlerte("L'identifiant ou le mot de passe saisi est invalide.",
          StageUtil.getFenetre(root));
      return;
    }

    // Vérifie les identifiants dans la base de données
    Utilisateur utilisateur =
        (estAdmin) ? new Admin(-1, identifiantSaisi, identifiantSaisi, motdepasseSaisi) :
            new Producteur(identifiantSaisi, identifiantSaisi, "", "", "", motdepasseSaisi, null);
    if (!utilisateur.verifieIdentifiants()) {
      StageUtil.afficheAlerte("L'identifiant et le mot de passe saisis ne correspondent pas.",
          StageUtil.getFenetre(root));
      return;
    }

    // L'utilisateur a saisi ses identifiants correctement.
    SingleSession.ouvreSession(identifiantSaisi, estAdmin);

    String ressource = "/root/controller/fxml/Tableaudebord.fxml";
    FXMLLoader loader = new FXMLLoader(getClass().getResource(ressource));
    Parent tableaudebord = loader.load();

    if (estAdmin) {
      // TODO à remplacer avec le tableau de bord admin (liste des producteurs ?)
      StageUtil.getFenetre(root).setScene(new Scene(tableaudebord));
    } else {
      StageUtil.getFenetre(root).setScene(new Scene(tableaudebord));
    }

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
  public boolean valideIdentifiants(String identifiant, boolean estAdmin) {
    String mailPattern =
        "^[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*@[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*\\.[a-z]{2,3}$";

    if (estAdmin) {
      // On est un admin
      String pseudoPattern = "^[A-Za-z0-9]+$"; // Pas sûr de ce pattern...
      return identifiant.matches(mailPattern + "|" + pseudoPattern);
    }
    // On est un producteur
    String siretPattern = "^\\d{14}$";
    return identifiant.matches(mailPattern + "|" + siretPattern);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    root.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER) {
        try {
          verifieIdentifiants();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }
}
