package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
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
  public static ArrayList<Producteur> generate(int nbProducteur) throws IOException {
    ArrayList<Producteur> listSiret = new ArrayList<>();
    for (int i = 0; i < nbProducteur; i++) {
      Faker faker = new Faker();

      GenAdresse genAdresse = new GenAdresse();
      Adresse adresse = genAdresse.genAdresse();

      String siret = faker.number().digits(14);
      String mdp = faker.internet().password(8, 16);
      String sel = BCrypt.gensalt();
      String mdpChiffre = BCrypt.hashpw(mdp, sel);
      String num = "0" + faker.phoneNumber().cellPhone().replace(".", "")
          .replace("-", "").substring(1, 10).replace(" ", "6")
          .replace(")", "7");

      Producteur producteur = new Producteur(siret,
          faker.internet().emailAddress(), faker.name().firstName(),
          faker.name().lastName(), num,
          mdpChiffre, adresse);
      listSiret.add(producteur);
      new ProducteurDao(SingleConnection.getInstance()).insert(producteur);
    }
    return listSiret;
  }
}
