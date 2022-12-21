package root.model;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Classe de modèle pour la tournée.
 */
public class Tournee {

  /**
   * Identifiant de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getNumTournee()
   * @see Tournee#setNumTournee(int)
   */
  private int numTournee;

  /**
   * Nom de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getLibelle()
   * @see Tournee#setLibelle(String)
   */
  private String libelle;

  /**
   * Heure de début de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getHeureMin()
   * @see Tournee#setHeureMin(Time)
   */
  private Time heureMin;

  /**
   * Heure de fin de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getHeureMax()
   * @see Tournee#setHeureMax(Time)
   */
  private Time heureMax;

  /**
   * Producteur de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getProducteur()
   * @see Tournee#setProducteur(Producteur)
   */
  private Producteur producteur;

  /**
   * Véhicule de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getVehicule()
   * @see Tournee#setVehicule(Vehicule)
   */
  private Vehicule vehicule;

  /**
   * Liste des commandes de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getCommandes()
   * @see Tournee#setCommandes(ArrayList)
   * @see Tournee#ajouteCommande(Commande)
   * @see Commande
   * @see ListeCommandes
   */
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
  public Tournee(int numTournee, String libelle, Time heureMin, Time heureMax,
                 Producteur producteur, Vehicule vehicule) {
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
  public Time getHeureMin() {
    return heureMin;
  }

  /**
   * Getter de l'heure maximale de la tournée.
   *
   * @return heureMax l'heure maximale de la tournée
   */
  public Time getHeureMax() {
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
  public void setHeureMin(Time heureMin) {
    this.heureMin = heureMin;
  }

  /**
   * Setter de l'heure maximale de la tournée.
   *
   * @param heureMax l'heure maximale de la tournée
   */
  public void setHeureMax(Time heureMax) {
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
   * <p>Une tournée est valide si toutes les commandes qu'elle contient ont lieu à la même date,
   * entre les horaires minimale et maximale de la tournée, et la somme de leur poids est
   * inférieur ou égal au poids que le véhicule peut supporter.</p>
   *
   * @return true si la tournée est valide, false sinon
   */
  public boolean estValide() {
    int poidTotal = 0;
    //pour chaque commande de la tournée
    for (Commande com : commandes) {

      //vérification de l'heure de début
      if (com.getHeureDeb().before(this.getHeureMin()))
        return false;

      //vérification de l'heure de fin
      if (com.getHeureFin().after(this.heureMax))
        return false;

      //si l'heure de début et l'heure de fin sont correspondantes alors
      //la date correspond aussi puisqu'on utilise java.sql.Date .

      //additionne le poid de toutes les commandes
      poidTotal += com.getPoids();
    }

    //vérifie si la somme du poid de toutes les commandes est valide
    if (poidTotal > this.vehicule.getPoidsMax())
      return false;

    return true;
  }

  /**
   * Méthode pour ajouter une commande à la tournée.
   *
   * @param commande commande à ajouter
   */
  public void ajouteCommande(Commande commande) {
    commandes.add(commande);
  }

  /**
   * Méthode pour supprimer une commande de la tournée.
   *
   * @param commande commande à supprimer
   */
  public void retireCommande(Commande commande) {
    commandes.remove(commande);
  }

}
