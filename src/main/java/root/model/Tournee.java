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

  /**
   * Getter du numéro de la tournée.
   *
   * @return numTournee le numéro de la tournée
   */
  private int getNumTournee() {
    return numTournee;
  }

  /**
   * Getter du libellé de la tournée.
   *
   * @return libelle le libellé de la tournée
   */
  private String getLibelle() {
    return libelle;
  }

  /**
   * Getter de l'heure minimale de la tournée.
   *
   * @return heureMin l'heure minimale de la tournée
   */
  private int getHeureMin() {
    return heureMin;
  }

  /**
   * Getter de l'heure maximale de la tournée.
   *
   * @return heureMax l'heure maximale de la tournée
   */
  private int getHeureMax() {
    return heureMax;
  }

  /**
   * Getter du producteur de la tournée.
   *
   * @return producteur le producteur de la tournée
   */
  private Producteur getProducteur() {
    return producteur;
  }

  /**
   * Getter du véhicule de la tournée.
   *
   * @return vehicule le véhicule de la tournée
   */
  private Vehicule getVehicule() {
    return vehicule;
  }

  /**
   * Getter des commandes de la tournée.
   *
   * @return commandes les commandes de la tournée
   */
  private ArrayList<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Setter du numéro de la tournée.
   *
   * @param numTournee le numéro de la tournée
   */
  private void setNumTournee(int numTournee) {
    this.numTournee = numTournee;
  }

  /**
   * Setter du libellé de la tournée.
   *
   * @param libelle le libellé de la tournée
   */
  private void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * Setter de l'heure minimale de la tournée.
   *
   * @param heureMin l'heure minimale de la tournée
   */
  private void setHeureMin(int heureMin) {
    this.heureMin = heureMin;
  }

  /**
   * Setter de l'heure maximale de la tournée.
   *
   * @param heureMax l'heure maximale de la tournée
   */
  private void setHeureMax(int heureMax) {
    this.heureMax = heureMax;
  }

  private void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  /**
   * Setter du véhicule de la tournée.
   *
   * @param vehicule le véhicule de la tournée
   */
  private void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }

  /**
   * Setter des commandes de la tournée.
   *
   * @param commandes les commandes de la tournée
   */
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
