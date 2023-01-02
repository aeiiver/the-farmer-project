package root.model;

/**
 * Classe de modèle pour les utilisateurs.
 */
public abstract class Utilisateur {

  /**
   * Mail de l'utilisateur.
   *
   * @see Utilisateur#Utilisateur(String, String)
   * @see Utilisateur#getMail()
   * @see Utilisateur#setMail(String)
   * @see Producteur
   * @see Admin
   */
  private String mail;

  /**
   * Mot de passe chiffré de l'utilisateur.
   *
   * @see Utilisateur#Utilisateur(String, String)
   * @see Utilisateur#getMdp()
   * @see Utilisateur#setMdp(String)
   * @see Producteur
   * @see Admin
   */
  private String mdp;

  public Utilisateur(String mail, String mdp) {
    this.mail = mail;
    this.mdp = mdp;
  }

  /**
   * Setter pour l'attribut mail.
   *
   * @param mail mail de l'utilisateur
   */
  public void setMail(String mail) {
    this.mail = mail;
  }

  /**
   * Setter pour l'attribut mdp.
   *
   * @param mdp mot de passe de l'utilisateur
   */
  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  /**
   * Méthode vérifiant les informations de connexion.
   *
   * <p>L'implémentation devra fait appel à son DAO pour effectuer la vérification.</p>
   *
   * @return true si les informations sont correctes, false sinon
   */
  public abstract boolean verifieIdentifiants();

  /**
   * Méthode pour récupérer le mail de l'utilisateur.
   *
   * @return mail de l'utilisateur
   */
  public String getMail() {
    return mail;
  }

  /**
   * Méthode pour récupérer le mot de passe de l'utilisateur.
   *
   * <p>Le mot de passe est chiffré.</p>
   *
   * @return mot de passe de l'utilisateur
   */
  public String getMdp() {
    return mdp;
  }

}
