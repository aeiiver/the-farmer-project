package datageneration;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;

import root.data.*;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;

import static java.lang.Math.min;

/**
 * Classe permettant de générer des tournées.
 */
public class GenTournee {
  /**
   * Génère des tournées aléatoires.
   *
   * @param commandes Les commandes de la tournée à ajouter.
   */
  public static void generate(ArrayList<Commande> commandes) {
    ArrayList<Vehicule> vehicules = new ArrayList<>();
    Faker faker = new Faker();
    Connection singleConnection = SingleConnection.getInstance();
    Time heureMin = null;
    Time heureMax = null;
    int vehiculeId = (int) Math.floor(Math.random() * vehicules.size());
    for (int j = 0; j < commandes.size(); j++) {
      if (heureMin == null || heureMin.after(commandes.get(j).getHeureDeb())) {
        heureMin = commandes.get(j).getHeureDeb();
      }
      if (heureMax == null || heureMax.before(commandes.get(j).getHeureFin())) {
        heureMax = commandes.get(j).getHeureFin();
      }
    }
    //TODO erreur ici
    Producteur producteur = new CommandeDao(singleConnection).get(commandes.get(0).getNumCom()).getProducteur();
    Vehicule vehicule = new VehiculeDao(singleConnection).get(vehicules.get(vehiculeId).getImmat());

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
