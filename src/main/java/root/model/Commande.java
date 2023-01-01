package root.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Classe de modèle pour les Commandes.
 */
public class Commande {

  /**
   * Identifiant de la commande dans la base de données.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getNumCom()
   * @see Commande#setNumCom(int)
   */
  private int numCom;

  /**
   * Nom de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getLibelle()
   * @see Commande#setLibelle(String)
   */
  private String libelle;

  /**
   * Poids total de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getPoids()
   * @see Commande#setPoids(int)
   */
  private int poids;

  /**
   * Date de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getDateCom()
   * @see Commande#setDateCom(Date)
   */
  private Date dateCom;

  /**
   * Horaire minimale de livraison de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getHeureDeb()
   * @see Commande#setHeureDeb(Time)
   */
  private Time heureDeb;

  /**
   * Horaire maximale de livraison de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getHeureFin()
   * @see Commande#setHeureFin(Time)
   */
  private Time heureFin;

  /**
   * Producteur de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getProducteur()
   * @see Commande#setProducteur(Producteur)
   * @see Producteur
   */
  private Producteur producteur;

  /**
   * Client de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client)  Commande
   * @see Commande#getClient()
   * @see Commande#setClient(Client)
   * @see Client
   */
  private Client client;

  /**
   * Constructeur de classe d'une commande insérée dans la base.
   *
   * @param numCom     Le numéro de la commande.
   * @param libelle    Le libellé.
   * @param poids      Le poids, en kg.
   * @param dateCom    La date à laquelle la commande devra être livrée.
   * @param heureDeb   L'heure de départ de livraison
   * @param heureFin   L'heure de fin de livraison
   * @param producteur Le producteur qui a envoyé la commande.
   * @param client     Le client auquel la commande est destiné.
   */
  public Commande(int numCom, String libelle, int poids, Date dateCom, Time heureDeb, Time heureFin,
                  Producteur producteur, Client client) {
    this.numCom = numCom;
    this.libelle = libelle;
    this.poids = poids;
    this.dateCom = dateCom;
    this.heureDeb = heureDeb;
    this.heureFin = heureFin;
    this.producteur = producteur;
    this.client = client;
  }

  /**
   * Constructeur de classe d'une commande non insérée dans la base.
   *
   * @param libelle    Le libellé.
   * @param poids      Le poids, en kg.
   * @param dateCom    La date à laquelle la commande devra être livrée.
   * @param heureDeb   L'heure de départ de livraison
   * @param heureFin   L'heure de fin de livraison
   * @param producteur Le producteur qui a envoyé la commande.
   * @param client     Le client auquel la commande est destiné.
   */
  public Commande(String libelle, int poids, Date dateCom, Time heureDeb, Time heureFin,
                  Producteur producteur, Client client) {
    this.numCom = -1;
    this.libelle = libelle;
    this.poids = poids;
    this.dateCom = dateCom;
    this.heureDeb = heureDeb;
    this.heureFin = heureFin;
    this.producteur = producteur;
    this.client = client;
  }

  /**
   * Getter du numéro de la commande.
   *
   * @return numCom le numéro de la commande
   */
  public int getNumCom() {
    return numCom;
  }

  /**
   * Getter du libellé de la commande.
   *
   * @return libelle le libellé de la commande
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * Getter du poids de la commande.
   *
   * @return poids le poids de la commande
   */
  public int getPoids() {
    return poids;
  }

  /**
   * Getter de la date de la commande.
   *
   * @return dateCom la date de la commande
   */
  public Date getDateCom() {
    return dateCom;
  }

  /**
   * Getter de l'heure de début de la commande.
   *
   * @return heureDeb l'heure de début de la commande
   */
  public Time getHeureDeb() {
    return heureDeb;
  }

  /**
   * Getter de l'heure de fin de la commande.
   *
   * @return heureFin l'heure de fin de la commande
   */
  public Time getHeureFin() {
    return heureFin;
  }

  /**
   * Getter du producteur de la commande.
   *
   * @return producteur le producteur de la commande
   */
  public Producteur getProducteur() {
    return producteur;
  }

  /**
   * Getter du client de la commande.
   *
   * @return client le client de la commande
   */
  public Client getClient() {
    return client;
  }

  /**
   * Setter du numéro de la commande.
   *
   * @param numCom le numéro de la commande
   */
  public void setNumCom(int numCom) {
    this.numCom = numCom;
  }

  /**
   * Setter du libellé de la commande.
   *
   * @param libelle le libellé de la commande
   */
  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * Setter du poids de la commande.
   *
   * @param poids le poids de la commande
   */
  public void setPoids(int poids) {
    this.poids = poids;
  }

  /**
   * Setter de la date de la commande.
   *
   * @param dateCom la date de la commande
   */
  public void setDateCom(Date dateCom) {
    this.dateCom = dateCom;
  }

  /**
   * Setter de l'heure de début de la commande.
   *
   * @param heureDeb l'heure de début de la commande
   */
  public void setHeureDeb(Time heureDeb) {
    this.heureDeb = heureDeb;
  }

  /**
   * Setter de l'heure de fin de la commande.
   *
   * @param heureFin l'heure de fin de la commande
   */
  public void setHeureFin(Time heureFin) {
    this.heureFin = heureFin;
  }

  /**
   * Setter du producteur de la commande.
   *
   * @param producteur le producteur de la commande
   */
  public void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  /**
   * Setter du client de la commande.
   *
   * @param client le client de la commande
   */
  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Commande)) {
      return false;
    }
    return numCom == ((Commande) other).getNumCom();
  }

}
