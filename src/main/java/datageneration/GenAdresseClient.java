package datageneration;

import static datageneration.UtilGen.parseGpsLat;
import static datageneration.UtilGen.parseGpsLon;
import static root.Utils.readInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import root.model.Adresse;

public class GenAdresseClient {
  private double longitudeProducteur;
  private double latitudeProducteur;

  private double longitudeClient;
  private double latitudeClient;

  public GenAdresseClient(double longitude, double latitude) {
    this.longitudeProducteur = longitude;
    this.latitudeProducteur = latitude;
  }

  public Adresse genAdresse() {
    String json = getAddressJson(calcCoord());
    return parseJson(json);
  }

  private Adresse parseJson(String json) {
    String typeRue = json.substring(json.indexOf("label") + 8, json.indexOf("score") - 3);
    String[] typeRueSplit = typeRue.split(" ");
    int numero = 0;
    String codePostal = "";
    for (String str : typeRueSplit) {
      if (str.matches("[0-9]{5}")) {
        codePostal = str;
      } else if (str.matches("[0-9]+")) {
        numero = Integer.parseInt(str);
      }
    }

    // Extraire le nom de la rue et la ville
    int indexCodePostal = typeRue.indexOf(codePostal);
    String rue = typeRue.substring(0, indexCodePostal).trim();
    String city = typeRue.substring(indexCodePostal).replace(codePostal, "").trim();

    // Créer et retourner l'objet Adresse
    return new Adresse("France", codePostal, city, "", rue, numero, "", "");
  }


  private String getAddressJson(String coordonnees) {
    this.longitudeClient = parseGpsLon(coordonnees);
    this.latitudeClient = parseGpsLat(coordonnees);
    String retour = "";
    try {
      URL url = new URL("https://api-adresse.data.gouv.fr/reverse/?lon=" + longitudeClient + "&lat=" + latitudeClient);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Accept", "application/json");
      connection.setDoOutput(true);
      int responseCode = connection.getResponseCode();
      if (responseCode >= 200 && responseCode < 300) {
        InputStream inputStream = connection.getInputStream();
        String responseBody = readInputStream(inputStream);
        if (responseBody.contains("properties")) {
          retour = responseBody.substring(responseBody.indexOf("properties") + 13);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (retour.equals("")) {
      longitudeProducteur += 0.1;
      latitudeProducteur -= 0.1;
      return getAddressJson(calcCoord());

    } else {

      return retour;
    }
  }

  private String calcCoord() {
    double longitude = this.longitudeProducteur + (Math.random() * 0.2) - 0.05;
    double latitude = this.latitudeProducteur + (Math.random() * 0.2) - 0.05;
    return longitude + ", " + latitude;
  }

  public String getGps() {
    return this.longitudeClient + ", " + this.latitudeClient;
  }
}
