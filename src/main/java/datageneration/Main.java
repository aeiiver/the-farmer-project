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
    producteurs.addAll(GenProducteur.generate(nbProducteurs));

    System.out.println("Génération des producteurs et véhicules terminés.");

    for (Producteur producteur : producteurs) {
      int nbClient = faker.number().numberBetween(5, 15);
      int nbCommandesParTournee = faker.number().numberBetween(5, 10);
      ArrayList<Client> clients = GenClient.generate(nbClient, producteur);
      for (int j = 0; j < nbCommandesParTournee; j++) {
        GenCommande.generate(nbCommandesParTournee, producteur, clients);
      }
    }
    System.out.println("Génération des tournées terminée");
  }
}