package root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe utilitaire.
 */
public class Utils {
  /**
   * Lit un InputStream.
   *
   * @param inputStream L'InputStream à lire.
   * @return Le contenu de l'InputStream.
   * @throws IOException Si l'InputStream n'a pas pu être lu.
   */
  public static String readInputStream(InputStream inputStream) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line;
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }
    reader.close();
    return sb.toString();
  }
}
