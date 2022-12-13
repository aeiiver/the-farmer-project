package root.data;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Cette classe encapsule un objet Connection dans un singleton.
 *
 * <p>Cet objet Connection correspond à une connexion à la base de données.</p>
 */
public class SingleConnection {

  private static Connection connexion = null;

  /**
   * Constructeur, privé pour empêcher l'instantiation.
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

  /**
   * Fermeture de la connexion à la base de données.
   *
   * @throws SQLException L'exception générée en cas d'échec.
   */
  public static void close() throws SQLException {
    connexion.close();
  }

}
