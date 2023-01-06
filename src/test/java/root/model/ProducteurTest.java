package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import root.data.ProducteurDao;
import root.data.SingleConnection;

import java.sql.Connection;

class ProducteurTest {

  static Connection connexion;
  static ProducteurDao producteurDao;

  /**
   * Ce test doit vérifier que la vérification des identifiants producteur renvoie bien
   * true quand les identifiants sont correctes.
   */
  @Test
  void verifieIdentifiantsOk() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);

    connexion = SingleConnection.getInstance();
    producteurDao = new ProducteurDao(connexion);

    Producteur entreeDao = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    producteurDao.insert(entreeDao);
    Producteur sortieDao = null;
    for (int i = 0; i < producteurDao.getAll().size(); i++) {
      if (producteur.getSiret() == producteurDao.get(String.valueOf(i)).getSiret()) {
        sortieDao = producteurDao.get(String.valueOf(i));
      }
    }

    assertEquals(producteur.getMdp(), sortieDao.getMdp());
  }

  /**
   * Ce test doit vérifier que la vérification des identifiants producteur renvoie bien
   * false quand les identifiants sont incorrectes.
   */
  @Test
  void verifieIdentifiantsPasOk() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);

    connexion = SingleConnection.getInstance();
    producteurDao = new ProducteurDao(connexion);

    Producteur entreeDao = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    producteurDao.insert(entreeDao);
    Producteur sortieDao = null;
    for (int i = 0; i < producteurDao.getAll().size(); i++) {
      if (producteur.getSiret() == producteurDao.get(String.valueOf(i)).getSiret()) {
        sortieDao = producteurDao.get(String.valueOf(i));
      }
    }

    assertNotEquals(producteur.getMdp(), sortieDao.getMdp());
  }

  @Test
  void testEquals() {
    //TODO
  }

  @Test
  void testToString() {
    //TODO
  }
}
