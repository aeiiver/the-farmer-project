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

}
