package root.model;

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
   * <p>La vérification se fait en invoquant un objet "AdminDAO" pour qu'il nous retourne
   * un autre objet "Admin" et pour qu'on puisse comparer le mot de passe de l'instance courante
   * à celui de cet autre objet.
   * </p>
   *
   * <p>Si AdminDAO retourne null à la place d'un Admin, alors on sait directement que
   * les identifiants sont incorrectes.</p>
   *
   * @return true si les informations sont correctes, false sinon.
   */
  @Override
  public boolean verifieIdentifiants() {
    return false;
  }

}
