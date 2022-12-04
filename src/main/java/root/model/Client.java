package root.model;

/**
 * Classe de modèle pour les Clients.
 */
public class Client {
  private int idClient;
  private String nom;
  private String prenom;
  private String numTel;
  private String gps;
  private Adresse adresse;

  private int getIdClient() {
    return idClient;
  }

  private String getNom() {
    return nom;
  }

  private String getPrenom() {
    return prenom;
  }

  private String getNumTel() {
    return numTel;
  }

  private String getGps() {
    return gps;
  }

  private Adresse getAdresse() {
    return adresse;
  }

  private void setIdClient(int idClient) {
    this.idClient = idClient;
  }

  private void setNom(String nom) {
    this.nom = nom;
  }

  private void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  private void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  private void setGps(String gps) {
    this.gps = gps;
  }

  private void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }
}