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

  /**
   * Getter de l'id du client.
   *
   * @return idClient l'id du client.
   */
  private int getIdClient() {
    return idClient;
  }

  /**
   * Getter du nom du client.
   *
   * @return nom le nom du client
   */
  private String getNom() {
    return nom;
  }

  /**
   * Getter du prénom du client.
   *
   * @return prenom le prénom du client
   */
  private String getPrenom() {
    return prenom;
  }

  /**
   * Getter du numéro de téléphone du client.
   *
   * @return numTel le numéro de téléphone du client
   */
  private String getNumTel() {
    return numTel;
  }

  /**
   * Getter des coordonnées GPS du client.
   *
   * @return gps les coordonnées GPS du client
   */
  private String getGps() {
    return gps;
  }

  /**
   * Getter de l'adresse du client.
   *
   * @return adresse l'adresse du client
   */
  private Adresse getAdresse() {
    return adresse;
  }

  /**
   * Setter de l'id du client.
   *
   * @param idClient l'id du client
   */
  private void setIdClient(int idClient) {
    this.idClient = idClient;
  }

  /**
   * Setter du nom du client.
   *
   * @param nom le nom du client
   */
  private void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du prénom du client.
   *
   * @param prenom le prénom du client
   */
  private void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Setter du numéro de téléphone du client.
   *
   * @param numTel le numéro de téléphone du client
   */
  private void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  /**
   * Setter des coordonnées GPS du client.
   *
   * @param gps les coordonnées GPS du client
   */
  private void setGps(String gps) {
    this.gps = gps;
  }

  /**
   * Setter de l'adresse du client.
   *
   * @param adresse l'adresse du client
   */
  private void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }
}