package root.model;

/**
 * Classe de modèle pour les Véhicules.
 */
public class Vehicule {

  private String immat;
  private int poidsMax;
  private Producteur proprietaire;

  /**
   * Getter de l'immatriculation du véhicule.
   *
   * @return immat l'immatriculation du véhicule
   */
  public String getImmat() {
    return immat;
  }

  /**
   * Getter du poids maximal du véhicule.
   *
   * @return poidsMax le poids maximal du véhicule
   */
  public int getPoidsMax() {
    return poidsMax;
  }

  /**
   * Getter du propriétaire du véhicule.
   *
   * @return proprietaire le propriétaire du véhicule
   */
  public Producteur getProprietaire() {
    return proprietaire;
  }

  /**
   * Setter de l'immatriculation du véhicule.
   *
   * @param immat l'immatriculation du véhicule
   */
  public void setImmat(String immat) {
    this.immat = immat;
  }

  /**
   * Setter du poids maximal du véhicule.
   *
   * @param poidsMax le poids maximal du véhicule
   */
  public void setPoidsMax(int poidsMax) {
    this.poidsMax = poidsMax;
  }

  /**
   * Setter du propriétaire du véhicule.
   *
   * @param proprietaire le propriétaire du véhicule
   */
  public void setProprietaire(Producteur proprietaire) {
    this.proprietaire = proprietaire;
  }

}
