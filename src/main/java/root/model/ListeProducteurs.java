package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Producteurs.
 */
public class ListeProducteurs {

  private ArrayList<Producteur> producteurs;

  /**
   * Constructeur.
   */
  public ListeProducteurs() {
    producteurs = new ArrayList<>();
  }

  /**
   * Getter de la liste des producteurs.
   *
   * @return producteurs la liste des producteurs
   */
  public ArrayList<Producteur> getProducteurs() {
    return producteurs;
  }

  /**
   * Méthode pour ajouter un producteur à la liste des producteurs.
   *
   * @param producteur producteur à ajouter
   */
  public void ajouter(Producteur producteur) {
  }

  /**
   * Méthode pour supprimer un producteur de la liste des producteurs.
   *
   * @param producteur producteur à supprimer
   */
  public void supprimer(Producteur producteur) {
  }

  /**
   * Méthode pour modifier un producteur de la liste des producteurs.
   *
   * @param producteur producteur à modifier
   */
  public void editer(Producteur producteur) {
  }

}
