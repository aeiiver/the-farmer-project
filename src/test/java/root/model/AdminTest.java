package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import root.data.AdminDao;
import root.data.SingleConnection;

import java.sql.Connection;
import java.sql.SQLException;

class AdminTest {

  static Connection connexion;
  static AdminDao adminDao;

  /**
   * Ce test doit vérifier que la vérification des identifiants administrateur renvoie bien
   * true quand les identifiants sont correctes.
   */
  @Test
  void verifieIdentifiantsOk() throws ClassNotFoundException, SQLException {
    Admin admin = new Admin(1, "mail@gmail.com", "NomPrenom", "motdepasse123");

    connexion = SingleConnection.getInstance();
    adminDao = new AdminDao(connexion);

    Admin entreeDao = new Admin(1, "mail@gmail.com", "NomPrenom", "motdepasse123");
    adminDao.insert(entreeDao);
    Admin sortieDao = null;
    for (int i = 0; i < adminDao.getAll().size(); i++) {
      if (admin.getPseudo() == adminDao.get(String.valueOf(i)).getPseudo()) {
        sortieDao = adminDao.get(String.valueOf(i));
      }
    }

    assertEquals(admin.getMdp(), sortieDao.getMdp());
  }

  /**
   * Ce test doit vérifier que la vérification des identifiants administrateur renvoie bien
   * false quand les identifiants sont incorrectes.
   */
  @Test
  void verifieIdentifiantsPasOk() {
    Admin admin = new Admin(1, "mail@gmail.com", "NomPrenom", "motdepasse123");

    connexion = SingleConnection.getInstance();
    adminDao = new AdminDao(connexion);

    Admin entreeDao = new Admin(1, "mail@gmail.com", "NomPrenom", "password123");
    adminDao.insert(entreeDao);
    Admin sortieDao = null;
    for (int i = 0; i < adminDao.getAll().size(); i++) {
      if (admin.getPseudo() == adminDao.get(String.valueOf(i)).getPseudo()) {
        sortieDao = adminDao.get(String.valueOf(i));
      }
    }

    assertNotEquals(admin.getMdp(), sortieDao.getMdp());
  }

  @Test
  void testEquals() {
    Admin admin1 = new Admin(1, "mail@gmail.com", "NomPrenom", "motdepasse123");
    Admin admin2 = new Admin(2, "mail@jaimail.com", "MachinTruc", "motdepasse1234");
    Admin admin3 = new Admin(3, "email@gmail.com", "Wow", "password123");
    Admin admin4 = new Admin(1, "mail@gmail.com", "NomPrenom", "motdepasse123");

    assertNotEquals(admin1, admin2);
    assertNotEquals(admin1, admin3);
    assertEquals(admin1, admin4);
  }
}
