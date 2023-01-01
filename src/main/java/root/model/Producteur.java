package root.model;

import root.data.AdminDao;
import root.data.ProducteurDao;
import root.data.SingleConnection;

/**
 * Classe de modèle pour les Producteurs.
 */
public class Producteur extends Utilisateur {

  /**
   * ID du producteur. Numéro Siret de son entreprise.
   *
   * @see Producteur#Producteur(String, String, String, String, String, String, Adresse)  Producteur
   * @see Producteur#getSiret() 
   * @see Producteur#setSiret(String)
   */
  private String siret;

  /**
   * Nom du producteur.
   *
   * @see Producteur#Producteur(String, String, String, String, String, String, Adresse)  Producteur
   * @see Producteur#getNom()
   * @see Producteur#setNom(String)
   */
  private String nom;
  
  /**
   * Prénom du producteur.
   *
   * @see Producteur#Producteur(String, String, String, String, String, String, Adresse)  Producteur
   * @see Producteur#getPrenom()
   * @see Producteur#setPrenom(String)
   */
  private String prenom;
  
  /**
   * Numéro de téléphone du producteur.
   *
   * @see Producteur#Producteur(String, String, String, String, String, String, Adresse)  Producteur
   * @see Producteur#getNumTel()
   * @see Producteur#setNumTel(String)
   */
  private String numTel;
  
  /**
   * Coordonnés GPS du producteur.
   *
   * @see Producteur#Producteur(String, String, String, String, String, String, Adresse)  Producteur
   * @see Producteur#getAdresse() 
   * @see Producteur#setAdresse(Adresse) 
   */
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
   * Getter du prénom et nom du producteur.
   *
   * @return La concaténation du prénom et du nom du producteur, séparée par un espace.
   */
  public String getPrenomNom() {
    return prenom + " " + nom;
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
   * Vérification des informations de connexion.
   *
   * <p>La vérification se fait en invoquant un objet "Producteur" pour créer un autre objet
   * "Producteur" avec l'identifiant saisi par l'utilisateur. Ensuite, on compare le mot de passe
   * de l'objet courant avec celui de l'autre objet pour vérifier qu'ils correspondent bien.
   * Si les mots de passes correspondent, alors les identifiants saisis sont correctes et on peut
   * retourner true. On retournera false dans le cas contraire.</p>
   *
   * <p>Si ProducteurDAO retourne null à la place d'un objet Producteur, alors on sait directement
   * que les identifiants sont incorrectes.</p>
   *
   * @return true si l'identifiant et le mot de passe saisis sont corrects, false sinon.
   */
  @Override
  public boolean verifieIdentifiants() {
    ProducteurDao bdd = new ProducteurDao(SingleConnection.getInstance());

    // Tente de chercher un producteur avec son mail
    Producteur existant = bdd.get(this.getMail());

    // Si on a rien, réessaye avec son siret
    if (existant == null) {
      existant = bdd.get(this.getSiret());

      // Si on a rien, alors le producteur recherché n'existe pas dans la base
      if (existant == null) {
        return false;
      }
    }

    return this.getMdp().equals(existant.getMdp());
  }

}
