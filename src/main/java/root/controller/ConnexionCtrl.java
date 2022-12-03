package root.controller;

import root.view.ConnexionView;
import root.view.TableaudebordView;

/**
 * Classe contrôleuse pour la vue sur l'écran de connexion utilisateur.
 *
 * <p>Cette classe n'a pas de modèles en champs privés car il n'y a pas besoin
 * de mémoriser les saisies de l'utilisateur.</p>
 */
public class ConnexionCtrl {

  private ConnexionView connexionView;
  private TableaudebordView tableaudebordView;

  /**
   * Constructeur de classe.
   *
   * @param connexionView     La vue correspondante à l'écran de connexion.
   * @param tableaudebordView La vue correspondante au tableau de bord.
   */
  public ConnexionCtrl(ConnexionView connexionView, TableaudebordView tableaudebordView) {
    this.connexionView = connexionView;
    this.tableaudebordView = tableaudebordView;
  }

  /**
   * Vérifie que les identifiants saisies ont une correspondance dans la base de
   * données.
   *
   * <p>
   * La vérification commence par la validation des champs avant d'établir une
   * connexion à la base. Si les champs ne sont pas valides, la vérification
   * s'arrête et on indiquera à l'utilisateur que les champs sont invalides.
   * </p>
   *
   * <p>Après validation des champs, il faut établir une connexion à la base de
   * données et récupérer les données concernant l'utilisateur. La case à cocher
   * "Administrateur" permettra de savoir quel DAO invoquer (AdminDAO ou
   * ProducteurDAO).
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
   * Valide les champs saisies.
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
  private boolean valideIdentifiants() {
    // dummy return
    return false;
  }

  /**
   * Retourne la vue de l'écran de connexion associée à ce contrôleur.
   *
   * @return La vue de l'écran de connexion.
   */
  private ConnexionView getConnexionView() {
    return connexionView;
  }

  /**
   * Change la vue courante de l'écran de connexion avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  private void setConnexionView(ConnexionView connexionView) {
    this.connexionView = connexionView;
  }

  /**
   * Retourne la vue du tableau de bord associée à ce contrôleur.
   *
   * @return La vue du tableau de bord.
   */
  private TableaudebordView getTableaudebordView() {
    return tableaudebordView;
  }

  /**
   * Change la vue courante du tableau de bord avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  private void setTableaudebordView(TableaudebordView tableaudebordView) {
    this.tableaudebordView = tableaudebordView;
  }

}
