package root.model;

// Defensive programming be like:

/**
 * Singleton représentant la session utilisateur.
 */
public class SingleSession {

  private static SessionUtilisateur session;

  private SingleSession() {
  }

  /**
   * Retourne une instance de la session.
   *
   * @return La session courante.
   * @throws RuntimeException Si aucune session n'est ouverte.
   */
  public static SessionUtilisateur getSession() throws RuntimeException {
    if (session == null) {
      throw new RuntimeException(
          "La session n'est pas ouverte. Appeler SingleSession.ouvreSession() en premier.");
    }
    return session;
  }

  /**
   * Ouvre la session utilisateur.
   *
   * @param identifiant L'identifiant de l'utilisateur.
   * @param estAdmin    Le type d'utilisateur.
   * @throws RuntimeException Si une session est déjà ouverte.
   */
  public static void ouvreSession(String identifiant, boolean estAdmin) throws RuntimeException {
    if (session != null) {
      throw new RuntimeException("Une session est déjà ouverte. Qui l'a ouverte avant vous ?");
    }
    session = (estAdmin) ? new SessionAdmin(identifiant) : new SessionProducteur(identifiant);
  }

  /**
   * Ferme la session utilisateur courante.
   *
   * <p>Si aucune session est en cours, rien ne se passe.</p>
   */
  public static void fermeSession() {
    // Garbage-collecte cette chose...
    session = null;
  }

}
