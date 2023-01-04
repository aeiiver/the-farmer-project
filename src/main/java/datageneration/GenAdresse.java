package datageneration;

import com.github.javafaker.Faker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    String json = getAddressJson();
    String typeRue = json.substring(json.indexOf("label") + 8, json.indexOf("score") - 3);
    String[] typeRueSplit = typeRue.split(" ");
    int numero = 0;
    String codePostal = "";
    for (String str : typeRueSplit) {
      if (str.matches("[0-9]{5}")) {
        codePostal = str;
      } else if (str.matches("[0-9]{1,}")) {
        numero = Integer.parseInt(typeRueSplit[0]);
      }
    }
    String city = typeRue.substring(typeRue.indexOf(codePostal)).replace(codePostal, "").trim();
    String rue = typeRue.substring(typeRue.indexOf(numero) + 1,
        typeRue.indexOf(codePostal)).replace(Integer.toString(numero), "").trim();

    ArrayList<Adresse> allAdresse = new AdresseDao(SingleConnection.getInstance()).getAll();
    int idMax = 1;
    if (allAdresse != null) {
      idMax = new AdresseDao(SingleConnection.getInstance()).getAll().stream()
          .max(Comparator.comparing(Adresse::getIdAdresse))
          .orElse(new Adresse(3, "", "", "", "", "", 0, "", "")).getIdAdresse();
    }
    idMax++;
    Adresse adresse;
    adresse = new Adresse(idMax, "France",
        codePostal,
        city,
        "",
        rue,
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
