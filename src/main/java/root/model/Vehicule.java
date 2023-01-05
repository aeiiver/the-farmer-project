package root.model;

/**
 * Classe de modèle pour les Véhicules.
 */
public class Vehicule {

  /**
   * Immatriculation du véhicule.
   *
   * @see Vehicule#Vehicule(String, int, Producteur)  Vehicule
   * @see Vehicule#getImmat()
   * @see Vehicule#setImmat(String)
   */
  private String immat;

  /**
   * Capacité maximale du véhicule en Kg.
   *
   * @see Vehicule#Vehicule(String, int, Producteur)  Vehicule
   * @see Vehicule#getPoidsMax() 
   * @see Vehicule#setPoidsMax(int)
   */
  private int poidsMax;
  
  /**
   * Propriétaire du véhicule.
   *
   * @see Vehicule#Vehicule(String, int, Producteur)  Vehicule
   * @see Vehicule#getProprietaire() 
   * @see Vehicule#setProprietaire(Producteur) 
   */
  private Producteur proprietaire;

  /**
   * Constructeur de la classe "Véhicule".
   *
   * @param immat immatriculation du véhicule
   * @param poidsMax capacité maximale du véhicule en Kg
   * @param proprietaire propriétaire du véhicule
   */
  public Vehicule(String immat, int poidsMax, Producteur proprietaire) {
    this.immat = immat;
    this.poidsMax = poidsMax;
    this.proprietaire = proprietaire;
  }

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

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Vehicule)) {
      return false;
    }
    return immat.contentEquals(((Vehicule) other).getImmat());
  }

  public String toString() {
    return immat + " (" + poidsMax + ")";
  }

}
