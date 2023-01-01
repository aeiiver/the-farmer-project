package DataGeneration;

import com.github.javafaker.Faker;
import root.model.Adresse;
import root.model.Producteur;

import java.io.IOException;
import java.util.ArrayList;

public class genProducteur {
    public static void main(String[] args) throws IOException {
        genProducteur(1);
    }

    public static ArrayList<String> genProducteur(int nbProducteur) throws IOException {
      ArrayList<String> listSiret = new ArrayList<String>();
      for (int i = 0; i < nbProducteur; i++) {
        Faker faker = new Faker();

        genAdresse genAdresse = new genAdresse();
        Adresse adresse = genAdresse.genAdresse();

        String siret = faker.number().digits(14);
        listSiret.add(siret);


        Producteur producteur = new Producteur(siret,
          faker.internet().emailAddress(), faker.name().firstName(),
          faker.name().lastName(), faker.phoneNumber().phoneNumber(),
          faker.internet().password(8, 16), adresse);
      }
      return listSiret;
    }
}
