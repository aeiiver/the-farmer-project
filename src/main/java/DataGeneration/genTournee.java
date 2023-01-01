package DataGeneration;

import com.github.javafaker.Faker;
import root.data.CommandeDao;
import root.data.SingleConnection;
import root.model.Tournee;

import java.sql.Connection;

public class genTournee {
  public static void genTournee(int nbTournees, int nbCommandes) {
    int nbCommandesParTournee = (int) Math.ceil(nbCommandes / nbTournees);
    int ite = 0;
    for (int i = 0; i < nbTournees; i += nbCommandesParTournee) {
      Faker faker = new Faker();
      Connection singleConnection = SingleConnection.getInstance();
      java.sql.Time heureMin = new CommandeDao(singleConnection).get(ite * i + i).getHeureDeb();
      java.sql.Time heureMax = new CommandeDao(singleConnection).get(ite * i + i).getHeureFin();

      // Je ne connais pas l'intention de ce code incomplet, mais ça fait rater la compilation
      /*
      Tournee tournee = new Tournee (i, faker.lorem().sentence(), heureMin, heureMax,


      );
      */
    }
  }
}
