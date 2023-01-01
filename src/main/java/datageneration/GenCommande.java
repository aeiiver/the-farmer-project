package datageneration;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import root.data.ClientDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Commande;

/**
 * Classe de génération de commandes aléatoires.
 */
public class GenCommande {
  /**
   * Génère des commandes aléatoires.
   *
   * @param nb Nombre de commandes à générer.
   * @param siret SIRET du producteur.
   * @param nbClients Nombre de clients.
   */
  public static void generate(int nb, String siret, int nbClients) {
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
          (java.sql.Date) faker.date().between(Date.valueOf("2020-01-01"),
              Date.valueOf("2023-12-31")),
          min, max,
          new ProducteurDao(singleConnection).get(siret),
          new ClientDao(singleConnection).get(faker.number().numberBetween(0, nbClients - 1)));
    }
  }
}
