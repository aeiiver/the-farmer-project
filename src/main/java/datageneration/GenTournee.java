package datageneration;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Time;
import java.util.ArrayList;
import root.data.CommandeDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.data.TourneeDao;
import root.model.Commande;
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
                              ArrayList<Vehicule> immatriculations, int commandesParTournee) {
    immatriculations.removeIf(vehicule -> !vehicule.getProprietaire().getSiret().equals(siret));
    Faker faker = new Faker();
    Connection singleConnection = SingleConnection.getInstance();
    ArrayList<Commande> commandes = new CommandeDao(singleConnection).getAll();
    for (int i = 0; i < nbTournees; i++) {
      Time heureMin = null;
      Time heureMax = null;
      int vehiculeId = (int) Math.floor(Math.random() * immatriculations.size());
      for (int j = 0; j < commandesParTournee; i++) {
        int commande = (int) Math.floor(Math.random() * commandes.size());
        if (heureMin == null || heureMin.after(commandes.get(commande).getHeureDeb())) {
          heureMin = commandes.get(commande).getHeureDeb();
        }
        if (heureMax == null || heureMax.before(commandes.get(commande).getHeureFin())) {
          heureMax = commandes.get(commande).getHeureFin();
        }
      }

      Tournee tournee = new Tournee(faker.lorem().sentence(),
          heureMin, heureMax,
          new ProducteurDao(singleConnection).get(siret),
          immatriculations.get(vehiculeId));
      new TourneeDao(singleConnection).insert(tournee);
    }
  }
}
