package root.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListeVehiculesTest {


  /**
   * Ce test doit vérifier que un véhicule a bien été ajouté a la liste des véhicules.
   * Il doit aussi vérifier que c'est le bon véhicule qui est ajouté.
   */
  @Test
  void ajouter() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    ListeVehicules listeVehicules = new ListeVehicules();

    listeVehicules.ajouter(vehicule);
    ArrayList<Vehicule> maListe = listeVehicules.getVehicules();
    Vehicule recu = maListe.get(maListe.size() - 1);

    assertEquals(vehicule.getImmat(), recu.getImmat());
    assertEquals(vehicule.getPoidsMax(), recu.getPoidsMax());
    assertEquals(vehicule.getProprietaire(), recu.getProprietaire());
  }

  /**
   * Ce test doit vérifier que le véhicule dont on veut la supression a bien été supprimé.
   */
  @Test
  void supprimer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    ListeVehicules listeVehicules = new ListeVehicules();

    listeVehicules.ajouter(vehicule);
    listeVehicules.supprimer(vehicule);
    ArrayList<Vehicule> maListe = listeVehicules.getVehicules();

    for (int i = 0; i < maListe.size(); i++) {
      assertNotEquals(vehicule, maListe.get(i));
    }
  }

  /**
   * Ce test doit vérifier que le bon véhicule a été modifié et que les modifications soit juste.
   */
  @Test
  void editer() {
    Adresse adresse = new Adresse(1, "France", "36300", "Villa", "Rue", "Quelconque", 5, "", "");
    Producteur producteur = new Producteur("email@jaimail.com", "motdepasse1234", "000 111 222 33333", "Producteur", "Random", "99 99 99 99 99", adresse);
    Vehicule vehicule = new Vehicule("SW-0241-1041", 500, producteur);
    ListeVehicules listeVehicules = new ListeVehicules();

    listeVehicules.ajouter(vehicule);
    vehicule.setPoidsMax(1000);
    listeVehicules.editer(vehicule);
    ArrayList<Vehicule> maListe = listeVehicules.getVehicules();
    Vehicule recu = maListe.get(maListe.size() - 1);

    assertEquals(vehicule.getImmat(), recu.getImmat());
    assertEquals(vehicule.getPoidsMax(), recu.getPoidsMax());
    assertEquals(vehicule.getProprietaire(), recu.getProprietaire());
  }

}
