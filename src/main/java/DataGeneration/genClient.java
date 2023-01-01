package DataGeneration;

import com.github.javafaker.Faker;
import root.model.Adresse;
import root.model.Client;
import java.io.IOException;

public class genClient {
    public static void main(String[] args) throws IOException {
      genClient(1);

    }

    public static void genClient(int nbClient) throws IOException {
        for (int i = 0; i < nbClient; i++) {
          Faker faker = new Faker();

          genAdresse genAdresse = new genAdresse();
          Adresse adresse = genAdresse.genAdresse();


          Client client = new Client(i, faker.name().firstName(),
              faker.name().lastName(), faker.phoneNumber().phoneNumber(),
              genAdresse.getGPS(), adresse);
        }
    }
}
