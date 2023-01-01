package DataGeneration;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
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
        Faker faker = new Faker();
        latitude = (faker.number().randomDouble(5,43,48));
        longitude = (faker.number().randomDouble(5,-2,6));
    }

    public Adresse genAdresse() throws IOException {
        Adresse adresse = null;
        URL url = new URL("https://api-adresse.data.gouv.fr/reverse/?lon=" + this.longitude + "&lat=" + this.latitude);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            InputStream inputStream = connection.getInputStream();
            String responseBody = readInputStream(inputStream);
            Gson gson = new Gson();
            String json = responseBody;
            adresse = gson.fromJson(json, Adresse.class);
            System.out.println(adresse);
        }
        return adresse;
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
