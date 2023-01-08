package root.model.list;

import org.junit.jupiter.api.Test;
import root.model.*;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListeProducteursTest {

  /**
   * Ce test doit vérifier que une tournée a bien été ajouté a la liste des tournées.
   * Il doit aussi vérifier que c'est la bonne tournée qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur", "Random", "99 99 99 99 99", "motdepasse1234", adresse);
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
    assertEquals(tournee.getCommandes(), recu.getCommandes());
  }

  /**
   * Ce test doit vérifier que la tournée dont on veut la supression a bien été supprimé.
   */
  @Test
  void supprimer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur", "Random", "99 99 99 99 99", "motdepasse1234", adresse);
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
    Producteur producteur = new Producteur("000 111 222 33333", "email@jaimail.com", "Producteur", "Random", "99 99 99 99 99", "motdepasse1234", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    Tournee tournee = new Tournee(1, "Trajet en camion", Time.valueOf("10:00:00"), Time.valueOf("20:00:00"), producteur, vehicule);
    ListeTournees listeTournees = new ListeTournees();

    listeTournees.ajouter(tournee);
    tournee.setLibelle("Tournée Trop Cool");
    tournee.setHeureMin(Time.valueOf("05:00:00"));
    tournee.setHeureMax(Time.valueOf("15:00:00"));
    listeTournees.editer(tournee);
    List<Tournee> maListe = listeTournees.getTournees();
    Tournee recu = maListe.get(maListe.size() - 1);

    assertEquals(tournee.getNumTournee(), recu.getNumTournee());
    assertEquals(tournee.getLibelle(), recu.getLibelle());
    assertEquals(tournee.getHeureMin(), recu.getHeureMin());
    assertEquals(tournee.getHeureMax(), recu.getHeureMax());
    assertEquals(tournee.getProducteur(), recu.getProducteur());
    assertEquals(tournee.getVehicule(), recu.getVehicule());
    assertEquals(tournee.getCommandes(), recu.getCommandes());
  }
}