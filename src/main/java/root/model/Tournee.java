package root.model;

import static root.Utils.readInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

import root.model.list.ListeCommandes;

/**
 * Classe de modèle pour la tournée.
 */
public class Tournee {

  /**
   * Identifiant de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getNumTournee()
   * @see Tournee#setNumTournee(int)
   */
  private int numTournee;

  /**
   * Nom de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getLibelle()
   * @see Tournee#setLibelle(String)
   */
  private String libelle;

  /**
   * Heure de début de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getHeureMin()
   * @see Tournee#setHeureMin(Time)
   */
  private Time heureMin;

  /**
   * Heure de fin de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getHeureMax()
   * @see Tournee#setHeureMax(Time)
   */
  private Time heureMax;

  /**
   * Producteur de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getProducteur()
   * @see Tournee#setProducteur(Producteur)
   */
  private Producteur producteur;

  /**
   * Véhicule de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getVehicule()
   * @see Tournee#setVehicule(Vehicule)
   */
  private Vehicule vehicule;

  /**
   * Liste des commandes de la tournée.
   *
   * @see Tournee#Tournee(int, String, Time, Time, Producteur, Vehicule)  Tournee
   * @see Tournee#getCommandes()
   * @see Tournee#setCommandes(ArrayList)
   * @see Tournee#ajouteCommande(Commande)
   * @see Commande
   * @see ListeCommandes
   */
  private ArrayList<Commande> commandes;

  /**
   * Constructeur de classe d'une tournée insérée dans la base.
   *
   * @param numTournee Le numéro de la tournée.
   * @param libelle    Le libellé de la tournée.
   * @param heureMin   L'heure minimale pour la réalisation de la tournée.
   * @param heureMax   L'heure maximale pour la réalisation de la tournée.
   * @param producteur Le producteur qui réalise la tournée.
   * @param vehicule   Le véhicule avec lequel la tournée sera réalisé.
   */
  public Tournee(int numTournee, String libelle, Time heureMin, Time heureMax,
                 Producteur producteur, Vehicule vehicule) {
    this.numTournee = numTournee;
    this.libelle = libelle;
    this.heureMin = heureMin;
    this.heureMax = heureMax;
    this.producteur = producteur;
    this.vehicule = vehicule;
    this.commandes = new ArrayList<>();
  }

  /**
   * Constructeur de classe d'une tournée non insérée dans la base.
   *
   * @param libelle    Le libellé de la tournée.
   * @param heureMin   L'heure minimale pour la réalisation de la tournée.
   * @param heureMax   L'heure maximale pour la réalisation de la tournée.
   * @param producteur Le producteur qui réalise la tournée.
   * @param vehicule   Le véhicule avec lequel la tournée sera réalisé.
   */
  public Tournee(String libelle, Time heureMin, Time heureMax,
                 Producteur producteur, Vehicule vehicule) {
    this.numTournee = -1;
    this.libelle = libelle;
    this.heureMin = heureMin;
    this.heureMax = heureMax;
    this.producteur = producteur;
    this.vehicule = vehicule;
    this.commandes = new ArrayList<>();
  }

  /**
   * Getter du numéro de la tournée.
   *
   * @return numTournee le numéro de la tournée
   */
  public int getNumTournee() {
    return numTournee;
  }

  /**
   * Getter du libellé de la tournée.
   *
   * @return libelle le libellé de la tournée
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * Getter de l'heure minimale de la tournée.
   *
   * @return heureMin l'heure minimale de la tournée
   */
  public Time getHeureMin() {
    return heureMin;
  }

  /**
   * Getter de l'heure maximale de la tournée.
   *
   * @return heureMax l'heure maximale de la tournée
   */
  public Time getHeureMax() {
    return heureMax;
  }

  /**
   * Getter du producteur de la tournée.
   *
   * @return producteur le producteur de la tournée
   */
  public Producteur getProducteur() {
    return producteur;
  }

  /**
   * Getter du véhicule de la tournée.
   *
   * @return vehicule le véhicule de la tournée
   */
  public Vehicule getVehicule() {
    return vehicule;
  }

  /**
   * Getter des commandes de la tournée.
   *
   * @return commandes les commandes de la tournée
   */
  public ArrayList<Commande> getCommandes() {
    return commandes;
  }

  /**
   * Setter du numéro de la tournée.
   *
   * @param numTournee le numéro de la tournée
   */
  public void setNumTournee(int numTournee) {
    this.numTournee = numTournee;
  }

  /**
   * Setter du libellé de la tournée.
   *
   * @param libelle le libellé de la tournée
   */
  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * Setter de l'heure minimale de la tournée.
   *
   * @param heureMin l'heure minimale de la tournée
   */
  public void setHeureMin(Time heureMin) {
    this.heureMin = heureMin;
  }

  /**
   * Setter de l'heure maximale de la tournée.
   *
   * @param heureMax l'heure maximale de la tournée
   */
  public void setHeureMax(Time heureMax) {
    this.heureMax = heureMax;
  }

  /**
   * Setter du producteur de la tournée.
   *
   * @param producteur le producteur de la tournée
   */
  public void setProducteur(Producteur producteur) {
    this.producteur = producteur;
  }

