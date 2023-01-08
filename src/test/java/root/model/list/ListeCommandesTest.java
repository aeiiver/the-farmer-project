package root.model.list;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.junit.jupiter.api.Test;
import root.model.Adresse;
import root.model.Client;
import root.model.Commande;
import root.model.Producteur;

class ListeCommandesTest {

  /**
   * Ce test doit vérifier que une commande a bien été ajouté a la liste des commandes.
   * Il doit aussi vérifier que c'est la bonne commande qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Commande commande = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2040"),
        Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    ListeCommandes listeCommandes = new ListeCommandes();

    listeCommandes.ajouter(commande);
    List<Commande> maListe = listeCommandes.getCommandes();
    Commande recu = maListe.get(maListe.size() - 1);

    assertEquals(commande.getNumCom(), recu.getNumCom());
    assertEquals(commande.getLibelle(), recu.getLibelle());
    assertEquals(commande.getPoids(), recu.getPoids());
    assertEquals(commande.getDateCom(), recu.getDateCom());
    assertEquals(commande.getHeureDeb(), recu.getHeureDeb());
    assertEquals(commande.getHeureFin(), recu.getHeureFin());
    assertEquals(commande.getClient(), recu.getClient());
    assertEquals(commande.getProducteur(), recu.getProducteur());
  }

  /**
   * Ce test doit vérifier que la commande dont on veut la supression a bien été supprimé.
   */
  @Test
  void supprimer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Commande commande = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2040"),
        Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    ListeCommandes listeCommandes = new ListeCommandes();

    listeCommandes.ajouter(commande);
    listeCommandes.supprimer(commande);
    List<Commande> maListe = listeCommandes.getCommandes();

    for (int i = 0; i < maListe.size(); i++) {
      assertNotEquals(commande, maListe.get(i));
    }
  }

  /**
   * Ce test doit vérifier que la bonne commande a été modifié et que les modifications soit juste.
   */
  @Test
  void editer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Commande commande = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2040"),
        Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    ListeCommandes listeCommandes = new ListeCommandes();

    listeCommandes.ajouter(commande);
    commande.setLibelle("Commande trop cool");
    commande.setHeureDeb(Time.valueOf("05:00:00"));
    commande.setHeureFin(Time.valueOf("15:00:00"));
    listeCommandes.editer(commande);
    List<Commande> maListe = listeCommandes.getCommandes();
    Commande recu = maListe.get(maListe.size() - 1);

    assertEquals(commande.getNumCom(), recu.getNumCom());
    assertEquals(commande.getLibelle(), recu.getLibelle());
    assertEquals(commande.getPoids(), recu.getPoids());
    assertEquals(commande.getDateCom(), recu.getDateCom());
    assertEquals(commande.getHeureDeb(), recu.getHeureDeb());
    assertEquals(commande.getHeureFin(), recu.getHeureFin());
    assertEquals(commande.getClient(), recu.getClient());
    assertEquals(commande.getProducteur(), recu.getProducteur());
  }

}
