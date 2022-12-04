package root.model;

/**
 * Classe de modèle pour les Véhicules.
 */
public class Vehicule {
  private String immat;
  private int poidsMax;
  private Producteur proprietaire;

  private String getImmat() {
    return immat;
  }

  private int getPoidsMax() {
    return poidsMax;
  }

  private Producteur getProprietaire() {
    return proprietaire;
  }

  private void setImmat(String immat) {
    this.immat = immat;
  }

  private void setPoidsMax(int poidsMax) {
    this.poidsMax = poidsMax;
  }

  private void setProprietaire(Producteur proprietaire) {
    this.proprietaire = proprietaire;
  }
}