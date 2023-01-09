package root.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cette classe encapsule un objet Connection dans un singleton.
 *
 * <p>Cet objet Connection correspond à une connexion à la base de données.</p>
 */
public class SingleConnection {

  public static final String DB_URL = "jdbc:mysql://les-roseaux.dev:3306/the-farmer-project";
  public static final String DB_USER = "farmer";
  public static final String DB_PASSWORD = "vgeGm3tZ2t2JEWE";

  private static Connection connexion = null;

  /**
   * Constructeur, privé pour empêcher l'instanciation.
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
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Connection established");
      } catch (Exception e) {
        e.printStackTrace();
      }
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
