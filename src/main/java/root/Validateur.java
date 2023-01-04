package root;

/**
 * Classe statique contenant des méthodes permettant de valider les champs des formulaires.
 */
public class Validateur {

  public static boolean validerNombre(String texte) {
    return texte.matches("^\\d+$");
  }

  public static boolean validerHeure(String texte) {
    if (!texte.matches("^\\d{1,2}$")) {
      return false;
    }
    int nombre = Integer.parseInt(texte);

    return 0 <= nombre && nombre <= 23;
  }

  public static boolean validerImmatriculation(String texte) {
    return texte.matches("[A-Z]{2}-[0-9]{3}-[A-Z]{2}")
        || texte.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}");
  }

  public static boolean validerMail(String texte) {
    return texte.matches(
        "^[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*@[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*\\.[a-z]{2,}$");
  }

  public static boolean validerSiret(String texte) {
    return texte.matches("^(\\d ?){14}$");
  }

  public static boolean validerPseudo(String texte) {
    return texte.matches("^[A-Za-z0-9]+$");
  }

  public static boolean validerNomPropre(String texte) {
    return texte.matches("^[A-Z](a-z)+([ -A-Z](a-z)+)*$");
  }

  public static boolean validerNumTel(String texte) {
    return texte.matches("^0[1-9]( ?[0-9]{2}){4}$");
  }

}
