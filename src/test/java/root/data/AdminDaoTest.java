package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Admin;

public class AdminDaoTest {

  static Connection connexion;
  static AdminDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = SingleConnection.getInstance();
    systemUnderTest = new AdminDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Admin;").executeUpdate();
  }


  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Admin renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Admin admin = new Admin(-1, "testemail@dontmail.me", "John", "1234hasher_moi");

    boolean recu = systemUnderTest.insert(admin);
    assertTrue(recu);

    assertInsertOk(admin);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Admin renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Admin attendu = new Admin(42, "testemail@dontmail.me", "John", "1234hasher_moi");
    insertAdmin(attendu);

    Admin recu = systemUnderTest.get(attendu.getPseudo());
    assertNotNull(recu);

    assertAdminEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Admin renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Admin> attendus = prepareSomesAdmins();

    ArrayList<Admin> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Admin attendu = attendus.get(index);
      Admin recu = recus.get(index);
      assertAdminEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Admin renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Admin admin = new Admin(42, "testemail@dontmail.me", "John", "1234hasher_moi");
    insertAdmin(admin);

    admin.setMail("jai.change.de.mail@mail.me");
    admin.setMdp("mot-de-passe-en-clair");

    boolean recu = systemUnderTest.update(admin);
    assertTrue(recu);

    assertUpdateOk(admin);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Admin renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Admin admin = new Admin(42, "testemail@dontmail.me", "John", "1234hasher_moi");
    insertAdmin(admin);

    boolean recu = systemUnderTest.delete(admin);
    assertTrue(recu);

    assertDeleteOk(admin);
  }

  private static void assertInsertOk(Admin admin) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Admin WHERE idAdmin = (SELECT MAX(idAdmin) FROM Admin);");

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String mailInsere = rs.getString("mail");
    String pseudoInsere = rs.getString("pseudo");
    String mdpInsere = rs.getString("mdp");

    assertEquals(admin.getMail(), mailInsere);
    assertEquals(admin.getPseudo(), pseudoInsere);
    assertEquals(admin.getMdp(), mdpInsere);
  }

  private static void assertUpdateOk(Admin admin) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Admin WHERE idAdmin = ?;");
    pstmt.setInt(1, admin.getIdAdmin());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String mailInsere = rs.getString("mail");
    String pseudoInsere = rs.getString("pseudo");
    String mdpInsere = rs.getString("mdp");

    assertEquals(admin.getMail(), mailInsere);
    assertEquals(admin.getPseudo(), pseudoInsere);
    assertEquals(admin.getMdp(), mdpInsere);
  }

  private static void assertDeleteOk(Admin admin) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Admin WHERE idAdmin = ?;");
    pstmt.setInt(1, admin.getIdAdmin());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertAdminEquals(Admin attendu, Admin recu) {
    assertEquals(attendu.getIdAdmin(), recu.getIdAdmin());
    assertEquals(attendu.getMail(), recu.getMail());
    assertEquals(attendu.getPseudo(), recu.getPseudo());
    assertEquals(attendu.getMdp(), recu.getMdp());
  }

  private static void insertAdmin(Admin admin)
      throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Admin VALUES (NULL,?,?,?);");

    pstmt.setString(1, admin.getMail());
    pstmt.setString(2, admin.getPseudo());
    pstmt.setString(3, admin.getMdp());

    pstmt.executeUpdate();
  }

  private static List<Admin> prepareSomesAdmins() {
    List<Admin> admins =
        List.of(new Admin(42, "testemail@dontmail.me", "John", "1234hasher_moi"),
            new Admin(43, "trying.something@website.org", "Jean", "un_mot_de_passe"),
            new Admin(44, "blabla@abc.xyz", "Carl", "le-chat-est-passe-par-la"));

    admins.forEach(admin -> {
      try {
        insertAdmin(admin);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return admins;
  }

}
