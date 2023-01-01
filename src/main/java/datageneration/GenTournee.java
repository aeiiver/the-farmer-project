package datageneration;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.util.ArrayList;
import root.data.CommandeDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Classe permettant de générer des tournées.
 */
public class GenTournee {
  /**
   * Génère des tournées aléatoires.
   *
   * @param nbTournees Nombre de tournées à générer.
   * @param nbCommandes Nombre de commandes par tournées
   * @param siret SIRET du producteur.
   * @param immatriculations Liste des immatriculations des véhicules du producteur.
   */
  public static void generate(int nbTournees, int nbCommandes, String siret,
                              ArrayList<Vehicule> immatriculations) {
    immatriculations.removeIf(vehicule -> !vehicule.getProprietaire().getSiret().equals(siret));
    for (int i = 0; i < nbTournees; i++) {
      Faker faker = new Faker();
      Connection singleConnection = SingleConnection.getInstance();
      java.sql.Time heureMin = new CommandeDao(singleConnection).get(i).getHeureDeb();
      java.sql.Time heureMax = new CommandeDao(singleConnection).get(i).getHeureFin();
      int vehicule = (int) Math.floor(Math.random() * immatriculations.size());

      Tournee tournee = new Tournee(faker.lorem().sentence(),
          heureMin, heureMax,
          new ProducteurDao(singleConnection).get(siret),
          immatriculations.get(vehicule));
    }
  }
}
