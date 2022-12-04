package root.data;

import java.sql.Connection;

/**
 * Cette classe encapsule un objet Connection dans un singleton.
 *
 * <p>Cette objet Connection correspond à une connexion à la base de données.</p>
 */
public class SingleConnection {

  private static Connection connexion = null;

  /**
   * Constructeur.
   */
  private SingleConnection() {
  }

  /**
   * Récupération de la connexion à la base de données.
   *
   * @return Connexion à la base de données
   */
  public static Connection getInstance() {
    if (connexion == null) {
      // do stuff that make so connexion is no longer null
    }
    return connexion;
  }

}
