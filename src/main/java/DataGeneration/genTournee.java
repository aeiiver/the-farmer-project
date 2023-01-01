package DataGeneration;

import com.github.javafaker.Faker;
import root.data.CommandeDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Tournee;
import root.model.Vehicule;

import java.sql.Connection;
import java.util.ArrayList;

public class genTournee {
  public static void genTournee(int nbTournees, int nbCommandes, String SIRET, ArrayList<Vehicule> immatriculations) {
    immatriculations.removeIf(vehicule -> !vehicule.getProprietaire().getSiret().equals(SIRET));
    for (int i = 0; i < nbTournees; i++) {
      Faker faker = new Faker();
      Connection singleConnection = SingleConnection.getInstance();
      java.sql.Time heureMin = new CommandeDao(singleConnection).get(i).getHeureDeb();
      java.sql.Time heureMax = new CommandeDao(singleConnection).get(i).getHeureFin();
      int vehicule = (int) Math.floor(Math.random() * immatriculations.size());

      Tournee tournee = new Tournee (faker.lorem().sentence(), heureMin, heureMax, new ProducteurDao(singleConnection).get(SIRET), immatriculations.get(vehicule));
    }
  }
}
