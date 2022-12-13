package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Adresse;

class AdresseDaoTest {

  static Connection connexion;
  static Statement statement;
  static AdresseDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = DriverManager.getConnection(
        System.getenv("DB_URL_DEV"),
        System.getenv("DB_USER"),
        System.getenv("DB_PSW")
    );
    statement = connexion.createStatement();
    systemUnderTest = new AdresseDao(connexion);
  }

  @AfterAll
  static void teardown() throws SQLException {
    statement.close();
    connexion.close();
  }

  @AfterEach
  void tear() throws SQLException {
    statement.executeUpdate("DELETE FROM Adresse;");
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Adresse renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse = new Adresse(-1, "France", "12345", "Rue", "Perce-cent-lieux", 3, "", "");

    boolean recu = systemUnderTest.insert(adresse);

    assertTrue(recu);
    assertEquals(1, TestUtil.nombreLignesTrouvees(statement, "Adresse"));
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Adresse renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void get() throws SQLException {
    String sql = "INSERT INTO Adresse VALUES "
        + "(54, 'France', '33600', 'Pessac', 'Ruelle', 'Grand vert', 2, '', '');";
    statement.executeUpdate(sql);

    Adresse recu = systemUnderTest.get(54);

    assertEquals(54, recu.getIdAdresse());
    assertEquals("France", recu.getPays());
    assertEquals("33600", recu.getCodePost());
    assertEquals("Ruelle", recu.getVoie());
    assertEquals("Grand vert", recu.getNom());
    assertEquals(2, recu.getVoie());
    assertEquals("", recu.getMention());
    assertEquals("Bis", recu.getComplement());
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Adresse renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void getAll() throws SQLException {
    List<Adresse> adressesAttendues = List.of(
        new Adresse(23, "France", "12400", "Rue", "Perce-cent-lieux", 3, "", ""),
        new Adresse(24, "France", "12400", "Rue", "Perce-cent-lieux", 3, "", "Bis"),
        new Adresse(25, "France", "30020", "Avenue", "Lueilwitz Court", 3, "Appt 230", "")
    );
    connexion.setAutoCommit(false);
    for (Adresse adresse : adressesAttendues) {
      statement.addBatch(String.format("INSERT INTO Adresse VALUES "
              + "(%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s');",
          adresse.getIdAdresse(), adresse.getPays(), adresse.getCodePost(), "", adresse.getVoie(),
          adresse.getNom(), adresse.getNumero(), adresse.getMention(), adresse.getComplement()));
    }
    statement.executeBatch();
    statement.clearBatch();
    connexion.commit();
    connexion.setAutoCommit(true);

    ArrayList<Adresse> adressesRecues = systemUnderTest.getAll();

    assertTrue(adressesRecues.size() == adressesAttendues.size());
    for (int index = 0; index < adressesAttendues.size(); ++index) {
      Adresse attendu = adressesAttendues.get(index);
      Adresse recu = adressesRecues.get(index);

      assertEquals(attendu.getIdAdresse(), recu.getIdAdresse());
      assertEquals(attendu.getPays(), recu.getPays());
      assertEquals(attendu.getCodePost(), recu.getCodePost());
      assertEquals(attendu.getVoie(), recu.getVoie());
      assertEquals(attendu.getNom(), recu.getNom());
      assertEquals(attendu.getNumero(), recu.getNumero());
      assertEquals(attendu.getMention(), recu.getMention());
      assertEquals(attendu.getComplement(), recu.getComplement());
    }
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Adresse renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse = new Adresse(22, "France", "12345", "Rue", "Perce-cent-lieux", 3, "", "");
    statement.executeUpdate(String.format("INSERT INTO Adresse VALUES "
            + "(%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s');",
        adresse.getIdAdresse(), adresse.getPays(), adresse.getCodePost(), "", adresse.getVoie(),
        adresse.getNom(), adresse.getNumero(), adresse.getMention(), adresse.getComplement()));
    adresse.setNom("Sentiers des éperdus");
    adresse.setMention("Appt 110");
    adresse.setComplement("Ter");

    boolean recu = systemUnderTest.update(adresse);

    assertTrue(recu);
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Adresse renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse = new Adresse(-1, "France", "12345", "Rue", "Perce-cent-lieux", 3, "", "");

    boolean recu = systemUnderTest.insert(adresse);

    assertTrue(recu);
    assertEquals(0, TestUtil.nombreLignesTrouvees(statement, "Adresse"));
  }

}
