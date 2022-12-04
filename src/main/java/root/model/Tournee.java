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
   * Construsteur.
   *
   * @param numTournee Le numéro de la tournée.
   * @param libelle    Le libellé de la tournée.
   * @param heureMin   L'heure minimal pour la réalisation de la tournée.
   * @param heureMax   L'heure maximal pour la réalisation de la tournée.
   * @param producteur Le producteur qui réalise la tournée.
   * @param vehicule   Le véhicule avec lequel la tournée sera réalisé.
   */
  public Tournee(int numTournee, String libelle, int heureMin, int heureMax, Producteur producteur,
                 Vehicule vehicule) {
    this.numTournee = numTournee;
    this.libelle = libelle;
    this.heureMin = heureMin;
    this.heureMax = heureMax;
    this.producteur = producteur;
    this.vehicule = vehicule;
    this.commandes = new ArrayList<>();
  }

  /**
   * Getter du numéro de la tournée.
   *
   * @return numTournee le numéro de la tournée
   */
  public int getNumTournee() {
    return numTournee;
  }

  /**
   * Getter du libellé de la tournée.
   *
   * @return libelle le libellé de la tournée
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * Getter de l'heure minimale de la tournée.
   *
   * @return heureMin l'heure minimale de la tournée
   */
  public int getHeureMin() {
    return heureMin;
  }

  /**
   * Getter de l'heure maximale de la tournée.
   *
   * @return heureMax l'heure maximale de la tournée
   */
  public int getHeureMax() {
    return heureMax;
  }

  /**
   * Getter du producteur de la tournée.
   *
   * @return producteur le producteur de la tournée
   */
  public Producteur getProducteur() {
    return producteur;
  }

  /**
   * Getter du véhicule de la tournée.
   *
   * @return vehicule le véhicule de la tournée
   */
  public Vehicule getVehicule() {
    return vehicule;
  }

  /**
   * Getter des commandes de la tournée.
   *
   * @return commandes les commandes de la tournée
   */
  public ArrayList<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Setter du numéro de la tournée.
   *
   * @param numTournee le numéro de la tournée
   */
  public void setNumTournee(int numTournee) {
    this.numTournee = numTournee;
  }

  /**
   * Setter du libellé de la tournée.
   *
   * @param libelle le libellé de la tournée
   */
  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * Setter de l'heure minimale de la tournée.
   *
   * @param heureMin l'heure minimale de la tournée
   */
  public void setHeureMin(int heureMin) {
    this.heureMin = heureMin;
  }

  /**
   * Setter de l'heure maximale de la tournée.
   *
   * @param heureMax l'heure maximale de la tournée
   */
  public void setHeureMax(int heureMax) {
    this.heureMax = heureMax;
  }

  /**
   * Setter du producteur de la tournée.
   *
   * @param producteur le producteur de la tournée
   */
  public void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  /**
   * Setter du véhicule de la tournée.
   *
   * @param vehicule le véhicule de la tournée
   */
  public void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }

  /**
   * Setter des commandes de la tournée.
   *
   * @param commandes les commandes de la tournée
   */
  public void setCommandes(ArrayList<Commande> commandes) {
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
   * @param commande commande à ajouter
   */
  public void ajouteCommande(Commande commande) {
  }

  /**
   * Méthode pour supprimer une commande de la tournée.
   *
   * @param commande commande à supprimer
   */
  public void retireCommande(Commande commande) {
  }

}
