package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import root.data.AdminDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

class TourneeTest {

  /**
   * Ce test doit vérifier que Tournee.estValide() renvoie true uniquement
   * lorsque la tournée est valide.
   */
  @Test
  void estValide() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);

    Commande commande1 = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2023"), Time.valueOf("02:00:00"), Time.valueOf("07:00:00"), producteur, client);
    Commande commande2 = new Commande(2, "Commande Trop Cool", 51, Date.valueOf("01/01/2023"), Time.valueOf("05:00:00"), Time.valueOf("12:00:00"), producteur, client);
    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("05:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);

    tournee.ajouteCommande(commande1);
    tournee.ajouteCommande(commande2);

    ArrayList<Commande> commandesTournee = tournee.getCommandes();
    int poidsTournee = 0;
    boolean checkTournee = true;

    Date dateTournee = commandesTournee.get(0).getDateCom();
    for (int i = 0; i < commandesTournee.size(); i++) {
      if (commandesTournee.get(i).getDateCom() == dateTournee &&
              (commandesTournee.get(i).getHeureDeb().compareTo(tournee.getHeureMin())) >= 0
              || commandesTournee.get(i).getHeureFin().compareTo(tournee.getHeureMax()) <= 0) {
        poidsTournee += commandesTournee.get(i).getPoids();
      }
      else {
        checkTournee = false;
      }
    }

    if (poidsTournee > vehicule.getPoidsMax()) {
      checkTournee = false;
    }

    assertTrue(checkTournee);
  }

  /**
   * Ce test doit vérifier qu'une commande a bien été ajouté a la tournée.
   * Il doit aussi vérifier que c'est la bonne commande qui est ajouté.
   */
  @Test
  void ajouteCommande() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);

    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    Commande commande = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2040"), Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    tournee.ajouteCommande(commande);
    ArrayList<Commande> listeCommandes = tournee.getCommandes();
    Commande commandeAttendu = listeCommandes.get(0);

    assertEquals(commande, commandeAttendu);
  }

  /**
   * Ce test doit vérifier que la bonne commande a bien été retiré de la tournée.
   */
  @Test
  void retireCommande() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);

    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    Commande commande = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2040"), Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    tournee.ajouteCommande(commande);
    tournee.retireCommande(commande);
    ArrayList<Commande> listeCommandes = tournee.getCommandes();

    for (int i = 0; i < listeCommandes.size(); i++) {
      assertNotEquals(commande, listeCommandes.get(i));
    }
  }

}
