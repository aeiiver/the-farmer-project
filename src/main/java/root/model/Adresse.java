package root.model;

/**
 * Classe de modèle pour les Adresses.
 */
public class Adresse {

  /**
   * Identifiant de l'adresse dans la base de données.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getIdAdresse()
   * @see Adresse#setIdAdresse(int)
   */
  private int idAdresse;

  /**
   * Pays de l'adresse.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getPays()
   * @see Adresse#setPays(String)
   */
  private String pays;

  /**
   * Code postal de l'adresse.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getCodePost()
   * @see Adresse#setCodePost(String)
   */
  private String codePost;

  /**
   * Code postal de l'adresse.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getVille()
   * @see Adresse#setVille(String)
   */
  private String ville;

  /**
   * Type de rue de l'adresse. (Avenue, Rue, Boulevard, etc.)
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getVoie()
   * @see Adresse#setVoie(String)
   */
  private String voie;

  /**
   * Nom de la rue de l'adresse.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getVoie()
   * @see Adresse#setVoie(String)
   */
  private String nom;

  /**
   * Numéro de la rue de l'adresse.
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getNumero()
   * @see Adresse#setNumero(int)
   */
  private int numero;

  /**
   * Mention de l'adresse (Bâtiment, Appartement, etc.)
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getMention()
   * @see Adresse#setMention(String)
   */
  private String mention;

  /**
   * Complément de l'adresse (Bis, Ter, etc.)
   *
   * @see Adresse#Adresse(int, String, String, String, String, String, int, String, String)
   * @see Adresse#getComplement()
   * @see Adresse#setComplement(String)
   */
  private String complement;

  /**
   * Constructeur de classe d'une Adresse insérée dans la base.
   *
   * @param idAdresse  Un identifiant pour l'adresse.
   * @param pays       Un nom de pays.
   * @param codePost   Le code postal lié à l'adresse.
   * @param ville      La ville liée à l'adresse.
   * @param voie       La dénomination de la voie (rue, boulevard, chemin, ...).
   * @param nom        Le nom lié l'adresse.
   * @param numero     Le numéro de l'adresse.
   * @param mention    La mention de l'adresse.
   * @param complement Le complément de l'adresse (bât., étage, ...)
   */
  public Adresse(int idAdresse, String pays, String codePost, String ville, String voie,
                 String nom, int numero, String mention, String complement) {
    this.idAdresse = idAdresse;
    this.pays = pays;
    this.codePost = codePost;
    this.ville = ville;
    this.voie = voie;
    this.nom = nom;
    this.numero = numero;
    this.mention = mention;
    this.complement = complement;
  }

  /**
   * Constructeur de classe d'une Adresse non insérée dans la base.
   *
   * @param pays       Un nom de pays.
   * @param codePost   Le code postal lié à l'adresse.
   * @param ville      La ville liée à l'adresse.
   * @param voie       La dénomination de la voie (rue, boulevard, chemin, ...).
   * @param nom        Le nom lié l'adresse.
   * @param numero     Le numéro de l'adresse.
   * @param mention    La mention de l'adresse.
   * @param complement Le complément de l'adresse (bât., étage, ...)
   */
  public Adresse(String pays, String codePost, String ville, String voie,
                 String nom, int numero, String mention, String complement) {
    this.idAdresse = -1;
    this.pays = pays;
    this.codePost = codePost;
    this.ville = ville;
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
   * Getter de la ville de l'adresse.
   *
   * @return ville la ville de l'adresse.
   */
  public String getVille() {
    return ville;
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
   * @return complement Le complément de l'adresse.
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
   * Setter de la ville de l'adresse.
   *
   * @param ville la ville de l'adresse.
   */
  public void setVille(String ville) {
    this.ville = ville;
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

  /**
   * Méthode permettant d'afficher une adresse.
   *
   * @return Une chaîne de caractères contenant l'adresse.
   */
  @Override
  public String toString() {
    return pays + " " + codePost + " " + ville + " " + numero + " " + voie + " " + nom + " "
        + mention + " " + complement;
  }

  /**
   * Méthode permettant d'afficher une partie de l'adresse
   */
  public String toStringPartiel() {
    return ville + " " + numero + " " + voie + " " + nom;
  }

  /**
   * Méthode ??.
   *
   * @return 0.
   */
  @Override
  public int hashCode() {
    return 0;
  }

  /**
   * Méthode permettant de comparer deux adresses.
   *
   * @param other L'adresse à comparer.
   * @return true si les deux adresses sont identiques, false sinon.
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Adresse)) {
      return false;
    }
    return idAdresse == ((Adresse) other).getIdAdresse();
  }

}
