package DataGeneration;

import com.github.javafaker.Faker;
import root.data.ClientDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Commande;
import root.model.Producteur;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class genCommande {
  public static void genCommande(int nb, String siret, int nbClients) {
    for (int i = 0; i < nb; i++) {
      Faker faker = new Faker();
      Time min = Time.valueOf(String.valueOf(faker.number().numberBetween(6, 21)));
      Time max = Time.valueOf(String.valueOf(faker.number().numberBetween(6, 21)));
      if (min.after(max)) {
        Time temp = min;
        min = max;
        max = temp;
      }
      Connection singleConnection = SingleConnection.getInstance();

      Commande commande = new Commande(i, faker.lorem().sentence(),
          faker.number().numberBetween(1, 80),
          (java.sql.Date) faker.date().between(Date.valueOf("2020-01-01"), Date.valueOf("2020-12-31")),
          min, max,
          new ProducteurDao(singleConnection).get(siret),
          new ClientDao(singleConnection).get(faker.number().numberBetween(0, nbClients - 1)));
    }
  }
}
