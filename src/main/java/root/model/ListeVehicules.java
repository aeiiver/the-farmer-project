package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Vehicules.
 */
public class ListeVehicules {
  private ArrayList<Vehicule> vehicules;

  /**
   * Constructeur.
   */
  public ListeVehicules() {
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
   * Setter de la liste des vehicules.
   *
   * @param vehicules la liste des vehicules
   */
  private void setVehicules(ArrayList<Vehicule> vehicules) {
    this.vehicules = vehicules;
  }

  /**
   * Méthode pour ajouter un véhicule à la liste des véhicules.
   *
   * @param v véhicule à ajouter
   */
  public void ajouter(Vehicule v) {
  }

  /**
   * Méthode pour supprimer un véhicule de la liste des véhicules.
   *
   * @param v véhicule à supprimer
   */
  public void supprimer(Vehicule v) {
  }

  /**
   * Méthode pour modifier un véhicule de la liste des véhicules.
   *
   * @param v véhicule à modifier
   */
  public void editer(Vehicule v) {
  }
}
