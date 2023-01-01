package root.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.ClientDao;
import root.data.SingleConnection;

/**
 * Classe de modèle pour la liste des Clients.
 */
public class ListeClients {

  /**
   * Liste des clients.
   *
   * @see ListeClients#ListeClients()
   * @see ListeClients#getClients()
   * @see ListeClients#ajouter(Client)
   * @see ListeClients#supprimer(Client)
   * @see Client
   */
  private ObservableList<Client> clients;
  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private ClientDao clientDao;

  /**
   * Constructeur.
   */
  public ListeClients() {
    clientDao = new ClientDao(SingleConnection.getInstance());
    clients = FXCollections.observableArrayList(clientDao.getAll());
  }

  /**
   * Getter de la liste des clients.
   *
   * @return La liste des clients.
   */
  public List<Client> getClients() {
    return clients;
  }

  /**
   * Méthode pour ajouter un client à la liste des clients.
   *
   * @param client client à ajouter
   */
  public void ajouter(Client client) {
    clients.add(client);

    clientDao.insert(client);
  }

  /**
   * Méthode pour supprimer un client de la liste des clients.
   *
   * @param client client à supprimer
   */
  public void supprimer(Client client) {
    clients.remove(client);

    clientDao.delete(client);
  }

  /**
   * Méthode pour modifier un client de la liste des clients.
   *
   * @param client client à modifier
   */
  public void editer(Client client) {
    int index = clients.indexOf(client);
    clients.set(index, client);

    clientDao.update(client);
  }

}
