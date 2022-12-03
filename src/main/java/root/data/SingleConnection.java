package root.data;

import java.sql.Connection;

/**
 * Singleton pour la connexion à la base de données.
 */
public class SingleConnection {
  private static Connection connexion;
  private SingleConnection() {
  }

  /**
   * Récupération de la connexion à la base de données.
   *
   * @return Connexion à la base de données
   */
  public static Connection getInstance() {
    return null;
  }
}