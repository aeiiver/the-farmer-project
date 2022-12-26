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
import root.model.Vehicule;

public class VehiculeDaoTest {

  static Connection connexion;
  static VehiculeDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = SingleConnection.getInstance();
    systemUnderTest = new VehiculeDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Vehicule;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Producteur;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }


  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Vehicule renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    insertProducteur(producteur);

    boolean recu = systemUnderTest.insert(vehicule);
    assertTrue(recu);

    assertInsertOk(vehicule);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Vehicule renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule attendu = new Vehicule("AB-121-XY", 140, producteur);

    insertProducteur(producteur);
    insertVehicule(attendu);

    Vehicule recu = systemUnderTest.get(attendu.getImmat());
    assertNotNull(recu);

    assertVehiculeEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Vehicule renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Vehicule> attendus = prepareSomeVehicules();

    ArrayList<Vehicule> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Vehicule attendu = attendus.get(index);
      Vehicule recu = recus.get(index);
      assertVehiculeEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Vehicule renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    insertProducteur(producteur);
    insertVehicule(vehicule);

    vehicule.setPoidsMax(200);

    boolean recu = systemUnderTest.update(vehicule);
    assertTrue(recu);

    assertUpdateOk(vehicule);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Vehicule renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    insertProducteur(producteur);
    insertVehicule(vehicule);

    boolean recu = systemUnderTest.delete(vehicule);
    assertTrue(recu);

    assertDeleteOk(vehicule);
  }

  private static void assertInsertOk(Vehicule vehicule) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement("SELECT * FROM Vehicule WHERE immat = ?;");
    pstmt.setString(1, vehicule.getImmat());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String immatInseree = rs.getString("immat");
    int poidsMaxInsere = rs.getInt("poidsMax");
    String siretInsere = rs.getString("SIRET");

    assertEquals(vehicule.getImmat(), immatInseree);
    assertEquals(vehicule.getPoidsMax(), poidsMaxInsere);
    assertEquals(vehicule.getProprietaire().getSiret(), siretInsere);
  }

  private static void assertUpdateOk(Vehicule vehicule) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement("SELECT * FROM Vehicule WHERE immat = ?;");
    pstmt.setString(1, vehicule.getImmat());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String immatInseree = rs.getString("immat");
    int poidsMaxInsere = rs.getInt("poidsMax");
    String siretInsere = rs.getString("SIRET");

    assertEquals(vehicule.getImmat(), immatInseree);
    assertEquals(vehicule.getPoidsMax(), poidsMaxInsere);
    assertEquals(vehicule.getProprietaire().getSiret(), siretInsere);
  }

  private static void assertDeleteOk(Vehicule vehicule) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Producteur WHERE SIRET = ?;");
    pstmt.setString(1, vehicule.getImmat());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertVehiculeEquals(Vehicule attendu, Vehicule recu) {
    assertEquals(attendu.getImmat(), recu.getImmat());
    assertEquals(attendu.getPoidsMax(), recu.getPoidsMax());
    assertEquals(attendu.getProprietaire(), recu.getProprietaire());
    assertProducteurEquals(attendu.getProprietaire(), recu.getProprietaire());
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

  private static void insertVehicule(Vehicule vehicule) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement("INSERT INTO Vehicule VALUES (?,?,?);");

    pstmt.setString(1, vehicule.getImmat());
    pstmt.setInt(2, vehicule.getPoidsMax());
    pstmt.setString(3, vehicule.getProprietaire().getSiret());

    pstmt.executeUpdate();
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

  private static List<Vehicule> prepareSomeVehicules() {
    Adresse adresse1 =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresse2 =
        new Adresse(24, "France", "12345", "Volaire", "Rue", "Perce-cent-lieux", 3, "", "Bis");
    Adresse adresse3 =
        new Adresse(25, "France", "30020", "Lecentre", "Avenue", "Lueilwitz Court", 3, "Appt 230",
            "");

    Producteur producteur1 =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse1);
    Producteur producteur2 =
        new Producteur("lautre@field-in-things.org", "bycryptiscool", "22446688001234", "Cent",
            "Pierre", "2244668800", adresse2);
    Producteur producteur3 =
        new Producteur("letiers@waiting-them-grow.org", "bycryptiscool", "11335577999876", "Send",
            "Daniel", "0987654321", adresse3);

    List<Vehicule> vehicules = List.of(
        new Vehicule("AB-121-XY", 140, producteur1),
        new Vehicule("TY-901-UI", 200, producteur1), new Vehicule("NO-436-OP", 160, producteur2),
        new Vehicule("WH-733-AT", 120, producteur3));

    List.of(producteur1, producteur2, producteur3).forEach(producteur -> {
      try {
        insertProducteur(producteur);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    vehicules.forEach(vehicule -> {
      try {
        insertVehicule(vehicule);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return vehicules;
  }

}
