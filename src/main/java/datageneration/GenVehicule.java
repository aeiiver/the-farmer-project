package datageneration;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.util.ArrayList;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.Vehicule;

/**
 * Génère des véhicules aléatoires.
 */
public class GenVehicule {
  /**
   * Génère des véhicules aléatoires.
   *
   * @param nbVehicules Nombre de véhicules à générer.
   * @param sirets Liste des SIRET des producteurs.
   */
  public static void generate(int nbVehicules, ArrayList<String> sirets) {
    for (int i = 0; i < nbVehicules; i++) {
      Faker faker = new Faker();
      Connection singleConnection = SingleConnection.getInstance();
      int producteur = (int) Math.floor(Math.random() * sirets.size());
      int poidsMax = faker.number().numberBetween(50, 500);
      String immatriculation = faker.regexify("[A-Z]{2}-[0-9]{3}-[A-Z]{2}");
      Vehicule vehicule = new Vehicule(immatriculation, poidsMax,
          new ProducteurDao(singleConnection).get(sirets.get(producteur)));
      new VehiculeDao(singleConnection).insert(vehicule);
    }
  }
}
