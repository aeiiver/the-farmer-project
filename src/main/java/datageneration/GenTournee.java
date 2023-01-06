package datageneration;

import static java.lang.Math.getExponent;
import static java.lang.Math.min;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import root.data.CommandeDao;
import root.data.SingleConnection;
import root.data.TourneeDao;
import root.data.VehiculeDao;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Classe permettant de générer des tournées.
 */
public class GenTournee {
  /**
   * Génère des tournées aléatoires.
   *
   * @param commandes Les commandes de la tournée à ajouter.
   */
  public static void generate(ArrayList<Commande> commandes, Producteur producteur) {
    Faker faker = new Faker();
    Connection singleConnection = SingleConnection.getInstance();
    Time heureMin = null;
    Time heureMax = null;
    for (int j = 0; j < commandes.size(); j++) {
      if (heureMin == null || heureMin.after(commandes.get(j).getHeureDeb())) {
        heureMin = commandes.get(j).getHeureDeb();
      }
      if (heureMax == null || heureMax.before(commandes.get(j).getHeureFin())) {
        heureMax = commandes.get(j).getHeureFin();
      }
    }
    Vehicule vehicule = GenVehicule.generate(1, producteur).get(0);

    if (producteur != null && vehicule != null) {
      String phrase = faker.lorem().sentence();
      Tournee tournee = new Tournee(phrase.substring(0, min(20, phrase.length() - 1)),
          heureMin, heureMax, producteur, vehicule);
      new TourneeDao(singleConnection).insert(tournee);

      for (Commande commande : commandes) {
        commande.setNumTournee(tournee.getNumTournee());
        new CommandeDao(singleConnection).update(commande);
      }
    }
  }
}
