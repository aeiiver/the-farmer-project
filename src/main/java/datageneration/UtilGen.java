package datageneration;

/**
 * Classe utilitaire pour la génération de données.
 */
public abstract class UtilGen {
  /**
   * Parse la latitude GPS.
   *
   * @param gps Une chaîne de caractère contenant les coordonnés GPS.
   * @return La latitude.
   */
  public static double parseGpsLon(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[0]);
  }

  /**
   * Parse la longitude GPS.
   *
   * @param gps Une chaîne de caractère contenant les coordonnés GPS.
   * @return La longitude.
   */
  public static double parseGpsLat(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[1]);
  }
}
