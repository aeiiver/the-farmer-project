package root.model.list;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import root.data.AdresseDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Producteur;

/**
 * Classe de modèle pour la liste des Producteurs.
 */
public class ListeProducteurs {

  /**
   * Liste des producteurs.
   *
   * @see ListeProducteurs#ListeProducteurs()
   * @see ListeProducteurs#getProducteurs()
   * @see ListeProducteurs#ajouter(Producteur)
   * @see ListeProducteurs#supprimer(Producteur)
   * @see Producteur
   */
  private static ObservableList<Producteur> producteurs;

  /**
   * Le DAO qui permet au modèle d'interagir avec la base de données.
   */
  private ProducteurDao producteurDao;

  private AdresseDao adresseDao;

  /**
   * Constructeur.
   */
  public ListeProducteurs() {
    producteurDao = new ProducteurDao(SingleConnection.getInstance());
    adresseDao = new AdresseDao(SingleConnection.getInstance());

    if (producteurs == null) {
      producteurs = FXCollections.observableArrayList(producteurDao.getAll());
    }
  }

  /**
   * Getter de la liste des producteurs.
   *
   * @return producteurs la liste des producteurs
   */
  public List<Producteur> getProducteurs() {
    return producteurs;
  }

  /**
   * Méthode pour ajouter un producteur à la liste des producteurs.
   *
   * @param producteur producteur à ajouter
   */
  public void ajouter(Producteur producteur) {

    producteurs.add(producteur);
    producteurDao.insert(producteur);
  }

  /**
   * Méthode pour supprimer un producteur de la liste des producteurs.
   *
   * @param producteur producteur à supprimer
   */
  public void supprimer(Producteur producteur) {

    producteurs.remove(producteur);
    producteurDao.delete(producteur);
  }

  /**
   * Méthode pour modifier un producteur de la liste des producteurs.
   *
   * @param producteur producteur à modifier
   */
  public void editer(Producteur producteur) {
    adresseDao.update(producteur.getAdresse());

    int index = producteurs.indexOf(producteur);
    producteurs.set(index, producteur);

    producteurDao.update(producteur);
  }

  public void clear() {
    producteurs.clear();
  }

}
