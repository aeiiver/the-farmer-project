package root.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe regroupant les méthodes utilitaires pour les tests du package "root.data".
 */
public class TestUtil {

  /**
   * Compte le nombre de lignes dans une table.
   *
   * @param statement L'objet permettant d'effectuer les requêtes à la base de données.
   * @param nomTable  Le nom de la table.
   * @return Le nombre de ligne dans la table.
   * @throws SQLException En cas d'erreur d'accès à la base de données.
   */
  static int nombreLignesTrouvees(Statement statement, String nomTable) throws SQLException {
    ResultSet rs = statement.executeQuery("SELECT * FROM " + nomTable);

    int nombreLignesTrouvees = 0;
    while (rs.next()) {
      nombreLignesTrouvees++;
    }

    return nombreLignesTrouvees;
  }

}
