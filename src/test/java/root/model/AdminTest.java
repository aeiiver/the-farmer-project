package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import root.data.AdminDao;

class AdminTest {

  /**
   * Ce test doit vérifier que la vérification des identifiants administrateur renvoie bien
   * true quand les identifiants sont correctes.
   */
  @Test
  void verifieIdentifiantsOk() {
    Admin admin = new Admin("mail@gmail.com", "motdepasse123", 1, "NomPrenom");
    // AdminDao adminDao = new AdminDao();
  }

  /**
   * Ce test doit vérifier que la vérification des identifiants administrateur renvoie bien
   * false quand les identifiants sont incorrectes.
   */
  @Test
  void verifieIdentifiantsPasOk() {
  }

}
