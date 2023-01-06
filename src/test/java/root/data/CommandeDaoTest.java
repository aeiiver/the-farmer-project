package root.data;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import root.model.Adresse;
import root.model.Client;
import root.model.Commande;
import root.model.Producteur;

public class CommandeDaoTest {

  static Connection connexion;
  static CommandeDao systemUnderTest;

  @BeforeAll
  static void setup() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connexion = SingleConnection.getInstance();
    systemUnderTest = new CommandeDao(connexion);
  }

  @AfterEach
  void teardownEach() throws SQLException {
    connexion.prepareStatement("DELETE FROM Commande;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Producteur;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Client;").executeUpdate();
    connexion.prepareStatement("DELETE FROM Adresse;").executeUpdate();
  }


  /**
   * Ce test doit vérifier que l'insertion des données dans
   * la table Commande renvoie bien true s'ils sont bien envoyés.
   */
  @Test
  void insert() throws SQLException {
    Adresse adresseProd =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresseClient =
        new Adresse(-1, "France", "21435", "Who", "Rue", "Clareté des scènes", 7, "Appt. 210", "");
    Producteur producteur =
        new Producteur("12345678901234", "contact@farmer-times.com", "Sant", "Paul", "1133557799",
            "bycryptiscool",
            adresseProd);
    Client client =
        new Client(-1, "Vant", "Jean", "1122334400", "46.232192999999995,2.209666999999996",
            adresseClient);
    Commande commande =
        new Commande(-1, "Orge", 30, Date.valueOf("2030-06-08"), Time.valueOf("11:00:00"),
            Time.valueOf("18:00:00"), producteur, client);
    insertProducteur(producteur);
    insertClient(client);

    boolean recu = systemUnderTest.insert(commande);
    assertTrue(recu);

    assertInsertOk(commande);
  }

  /**
   * Ce test doit vérifier si la récupération d'une ligne de données
   * dans la table Commande renvoie bien l'objet correspondant.
   */
  @Test
  void get() throws SQLException {
    Adresse adresseProd =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresseClient =
        new Adresse(-1, "France", "21435", "Who", "Rue", "Clareté des scènes", 7, "Appt. 210", "");
    Producteur producteur =
        new Producteur("12345678901234", "contact@farmer-times.com", "Sant", "Paul", "1133557799",
            "bycryptiscool",
            adresseProd);
    Client client =
        new Client(-1, "Vant", "Jean", "1122334400", "46.232192999999995,2.209666999999996",
            adresseClient);
    Commande attendu =
        new Commande(-1, "Orge", 30, Date.valueOf("2030-06-08"), Time.valueOf("11:00:00"),
            Time.valueOf("18:00:00"), producteur, client);
    insertProducteur(producteur);
    insertClient(client);
    insertCommande(attendu);

    Commande recu = systemUnderTest.get(attendu.getNumCom());
    assertNotNull(recu);

    assertCommandeEquals(attendu, recu);
  }

  /**
   * Ce test doit vérifier si la récupération de toutes les données
   * dans la table Commande renvoie bien la liste de tous les objets correspondants.
   */
  @Test
  void getAll() throws SQLException {
    List<Commande> attendus = prepareSomeCommandes();

    ArrayList<Commande> recus = systemUnderTest.getAll();
    assertNotNull(recus);
    assertEquals(attendus.size(), recus.size());

    for (int index = 0; index < attendus.size(); ++index) {
      Commande attendu = attendus.get(index);
      Commande recu = recus.get(index);
      assertCommandeEquals(attendu, recu);
    }
  }

  /**
   * Ce test doit vérifier que la mise à jour des données dans
   * la table Commande renvoie bien true s'ils sont bien modifiés.
   */
  @Test
  void update() throws SQLException {
    Adresse adresseProd =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresseClient =
        new Adresse(-1, "France", "21435", "Who", "Rue", "Clareté des scènes", 7, "Appt. 210", "");
    Producteur producteur =
        new Producteur("12345678901234", "contact@farmer-times.com", "Sant", "Paul", "1133557799",
            "bycryptiscool",
            adresseProd);
    Client client =
        new Client(-1, "Vant", "Jean", "1122334400", "46.232192999999995,2.209666999999996",
            adresseClient);
    Commande commande =
        new Commande(-1, "Orge", 30, Date.valueOf("2030-06-08"), Time.valueOf("11:00:00"),
            Time.valueOf("18:00:00"), producteur, client);
    insertProducteur(producteur);
    insertClient(client);
    insertCommande(commande);

    commande.setLibelle("Blé");
    commande.setPoids(40);
    commande.setDateCom(Date.valueOf("2030-06-10"));

    boolean recu = systemUnderTest.update(commande);
    assertTrue(recu);

    assertUpdateOk(commande);
  }

  /**
   * Ce test doit vérifier que la suppresion des données dans
   * la table Commande renvoie bien true s'ils sont bien enlevés.
   */
  @Test
  void delete() throws SQLException {
    Adresse adresseProd =
        new Adresse(-1, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresseClient =
        new Adresse(-1, "France", "21435", "Who", "Rue", "Clareté des scènes", 7, "Appt. 210", "");
    Producteur producteur =
        new Producteur("12345678901234", "contact@farmer-times.com", "Sant", "Paul", "1133557799",
            "bycryptiscool",
            adresseProd);
    Client client =
        new Client(-1, "Vant", "Jean", "1122334400", "46.232192999999995,2.209666999999996",
            adresseClient);
    Commande commande =
        new Commande(-1, "Orge", 30, Date.valueOf("2030-06-08"), Time.valueOf("11:00:00"),
            Time.valueOf("18:00:00"), producteur, client);
    insertProducteur(producteur);
    insertClient(client);
    insertCommande(commande);

    boolean recu = systemUnderTest.delete(commande);
    assertTrue(recu);

    assertDeleteOk(commande);
  }

  private static void assertInsertOk(Commande commande) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement(
        "SELECT * FROM Commande WHERE numCom = (SELECT MAX(numCom) FROM Commande);");

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String libelleInsere = rs.getString("libelle");
    int poidsInsere = rs.getInt("poids");
    Date dateInseree = rs.getDate("dateCom");
    Time heureDebInsere = rs.getTime("heureDeb");
    Time heureFinInsere = rs.getTime("heureFin");
    String siretInsere = rs.getString("SIRET");
    int idClientInsere = rs.getInt("idClient");

    assertEquals(commande.getLibelle(), libelleInsere);
    assertEquals(commande.getPoids(), poidsInsere);
    assertEquals(commande.getDateCom(), dateInseree);
    assertEquals(commande.getHeureDeb(), heureDebInsere);
    assertEquals(commande.getHeureFin(), heureFinInsere);
    assertEquals(commande.getProducteur().getSiret(), siretInsere);
    assertEquals(commande.getClient().getIdClient(), idClientInsere);
  }

  private static void assertUpdateOk(Commande commande) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement("SELECT * FROM Commande WHERE numCom = ?");
    pstmt.setInt(1, commande.getNumCom());

    ResultSet rs = pstmt.executeQuery();
    assertTrue(rs.next());

    String libelleInsere = rs.getString("libelle");
    int poidsInsere = rs.getInt("poids");
    Date dateInseree = rs.getDate("date");
    Time heureDebInsere = rs.getTime("heureDeb");
    Time heureFinInsere = rs.getTime("heureFin");
    String siretInsere = rs.getString("SIRET");
    int idClientInsere = rs.getInt("idClient");

    assertEquals(commande.getLibelle(), libelleInsere);
    assertEquals(commande.getPoids(), poidsInsere);
    assertEquals(commande.getDateCom(), dateInseree);
    assertEquals(commande.getHeureDeb(), heureDebInsere);
    assertEquals(commande.getHeureFin(), heureFinInsere);
    assertEquals(commande.getProducteur().getSiret(), siretInsere);
    assertEquals(commande.getClient().getIdClient(), idClientInsere);
  }

  private static void assertDeleteOk(Commande commande) throws SQLException {
    PreparedStatement pstmt = connexion.prepareStatement("SELECT * FROM Commande WHERE numCom = ?");
    pstmt.setInt(1, commande.getNumCom());

    ResultSet rs = pstmt.executeQuery();
    assertFalse(rs.next());
  }

  private static void assertCommandeEquals(Commande attendu, Commande recu) {
    assertEquals(attendu.getNumCom(), recu.getNumCom());
    assertEquals(attendu.getLibelle(), recu.getLibelle());
    assertEquals(attendu.getPoids(), recu.getPoids());
    assertEquals(attendu.getDateCom(), recu.getDateCom());
    assertEquals(attendu.getHeureFin(), recu.getHeureFin());
    assertProducteurEquals(attendu.getProducteur(), recu.getProducteur());
    assertClientEquals(attendu.getClient(), recu.getClient());
  }

  private static void assertProducteurEquals(Producteur attendu, Producteur recu) {
    assertEquals(attendu.getMail(), recu.getMail());
    assertEquals(attendu.getNom(), recu.getNom());
    assertEquals(attendu.getPrenom(), recu.getPrenom());
    assertEquals(attendu.getNumTel(), recu.getNumTel());
    assertEquals(attendu.getMdp(), recu.getMdp());
    assertAdresseEquals(attendu.getAdresse(), recu.getAdresse());
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

  private static void insertCommande(Commande commande) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Commande VALUES (NULL,?,?,?,?,?,?,?,NULL);");

    pstmt.setString(1, commande.getLibelle());
    pstmt.setInt(2, commande.getPoids());
    pstmt.setDate(3, commande.getDateCom());
    pstmt.setTime(4, commande.getHeureDeb());
    pstmt.setTime(5, commande.getHeureFin());
    pstmt.setString(6, commande.getProducteur().getSiret());
    pstmt.setInt(7, commande.getClient().getIdClient());

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

  private static void insertClient(Client client) throws SQLException {
    PreparedStatement pstmt =
        connexion.prepareStatement("INSERT INTO Adresse VALUES (NULL,?,?,?,?,?,?,?,?);",
            Statement.RETURN_GENERATED_KEYS);
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

    ResultSet keys = pstmt.getGeneratedKeys();
    assertTrue(keys.next());
    int insertedIdAdresse = keys.getInt(1);

    pstmt = connexion.prepareStatement("INSERT INTO Client VALUES (NULL,?,?,?,?,?);",
        Statement.RETURN_GENERATED_KEYS);

    pstmt.setString(1, client.getNom());
    pstmt.setString(2, client.getPrenom());
    pstmt.setString(3, client.getNumTel());
    pstmt.setString(4, client.getGps());
    pstmt.setInt(5, insertedIdAdresse);

    pstmt.executeUpdate();

    keys = pstmt.getGeneratedKeys();
    assertTrue(keys.next());
    int insertedIdClient = keys.getInt(1);

    client.setIdClient(insertedIdClient);
  }

  private static List<Commande> prepareSomeCommandes() {
    Adresse adresse1 =
        new Adresse(23, "France", "12400", "Bou", "Rue", "Perce-cent-lieux", 3, "", "");
    Adresse adresse2 =
        new Adresse(24, "France", "12345", "Volaire", "Rue", "Perce-cent-lieux", 3, "", "Bis");
    Adresse adresse3 =
        new Adresse(25, "France", "30020", "Lecentre", "Avenue", "Lueilwitz Court", 3, "Appt 230",
            "");
    Adresse adresse4 =
        new Adresse(26, "France", "21435", "Who", "Rue", "Clareté des scènes", 7, "Appt. 210", "");
    Adresse adresse5 =
        new Adresse(27, "France", "54600", "Perché", "Boulevard", "Place du perché", 1, "", "");
    Adresse adresse6 =
        new Adresse(28, "France", "21300", "Otourd", "Avenue", "Haut-les-ciels", 2, "", "Ter.");

    Producteur producteur1 =
        new Producteur("12345678901234", "contact@farmer-times.com", "Sant", "Paul", "1133557799",
            "bycryptiscool",
            adresse1);
    Producteur producteur2 =
        new Producteur("22446688001234", "lautre@field-in-things.org", "Cent", "Pierre",
            "2244668800", "bycryptiscool",
            adresse2);
    Producteur producteur3 =
        new Producteur("11335577999876", "letiers@waiting-them-grow.org", "Send", "Daniel",
            "0987654321", "bycryptiscool",
            adresse3);

    Client client1 = new Client(23, "Vant", "Jean", "1122334400", "46.232193,2.2096670", adresse4);
    Client client2 = new Client(24, "Vant", "Jean", "1231231230", "46.232193,2.2096670", adresse5);
    Client client3 = new Client(25, "Vant", "Jean", "2244668800", "46.232193,2.2096670", adresse6);

    List<Commande> commandes = List.of(
        new Commande(-1, "Orge", 30, Date.valueOf("2030-06-08"), Time.valueOf("11:00:00"),
            Time.valueOf("18:00:00"), producteur1, client1),
        new Commande(-1, "Seigle", 30, Date.valueOf("2030-06-08"), Time.valueOf("08:00:00"),
            Time.valueOf("15:00:00"), producteur1, client2),
        new Commande(-1, "Blé", 20, Date.valueOf("2024-05-02"), Time.valueOf("09:00:00"),
            Time.valueOf("17:00:00"), producteur2, client2),
        new Commande(-1, "Pomme", 50, Date.valueOf("2029-06-21"), Time.valueOf("9:00:00"),
            Time.valueOf("16:00:00"), producteur3, client3));

    List.of(producteur1, producteur2, producteur3).forEach(producteur -> {
      try {
        insertProducteur(producteur);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    List.of(client1, client2, client3).forEach(client -> {
      try {
        insertClient(client);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    commandes.forEach(commande -> {
      try {
        insertCommande(commande);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });

    return commandes;
  }

  @Test
  void getAllByNumTournee() {
    //TODO
  }

  @Test
  void getAllByProducteur() {
    //TODO
  }

  @Test
  void getCommandeCourante() {
    //TODO
  }
}
