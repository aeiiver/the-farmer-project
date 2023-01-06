package datageneration;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.data.VehiculeDao;
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
    int nbClients = nbProducteurs * 4;

    GenClient.generate(nbClients);
    System.out.println("Génération des clients terminée");

    ArrayList<Producteur> producteurs = GenProducteur.generate(nbProducteurs);
    producteurs.add(new ProducteurDao(SingleConnection.getInstance()).get("12345678901234"));
    System.out.println("Génération des producteurs terminée");

    for (Producteur producteur : producteurs) {
      int nbCommandes = 50;
      int nbCommandesParTournee = 10;
      for (int j = 0; j < nbCommandes / nbCommandesParTournee; j++) {
        GenCommande.generate(nbCommandesParTournee, producteur);
      }
    }
    System.out.println("Génération des tournées terminée");
  }
}