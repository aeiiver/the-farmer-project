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
   * Constructeur de classe.
   *
   * @param idAdresse  Un identifiant pour l'adresse.
   * @param pays       Un nom de pays.
   * @param codePost   Le code postal lié à l'adresse.
   * @param voie       La dénomination de la voie (rue, boulevard, chemin, ...).
   * @param nom        Le nom lié l'adresse.
   * @param numero     Le numéro de l'adresse.
   * @param mention    La mention de l'adresse.
   * @param complement Le complément de l'adresse (bât., étage, ...)
   */
  public Adresse(int idAdresse, String pays, String codePost, String voie, String nom, int numero,
                 String mention, String complement) {
    this.idAdresse = idAdresse;
    this.pays = pays;
    this.codePost = codePost;
    this.voie = voie;
    this.nom = nom;
    this.numero = numero;
    this.mention = mention;
    this.complement = complement;
  }

  /**
   * Getter de l'identifiant de l'adresse.
   *
   * @return idAdresse l'identifiant de l'adresse.
   */
  public int getIdAdresse() {
    return idAdresse;
  }

  /**
   * Getter du pays de l'adresse.
   *
   * @return pays le pays de l'adresse.
   */
  public String getPays() {
    return pays;
  }

  /**
   * Getter du code postal de l'adresse.
   *
   * @return codePost le code postal de l'adresse.
   */
  public String getCodePost() {
    return codePost;
  }

  /**
   * Getter de la voie de l'adresse.
   *
   * @return voie la voie de l'adresse.
   */
  public String getVoie() {
    return voie;
  }

  /**
   * Getter du nom de l'adresse.
   *
   * @return nom le nom de l'adresse.
   */
  public String getNom() {
    return nom;
  }

  /**
   * Getter du numéro de l'adresse.
   *
   * @return Le numéro de l'adresse.
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Getter de la mention de l'adresse.
   *
   * @return La mention de l'adresse.
   */
  public String getMention() {
    return mention;
  }

  /**
   * Getter du complément de l'adresse.
   *
   * @return Le complément de l'adresse.
   */
  public String getComplement() {
    return complement;
  }

  /**
   * Setter de l'identifiant de l'adresse.
   *
   * @param idAdresse l'identifiant de l'adresse.
   */
  public void setIdAdresse(int idAdresse) {
    this.idAdresse = idAdresse;
  }

  /**
   * Setter du pays de l'adresse.
   *
   * @param pays le pays de l'adresse.
   */
  public void setPays(String pays) {
    this.pays = pays;
  }

  /**
   * Setter du code postal de l'adresse.
   *
   * @param codePost le code postal de l'adresse.
   */
  public void setCodePost(String codePost) {
    this.codePost = codePost;
  }

  /**
   * Setter de la voie de l'adresse.
   *
   * @param voie la voie de l'adresse.
   */
  public void setVoie(String voie) {
    this.voie = voie;
  }

  /**
   * Setter du nom de l'adresse.
   *
   * @param nom le nom de l'adresse.
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * Setter du numéro de l'adresse.
   *
   * @param numero le numéro de l'adresse.
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Setter de la mention de l'adresse.
   *
   * @param mention la mention de l'adresse.
   */
  public void setMention(String mention) {
    this.mention = mention;
  }

  /**
   * Setter du complément de l'adresse.
   *
   * @param complement le complément de l'adresse.
   */
  public void setComplement(String complement) {
    this.complement = complement;
  }

}
