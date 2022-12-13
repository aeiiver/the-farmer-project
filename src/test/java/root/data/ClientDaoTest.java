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
import root.model.Adresse;
import root.model.Client;

class ClientDaoTest {


  static Connection connexion;
  static Statement statement;
  static ClientDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = DriverManager.getConnection(
        System.getenv("DB_URL_DEV"),
        System.getenv("DB_USER"),
        System.getenv("DB_PSW")
    );
    statement = connexion.createStatement();
    systemUnderTest = new ClientDao(connexion);
  }

  @AfterAll
  static void teardown() throws SQLException {
    statement.close();
    connexion.close();
  }

  @AfterEach
  void tear() throws SQLException {
    statement.executeUpdate("DELETE FROM Client;");
  }

  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Client renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresse = new Adresse(33, "France", "72310", "Chemin", "Les Charbonnieres", 0, "", "");
    Client client = new Client(-1, "Smith", "John", "0624745201",
        "47.83700332971232,0.7046477664761941", adresse);

    boolean recu = systemUnderTest.insert(client);

    assertTrue(recu);
    assertEquals(TestUtil.nombreLignesTrouvees(statement, "Client"), 1);
    assertEquals(TestUtil.nombreLignesTrouvees(statement, "Adresse"), 1);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Client renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void get() throws SQLException {
    statement.executeUpdate("INSERT INTO Adresse VALUES "
        + "(54, 'France', '33600', 'Pessac', 'Ruelle', 'Grand vert', 2, '', '');");
    statement.executeUpdate("INSERT INTO Client VALUES (23, 'Smith', 'John', '0624745201',"
        + "'47.83700332971232,0.7046477664761941', 54);");

    Client recu = systemUnderTest.get(23);

    assertEquals(23, recu.getIdClient());
    assertEquals("Smith", recu.getNom());
    assertEquals("John", recu.getPrenom());
    assertEquals("0624745201", recu.getNumTel());
    assertEquals("47.83700332971232,0.7046477664761941", recu.getGps());
    assertTrue(recu.getAdresse() != null);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Client renvoie bien true s'ils sont bien reçus.
   */
  @Test
  void getAll() throws SQLException {
    List<Adresse> adresses = List.of(
        new Adresse(33, "France", "72310", "Chemin", "Les Charbonnieres", 0, "", ""),
        new Adresse(34, "France", "79340", "Rue", "Les Forges", 2, "", ""),
        new Adresse(35, "France", "72310", "Promenade", "La Petite Piece", 1, "", "")
    );
    List<Client> clientsAttendus = List.of(
        new Client(14, "Smith", "John", "0642784201",
            "47.83700332971232,0.7046477664761941", adresses.get(0)),
        new Client(15, "Charles", "Peter", "0713928374",
            "46.53935446877776,-0.024586199879674808", adresses.get(1)),
        new Client(16, "Let", "Pomme", "0683947362",
            "46.8381642630827,0.439126696719514", adresses.get(2))
    );
    connexion.setAutoCommit(false);
    for (Adresse adresse : adresses) {
      statement.addBatch(String.format("INSERT INTO Adresse VALUES "
              + "(%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s');",
          adresse.getIdAdresse(), adresse.getPays(), adresse.getCodePost(), "", adresse.getVoie(),
          adresse.getNom(), adresse.getNumero(), adresse.getMention(), adresse.getComplement()));
    }
    statement.executeBatch();
    statement.clearBatch();
    connexion.commit();
    for (Client client : clientsAttendus) {
      statement.addBatch(String.format("INSERT INTO Client VALUES "
              + "(%d, '%s', '%s', '%s', '%s', %d);",
          client.getIdClient(), client.getNom(), client.getPrenom(), client.getNumTel(),
          client.getGps(), client.getAdresse().getIdAdresse()));
    }
    statement.executeBatch();
    statement.clearBatch();
    connexion.commit();
    connexion.setAutoCommit(true);

    ArrayList<Client> clientsRecus = systemUnderTest.getAll();

    assertTrue(clientsRecus.size() == clientsAttendus.size());
    for (int index = 0; index < clientsAttendus.size(); ++index) {
      Client attendu = clientsAttendus.get(index);
      Client recu = clientsRecus.get(index);

      assertEquals(attendu.getIdClient(), recu.getIdClient());
      assertEquals(attendu.getNom(), recu.getNom());
      assertEquals(attendu.getPrenom(), recu.getPrenom());
      assertEquals(attendu.getNumTel(), recu.getNumTel());
      assertEquals(attendu.getGps(), recu.getGps());
      assertEquals(attendu.getAdresse().getIdAdresse(), recu.getAdresse().getIdAdresse());
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Client renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresse = new Adresse(33, "France", "72310", "Chemin", "Les Charbonnieres", 0, "", "");
    Client client = new Client(55, "Smith", "John", "0624745201",
        "47.83700332971232,0.7046477664761941", adresse);
    statement.executeUpdate(String.format("INSERT INTO Client VALUES "
            + "(%d, '%s', '%s', '%s', '%s', %d);",
        client.getIdClient(), client.getNom(), client.getPrenom(), client.getNumTel(),
        client.getGps(), client.getAdresse().getIdAdresse()));
    client.setNumTel("0756478674");

    boolean recu = systemUnderTest.update(client);

    assertTrue(recu);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Client renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresse = new Adresse(33, "France", "72310", "Chemin", "Les Charbonnieres", 0, "", "");
    Client client = new Client(-1, "Smith", "John", "0624745201",
        "47.83700332971232,0.7046477664761941", adresse);

    boolean recu = systemUnderTest.delete(client);

    assertTrue(recu);
    assertEquals(TestUtil.nombreLignesTrouvees(statement, "Client"), 0);
  }

}
