package root.model;

/**
 * Classe de modèle pour les administrateurs.
 */
public class Admin extends Utilisateur {
  private int idAdmin;
  private String pseudo;

  /**
   * Getter de l'identifiant de l'administrateur.
   *
   * @return idAdmin Identifiant de l'administrateur
   */
  private int getIdAdmin() {
    return idAdmin;
  }

  /** Getter du pseudo de l'administrateur.
   *
   * @return pseudo Pseudo de l'administrateur
   */

  private String getPseudo() {
    return pseudo;
  }

  /**
   * Setter de l'identifiant de l'administrateur.
   *
   * @param idAdmin Identifiant de l'administrateur
   */
  private void setIdAdmin(int idAdmin) {
    this.idAdmin = idAdmin;
  }

  /**
   * Setter du pseudo de l'administrateur.
   *
   * @param pseudo Pseudo de l'administrateur
   */
  private void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  /**
   * Vérification des informations de connexion.
   *
   * @return true si les informations sont correctes, false sinon
   */
  @Override
  public boolean verifieIdentifiants() {
    return false;
  }
}