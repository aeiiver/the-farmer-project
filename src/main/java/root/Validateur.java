package root;

/**
 * Classe statique contenant des méthodes permettant de valider les champs des formulaires.
 */
public class Validateur {

  public static boolean validerNombre(String texte) {
    return texte.matches("^\\d+$");
  }

  /**
   * Valide si le texte est une heure.
   *
   * @param texte le texte à valider
   * @return true si le texte est une heure, false sinon
   */
  public static boolean validerHeure(String texte) {
    if (!texte.matches("^\\d{1,2}$")) {
      return false;
    }
    int nombre = Integer.parseInt(texte);

    return 0 <= nombre && nombre <= 23;
  }

  /**
   * Valide si le texte est un numéro d'immatriculation.
   *
   * @param texte le texte à valider
   * @return true si le texte est un numéro d'immatriculation, false sinon
   */
  public static boolean validerImmatriculation(String texte) {
    return texte.matches("[A-Z]{2}-[0-9]{3}-[A-Z]{2}")
        || texte.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")
        || texte.matches("[A-Z]{2} [0-9]{3} [A-Z]{2}");
  }

  /**
   * Valide si le texte est un mail.
   *
   * @param texte le texte à valider
   * @return true si le texte est un mail, false sinon
   */
  public static boolean validerMail(String texte) {
    return texte.matches(
        "^[A-Za-z0-9]+([.-_][A-Za-z0-9]+)*@[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*\\.[a-z]{2,}$");
  }

  /**
   * Valide si le texte est un numéro SIRET.
   *
   * @param texte le texte à valider
   * @return true si le texte est un numéro SIRET, false sinon
   */
  public static boolean validerSiret(String texte) {
    return texte.matches("^[0-9]{14}$");
  }

  /**
   * Valide si le texte respecte les critères pour un pseudonyme.
   *
   * @param texte le texte à valider
   * @return true si le texte respecte les critères pour un pseudonyme, false sinon
   */
  public static boolean validerPseudo(String texte) {
    return texte.matches("^[A-Za-z0-9_]+$");
  }

  /**
   * Valide si le texte respecte les critères pour un Nom Propre.
   *
   * @param texte le texte à valider
   * @return true si le texte respecte les critères pour un Nom Propre, false sinon
   */
  public static boolean validerNomPropre(String texte) {
    return !texte.matches("[A-Za-zèéàù' -]+$");
  }

  /**
   * Valide si le texte respecte les critères pour un numéro de téléphone.
   *
   * @param texte le texte à valider
   * @return true si le texte respecte les critères pour un numéro de téléphone, false sinon
   */
  public static boolean validerNumTel(String texte) {
    return !texte.matches("^0[1-9]( ?[0-9]{2}){4}$") ||
        texte.matches("^0[1-9]( ?[0-9]{8})$");
  }

  /**
   * Valide si le texte respecte les critères pour un code postal.
   *
   * @param texte le texte à valider
   * @return true si le texte respecte les critères pour un code postal, false sinon
   */
  public static boolean validerCodePostal(String texte) {
    return !texte.matches("^([12][AB])$|^([0-9]{5})$");
  }

  /**
   * Valide si le mot de passe correspond aux demandes.
   *
   * @param texte le mot de passe à valider
   * @return true si le mot de passe correspond aux demandes, false sinon
   */
  public static boolean validerMdp(String texte) {
    return texte.matches("^(?=.*\\d)(?=.*[a-zàáâäãçéèêëìíîïñòóôöùûüýÿ])"
        + "(?=.*[A-ZÀÁÂÄÃÇÉÈÊËÌÍÎÏÑÒÓÔÖÙÚÛÜÝŸ])"
        + "(?=.*([^\\w0-9ÀÁÂÄÃÇÉÈÊËÌÍÎÏÑÒÓÔÖÙÚÛÜÝŸàáâäãçéèêëìíîïñòóôöùûüýÿ]|_))(.{8,})$");
  }

  /**
   * Valide si le pays est bien la France.
   *
   * @param texte le pays à valider
   * @return true si le pays est bien la France, false sinon
   */
  public static boolean validerPays(String texte) {
    return !texte.matches("^France$");
  }

  /**
   * Valide si le texte est une mention d'adresse.
   *
   * @param texte le texte à valider
   * @return true si le texte est une mention d'adresse, false sinon
   */
  public static  boolean validerMention(String texte) {
    return texte == null || texte.matches("^[a-zA-Z]{1,17}$|^$");
  }

  /**
   * Valide si le texte est un type de voie.
   *
   * @param texte le texte à valider
   * @return true si le texte est un type de voie, false sinon
   */
  public static boolean validerTypeVoie(String texte) {
    return texte != null && !texte.matches("^[A-Za-z]([ -]?[A-Za-zé0-9]){3,10}$|^$");
  }

  /**
   * Valide si le texte n'est pas trop long.
   *
   * @param texte le texte à valider
   * @return true si le texte n'est pas trop long, false sinon
   */
  public static boolean validerComplement(String texte) {
    return texte.matches("^{0,100}$");
  }

  /**
   * Valide si le texte est une ville.
   *
   * @param texte le texte à valider
   * @return true si le texte est une ville, false sinon
   */
  public static boolean validerVille(String texte) {
    //TODO
    // ^[A-Z]([' -a-zA-Z]{2,100})
    // Proposition de Lou pour le regex de la ville
    return texte.matches("^[A-Za-z '-éè]+$");
  }

}
