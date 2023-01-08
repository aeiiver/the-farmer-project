package datageneration;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.ArrayList;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Client;
import root.model.Producteur;

/**
 * Classe chargée de lancer la génération de données fictives pour
 * emplir la base de données.
 */
public class Main {
  /**
   * Méthode lançant les différentes générations.
   *
   * @param args arguments.
   * @throws IOException Exception en cas d'erreur sur un URL lors de la génération d'adresses.
   */
  public static void main(String[] args) throws IOException {
    int nbProducteurs = 50;
    Faker faker = new Faker();

    ArrayList<Producteur> producteurs = new ArrayList<>();
    Producteur base = new ProducteurDao(SingleConnection.getInstance()).get("12345678901234");
    base.setGps("47.266899, -0.074186");
    //producteurs.add(base);
    producteurs.addAll(GenProducteur.generate(nbProducteurs));

    System.out.println("Génération des producteurs terminée");

    for (Producteur producteur : producteurs) {
      int nbClient = faker.number().numberBetween(5, 10);
      int nbCommandesParTournee = faker.number().numberBetween(5, 10);
      int temp = Math.min(nbClient, nbCommandesParTournee);
      nbClient = Math.max(nbClient, nbCommandesParTournee);
      nbCommandesParTournee = temp;
      ArrayList<Client> clients = GenClient.generate(nbClient, producteur);
      for (int j = 0; j < nbClient; j++) {
        GenCommande.generate(nbCommandesParTournee, producteur, clients);
      }
    }
    System.out.println("Génération des tournées terminée");
  }
}