package root.model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.SingleConnection;
import root.data.VehiculeDao;

/**
 * Classe de modèle pour la liste des véhicules.
 */
public class ListeVehicules {

  /**
   * Liste des véhicules.
   *
   * @see ListeVehicules#ListeVehicules()
   * @see ListeVehicules#getVehicules()
   * @see ListeVehicules#ajouter(Vehicule)
   * @see ListeVehicules#supprimer(Vehicule)
   * @see Vehicule
   */
  private ObservableList<Vehicule> vehicules;
  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private VehiculeDao vehiculeDao;

  /**
   * Constructeur.
   */
  public ListeVehicules() {
    vehiculeDao = new VehiculeDao(SingleConnection.getInstance());
    vehicules = FXCollections.observableArrayList(vehiculeDao.getAll());
  }

  /**
   * Getter de la liste des véhicules.
   *
   * @return vehicules la liste des véhicules
   */
  public List<Vehicule> getVehicules() {
    return vehicules;
  }

  /**
   * Méthode pour ajouter un véhicule à la liste des véhicules.
   *
   * @param vehicule véhicule à ajouter
   */
  public void ajouter(Vehicule vehicule) {
    vehicules.add(vehicule);
    vehiculeDao.insert(vehicule);
  }

  /**
   * Méthode pour supprimer un véhicule de la liste des véhicules.
   *
   * @param vehicule véhicule à supprimer
   */
  public void supprimer(Vehicule vehicule) {
    vehicules.remove(vehicule);
    vehiculeDao.delete(vehicule);
  }

  /**
   * Méthode pour modifier un véhicule de la liste des véhicules.
   *
   * @param vehicule véhicule à modifier
   */
  public void editer(Vehicule vehicule) {
    int index = vehicules.indexOf(vehicule);
    vehicules.set(index, vehicule);
    vehiculeDao.update(vehicule);
  }

}
