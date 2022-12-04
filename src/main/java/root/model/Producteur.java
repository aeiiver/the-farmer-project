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

  private String getSiret() {
    return Siret;
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

  private Adresse getAdresse() {
    return adresse;
  }

  private void setSiret(String siret) {
    this.Siret = siret;
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

  private void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  @Override
  public boolean verifieIdentifiants() {

    // dummy return
    return false;
  }
}
