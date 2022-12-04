package root.model;

/**
 * Classe de modèle pour les Adresses.
 */
public class Adresse {
  private int idAdresse;
  private String pays;
  private String codePost;
  private String voie;
  private String nom;
  private int numero;
  private String mention;
  private String complement;

  private int getIdAdresse() {
    return idAdresse;
  }

  private String getPays() {
    return pays;
  }

  private String getCodePost() {
    return codePost;
  }

  private String getVoie() {
    return voie;
  }

  private String getNom() {
    return nom;
  }

  private int getNumero() {
    return numero;
  }

  private String getMention() {
    return mention;
  }

  private String getComplement() {
    return complement;
  }

  private void setIdAdresse(int idAdresse) {
    this.idAdresse = idAdresse;
  }

  private void setPays(String pays) {
    this.pays = pays;
  }

  private void setCodePost(String codePost) {
    this.codePost = codePost;
  }

  private void setVoie(String voie) {
    this.voie = voie;
  }

  private void setNom(String nom) {
    this.nom = nom;
  }

  private void setNumero(int numero) {
    this.numero = numero;
  }

  private void setMention(String mention) {
    this.mention = mention;
  }

  private void setComplement(String complement) {
    this.complement = complement;
  }
}