  /**
   * Setter du véhicule de la tournée.
   *
   * @param vehicule le véhicule de la tournée
   */
  public void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }

  /**
   * Setter des commandes de la tournée.
   *
   * @param commandes les commandes de la tournée
   */
  public void setCommandes(ArrayList<Commande> commandes) {
    this.commandes = commandes;
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
   * Méthode permettant de comparer deux tournées.
   *
   * @param other L'objet à comparer.
   * @return true si les deux tournées sont identiques, false sinon.
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Tournee)) {
      return false;
    }
    return numTournee == ((Tournee) other).getNumTournee();
  }

  /**
   * Méthode pour vérifier si la tournée est valide.
   *
   * <p>Une tournée est valide si toutes les commandes qu'elle contient ont lieu à la même date,
   * entre les horaires minimale et maximale de la tournée, et la somme de leur poids est
   * inférieur ou égal au poids que le véhicule peut supporter.</p>
   *
   * @return true si la tournée est valide, false sinon
   */
  public boolean estValide() {
    return valideHeure() && validePoids();
  }

  /**
   * Méthode pour vérifier si la tournée est valide en termes de poids.
   *
   * @return true si la tournée est valide, false sinon
   */
  public boolean validePoids() {
    int poidsTotal = 0;
    for (Commande com : commandes) {
      poidsTotal += com.getPoids();
    }
    return poidsTotal < this.vehicule.getPoidsMax();
  }

  /**
   * Méthode pour vérifier si la tournée est valide en termes d'heure.
   *
   * @return true si la tournée est valide, false sinon
   */
  public boolean valideHeure() {
    commandes.sort(Comparator.comparing(Commande::getOrdreTournee));

    boolean valide = true;

    Time tempsTournee = new Time(commandes.get(0).getHeureDeb().getTime());
    System.out.println("tempsTournee : " + tempsTournee);
    for (int i = 0; i < commandes.size() - 1; i++) {
      Commande com = commandes.get(i);
      Commande comNp = commandes.get(i + 1);
      String gpsClient = com.getClient().getGps();
      String gpsClientNp = comNp.getClient().getGps();
      Time tempsTrajet = getTempsTrajet(gpsClient, gpsClientNp);
      LocalTime time1 = tempsTournee.toLocalTime();
      LocalTime time2 = tempsTrajet.toLocalTime();

      LocalTime sum = time1.plusHours(time2.getHour()).plusMinutes(time2.getMinute()).plusSeconds(time2.getSecond());
      tempsTournee = Time.valueOf(sum);
      System.out.println("tempsTournee : " + tempsTournee);
      valide = tempsTournee.after(heureMin) && tempsTournee.before(heureMax);
    }

    return valide;
  }

  /**
   * Méthode pour ajouter une commande à la tournée.
   *
   * @param commande commande à ajouter
   */
  public void ajouteCommande(Commande commande) {
    commandes.add(commande);
  }

  /**
   * Méthode pour supprimer une commande de la tournée.
   *
   * @param commande commande à supprimer
   */
  public void retireCommande(Commande commande) {
    commandes.remove(commande);
  }

  /**
   * Méthode pour afficher les informations de la tournée.
   *
   * @return les informations de la tournée
   */
  public String toString() {
    return libelle + "\n" + heureMin + "/" + heureMax + "\n" + vehicule + "\n";
  }

  /**
   * Méthode pour calculer le temps de trajet entre deux points.
   *
   * @param depart Coordonnés GPS du départ
   * @param arrivee Coordonnés GPS de l'arrivée
   * @return le temps de trajet entre les deux points
   */
  private Time getTempsTrajet(String depart, String arrivee) {
    try {
      Time temps = new Time(0);
      String retour = "";
      depart = depart.replace(" ", "");
      arrivee = arrivee.replace(" ", "");
      URL url = new URL(
          "https://wxs.ign.fr/calcul/geoportail/itineraire/rest/1.0.0/route?resource=bdtopo-osrm&start="
              + depart + "&end=" + arrivee);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.connect();
      int responseCode = connection.getResponseCode();
      if (responseCode >= 200 && responseCode < 300) {
        InputStream inputStream = connection.getInputStream();
        String responseBody = readInputStream(inputStream);
        if (responseBody.contains("duration")) {
          retour = responseBody.substring(responseBody.indexOf("distance"));
        }
      }
      if (retour.equals("")) {
        return temps;
      } else {
        retour = retour.substring(retour.indexOf("\"duration\":") + 11,
            retour.indexOf(",", retour.indexOf("\"duration\":")));
        retour = retour.substring(0, retour.indexOf("."));
        String heure = Integer.toString(Integer.parseInt(retour) / 60);
        String minute = Integer.toString(Integer.parseInt(retour) % 60);
        heure = heure.length() == 1 ? "0" + heure : heure;
        minute = minute.length() == 1 ? "0" + minute : minute;
        try {
          temps = new Time(new SimpleDateFormat("HH:mm").parse(heure + ":" + minute).getTime());
        } catch (Exception e) {
          e.printStackTrace();
          temps = new Time(0);
        }
        return temps;
      }
    } catch (IOException e) {
      e.printStackTrace();
      return new Time(0);
    }
  }

}
