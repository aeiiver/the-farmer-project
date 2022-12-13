package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Admin;

class AdminDaoTest {

  static Connection connexion;
  static Statement statement;
  static AdminDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = DriverManager.getConnection(
        System.getenv("DB_URL_DEV"),
        System.getenv("DB_USER"),
        System.getenv("DB_PSW")
    );
    statement = connexion.createStatement();
    systemUnderTest = new AdminDao(connexion);
  }

  @AfterAll
  static void teardown() throws SQLException {
    statement.close();
    connexion.close();
  }

  @AfterEach
  void teardownEach() throws SQLException {
    statement.executeUpdate("DELETE FROM Admin;");
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Admin renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Admin admin = new Admin("testemail@dontmail.me", "1234hasher_moi", -1, "John");

    boolean recu = systemUnderTest.insert(admin);

    assertTrue(recu);
    assertEquals(1, TestUtil.nombreLignesTrouvees(statement, "Admin"));
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Admin renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void get() throws SQLException {
    statement.executeUpdate("INSERT INTO Admin VALUES "
        + "(42, 'testemail@dontmail.me', 'Jean', '1234hasher_moi');");

    Admin recu = systemUnderTest.get("Jean");

    assertEquals(42, recu.getIdAdmin());
    assertEquals("testemail@dontmail.me", recu.getMail());
    assertEquals("Jean", recu.getPseudo());
    assertEquals("1234hasher_moi", recu.getMdp());
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Admin renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void getAll() throws SQLException {
    List<Admin> adminsAttendus = List.of(
        new Admin("testemail@dontmail.me", "1234hasher_moi", 42, "John"),
        new Admin("trying.something@website.org", "un_mot_de_passe", 43, "Jean"),
        new Admin("blabla@abc.xyz", "le-chat-est-passe-par-la", 44, "Carl"));
    connexion.setAutoCommit(false);
    for (Admin admin : adminsAttendus) {
      statement.addBatch(String.format("INSERT INTO Admin VALUES (%d, '%s', '%s', '%s');",
          admin.getIdAdmin(), admin.getMail(), admin.getPseudo(), admin.getMdp()));
    }
    statement.executeBatch();
    statement.clearBatch();
    connexion.commit();
    connexion.setAutoCommit(true);

    ArrayList<Admin> adminsRecus = systemUnderTest.getAll();

    assertTrue(adminsRecus.size() == adminsAttendus.size());
    for (int index = 0; index < adminsAttendus.size(); ++index) {
      Admin attendu = adminsAttendus.get(index);
      Admin recu = adminsRecus.get(index);

      assertEquals(attendu.getIdAdmin(), recu.getIdAdmin());
      assertEquals(attendu.getMail(), recu.getMail());
      assertEquals(attendu.getPseudo(), recu.getPseudo());
      assertEquals(attendu.getMdp(), recu.getMdp());
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Admin renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Admin admin = new Admin("testemail@dontmail.me", "1234hasher_moi", -1, "John");
    statement.executeUpdate(String.format("INSERT INTO Admin VALUES (%d, '%s', '%s', '%s')",
        admin.getIdAdmin(), admin.getMail(), admin.getPseudo(), admin.getMdp()));
    admin.setMail("jai.change.de.mail@mail.me");
    admin.setMdp("mot-de-passe-en-clair");

    boolean recu = systemUnderTest.update(admin);

    assertTrue(recu);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Admin renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Admin admin = new Admin("testemail@dontmail.me", "1234hasher_moi", -1, "John");
    statement.executeUpdate(String.format("INSERT INTO Admin VALUES (%d, '%s', '%s', '%s')",
        admin.getIdAdmin(), admin.getMail(), admin.getPseudo(), admin.getMdp()));

    boolean recu = systemUnderTest.delete(admin);

    assertTrue(recu);
    assertEquals(0, TestUtil.nombreLignesTrouvees(statement, "Admin"));
  }

}
