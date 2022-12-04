package root.model;

import java.util.ArrayList;

/**
 * Classe de modèle pour la tournée.
 */
public class Tournee {
  private int numTournee;
  private String libelle;
  private int heureMin;
  private int heureMax;
  private Producteur producteur;
  private Vehicule vehicule;
  private ArrayList<Commande> commandes;

  private int getNumTournee() {
    return numTournee;
  }

  private String getLibelle() {
    return libelle;
  }

  private int getHeureMin() {
    return heureMin;
  }

  private int getHeureMax() {
    return heureMax;
  }

  private Producteur getProducteur() {
    return producteur;
  }

  private Vehicule getVehicule() {
    return vehicule;
  }

  private ArrayList<Commande> getCommandes() {
    return commandes;
  }

  private void setNumTournee(int numTournee) {
    this.numTournee = numTournee;
  }

  private void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  private void setHeureMin(int heureMin) {
    this.heureMin = heureMin;
  }

  private void setHeureMax(int heureMax) {
    this.heureMax = heureMax;
  }

  private void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  private void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }

  private void setCommandes(ArrayList<Commande> commandes) {
    this.commandes = commandes;
  }

  /**
   * Méthode pour vérifier si la tournée est valide.
   *
   * @return true si la tournée est valide, false sinon
   */
  public boolean estValide() {

    // dummy return
    return false;
  }

  /**
   * Méthode pour ajouter une commande à la tournée.
   *
   * @param c commande à ajouter
   */
  public void ajouteCommande(Commande c) {
  }

  /**
   * Méthode pour supprimer une commande de la tournée.
   *
   * @param c commande à supprimer
   */
  public void retireCommande(Commande c) {
  }
}
