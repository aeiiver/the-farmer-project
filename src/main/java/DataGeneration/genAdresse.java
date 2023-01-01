package DataGeneration;

import com.github.javafaker.Faker;
import root.model.Adresse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class genAdresse {
    private double latitude;
    private double longitude;
    public genAdresse() {
        newCoords();
    }

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
        String cityName = json.substring(json.indexOf("\"city\"") + 8, json.indexOf("\"", json.indexOf("\"city\"") + 9));
        adresse = new Adresse(0, "France", json.substring(json.indexOf("postcode") + 11, json.indexOf("postcode") + 16),
            cityName,
            typeRueSplit[1],
            typeRueSplit[valRue],
            numero,
            "", ""
            );
        System.out.println(adresse);
        return adresse;
    }

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

    private void newCoords() {
        Faker faker = new Faker();
        latitude = (faker.number().randomDouble(5,43,48));
        longitude = (faker.number().randomDouble(5,-2,6));
    }

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

    public String getGPS() {
        return this.latitude + "," + this.longitude;
    }
}
