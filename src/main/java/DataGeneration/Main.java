package DataGeneration;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int nbClients = 1;
        int nbCommandes = 500;

        ArrayList<String> sirets = genProducteur.genProducteur(10);
        genClient.genClient(nbClients);

        genVehicule.genVehicule(15, sirets);

        genCommande.genCommande(nbCommandes, sirets, nbClients);
        genTournee.genTournee(50, nbCommandes);

    }
}
