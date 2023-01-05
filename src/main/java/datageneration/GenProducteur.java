package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Adresse;
import root.model.Producteur;
import java.io.FileWriter;

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
    generate(5);
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
    FileWriter fw = new FileWriter("InfoProducteur.txt");
    fw.write("Nom   Prénom      Siret           mdp\n");
    for (int i = 0; i < nbProducteur; i++) {
      Faker faker = new Faker();

      GenAdresse genAdresse = new GenAdresse();
      Adresse adresse = genAdresse.genAdresse();

      String siret = faker.number().digits(14);
      String mdp = faker.internet().password(4, 6);
      String sel = BCrypt.gensalt();
      String mdpChiffre = BCrypt.hashpw(mdp, sel);
      String num = "0" + faker.phoneNumber().cellPhone().replace(".", "")
          .replace("-", "").substring(1, 10).replace(" ", "6")
          .replace(")", "7");
      String nom = faker.name().lastName();
      String prenom = faker.name().firstName();
      String mail = faker.internet().emailAddress();
      int indexOfArobase = mail.indexOf('@');
      mail = nom + "." + prenom + mail.substring(indexOfArobase);

      Producteur producteur = new Producteur(siret,
          mail, nom,
          prenom, num,
          mdpChiffre, adresse);
      listSiret.add(producteur);
      new ProducteurDao(SingleConnection.getInstance()).insert(producteur);


      fw.write(nom + " " + prenom + " : " + siret + " " + mdp + "\n");
    }
    fw.close();
    return listSiret;
  }
}
