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
}
