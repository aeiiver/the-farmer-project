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
    int nbProducteurs = 50;
    int nbClients = nbProducteurs * 4;
    Connection singleConnection = SingleConnection.getInstance();

    ArrayList<String> sirets = GenProducteur.generate(nbProducteurs);
    GenClient.generate(nbClients);
    GenVehicule.generate((int) (nbProducteurs * 1.5), sirets);

    for (String siret : sirets) {
      int nbCommandes = 50;
      int nbCommandesParTournee = 10;
      for (int i = 0; i < nbCommandes / nbCommandesParTournee; i++) {
        GenCommande.generate(nbCommandesParTournee, siret, nbClients);
        GenTournee.generate(nbCommandes / nbCommandesParTournee,
            nbCommandes, siret, new VehiculeDao(singleConnection).getAll(), nbCommandesParTournee);
      }
    }
  }
}