package root.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import root.model.list.ListeClients;

class ListeClientsTest {


  /**
   * Ce test doit vérifier que un client a bien été ajouté a la liste des clients.
   * Il doit aussi vérifier que c'est le bon client qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    ListeClients listeClients = new ListeClients();

    listeClients.ajouter(client);
    List<Client> maListe = listeClients.getClients();
    Client recu = maListe.get(maListe.size() - 1);

    assertEquals(client.getIdClient(), recu.getIdClient());
    assertEquals(client.getNom(), recu.getNom());
    assertEquals(client.getPrenom(), recu.getPrenom());
    assertEquals(client.getNumTel(), recu.getNumTel());
    assertEquals(client.getGps(), recu.getGps());
    assertEquals(client.getAdresse(), recu.getAdresse());
  }

  /**
   * Ce test doit vérifier que le client dont on veut la supression a bien été supprimé.
   */
  @Test
  void supprimer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    ListeClients listeClients = new ListeClients();

    listeClients.ajouter(client);
    listeClients.supprimer(client);
    List<Client> maListe = listeClients.getClients();

    for (int i = 0; i < maListe.size(); i++) {
      assertNotEquals(client, maListe.get(i));
    }
  }

  /**
   * Ce test doit vérifier que le bon client a été modifié et que les modifications soit juste.
   */
  @Test
  void editer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    ListeClients listeClients = new ListeClients();

    listeClients.ajouter(client);
    client.setNom("AutreNom");
    client.setNumTel("01 02 03 04 05");
    listeClients.editer(client);
    List<Client> maListe = listeClients.getClients();
    Client recu = maListe.get(maListe.size() - 1);

    assertEquals(client.getIdClient(), recu.getIdClient());
    assertEquals(client.getNom(), recu.getNom());
    assertEquals(client.getPrenom(), recu.getPrenom());
    assertEquals(client.getNumTel(), recu.getNumTel());
    assertEquals(client.getGps(), recu.getGps());
    assertEquals(client.getAdresse(), recu.getAdresse());
  }

}
