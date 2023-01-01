package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Adresse;
import root.model.Producteur;

/**
 * Génération de producteurs aléatoires.
 */
public class GenProducteur {
  /**
  * Génère un producteur aléatoirement.
  *
  * @param args Arguments de la ligne de commande.
  * @throws IOException Si le producteur n'a pas pu être généré.
  */
  public static void main(String[] args) throws IOException {
    generate(1);
  }

  /**
   * Génère n producteur aléatoirement.
   *
   * @param nbProducteur nombre de producteurs à générer.
   * @return liste des SIRET des producteurs générés.
   * @throws IOException Si le producteur n'a pas pu être généré.
   */
  public static ArrayList<String> generate(int nbProducteur) throws IOException {
    ArrayList<String> listSiret = new ArrayList<String>();
    for (int i = 0; i < nbProducteur; i++) {
      Faker faker = new Faker();

      GenAdresse genAdresse = new GenAdresse();
      Adresse adresse = genAdresse.genAdresse();

      String siret = faker.number().digits(14);
      listSiret.add(siret);
      Connection singleConnection = SingleConnection.getInstance();

      Producteur producteur = new Producteur(siret,
          faker.internet().emailAddress(), faker.name().firstName(),
          faker.name().lastName(), faker.phoneNumber().phoneNumber(),
          faker.internet().password(8, 16), adresse);
      new ProducteurDao(singleConnection).insert(producteur);
    }
    return listSiret;
  }
}
