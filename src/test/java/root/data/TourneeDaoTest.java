package root.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Adresse;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;

public class TourneeDaoTest {

  static Connection connexion;
  static TourneeDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = SingleConnection.getInstance();
    systemUnderTest = new TourneeDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Tournee;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Vehicule;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Producteur;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }


  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Tournee renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    Tournee tournee =
        new Tournee(-1, "Céréales de saison", Time.valueOf("06:00:00"), Time.valueOf("19:00:00"),
            producteur, vehicule);
    insertProducteur(producteur);
    insertVehicule(vehicule);

    boolean recu = systemUnderTest.insert(tournee);
    assertTrue(recu);

    assertInsertOk(tournee);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Tournee renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    Tournee attendu =
        new Tournee(-1, "Céréales de saison", Time.valueOf("06:00:00"), Time.valueOf("19:00:00"),
            producteur, vehicule);
    insertProducteur(producteur);
    insertVehicule(vehicule);
    insertTournee(attendu);

    Tournee recu = systemUnderTest.get(attendu.getNumTournee());
    assertNotNull(recu);

    assertTourneeEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Tournee renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Tournee> attendus = prepareSomeTournees();

    ArrayList<Tournee> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Tournee attendu = attendus.get(index);
      Tournee recu = recus.get(index);
      assertTourneeEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Tournee renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    Tournee tournee =
        new Tournee(-1, "Céréales de saison", Time.valueOf("06:00:00"), Time.valueOf("19:00:00"),
            producteur, vehicule);
    insertProducteur(producteur);
    insertVehicule(vehicule);
    insertTournee(tournee);

    tournee.setLibelle("Céréales de saison, première qualité");
    tournee.setVehicule(new Vehicule("RT-722-BT", 200, producteur));

    boolean recu = systemUnderTest.update(tournee);
    assertTrue(recu);

    assertUpdateOk(tournee);
  }


  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Commande renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);
    Tournee tournee =
        new Tournee(-1, "Céréales de saison", Time.valueOf("06:00:00"), Time.valueOf("19:00:00"),
            producteur, vehicule);
    insertProducteur(producteur);
    insertVehicule(vehicule);
    insertTournee(tournee);

    boolean recu = systemUnderTest.delete(tournee);
    assertTrue(recu);

    assertDeleteOk(tournee);
  }

  private static void assertInsertOk(Tournee tournee) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Tournee WHERE numTournee  = (SELECT MAX(numTournee) FROM Tournee);");

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String libelleInsere = rs.getString("libelle");
    Time heureMinInsere = rs.getTime("heureMin");
    Time heureMaxInsere = rs.getTime("heureMax");
    String immatInseree = rs.getString("immat");

    assertEquals(tournee.getLibelle(), libelleInsere);
    assertEquals(tournee.getHeureMin(), heureMinInsere);
    assertEquals(tournee.getHeureMax(), heureMaxInsere);
    assertEquals(tournee.getVehicule().getImmat(), immatInseree);
  }

  private static void assertUpdateOk(Tournee tournee) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Tournee WHERE numTournee = ?;");
    pstmt.setInt(1, tournee.getNumTournee());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String libelleInsere = rs.getString("libelle");
    Time heureMinInsere = rs.getTime("heureMin");
    Time heureMaxInsere = rs.getTime("heureMax");
    String immatInseree = rs.getString("immat");

    assertEquals(tournee.getLibelle(), libelleInsere);
    assertEquals(tournee.getHeureMin(), heureMinInsere);
    assertEquals(tournee.getHeureMax(), heureMaxInsere);
    assertEquals(tournee.getVehicule().getImmat(), immatInseree);
  }

  private static void assertDeleteOk(Tournee tournee) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Tournee WHERE numTournee = ?;");
    pstmt.setInt(1, tournee.getNumTournee());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertTourneeEquals(Tournee attendu, Tournee recu) {
    assertEquals(attendu.getNumTournee(), recu.getNumTournee());
    assertEquals(attendu.getLibelle(), recu.getLibelle());
    assertEquals(attendu.getHeureMin(), recu.getHeureMin());
    assertEquals(attendu.getHeureMax(), recu.getHeureMax());
    assertEquals(attendu.getVehicule(), recu.getVehicule());
    assertVehiculeEquals(attendu.getVehicule(), recu.getVehicule());
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

  private static void insertTournee(Tournee tournee) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Tournee VALUES (NULL,?,?,?,?);",
            Statement.RETURN_GENERATED_KEYS);

    pstmt.setString(1, tournee.getLibelle());
    pstmt.setTime(2, tournee.getHeureMin());
    pstmt.setTime(3, tournee.getHeureMax());
    pstmt.setString(4, tournee.getVehicule().getImmat());

    pstmt.executeUpdate();

    ResultSet keys = pstmt.getGeneratedKeys();
    assertTrue(keys.next());
    int insertedNumTournee = keys.getInt(1);

    tournee.setNumTournee(insertedNumTournee);
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

  private static List<Tournee> prepareSomeTournees() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Producteur producteur =
        new Producteur("contact@farmer-times.com", "bycryptiscool", "12345678901234", "Sant",
            "Paul", "1133557799", adresse);
    Vehicule vehicule = new Vehicule("AB-121-XY", 140, producteur);

    List<Tournee> tournees = List.of(
        new Tournee(-1, "Céréales de saison", Time.valueOf("06:00:00"), Time.valueOf("19:00:00"),
            producteur, vehicule),
        new Tournee(-1, "Produits laitiers", Time.valueOf("05:00:00"), Time.valueOf("18:00:00"),
            producteur, vehicule),
        new Tournee(-1, "Fruits et légumes", Time.valueOf("07:00:00"), Time.valueOf("18:00:00"),
            producteur, vehicule));

    insertProducteur(producteur);
    insertVehicule(vehicule);

    tournees.forEach(tournee -> {
      try {
        insertTournee(tournee);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return tournees;
  }

}
