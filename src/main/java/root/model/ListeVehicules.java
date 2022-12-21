package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Vehicules.
 */
public class ListeVehicules {

  /**
   * Liste des vehicules.
   *
   * @see ListeVehicules#ListeVehicules()
   * @see ListeVehicules#getVehicules()
   * @see ListeVehicules#ajouter(Vehicule)
   * @see ListeVehicules#supprimer(Vehicule)
   * @see Vehicule
   */
  private ArrayList<Vehicule> vehicules;

  /**
   * Constructeur.
   */
  public ListeVehicules() {
    vehicules = new ArrayList<>();
  }

  /**
   * Getter de la liste des vehicules.
   *
   * @return vehicules la liste des vehicules
   */
  public ArrayList<Vehicule> getVehicules() {
    return vehicules;
  }

  /**
   * Méthode pour ajouter un véhicule à la liste des véhicules.
   *
   * @param vehicule véhicule à ajouter
   */
  public void ajouter(Vehicule vehicule) {
    vehicules.add(vehicule);
  }

  /**
   * Méthode pour supprimer un véhicule de la liste des véhicules.
   *
   * @param vehicule véhicule à supprimer
   */
  public void supprimer(Vehicule vehicule) {
    vehicules.remove(vehicule);
  }

  /**
   * Méthode pour modifier un véhicule de la liste des véhicules.
   *
   * @param vehicule véhicule à modifier
   */
  public void editer(Vehicule vehicule) {
  }

}
