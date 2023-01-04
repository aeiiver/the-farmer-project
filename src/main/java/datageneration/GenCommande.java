package datageneration;

import static java.lang.Math.min;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import root.data.ClientDao;
import root.data.CommandeDao;
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
      Time min = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
      Time max = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
      while (min.before(Time.valueOf("21:00:00")) && min.after(Time.valueOf("06:00:00"))
          && max.before(Time.valueOf("21:00:00")) && max.after(Time.valueOf("06:00:00"))) {
        min = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
        max = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
      }

      if (min.after(max)) {
        Time temp = min;
        min = max;
        max = temp;
      }
      Connection singleConnection = SingleConnection.getInstance();
      Date date = Date.valueOf(faker.number().numberBetween(2020, 2023) + "-"
          + faker.number().numberBetween(1, 12) + "-" + faker.number().numberBetween(1, 28));

      Commande commande = new Commande(
          faker.lorem().sentence().substring(0, min(20, faker.lorem().sentence().length())),
          faker.number().numberBetween(1, 80), date, min, max,
          new ProducteurDao(singleConnection).get(siret),
          new ClientDao(singleConnection).get(faker.number().numberBetween(0, nbClients - 1)));
      new CommandeDao(singleConnection).insert(commande);
    }
  }
}
