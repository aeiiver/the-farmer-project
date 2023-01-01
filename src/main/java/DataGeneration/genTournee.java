package DataGeneration;

public class genTournee {
  public static void genTournee(int nbTournees, int nbCommandes) {
    for (int i = 0; i < nbTournees; i++) {
      int nbCommandesTournee = (int) Math.ceil(nbCommandes / nbTournees);
      int nbCommandesRestantes = nbCommandes - nbCommandesTournee * i;
      if (nbCommandesRestantes < nbCommandesTournee) {
        nbCommandesTournee = nbCommandesRestantes;
      }
      int[] commandes = new int[nbCommandesTournee];
      for (int j = 0; j < nbCommandesTournee; j++) {
        commandes[j] = i * nbCommandesTournee + j;
      }
    }
  }
}
