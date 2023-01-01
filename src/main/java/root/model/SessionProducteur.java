package root.model;

import java.sql.Connection;
import root.data.ProducteurDao;
import root.data.SingleConnection;

/**
 * Classe représentant la session utilisateur d'un producteur.
 */
public class SessionProducteur extends SessionUtilisateur {

  private ListeCommandes listeCommandes;
  private ListeTournees listeTournees;
  private ListeVehicules listeVehicules;
  private ListeClients listeClients;

  SessionProducteur(String identifiant) {
    Connection connection = SingleConnection.getInstance();

    utilisateur = new ProducteurDao(connection).get(identifiant);

    listeCommandes = new ListeCommandes();
    listeTournees = new ListeTournees();
    listeVehicules = new ListeVehicules();
    listeClients = new ListeClients();
  }

  public ListeCommandes getListeCommandes() {
    return listeCommandes;
  }

  public ListeTournees getListeTournees() {
    return listeTournees;
  }

  public ListeVehicules getListeVehicules() {
    return listeVehicules;
  }

  public ListeClients getListeClients() {
    return listeClients;
  }

}
