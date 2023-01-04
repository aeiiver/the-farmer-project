package root.model;

import java.sql.Connection;
import root.data.AdminDao;
import root.data.SingleConnection;

/**
 * Classe représentant la session utilisateur d'un administrateur.
 */
public class SessionAdmin extends SessionUtilisateur {

  private ListeProducteurs listeProducteurs;
  private ListeClients listeClients;

  SessionAdmin(String identifiant) {
    Connection connection = SingleConnection.getInstance();

    utilisateur = new AdminDao(connection).get(identifiant);

    listeProducteurs = new ListeProducteurs();
    listeClients = new ListeClients();
  }

  public ListeProducteurs getListeProducteurs() {
    return listeProducteurs;
  }

  public ListeClients getListeClients() {
    return listeClients;
  }
}
