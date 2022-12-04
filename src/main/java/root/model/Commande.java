package root.model;

/**
 * Classe de modèle pour les Commandes.
 */
public class Commande {

  private int numCom;
  private String libelle;
  private int poids;
  private String dateCom;
  private int heureDeb;
  private int heureFin;
  private Producteur producteur;
  private Client client;

  /**
   * Constructeur de classe.
   *
   * @param numCom     Le numéro de la commande.
   * @param libelle    Le libéllé.
   * @param poids      Le poids, en kg.
   * @param dateCom    La date à laquelle la commande devra être livrée, sous la forme "AAAA-MM-JJ".
   * @param heureDeb   L'heure minimal de livraison
   * @param heureFin   L'heure maximal de livraison
   * @param producteur Le producteur qui a envoyé la commande.
   * @param client     Le client auquel la commande est destiné.
   */
  public Commande(int numCom, String libelle, int poids, String dateCom, int heureDeb, int heureFin,
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
  public String getDateCom() {
    return dateCom;
  }

  /**
   * Getter de l'heure de début de la commande.
   *
   * @return heureDeb l'heure de début de la commande
   */
  public int getHeureDeb() {
    return heureDeb;
  }

  /**
   * Getter de l'heure de fin de la commande.
   *
   * @return heureFin l'heure de fin de la commande
   */
  public int getHeureFin() {
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
  public void setDateCom(String dateCom) {
    this.dateCom = dateCom;
  }

  /**
   * Setter de l'heure de début de la commande.
   *
   * @param heureDeb l'heure de début de la commande
   */
  public void setHeureDeb(int heureDeb) {
    this.heureDeb = heureDeb;
  }

  /**
   * Setter de l'heure de fin de la commande.
   *
   * @param heureFin l'heure de fin de la commande
   */
  public void setHeureFin(int heureFin) {
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

}
