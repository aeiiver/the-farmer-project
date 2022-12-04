package root.model;

/**
 * Classe de modèle pour les Producteurs.
 */
public class Producteur extends Utilisateur {
  private String Siret;
  private String nom;
  private String prenom;
  private String numTel;
  private Adresse adresse;

  /**
   * Getter du numéro Siret du producteur.
   *
   * @return Siret le numéro Siret du producteur
   */
  private String getSiret() {
    return Siret;
  }

  /**
   * Getter du nom du producteur.
   *
   * @return nom le nom du producteur
   */
  private String getNom() {
    return nom;
  }

  /**
   * Getter du prénom du producteur.
   *
   * @return prenom le prénom du producteur
   */
  private String getPrenom() {
    return prenom;
  }

  /**
   * Getter du numéro de téléphone du producteur.
   *
   * @return numTel le numéro de téléphone du producteur
   */
  private String getNumTel() {
    return numTel;
  }

  /**
   * Getter de l'adresse du producteur.
   *
   * @return adresse l'adresse du producteur
   */
  private Adresse getAdresse() {
    return adresse;
  }

  /**
   * Setter du numéro Siret du producteur.
   *
   * @param siret le numéro Siret du producteur
   */
  private void setSiret(String siret) {
    this.Siret = siret;
  }

  /**
   * Setter du nom du producteur.
   *
   * @param nom le nom du producteur
   */
  private void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du prénom du producteur.
   *
   * @param prenom le prénom du producteur
   */
  private void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * Setter du numéro de téléphone du producteur.
   *
   * @param numTel le numéro de téléphone du producteur
   */
  private void setNumTel(String numTel) {
    this.numTel = numTel;
  }

  /**
   * Setter de l'adresse du producteur.
   *
   * @param adresse l'adresse du producteur
   */
  private void setAdresse(Adresse adresse) {
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
