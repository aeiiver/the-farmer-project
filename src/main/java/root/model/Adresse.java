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

  /**
   * Getter de l'identifiant de l'adresse.
   *
   * @return idAdresse l'identifiant de l'adresse.
   */
  private int getIdAdresse() {
    return idAdresse;
  }

  /**
   * Getter du pays de l'adresse.
   *
   * @return pays le pays de l'adresse.
   */
  private String getPays() {
    return pays;
  }

  /**
   * Getter du code postal de l'adresse.
   *
   * @return codePost le code postal de l'adresse.
   */
  private String getCodePost() {
    return codePost;
  }

  /**
   * Getter de la voie de l'adresse.
   *
   * @return voie la voie de l'adresse.
   */
  private String getVoie() {
    return voie;
  }

  /**
   * Getter du nom de l'adresse.
   *
   * @return nom le nom de l'adresse.
   */
  private String getNom() {
    return nom;
  }

  /**
   * Getter du numéro de l'adresse.
   *
   * @return
   */
  private int getNumero() {
    return numero;
  }

  /**
   * Getter de la mention de l'adresse.
   *
   * @return
   */
  private String getMention() {
    return mention;
  }

  /**
   * Getter du complément de l'adresse.
   *
   * @return
   */
  private String getComplement() {
    return complement;
  }

  /**
   * Setter de l'identifiant de l'adresse.
   *
   * @param idAdresse l'identifiant de l'adresse.
   */
  private void setIdAdresse(int idAdresse) {
    this.idAdresse = idAdresse;
  }

  /**
   * Setter du pays de l'adresse.
   *
   * @param pays le pays de l'adresse.
   */
  private void setPays(String pays) {
    this.pays = pays;
  }

  /**
   * Setter du code postal de l'adresse.
   *
   * @param codePost le code postal de l'adresse.
   */
  private void setCodePost(String codePost) {
    this.codePost = codePost;
  }

  /**
   * Setter de la voie de l'adresse.
   *
   * @param voie la voie de l'adresse.
   */
  private void setVoie(String voie) {
    this.voie = voie;
  }

  /**
   * Setter du nom de l'adresse.
   *
   * @param nom le nom de l'adresse.
   */
  private void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du numéro de l'adresse.
   *
   * @param numero le numéro de l'adresse.
   */
  private void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Setter de la mention de l'adresse.
   *
   * @param mention la mention de l'adresse.
   */
  private void setMention(String mention) {
    this.mention = mention;
  }

  /**
   * Setter du complément de l'adresse.
   *
   * @param complement le complément de l'adresse.
   */
  private void setComplement(String complement) {
    this.complement = complement;
  }
}