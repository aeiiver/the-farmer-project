package root.model.list;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.SingleConnection;
import root.data.TourneeDao;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;

/**
 * Classe de modèle pour la liste des tournées.
 */
public class ListeTournees {

  /**
   * Liste des tournées.
   *
   * @see ListeTournees#ListeTournees(Producteur)
   * @see ListeTournees#getTournees()
   * @see ListeTournees#ajouter(Tournee)
   * @see ListeTournees#supprimer(Tournee)
   * @see Tournee
   */
  private static ObservableList<Tournee> tournees;

  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private TourneeDao tourneeDao;

  /**
   * Constructeur avec une liste vide.
   */
  public ListeTournees() {
    tourneeDao = new TourneeDao(SingleConnection.getInstance());
    tournees = FXCollections.observableArrayList();
  }

  /**
   * Constructeur avec une liste remplie de données de la base de données.
   */
  public ListeTournees(Producteur producteur) {
    tourneeDao = new TourneeDao(SingleConnection.getInstance());

    if (tournees == null) {
      tournees = FXCollections.observableArrayList(tourneeDao.getAllByProducteur(producteur));
    }
  }

  /**
   * Getter de la liste des tournées.
   *
   * @return tournees la liste des tournées
   */
  public List<Tournee> getTournees() {
    return tournees;
  }

  /**
   * Méthode pour trouver les tournées dont les dates ne sont pas encore passées.
   *
   * @return tournees la liste des tournées dont les dates ne sont pas encore passées
   */
  public List<Tournee> getTourneesCourantes() {
    return tournees.stream().filter(tournee -> {
      List<Commande> commandes = tournee.getCommandes();

      return commandes.stream().anyMatch(commande -> {
        Date aujourdhui = Calendar.getInstance().getTime();

        return commande.getDateCom().after(aujourdhui);
      });
    }).collect(Collectors.toList());
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

  public void clear() {
    tournees = null;
  }

}
