package root.model.session;

import root.model.Utilisateur;

/**
 * Classe représentant la session utilisateur.
 */
public abstract class SessionUtilisateur {

  protected Utilisateur utilisateur;

  protected SessionUtilisateur() {
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

}
