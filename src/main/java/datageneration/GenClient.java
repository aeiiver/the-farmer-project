package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
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
    String GpsProducteur = producteur.getGPS();
    for (int i = 0; i < nbClient; i++) {
      Faker faker = new Faker();

      Random random = new Random();

      double minLon = parseGpsLon(GpsProducteur) -0.00002;
      double minLat = parseGpsLat(GpsProducteur) -0.00002;


      double randomLon = minLon + 0.0004 * random.nextDouble();
      double randomLat = minLat + 0.0004 * random.nextDouble();

      GenAdresse genAdresse = new GenAdresse(randomLon, randomLat);
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

  private static double parseGpsLon(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[0]);
  }

  private static double parseGpsLat(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[1]);
  }
}
