package datageneration;

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

    ArrayList<Producteur> producteurs = GenProducteur.generate(nbProducteurs);
    Producteur base = new ProducteurDao(SingleConnection.getInstance()).get("12345678901234");
    base.setGps("48.856614, 2.3522219");
    producteurs.add(base);
    System.out.println("Génération des producteurs terminée");

    for (Producteur producteur : producteurs) {
      int nbCommandes = 50;
      int nbCommandesParTournee = 10;
      ArrayList<Client> clients = GenClient.generate(nbCommandesParTournee, producteur);
      for (int j = 0; j < nbCommandes / nbCommandesParTournee; j++) {
        GenCommande.generate(nbCommandesParTournee, producteur, clients);
      }
    }
    System.out.println("Génération des tournées terminée");
  }
}