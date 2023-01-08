package datageneration;

import static datageneration.UtilGen.parseGpsLat;
import static datageneration.UtilGen.parseGpsLon;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import root.data.AdresseDao;
import root.data.ClientDao;
import root.data.SingleConnection;
import root.model.Adresse;
import root.model.Client;
import root.model.Producteur;

/**
 * Génération de clients aléatoires.
 */
public class GenClient {

  private static final int EARTH_RADIUS = 6371;

  /**
   * Génère un client aléatoirement.
   *
   * @param nbClient Nombre de clients à générer.
   * @throws IOException Si le client n'a pas pu être généré.
   */
  public static ArrayList<Client> generate(int nbClient, Producteur producteur) throws IOException {
    ArrayList<Client> listClient = new ArrayList<>();
    String gpsProducteur = producteur.getGps();
    for (int i = 0; i < nbClient; i++) {
      Faker faker = new Faker();

      GenAdresseClient genAdresse =
          new GenAdresseClient(parseGpsLon(gpsProducteur), parseGpsLat(gpsProducteur));
      Adresse adresse = genAdresse.genAdresse();
      String gps = genAdresse.getGps();

      Connection singleConnection = SingleConnection.getInstance();
      String num = "0" + faker.phoneNumber().cellPhone().replace(".", "")
          .replace("-", "").substring(1, 10).replace(" ", "6")
          .replace(")", "7");


      Client client = new Client(faker.name().lastName(),
          faker.name().firstName(), num,
          gps, adresse);
      listClient.add(client);
      new AdresseDao(SingleConnection.getInstance()).insert(adresse);
      new ClientDao(singleConnection).insert(client);
    }
    return listClient;
  }
}
