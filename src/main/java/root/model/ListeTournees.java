package root.model;

import java.util.ArrayList;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.data.TourneeDao;

/**
 * Classe de modèle pour la liste des Tournees.
 */
public class ListeTournees {

  /**
   * Liste des tournees.
   *
   * @see ListeTournees#ListeTournees()
   * @see ListeTournees#getTournees()
   * @see ListeTournees#ajouter(Tournee)
   * @see ListeTournees#supprimer(Tournee)
   * @see Tournee
   */
  private ArrayList<Tournee> tournees;

  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private TourneeDao tourneeDao;

  /**
   * Constructeur.
   */
  public ListeTournees() {

    tournees = new ArrayList<>();
    tourneeDao = new TourneeDao(SingleConnection.getInstance());
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
   * @param tournee tournée à ajouter
   */
  public void ajouter(Tournee tournee) {
    tournees.add(tournee);
    tourneeDao.insert(tournee);
  }

  /**
   * Méthode pour supprimer une tournée de la liste des tournées.
   *
   * @param tournee tournée à supprimer
   */
  public void supprimer(Tournee tournee) {
    tournees.remove(tournee);
    tourneeDao.delete(tournee);
  }

  /**
   * Méthode pour modifier une tournée de la liste des tournées.
   *
   * @param tournee tournée à modifier
   */
  public void editer(Tournee tournee) {
    int index = tournees.indexOf(tournee);
    tournees.set(index, tournee);

    tourneeDao.update(tournee);
  }

}
