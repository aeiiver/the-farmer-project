package root.model;

/**
 * Classe de modèle pour les Producteurs.
 */
public class Producteur extends Utilisateur {

  private String siret;
  private String nom;
  private String prenom;
  private String numTel;
  private Adresse adresse;

  /**
   * Constructeur.
   *
   * @param mail    L'adresse email du producteur.
   * @param mdp     Son mot de passe.
   * @param siret   Le numéro SIRET auquel le producteur est associé.
   * @param nom     Le nom du producteur.
   * @param prenom  Le prénom du producteur.
   * @param numTel  Le numéro de téléphone du producteur.
   * @param adresse L'adresse du producteur, représenté par un objet Adresse.
   */
  public Producteur(String mail, String mdp, String siret, String nom, String prenom, String numTel,
                    Adresse adresse) {
    super(mail, mdp);
    this.siret = siret;
    this.nom = nom;
    this.prenom = prenom;
    this.numTel = numTel;
    this.adresse = adresse;
  }

  /**
   * Getter du numéro Siret du producteur.
   *
   * @return Siret le numéro Siret du producteur
   */
  public String getSiret() {
    return siret;
  }

  /**
   * Getter du nom du producteur.
   *
   * @return nom le nom du producteur
   */
  public String getNom() {
    return nom;
  }

  /**
   * Getter du prénom du producteur.
   *
   * @return prenom le prénom du producteur
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * Getter du numéro de téléphone du producteur.
   *
   * @return numTel le numéro de téléphone du producteur
   */
  public String getNumTel() {
    return numTel;
  }

  /**
   * Getter de l'adresse du producteur.
   *
   * @return adresse l'adresse du producteur
   */
  public Adresse getAdresse() {
    return adresse;
  }

  /**
   * Setter du numéro Siret du producteur.
   *
   * @param siret le numéro Siret du producteur
   */
  public void setSiret(String siret) {
    this.siret = siret;
  }

  /**
   * Setter du nom du producteur.
   *
   * @param nom le nom du producteur
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du prénom du producteur.
   *
   * @param prenom le prénom du producteur
   */
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Setter du numéro de téléphone du producteur.
   *
   * @param numTel le numéro de téléphone du producteur
   */
  public void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  /**
   * Setter de l'adresse du producteur.
   *
   * @param adresse l'adresse du producteur
   */
  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  /**
   * Méthode vérifiant les identifiants du producteur.
   *
   * @return true si les identifiants sont corrects, false sinon
   */
  @Override
  public boolean verifieIdentifiants() {

    // dummy return
    return false;
  }

}
