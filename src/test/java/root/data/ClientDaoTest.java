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
import root.model.Client;

public class ClientDaoTest {

  static Connection connexion;
  static ClientDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = SingleConnection.getInstance();
    systemUnderTest = new ClientDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Client;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Client renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Client client = new Client(-1, "Vant", "Jean", "1122334400",
        "46.232192999999995,2.209666999999996", adresse);

    boolean recu = systemUnderTest.insert(client);
    assertTrue(recu);

    assertInsertOk(client);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Client renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Client attendu = new Client(23, "Vant", "Jean", "1122334400",
        "46.232193,2.2096670", adresse);
    insertClient(attendu);

    Client recu = systemUnderTest.get(attendu.getIdClient());
    assertNotNull(recu);

    assertClientEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Client renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Client> attendus = prepareSomeClients();

    ArrayList<Client> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Client attendu = attendus.get(index);
      Client recu = recus.get(index);
      assertClientEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Client renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Client client = new Client(23, "Vant", "Jean", "1122334400",
        "46.232193,2.2096670", adresse);
    insertClient(client);

    client.setGps("43.957193,3.7126230");
    client.setAdresse(
        new Adresse(24, "France", "13700", "Nou", "Avenue", "Marche-mille-pas", 2, "", "Bis."));

    boolean recu = systemUnderTest.update(client);
    assertTrue(recu);

    assertUpdateOk(client);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Client renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Client client = new Client(23, "Vant", "Jean", "1122334400",
        "46.232193,2.2096670", adresse);
    insertClient(client);

    boolean recu = systemUnderTest.delete(client);
    assertTrue(recu);

    assertDeleteOk(client);
  }

  private static void assertInsertOk(Client client) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Client WHERE idClient = (SELECT MAX(idClient) FROM Client);");

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String nomInsere = rs.getString("nomClient");
    String prenomInsere = rs.getString("prenomClient");
    String numTelInsere = rs.getString("numTel");
    String gpsInsere = rs.getString("gps");
    int idAdresseInsere = rs.getInt("idAdresse");

    assertEquals(client.getNom(), nomInsere);
    assertEquals(client.getPrenom(), prenomInsere);
    assertEquals(client.getNumTel(), numTelInsere);
    assertEquals(client.getGps(), gpsInsere);
    assertEquals(client.getAdresse().getIdAdresse(), idAdresseInsere);
  }

  private static void assertUpdateOk(Client client) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Client WHERE idClient = ?;");
    pstmt.setInt(1, client.getIdClient());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String nomInsere = rs.getString("nomClient");
    String prenomInsere = rs.getString("prenomClient");
    String numTelInsere = rs.getString("numTel");
    String gpsInsere = rs.getString("gps");
    int idAdresseInsere = rs.getInt("idAdresse");

    assertEquals(client.getNom(), nomInsere);
    assertEquals(client.getPrenom(), prenomInsere);
    assertEquals(client.getNumTel(), numTelInsere);
    assertEquals(client.getGps(), gpsInsere);
    assertEquals(client.getAdresse().getIdAdresse(), idAdresseInsere);
  }

  private static void assertDeleteOk(Client client) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("SELECT * FROM Client WHERE idClient = ?;");
    pstmt.setInt(1, client.getIdClient());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertClientEquals(Client attendu, Client recu) {
    assertEquals(attendu.getIdClient(), recu.getIdClient());
    assertEquals(attendu.getNom(), recu.getNom());
    assertEquals(attendu.getPrenom(), recu.getPrenom());
    assertEquals(attendu.getNumTel(), recu.getNumTel());
    assertEquals(attendu.getGps(), recu.getGps());
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

  private static void insertClient(Client client) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Adresse VALUES (NULL,?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
    Adresse adresse = client.getAdresse();

    pstmt.setString(1, adresse.getPays());
    pstmt.setString(2, adresse.getCodePost());
    pstmt.setString(3, adresse.getVille());
    pstmt.setString(4, adresse.getVoie());
    pstmt.setString(5, adresse.getNom());
    pstmt.setInt(6, adresse.getNumero());
    pstmt.setString(7, adresse.getMention());
    pstmt.setString(8, adresse.getComplement());

    pstmt.executeUpdate();

    ResultSet keys =  pstmt.getGeneratedKeys();
    assertTrue(keys.next());
    int insertedIdAdresse = keys.getInt(1);

    pstmt =
        connexion.prepareStatement("INSERT INTO Client VALUES (NULL,?,?,?,?,?);");

    pstmt.setString(1, client.getNom());
    pstmt.setString(2, client.getPrenom());
    pstmt.setString(3, client.getNumTel());
    pstmt.setString(4, client.getGps());
    pstmt.setInt(5, insertedIdAdresse);

    pstmt.executeUpdate();
  }

  private static List<Client> prepareSomeClients() {
    Adresse adresse1 =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresse2 =
        new Adresse(24, "France", "12345", "Volaire", "Rue", "Perce-cent-lieux", 3, "", "Bis");
    Adresse adresse3 =
        new Adresse(25, "France", "30020", "Lecentre", "Avenue", "Lueilwitz Court", 3,
            "Appt 230", "");

    List<Client> clients =
        List.of(new Client(23, "Vant", "Jean", "1122334400",
                "46.232193,2.2096670", adresse1),
            new Client(24, "Vant", "Jean", "1231231230",
                "46.232193,2.2096670", adresse2),
            new Client(25, "Vant", "Jean", "2244668800",
                "46.232193,2.2096670", adresse3));

    clients.forEach(client -> {
      try {
        insertClient(client);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return clients;
  }

}
