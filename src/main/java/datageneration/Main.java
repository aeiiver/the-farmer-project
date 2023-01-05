package datageneration;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import root.data.SingleConnection;
import root.data.VehiculeDao;

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
    int nbProducteurs = 10;
    int nbClients = nbProducteurs * 4;

    int nbProducteursGen = (GenProducteur.generate(nbProducteurs)).size();
    GenClient.generate(nbClients);
    GenVehicule.generate((int) (nbProducteurs * 1.5));

    for (int i = 0; i < nbProducteursGen; i++) {
      int nbCommandes = 50;
      int nbCommandesParTournee = 10;
      for (int j = 0; j < nbCommandes / nbCommandesParTournee; j++) {
        GenCommande.generate(nbCommandesParTournee);
      }
    }
  }
}