package DataGeneration;

import com.github.javafaker.Faker;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Vehicule;

import java.sql.Connection;
import java.util.ArrayList;

public class genVehicule {
  public static void genVehicule(int nbVehicules, ArrayList<String> SIRETS) {
    for (int i = 0; i < nbVehicules; i++) {
      Faker faker = new Faker();
      Connection singleConnection = SingleConnection.getInstance();
      int producteur = (int) Math.floor(Math.random() * SIRETS.size());
      int poidsMax = (int) Math.floor(Math.random() * 10) + 1;
      String immatriculation = faker.regexify("[A-Z]{2}-[0-9]{3}-[A-Z]{2}");
      Vehicule vehicule = new Vehicule(immatriculation, poidsMax, new ProducteurDao(singleConnection).get(SIRETS.get(producteur)));
    }
  }
}
