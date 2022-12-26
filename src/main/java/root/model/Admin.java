package root.model;

import root.data.AdminDao;
import root.data.SingleConnection;

/**
 * Classe de modèle pour les administrateurs.
 */
public class Admin extends Utilisateur {

  /**
   * ID de l'administrateur.
   *
   * @see Admin#Admin(String, String, int, String)
   * @see Admin#getIdAdmin()
   * @see Admin#setIdAdmin(int)
   */
  private int idAdmin;

  /**
   * Pseudonyme de l'administrateur.
   *
   * @see Admin#Admin(String, String, int, String)
   * @see Admin#getPseudo()
   * @see Admin#setPseudo(String)
   */
  private String pseudo;

  /**
   * Constructeur de classe.
   *
   * @param mail    Une adresse email.
   * @param mdp     Un mot de passe.
   * @param idAdmin Un numéro d'identification.
   * @param pseudo  Un pseudo.
   */
  public Admin(String mail, String mdp, int idAdmin, String pseudo) {
    super(mail, mdp);
    this.idAdmin = idAdmin;
    this.pseudo = pseudo;
  }

  /**
   * Getter de l'identifiant de l'administrateur.
   *
   * @return idAdmin Identifiant de l'administrateur
   */
  public int getIdAdmin() {
    return idAdmin;
  }

  /**
   * Getter du pseudo de l'administrateur.
   *
   * @return pseudo Pseudo de l'administrateur
   */

  public String getPseudo() {
    return pseudo;
  }

  /**
   * Setter de l'identifiant de l'administrateur.
   *
   * @param idAdmin Identifiant de l'administrateur
   */
  public void setIdAdmin(int idAdmin) {
    this.idAdmin = idAdmin;
  }

  /**
   * Setter du pseudo de l'administrateur.
   *
   * @param pseudo Pseudo de l'administrateur
   */
  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  /**
   * Vérification des informations de connexion.
   *
   * <p>La vérification se fait en invoquant un objet "Admin" pour créer un autre objet
   * "Admin" avec l'identifiant saisi par l'utilisateur. Ensuite, on compare le mot de passe
   * de l'objet courant avec celui de l'autre objet pour vérifier qu'ils correspondent bien.
   * Si les mots de passes correspondent, alors les identifiants saisis sont correctes et on peut
   * retourner true. On retournera false dans le cas contraire.</p>
   *
   * <p>Si AdminDAO retourne null à la place d'un objet Admin, alors on sait directement
   * que les identifiants sont incorrectes.</p>
   *
   * @return true si l'identifiant et le mot de passe saisis sont corrects, false sinon.
   */
  @Override
  public boolean verifieIdentifiants() {
    AdminDao bdd = new AdminDao(SingleConnection.getInstance());

    // Tente de chercher un administrateur avec son mail
    Admin existant = bdd.get(this.getMail());

    // Si on a rien, réessaye avec son pseudo
    if (existant == null) {
      existant = bdd.get(this.getPseudo());

      // Si on a rien, alors l'administrateur recherché n'existe pas dans la base
      if (existant == null) {
        return false;
      }
    }

    return this.getMdp().equals(existant.getMdp());
  }

}
