package datageneration;

public abstract class UtilGen {
  public static double parseGpsLon(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[0]);
  }

  public static double parseGpsLat(String gps) {
    String[] gpsSplit = gps.split(",");
    return Double.parseDouble(gpsSplit[1]);
  }
}
