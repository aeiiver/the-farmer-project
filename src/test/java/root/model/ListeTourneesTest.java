package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListeTourneesTest {

  /**
   * Ce test doit vérifier que uniquement toutes les tournées dont la date
   * n'est pas dépasser soit renvoyé.
   */
  @Test
  void getTourneesCourantes() {
    /*
    Adresse adresse = new Adresse(1, "France", "36300", "Rue", "Quelconque", 5, "", "");
    Client client = new Client(1, "Nom", "Prenom", "01 23 45 67 89", "0.0", adresse);
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    ListeTournees listeTournees = new ListeTournees();

    Commande commande1 = new Commande(1, "Super Commande", 245, "01/01/2023", 2, 4, producteur, client);
    Commande commande2 = new Commande(2, "Commande Trop Cool", 51, "02/01/2023", 5, 12, producteur, client);
    Commande commande3 = new Commande(3, "Hyper Commande", 2565, "03/01/2023", 10, 14, producteur, client);
    Tournee tournee1 = new Tournee(1, "Trajet en camion", 10, 20, producteur, vehicule);
    Tournee tournee2 = new Tournee(2, "Trajet cool en camion", 10, 20, producteur, vehicule);

    tournee1.ajouteCommande(commande1);
    tournee2.ajouteCommande(commande2);
    tournee2.ajouteCommande(commande3);
    listeTournees.ajouter(tournee1);
    listeTournees.ajouter(tournee2);
    */
  }

  /**
   * Ce test doit vérifier que une tournée a bien été ajouté a la liste des tournées.
   * Il doit aussi vérifier que c'est la bonne tournée qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", 10, 20, producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    ArrayList<Tournee> maListe = listeTournees.getTournees();
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
    Adresse adresse = new Adresse(1, "France", "36300", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", 10, 20, producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    listeTournees.supprimer(tournee);
    ArrayList<Tournee> maListe = listeTournees.getTournees();

    for (int i = 0; i < maListe.size(); i++) {
      assertNotEquals(tournee, maListe.get(i));
    }
  }

  /**
   * Ce test doit vérifier que la bonne tournée a été modifié et que les modifications soit juste.
   */
  @Test
  void editer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", 10, 20, producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    tournee.setLibelle("L'autre trajet en camion");
    tournee.setHeureMin(2);
    listeTournees.editer(tournee);
    ArrayList<Tournee> maListe = listeTournees.getTournees();
    Tournee recu = maListe.get(maListe.size() - 1);

    assertEquals(tournee.getNumTournee(), recu.getNumTournee());
    assertEquals(tournee.getLibelle(), recu.getLibelle());
    assertEquals(tournee.getHeureMin(), recu.getHeureMin());
    assertEquals(tournee.getHeureMax(), recu.getHeureMax());
    assertEquals(tournee.getProducteur(), recu.getProducteur());
    assertEquals(tournee.getVehicule(), recu.getVehicule());
  }

}
