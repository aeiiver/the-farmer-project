package datageneration;

import com.github.javafaker.Faker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import root.data.AdresseDao;
import root.data.SingleConnection;
import root.model.Adresse;

/**
 * Génère une adresse aléatoire.
 */
public class GenAdresse {
  /**
   * La latitude de l'adresse.
   */
  private double latitude;

  /**
   * Longitude de l'adresse.
   */
  private double longitude;

  /**
   * Constructeur générant des coordonnées GPS aléatoires.
   */
  public GenAdresse() {
    newCoords();
  }

  /**
   * Génère une adresse aléatoirement.
   *
   * @return L'adresse générée.
   * @throws IOException Si l'adresse n'a pas pu être générée.
   */
  public Adresse genAdresse() throws IOException {
    Adresse adresse = null;
    String json = getAddressJson();
    String typeRue = json.substring(json.indexOf("name") + 7, json.indexOf("postcode") - 3);
    String[] typeRueSplit = typeRue.split(" ");
    int valRue = 2;
    int numero;
    try {
      numero = Integer.parseInt(typeRueSplit[0]);
    } catch (NumberFormatException e) {
      valRue = 3;
      numero = 0;
    }
    if (typeRueSplit[1].equals("Lieu")) {
      for (int i = 4; i < typeRueSplit.length - 1; i++) {
        typeRueSplit[3] += typeRueSplit[i + 1];
      }
    } else {
      for (int i = 2; i < typeRueSplit.length - 1; i++) {
        typeRueSplit[2] += " " + typeRueSplit[i + 1];
      }
    }
    String cityName = json.substring(json.indexOf("\"city\"") + 8,
        json.indexOf("\"", json.indexOf("\"city\"") + 9));
    adresse = new Adresse("France",
        json.substring(json.indexOf("postcode") + 11, json.indexOf("postcode") + 16),
        cityName,
        typeRueSplit[1],
        typeRueSplit[valRue],
        numero,
        "", ""
    );
    Connection connection = SingleConnection.getInstance();
    new AdresseDao(connection).insert(adresse);
    return adresse;
  }

  /**
   * Récupère un JSON contenant les informations d'une adresse.
   *
   * @return Le JSON contenant les informations d'une adresse.
   * @throws IOException Si le JSON n'a pas pu être récupéré.
   */
  private String getAddressJson() throws IOException {
    String retour = "";
    URL url = new URL("https://api-adresse.data.gouv.fr/reverse/?lon=" + this.longitude + "&lat=" + this.latitude);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.connect();
    int responseCode = connection.getResponseCode();
    if (responseCode >= 200 && responseCode < 300) {
      InputStream inputStream = connection.getInputStream();
      String responseBody = readInputStream(inputStream);
      if (responseBody.contains("properties")) {
        retour = responseBody;
        retour = retour.substring(retour.indexOf("properties") + 13);
      }
    }
    if (retour.equals("")) {
      newCoords();
      return getAddressJson();
    } else {
      return retour;
    }
  }

  /**
   * Génère de nouvelles coordonnées GPS aléatoires.
   */
  private void newCoords() {
    Faker faker = new Faker();
    latitude = (faker.number().randomDouble(5, 43, 48));
    longitude = (faker.number().randomDouble(5, -2, 6));
  }

  /**
   * Lit un InputStream.
   *
   * @param inputStream L'InputStream à lire.
   * @return Le contenu de l'InputStream.
   * @throws IOException Si l'InputStream n'a pas pu être lu.
   */
  private static String readInputStream(InputStream inputStream) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line;
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }
    reader.close();
    return sb.toString();
  }

  public String getGps() {
    return this.latitude + "," + this.longitude;
  }
}
