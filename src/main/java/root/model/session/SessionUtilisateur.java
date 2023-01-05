package root.model.session;

import root.model.Utilisateur;

/**
 * Classe représentant la session utilisateur.
 */
public class SessionUtilisateur {

  protected Utilisateur utilisateur;

  protected SessionUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

}
