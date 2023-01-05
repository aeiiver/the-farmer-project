package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import root.data.ClientDao;
import root.data.SingleConnection;
import root.model.Adresse;
import root.model.Client;

/**
 * Génération de clients aléatoires.
 */
public class GenClient {
  /**
   * Génère un client aléatoirement.
   *
   * @param args Arguments de la ligne de commande.
   * @throws IOException Si le client n'a pas pu être généré.
   */
  public static void main(String[] args) throws IOException {
    generate(1);
  }

  /**
   * Génère un client aléatoirement.
   *
   * @param nbClient Nombre de clients à générer.
   * @throws IOException Si le client n'a pas pu être généré.
   */
  public static void generate(int nbClient) throws IOException {
    for (int i = 0; i < nbClient; i++) {
      Faker faker = new Faker();

      GenAdresse genAdresse = new GenAdresse();
      Adresse adresse = genAdresse.genAdresse();
      Connection singleConnection = SingleConnection.getInstance();
      String num = "0" + faker.phoneNumber().cellPhone().replace(".", "")
          .replace("-", "").substring(1, 10).replace(" ", "6")
          .replace(")", "7");


      Client client = new Client(faker.name().firstName(),
          faker.name().lastName(), num,
          genAdresse.getGps(), adresse);
      new ClientDao(singleConnection).insert(client);
    }
  }
}
