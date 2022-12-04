package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la liste des Producteurs.
 */
public class listeProducteurs {
  private ArrayList<Producteur> producteurs;

  /**
   * Constructeur.
   */
  public void listeProducteur() {
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
   * Setter de la liste des producteurs.
   *
   * @param producteurs la liste des producteurs
   */
  private void setProducteurs(ArrayList<Producteur> producteurs) {
    this.producteurs = producteurs;
  }

  /**
   * Méthode pour ajouter un producteur à la liste des producteurs.
   *
   * @param p producteur à ajouter
   */
  public void ajouter(Producteur p) {
  }

  /**
   * Méthode pour supprimer un producteur de la liste des producteurs.
   *
   * @param p producteur à supprimer
   */
  public void supprimer(Producteur p) {
  }

  /**
   * Méthode pour modifier un producteur de la liste des producteurs.
   *
   * @param p producteur à modifier
   */
  public void editer(Producteur p) {
  }
}
