package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import root.model.Producteur;

class ProducteurDaoTest {

  static Connection connexion;
  static ProducteurDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = DriverManager.getConnection(
        System.getenv("DB_URL_DEV"),
        System.getenv("DB_USER"),
        System.getenv("DB_PSW"));
    systemUnderTest = new ProducteurDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Producteur;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }

  @AfterAll
  static void teardown() throws SQLException {
    connexion.close();
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Producteur renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);

    boolean recu = systemUnderTest.insert(producteur);
    assertTrue(recu);

    assertInsertOk(producteur);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Producteur renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur attendu =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    insertProducteur(attendu);

    Producteur recu = systemUnderTest.get(attendu.getSiret());
    assertNotNull(recu);

    assertProducteurEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Producteur renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Producteur> attendus = prepareSomeProducteurs();

    ArrayList<Producteur> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Producteur attendu = attendus.get(index);
      Producteur recu = recus.get(index);
      assertProducteurEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Producteur renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    insertProducteur(producteur);

    producteur.setNumTel("9876543210");
    producteur.setAdresse(
        new Adresse(24, "France", "13700", "Nou", "Avenue", "Marche-mille-pas", 2, "", "Bis."));

    boolean recu = systemUnderTest.update(producteur);
    assertTrue(recu);

    assertUpdateOk(producteur);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Producteur renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    insertProducteur(producteur);

    boolean recu = systemUnderTest.delete(producteur);
    assertTrue(recu);

    assertDeleteOk(producteur);
  }

  private static void assertInsertOk(Producteur producteur) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Producteur WHERE SIRET = ?;");
    pstmt.setString(1, producteur.getSiret());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String mailInsere = rs.getString("mail");
    String nomInsere = rs.getString("nomProd");
    String prenomInsere = rs.getString("prenomProd");
    String numTelInsere = rs.getString("numTel");
    String mdpInsere = rs.getString("mdp");
    int idAdresseInsere = rs.getInt("idAdresse");

    assertEquals(producteur.getMail(), mailInsere);
    assertEquals(producteur.getNom(), nomInsere);
    assertEquals(producteur.getPrenom(), prenomInsere);
    assertEquals(producteur.getNumTel(), numTelInsere);
    assertEquals(producteur.getMdp(), mdpInsere);
    assertEquals(producteur.getAdresse().getIdAdresse(), idAdresseInsere);
  }

  private static void assertUpdateOk(Producteur producteur) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Producteur WHERE SIRET = ?;");
    pstmt.setString(1, producteur.getSiret());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String mailInsere = rs.getString("mail");
    String nomInsere = rs.getString("nomProd");
    String prenomInsere = rs.getString("prenomProd");
    String numTelInsere = rs.getString("numTel");
    String mdpInsere = rs.getString("mdp");
    int idAdresseInsere = rs.getInt("idAdresse");

    assertEquals(producteur.getMail(), mailInsere);
    assertEquals(producteur.getNom(), nomInsere);
    assertEquals(producteur.getPrenom(), prenomInsere);
    assertEquals(producteur.getNumTel(), numTelInsere);
    assertEquals(producteur.getMdp(), mdpInsere);
    assertEquals(producteur.getAdresse().getIdAdresse(), idAdresseInsere);
  }

  private static void assertDeleteOk(Producteur producteur) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Producteur WHERE SIRET = ?;");
    pstmt.setString(1, producteur.getSiret());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertProducteurEquals(Producteur attendu, Producteur recu) {
    assertEquals(attendu.getMail(), recu.getMail());
    assertEquals(attendu.getNom(), recu.getNom());
    assertEquals(attendu.getPrenom(), recu.getPrenom());
    assertEquals(attendu.getNumTel(), recu.getNumTel());
    assertEquals(attendu.getMdp(), recu.getMdp());
    assertAdresseEquals(attendu.getAdresse(), recu.getAdresse());
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

  private static void insertProducteur(Producteur producteur) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Adresse VALUES (NULL,?,?,?,?,?,?,?,?);",
            Statement.RETURN_GENERATED_KEYS);

    Adresse adresse = producteur.getAdresse();
    pstmt.setString(1, adresse.getPays());
    pstmt.setString(2, adresse.getCodePost());
    pstmt.setString(3, adresse.getVille());
    pstmt.setString(4, adresse.getVoie());
    pstmt.setString(5, adresse.getNom());
    pstmt.setInt(6, adresse.getNumero());
    pstmt.setString(7, adresse.getMention());
    pstmt.setString(8, adresse.getComplement());

    pstmt.executeUpdate();

    ResultSet keys = pstmt.getGeneratedKeys();
    assertTrue(keys.next());
    int insertedIdAdresse = keys.getInt(1);

    pstmt = connexion.prepareStatement("INSERT INTO Producteur VALUES (?,?,?,?,?,?,?);");

    pstmt.setString(1, producteur.getSiret());
    pstmt.setString(2, producteur.getMail());
    pstmt.setString(3, producteur.getNom());
    pstmt.setString(4, producteur.getPrenom());
    pstmt.setString(5, producteur.getNumTel());
    pstmt.setString(6, producteur.getMdp());
    pstmt.setInt(7, insertedIdAdresse);

    pstmt.executeUpdate();
  }

  private static List<Producteur> prepareSomeProducteurs() {
    Adresse adresse1 =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresse2 =
        new Adresse(24, "France", "12345", "Volaire", "Rue", "Perce-cent-lieux", 3, "", "Bis");
    Adresse adresse3 =
        new Adresse(25, "France", "30020", "Lecentre", "Avenue", "Lueilwitz Court", 3, "Appt 230",
            "");

    List<Producteur> producteurs = List.of(
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse1),
        new Producteur("lautre@field-in-things.org", "bycryptiscool", "22446688001234", "Cent",
            "Pierre", "2244668800", adresse2),
        new Producteur("letiers@waiting-them-grow.org", "bycryptiscool", "11335577999876", "Send",
            "Daniel", "0987654321", adresse3));

    producteurs.forEach(producteur -> {
      try {
        insertProducteur(producteur);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return producteurs;
  }

}
