package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Adresse;

class AdresseDaoTest {

  static Connection connexion;
  static AdresseDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = DriverManager.getConnection(
        System.getenv("DB_URL_DEV"),
        System.getenv("DB_USER"),
        System.getenv("DB_PSW"));
    systemUnderTest = new AdresseDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }

  @AfterAll
  static void teardown() throws SQLException {
    connexion.close();
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Adresse renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12345", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");

    boolean recu = systemUnderTest.insert(adresse);
    assertTrue(recu);

    assertInsertOk(adresse);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Adresse renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse attendu =
        new Adresse(23, "France", "12345", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    insertAdresse(attendu);

    Adresse recu = systemUnderTest.get(attendu.getIdAdresse());
    assertNotNull(recu);

    assertAdresseEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Adresse renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Adresse> attendus = prepareSomesAdresses();

    ArrayList<Adresse> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Adresse attendu = attendus.get(index);
      Adresse recu = recus.get(index);
      assertAdresseEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Adresse renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12345", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    insertAdresse(adresse);

    adresse.setNom("Sentiers des éperdus");
    adresse.setMention("Appt 110");
    adresse.setComplement("Ter");

    boolean recu = systemUnderTest.update(adresse);
    assertTrue(recu);

    assertUpdateOk(adresse);
  }


  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Adresse renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12345", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    insertAdresse(adresse);

    boolean recu = systemUnderTest.delete(adresse);
    assertTrue(recu);

    assertDeleteOk(adresse);
  }

  private static void assertInsertOk(Adresse adresse) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Adresse WHERE idAdresse = (SELECT MAX(idAdresse) FROM Adresse);");

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String paysInsere = rs.getString("pays");
    String codePostInsere = rs.getString("codePost");
    String villeInseree = rs.getString("ville");
    String voieInseree = rs.getString("voie");
    String nomInsere = rs.getString("nom");
    int numeroInsere = rs.getInt("numero");
    String mentionInseree = rs.getString("mention");
    String complementInsere = rs.getString("complement");

    assertEquals(adresse.getPays(), paysInsere);
    assertEquals(adresse.getCodePost(), codePostInsere);
    assertEquals(adresse.getVille(), villeInseree);
    assertEquals(adresse.getVoie(), voieInseree);
    assertEquals(adresse.getNom(), nomInsere);
    assertEquals(adresse.getNumero(), numeroInsere);
    assertEquals(adresse.getMention(), mentionInseree);
    assertEquals(adresse.getComplement(), complementInsere);
  }

  private static void assertUpdateOk(Adresse adresse) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Adresse WHERE idAdresse = ?;");
    pstmt.setInt(1, adresse.getIdAdresse());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String paysInsere = rs.getString("pays");
    String codePostInsere = rs.getString("codePost");
    String villeInseree = rs.getString("ville");
    String voieInseree = rs.getString("voie");
    String nomInsere = rs.getString("nom");
    int numeroInsere = rs.getInt("numero");
    String mentionInseree = rs.getString("mention");
    String complementInsere = rs.getString("complement");

    assertEquals(adresse.getPays(), paysInsere);
    assertEquals(adresse.getCodePost(), codePostInsere);
    assertEquals(adresse.getVille(), villeInseree);
    assertEquals(adresse.getVoie(), voieInseree);
    assertEquals(adresse.getNom(), nomInsere);
    assertEquals(adresse.getNumero(), numeroInsere);
    assertEquals(adresse.getMention(), mentionInseree);
    assertEquals(adresse.getComplement(), complementInsere);
  }

  private static void assertDeleteOk(Adresse adresse) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Adresse WHERE idAdresse = ?;");
    pstmt.setInt(1, adresse.getIdAdresse());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertAdresseEquals(Adresse attendu, Adresse recu) {
    assertEquals(attendu.getIdAdresse(), recu.getIdAdresse());
    assertEquals(attendu.getPays(), recu.getPays());
    assertEquals(attendu.getCodePost(), recu.getCodePost());
    assertEquals(attendu.getVille(), recu.getVille());
    assertEquals(attendu.getVoie(), recu.getVoie());
    assertEquals(attendu.getNom(), recu.getNom());
    assertEquals(attendu.getNumero(), recu.getNumero());
    assertEquals(attendu.getMention(), recu.getMention());
    assertEquals(attendu.getComplement(), recu.getComplement());
  }

  private static void insertAdresse(Adresse adresse) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Adresse VALUES (NULL,?,?,?,?,?,?,?,?);");

    pstmt.setString(1, adresse.getPays());
    pstmt.setString(2, adresse.getCodePost());
    pstmt.setString(3, adresse.getVille());
    pstmt.setString(4, adresse.getVoie());
    pstmt.setString(5, adresse.getNom());
    pstmt.setInt(6, adresse.getNumero());
    pstmt.setString(7, adresse.getMention());
    pstmt.setString(8, adresse.getComplement());

    pstmt.executeUpdate();
  }

  private static List<Adresse> prepareSomesAdresses() {
    List<Adresse> adresses =
        List.of(new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", ""),
            new Adresse(24, "France", "12345", "Volaire", "Rue", "Perce-cent-lieux", 3, "", "Bis"),
            new Adresse(25, "France", "30020", "Lecentre", "Avenue", "Lueilwitz Court", 3,
                "Appt 230", ""));

    adresses.forEach(adresse -> {
      try {
        insertAdresse(adresse);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return adresses;
  }

}
