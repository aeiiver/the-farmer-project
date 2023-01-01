package DataGeneration;

import root.data.SingleConnection;
import root.data.VehiculeDao;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int nbClients = 1;
        Connection singleConnection = SingleConnection.getInstance();

        ArrayList<String> sirets = genProducteur.genProducteur(10);
        genClient.genClient(nbClients);
        genVehicule.genVehicule(15, sirets);

        for (String siret : sirets) {
            int nbCommandes = 50;
            int nbCommandesParTournee = 10;
            for (int i = 0; i < nbCommandes / nbCommandesParTournee; i++) {
                genCommande.genCommande(nbCommandesParTournee, siret, nbClients);
                genTournee.genTournee(50, nbCommandes, siret, new VehiculeDao(singleConnection).getAll());

            }
        }


    }
}
