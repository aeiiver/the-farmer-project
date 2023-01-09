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
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getNumCom()
   * @see Commande#setNumCom(int)
   */
  private int numCom;

  /**
   * Nom de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getLibelle()
   * @see Commande#setLibelle(String)
   */
  private String libelle;

  /**
   * Poids total de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getPoids()
   * @see Commande#setPoids(int)
   */
  private int poids;

  /**
   * Date de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getDateCom()
   * @see Commande#setDateCom(Date)
   */
  private Date dateCom;

  /**
   * Horaire minimale de livraison de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getHeureDeb()
   * @see Commande#setHeureDeb(Time)
   */
  private Time heureDeb;

  /**
   * Horaire maximale de livraison de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getHeureFin()
   * @see Commande#setHeureFin(Time)
   */
  private Time heureFin;

  /**
   * Producteur de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getProducteur()
   * @see Commande#setProducteur(Producteur)
   * @see Producteur
   */
  private Producteur producteur;

  /**
   * Client de la commande.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getClient()
   * @see Commande#setClient(Client)
   * @see Client
   */
  private Client client;

  /**
   * Numéro de la tournée dans laquelle la commande est associée.
   *
   * @see Commande#Commande(int, String, int, Date, Time, Time, Producteur, Client, int)  Commande
   * @see Commande#getNumTournee()
   * @see Commande#setNumTournee(int)
   */
  private int numTournee;

  /**
   * Ordre dans la tournée dans laquelle la commande est associée.
   */
  private int ordreTournee;


  /**
   * Constructeur de la classe Commande utilisée lorsque
   * l'on choisit la position de la commande dans la tournée.
   *
   * @param numCom     Le numéro de la commande.
   * @param libelle    Le libellé.
   * @param poids      Le poids, en kg.
   * @param dateCom    La date à laquelle la commande devra être livrée.
   * @param heureDeb   L'heure de départ de livraison
   * @param heureFin   L'heure de fin de livraison
   * @param producteur Le producteur qui a envoyé la commande.
   * @param client     Le client auquel la commande est destiné.
   * @param numTournee Le numéro de la tournée dans laquelle la commande est insérée.
   * @param ordreTournee L'ordre dans la tournée dans laquelle la commande est insérée.
   */
  public Commande(int numCom, String libelle, int poids, Date dateCom, Time heureDeb, Time heureFin,
                  Producteur producteur, Client client, int numTournee, int ordreTournee) {
    this(numCom, libelle, poids, dateCom, heureDeb, heureFin, producteur, client, numTournee);
    this.ordreTournee = ordreTournee;
  }

  /**
   * Constructeur de classe d'une commande insérée dans la base et incluse dans une tournée.
   *
   * @param numCom     Le numéro de la commande.
   * @param libelle    Le libellé.
   * @param poids      Le poids, en kg.
   * @param dateCom    La date à laquelle la commande devra être livrée.
   * @param heureDeb   L'heure de départ de livraison
   * @param heureFin   L'heure de fin de livraison
   * @param producteur Le producteur qui a envoyé la commande.
   * @param client     Le client auquel la commande est destiné.
   * @param numTournee Le numéro de la tournée dans laquelle la commande est insérée.
   */
  public Commande(int numCom, String libelle, int poids, Date dateCom, Time heureDeb, Time heureFin,
                  Producteur producteur, Client client, int numTournee) {
    this(libelle, poids, dateCom, heureDeb, heureFin, producteur, client);
    this.numCom = numCom;
    this.numTournee = numTournee;
  }

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
    this(libelle, poids, dateCom, heureDeb, heureFin, producteur, client);
    this.numCom = numCom;
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
    this.numTournee = -1;
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
   * Getter du numéro de la tournée auquel la commande est associé.
   *
   * @return numTournee le numéro de la tournée.
   */
  public int getNumTournee() {
    return numTournee;
  }

  /**
   * Getter de l'ordre dans la tournée auquel la commande est associé.
   *
   * @return ordreTournee l'ordre dans la tournée.
   */
  public int getOrdreTournee() {
    return ordreTournee;
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

  /**
   * Setter du numéro de la tournée auquel la commande est associé.
   *
   * @param numTournee Le numéro de la tournée.
   */
  public void setNumTournee(int numTournee) {
    this.numTournee = numTournee;
  }

  /**
   * Setter de l'ordre dans la tournée auquel la commande est associé.
   *
   * @param ordreTournee L'ordre dans la tournée.
   */
  public void setOrdreTournee(int ordreTournee) {
    this.ordreTournee = ordreTournee;
  }

  /**
   * Méthode ??.
   *
   * @return 0.
   */
  @Override
  public int hashCode() {
    return 0;
  }

  /**
   * Méthode permettant de comparer deux commandes.
   *
   * @param other L'autre commande à comparer.
   * @return true si les deux commandes sont identiques, false sinon.
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Commande)) {
      return false;
    }
    return numCom == ((Commande) other).getNumCom();
  }

  /**
   * Méthode permettant de convertir une commande en chaîne de caractères.
   *
   * @return Une chaîne de caractères représentant la commande.
   */
  @Override
  public String toString() {
    return this.libelle + "\n" + this.client
        + "\n" + this.dateCom + "\n(" + this.heureDeb
        + "/" + this.heureFin + ")" + "\n" + this.client.getAdresse();
  }

}
