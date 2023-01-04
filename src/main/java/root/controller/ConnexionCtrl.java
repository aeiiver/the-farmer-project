package root.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import root.SceneChanger;
import root.StageUtil;
import root.Validateur;
import root.data.AdminDao;
import root.data.Dao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Utilisateur;
import root.model.session.SingleSession;

/**
 * Classe contrôleuse pour la vue sur l'écran de connexion utilisateur.
 *
 * <p>Cette classe n'a pas de modèles en champs privés car il n'y a pas besoin
 * de mémoriser les saisies de l'utilisateur.</p>
 */
public class ConnexionCtrl {

  private Stage fenetre;

  public ConnexionCtrl(Stage fenetre) {
    this.fenetre = fenetre;
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
  @FXML
  public void verifieIdentifiants(String identifiant, String motdepasse, boolean estAdmin) {
    // Valide les champs
    if (identifiant.isEmpty() || motdepasse.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.", fenetre);
      return;
    }
    if (!valideIdentifiants(identifiant, estAdmin)) {
      StageUtil.afficheAlerte("L'identifiant ou le mot de passe saisi est invalide.", fenetre);
      return;
    }

    // Vérifie les identifiants dans la base de données
    Dao dao = (estAdmin) ? new AdminDao(SingleConnection.getInstance()) :
        new ProducteurDao(SingleConnection.getInstance());
    Utilisateur utilisateur = (Utilisateur) dao.get(identifiant);

    String hashRecupere = utilisateur.getMdp();
    boolean motdepasseOk = BCrypt.checkpw(motdepasse, hashRecupere);

    if (!motdepasseOk) {
      StageUtil.afficheAlerte("L'identifiant et le mot de passe saisis ne correspondent pas.",
          fenetre);
      return;
    }

    // L'utilisateur a saisi ses identifiants correctement.
    SingleSession.ouvreSession(identifiant, estAdmin);

    if (estAdmin) {
      SceneChanger.voirTableaudebordAdmin(fenetre);
    } else {
      SceneChanger.voirTableaudebord(fenetre);
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
  private boolean valideIdentifiants(String identifiant, boolean estAdmin) {
    if (estAdmin) {
      return Validateur.validerMail(identifiant) || Validateur.validerPseudo(identifiant);
    }
    return Validateur.validerMail(identifiant) || Validateur.validerSiret(identifiant);
  }

}
