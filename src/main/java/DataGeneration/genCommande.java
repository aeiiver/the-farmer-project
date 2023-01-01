package DataGeneration;

import com.github.javafaker.Faker;
import root.model.Commande;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class genCommande {
  public static void genCommande(int nb, ArrayList<String> sirets, int nbClients) {
    for (int i = 0; i < nb; i++) {
      Faker faker = new Faker();
      Time min = Time.valueOf(String.valueOf(faker.number().numberBetween(6, 21)));
      Time max = Time.valueOf(String.valueOf(faker.number().numberBetween(6, 21)));
      if (min.after(max)) {
        Time temp = min;
        min = max;
        max = temp;
      }

      Commande commande = new Commande(i, faker.lorem().sentence(),
          faker.number().numberBetween(1, 50), faker.date().between(Date.valueOf("2020-01-01"), Date.valueOf("2020-12-31")),
          min, max, sirets.get(faker.number().numberBetween(0, sirets.size() - 1)),
          faker.number().numberBetween(1, nbClients));

    }
  }
}
