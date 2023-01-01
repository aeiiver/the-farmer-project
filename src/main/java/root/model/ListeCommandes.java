package root.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.CommandeDao;
import root.data.SingleConnection;

/**
 * Classe de modèle pour la liste des Commandes.
 */
public class ListeCommandes {

  /**
   * Liste des commandes.
   *
   * @see ListeCommandes#ListeCommandes()
   * @see ListeCommandes#getCommandes()
   * @see ListeCommandes#ajouter(Commande)
   * @see ListeCommandes#supprimer(Commande)
   * @see Commande
   */
  private ObservableList<Commande> commandes;
  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private CommandeDao commandeDao;

  /**
   * Constructeur.
   */
  public ListeCommandes() {
    commandeDao = new CommandeDao(SingleConnection.getInstance());
    commandes = FXCollections.observableArrayList(commandeDao.getAll());
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

}
