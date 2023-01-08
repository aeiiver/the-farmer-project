package root.model.session;

import root.model.Utilisateur;

/**
 * Classe représentant la session utilisateur.
 */
public class SessionUtilisateur {

  protected Utilisateur utilisateur;

  /**
   * Constructeur de la session Utilisateur.
   *
   * @param utilisateur utilisateur connecté
   */
  protected SessionUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  /**
   * Getter de l'utilisateur connecté.
   *
   * @return utilisateur l'utilisateur connecté
   */
  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  /**
   * Getter de l'utilisateur connecté.
   */
  public void setUtilisateur(Utilisateur u) {
    utilisateur = u;
  }

}
