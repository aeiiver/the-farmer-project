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

  private int getNumCom() {
    return numCom;
  }

  private String getLibelle() {
    return libelle;
  }

  private int getPoids() {
    return poids;
  }

  private String getDateCom() {
    return dateCom;
  }

  private int getHeureDeb() {
    return heureDeb;
  }

  private int getHeureFin() {
    return heureFin;
  }

  private Producteur getProducteur() {
    return producteur;
  }

  private Client getClient() {
    return client;
  }

  private void setNumCom(int numCom) {
    this.numCom = numCom;
  }

  private void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  private void setPoids(int poids) {
    this.poids = poids;
  }

  private void setDateCom(String dateCom) {
    this.dateCom = dateCom;
  }

  private void setHeureDeb(int heureDeb) {
    this.heureDeb = heureDeb;
  }

  private void setHeureFin(int heureFin) {
    this.heureFin = heureFin;
  }

  private void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  private void setClient(Client client) {
    this.client = client;
  }
}