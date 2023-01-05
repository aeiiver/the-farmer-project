package datageneration;

import static java.lang.Math.min;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import root.data.ClientDao;
import root.data.CommandeDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Client;
import root.model.Commande;
import root.model.Producteur;

/**
 * Classe de génération de commandes aléatoires.
 */
public class GenCommande {
  /**
   * Génère des commandes aléatoires.
   *
   * @param nb Nombre de commandes à générer.
   */
  public static void generate(int nb) {
    ArrayList<Producteur> producteurs = new ProducteurDao(SingleConnection.getInstance()).getAll();
    ArrayList<Client> clients = new ClientDao(SingleConnection.getInstance()).getAll();
    ArrayList<Commande> commandes = new ArrayList<>();
    System.out.println(producteurs);
    for (int i = 0; i < nb; i++) {
      Faker faker = new Faker();
      Time min = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
      Time max = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);
      while (min.before(Time.valueOf("21:00:00")) && min.after(Time.valueOf("06:00:00"))) {
        min = Time.valueOf(faker.date().future(1, TimeUnit.DAYS).toString().split(" ")[3]);

      }
      while (max.before(Time.valueOf("21:00:00")) && max.after(Time.valueOf("06:00:00"))) {
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

      Producteur producteur = producteurs.get(faker.number().numberBetween(0, producteurs.size() - 1));
      if (producteur == null) {
        System.out.println();
      } else {
        Client client = clients.get(faker.number().numberBetween(0, clients.size() - 1));
        if (client == null) {
          System.out.println();
        } else {
          String libelle = faker.lorem().sentence();
          Commande commande = new Commande(
              libelle.substring(0, min(20, libelle.length() - 1)),
              faker.number().numberBetween(1, 80), date, min, max,
              producteur, client);
          commandes.add(commande);
          new CommandeDao(singleConnection).insert(commande);
        }
      }
    }
    GenTournee.generate(commandes);
  }
}
