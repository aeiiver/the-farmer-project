package root.model.list;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.CommandeDao;
import root.data.SingleConnection;
import root.model.Commande;
import root.model.Producteur;

/**
 * Classe de modèle pour la liste des Commandes.
 */
public class ListeCommandes {

  /**
   * Liste des commandes.
   *
   * @see ListeCommandes#ListeCommandes(Producteur)
   * @see ListeCommandes#getCommandes()
   * @see ListeCommandes#ajouter(Commande)
   * @see ListeCommandes#supprimer(Commande)
   * @see Commande
   */
  private static ObservableList<Commande> commandes;
  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private CommandeDao commandeDao;

  /**
   * Constructeur avec une liste vide.
   */
  public ListeCommandes() {
    commandeDao = new CommandeDao(SingleConnection.getInstance());
    commandes = FXCollections.observableArrayList();
  }

  /**
   * Constructeur avec une liste remplie de données de la base de données.
   */
  public ListeCommandes(Producteur producteur) {
    commandeDao = new CommandeDao(SingleConnection.getInstance());

    if (commandes == null) {
      commandes = FXCollections.observableArrayList(commandeDao.getAllByProducteur(producteur));
    }
  }

  /**
   * Getter de la liste des commandes.
   *
   * @return La liste des commandes.
   */
  public List<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Méthode pour ajouter une commande à la liste des commandes.
   *
   * @param commande commande à ajouter
   */
  public void ajouter(Commande commande) {
    commandes.add(commande);

    commandeDao.insert(commande);
  }

  /**
   * Méthode pour supprimer une commande de la liste des commandes.
   *
   * @param commande commande à supprimer
   */
  public void supprimer(Commande commande) {
    commandes.remove(commande);

    commandeDao.delete(commande);
  }

  /**
   * Méthode pour modifier une commande de la liste des commandes.
   *
   * @param commande commande à modifier
   */
  public void editer(Commande commande) {
    int index = commandes.indexOf(commande);
    commandes.set(index, commande);

    commandeDao.update(commande);
  }

  public void clear() {
    commandes.clear();
  }

}
