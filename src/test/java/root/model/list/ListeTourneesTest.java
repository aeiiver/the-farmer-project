package root.model.list;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.junit.jupiter.api.Test;
import root.model.*;

import java.util.ArrayList;

class ListeTourneesTest {

  /**
   * Ce test doit vérifier que uniquement toutes les tournées dont la date
   * n'est pas dépasser soit renvoyé.
   */
  @Test
  void getTourneesCourantes() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);

    Commande commande1 = new Commande(1, "Super Commande", 245, Date.valueOf("01/01/2023"), Time.valueOf("02:00:00"), Time.valueOf("04:00:00"), producteur, client);
    Commande commande2 = new Commande(2, "Commande Trop Cool", 51, Date.valueOf("02/01/2023"), Time.valueOf("05:00:00"), Time.valueOf("12:00:00"), producteur, client);
    Tournee tournee1 = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    Tournee tournee2 = new Tournee(2, "Trajet cool en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);

    tournee1.ajouteCommande(commande1);
    tournee2.ajouteCommande(commande2);

    Date dateActuel = Date.valueOf("02/01/2023");
    ArrayList<Commande> commandesTournee1 = tournee1.getCommandes();
    ArrayList<Commande> commandesTournee2 = tournee2.getCommandes();

    // TODO
    // Il faut vérifier en fonction des commandes dans la tournée ?
    // Faut-il utiliser la méthode "estValide()" ?
  }

  /**
   * Ce test doit vérifier que une tournée a bien été ajouté a la liste des tournées.
   * Il doit aussi vérifier que c'est la bonne tournée qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    List<Tournee> maListe = listeTournees.getTournees();
    Tournee recu = maListe.get(maListe.size() - 1);

    assertEquals(tournee.getNumTournee(), recu.getNumTournee());
    assertEquals(tournee.getLibelle(), recu.getLibelle());
    assertEquals(tournee.getHeureMin(), recu.getHeureMin());
    assertEquals(tournee.getHeureMax(), recu.getHeureMax());
    assertEquals(tournee.getProducteur(), recu.getProducteur());
    assertEquals(tournee.getVehicule(), recu.getVehicule());
  }

  /**
   * Ce test doit vérifier que la tournée dont on veut la supression a bien été supprimé.
   */
  @Test
  void supprimer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    listeTournees.supprimer(tournee);
    List<Tournee> maListe = listeTournees.getTournees();

    for (int i = 0; i < maListe.size(); i++) {
      assertNotEquals(tournee, maListe.get(i));
    }
  }

  /**
   * Ce test doit vérifier que la bonne tournée a été modifié et que les modifications soit juste.
   */
  @Test
  void editer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur",
        "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    tournee.setLibelle("L'autre trajet en camion");
    tournee.setHeureMin(Time.valueOf("02:00:00"));
    listeTournees.editer(tournee);
    List<Tournee> maListe = listeTournees.getTournees();
    Tournee recu = maListe.get(maListe.size() - 1);

    assertEquals(tournee.getNumTournee(), recu.getNumTournee());
    assertEquals(tournee.getLibelle(), recu.getLibelle());
    assertEquals(tournee.getHeureMin(), recu.getHeureMin());
    assertEquals(tournee.getHeureMax(), recu.getHeureMax());
    assertEquals(tournee.getProducteur(), recu.getProducteur());
    assertEquals(tournee.getVehicule(), recu.getVehicule());
  }

}
