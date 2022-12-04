package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Tournees.
 */
public class listeTournees {
  private ArrayList<Tournee> tournees;

  /**
   * Constructeur.
   */
  public listeTournees() {
  }

  /**
   * Getter de la liste des tournees.
   *
   * @return tournees la liste des tournees
   */
  public ArrayList<Tournee> getTournees() {
    return tournees;
  }

  /**
   * Setter de la liste des tournees.
   *
   * @param tournees la liste des tournees
   */
  private void setTournees(ArrayList<Tournee> tournees) {
    this.tournees = tournees;
  }


  /**
   * Méthode pour trouver les tournées dont les dates ne sont pas encore passées.
   *
   * @return tournees la liste des tournées dont les dates ne sont pas encore passées
   */
  public ArrayList<Tournee> getTourneesCourantes() {
    return null;
  }

  /**
   * Méthode pour ajouter une tournée à la liste des tournées.
   *
   * @param t tournée à ajouter
   */
  public void ajouter(Tournee t) {
  }

  /**
   * Méthode pour supprimer une tournée de la liste des tournées.
   *
   * @param t tournée à supprimer
   */
  public void supprimer(Tournee t) {
  }

  /**
   * Méthode pour modifier une tournée de la liste des tournées.
   *
   * @param t tournée à modifier
   */
  public void editer(Tournee t) {
  }
}
