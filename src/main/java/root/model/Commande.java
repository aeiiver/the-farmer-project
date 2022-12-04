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
   * Getter du numéro de la commande.
   *
   * @return numCom le numéro de la commande
   */
  private int getNumCom() {
    return numCom;
  }

  /**
   * Getter du libellé de la commande.
   *
   * @return libelle le libellé de la commande
   */
  private String getLibelle() {
    return libelle;
  }

  /**
   * Getter du poids de la commande.
   *
   * @return poids le poids de la commande
   */
  private int getPoids() {
    return poids;
  }

  /**
   * Getter de la date de la commande.
   *
   * @return dateCom la date de la commande
   */
  private String getDateCom() {
    return dateCom;
  }

  /**
   * Getter de l'heure de début de la commande.
   *
   * @return heureDeb l'heure de début de la commande
   */
  private int getHeureDeb() {
    return heureDeb;
  }

  /**
   * Getter de l'heure de fin de la commande.
   *
   * @return heureFin l'heure de fin de la commande
   */
  private int getHeureFin() {
    return heureFin;
  }

  /**
   * Getter du producteur de la commande.
   *
   * @return producteur le producteur de la commande
   */
  private Producteur getProducteur() {
    return producteur;
  }

  /**
   * Getter du client de la commande.
   *
   * @return client le client de la commande
   */
  private Client getClient() {
    return client;
  }

  /**
   * Setter du numéro de la commande.
   *
   * @param numCom le numéro de la commande
   */
  private void setNumCom(int numCom) {
    this.numCom = numCom;
  }

  /**
   * Setter du libellé de la commande.
   *
   * @param libelle le libellé de la commande
   */
  private void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * Setter du poids de la commande.
   *
   * @param poids le poids de la commande
   */
  private void setPoids(int poids) {
    this.poids = poids;
  }

  /**
   * Setter de la date de la commande.
   *
   * @param dateCom la date de la commande
   */
  private void setDateCom(String dateCom) {
    this.dateCom = dateCom;
  }

  /**
   * Setter de l'heure de début de la commande.
   *
   * @param heureDeb l'heure de début de la commande
   */
  private void setHeureDeb(int heureDeb) {
    this.heureDeb = heureDeb;
  }

  /**
   * Setter de l'heure de fin de la commande.
   *
   * @param heureFin l'heure de fin de la commande
   */
  private void setHeureFin(int heureFin) {
    this.heureFin = heureFin;
  }

  /**
   * Setter du producteur de la commande.
   *
   * @param producteur le producteur de la commande
   */
  private void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  /**
   * Setter du client de la commande.
   *
   * @param client le client de la commande
   */
  private void setClient(Client client) {
    this.client = client;
  }
}