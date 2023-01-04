package root.model;

/**
 * Classe de modèle pour les Clients.
 */
public class Client {

  /**
   * Identifiant du client dans la base de données.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getIdClient()
   * @see Client#setIdClient(int)
   */
  private int idClient;

  /**
   * Nom du client.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getNom()
   * @see Client#setNom(String)
   */
  private String nom;

  /**
   * Prénom du client.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getPrenom()
   * @see Client#setPrenom(String)
   */
  private String prenom;

  /**
   * Numéro de téléphone du client.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getNumTel()
   * @see Client#setNumTel(String)
   */
  private String numTel;

  /**
   * Coordonnés GPS du client.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getGps()
   * @see Client#setGps(String)
   */
  private String gps;

  /**
   * Adresse du client.
   *
   * @see Client#Client(int, String, String, String, String, Adresse)
   * @see Client#getAdresse()
   * @see Client#setAdresse(Adresse)
   * @see Adresse
   */
  private Adresse adresse;

  /**
   * Constructeur de classe d'un client inséré dans la base.
   *
   * @param idClient L'identifiant du client.
   * @param nom      Le nom du client.
   * @param prenom   Le prénom du client.
   * @param numTel   Le numéro de téléphone du client.
   * @param gps      Les coordonnées GPS du client, sous la forme d'une chaîne "latitude;longitude".
   * @param adresse  L'adresse du client, représenté par un objet "Adresse".
   */
  public Client(int idClient, String nom, String prenom, String numTel, String gps,
                Adresse adresse) {
    this.idClient = idClient;
    this.nom = nom;
    this.prenom = prenom;
    this.numTel = numTel;
    this.gps = gps;
    this.adresse = adresse;
  }

  /**
   * Constructeur de classe d'un client non inséré dans la base.
   *
   * @param nom      Le nom du client.
   * @param prenom   Le prénom du client.
   * @param numTel   Le numéro de téléphone du client.
   * @param gps      Les coordonnées GPS du client, sous la forme d'une chaîne "latitude;longitude".
   * @param adresse  L'adresse du client, représenté par un objet "Adresse".
   */
  public Client(String nom, String prenom, String numTel, String gps,
                Adresse adresse) {
    this.idClient = -1;
    this.nom = nom;
    this.prenom = prenom;
    this.numTel = numTel;
    this.gps = gps;
    this.adresse = adresse;
  }

  /**
   * Getter de l'id du client.
   *
   * @return idClient l'id du client.
   */
  public int getIdClient() {
    return idClient;
  }

  /**
   * Getter du nom du client.
   *
   * @return nom le nom du client
   */
  public String getNom() {
    return nom;
  }

  /**
   * Getter du prénom du client.
   *
   * @return prenom le prénom du client
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * Getter du prénom et nom du client.
   *
   * @return La concaténation du prénom et du nom du client, séparée par un espace.
   */
  public String getPrenomNom() {
    return prenom + " " + nom;
  }

  /**
   * Getter du numéro de téléphone du client.
   *
   * @return numTel le numéro de téléphone du client
   */
  public String getNumTel() {
    return numTel;
  }

  /**
   * Getter des coordonnées GPS du client.
   *
   * @return gps les coordonnées GPS du client
   */
  public String getGps() {
    return gps;
  }

  /**
   * Getter de l'adresse du client.
   *
   * @return adresse l'adresse du client
   */
  public Adresse getAdresse() {
    return adresse;
  }

  /**
   * Setter de l'id du client.
   *
   * @param idClient l'id du client
   */
  public void setIdClient(int idClient) {
    this.idClient = idClient;
  }

  /**
   * Setter du nom du client.
   *
   * @param nom le nom du client
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du prénom du client.
   *
   * @param prenom le prénom du client
   */
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Setter du numéro de téléphone du client.
   *
   * @param numTel le numéro de téléphone du client
   */
  public void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  /**
   * Setter des coordonnées GPS du client.
   *
   * @param gps les coordonnées GPS du client
   */
  public void setGps(String gps) {
    this.gps = gps;
  }

  /**
   * Setter de l'adresse du client.
   *
   * @param adresse l'adresse du client
   */
  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Client)) {
      return false;
    }
    return idClient == ((Client) other).getIdClient();
  }

  public String toString() {
    return this.nom + " " + this.prenom;
  }

}
