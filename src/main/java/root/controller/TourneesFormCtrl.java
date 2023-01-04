package root.controller;

import java.sql.Time;
import java.util.List;
import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.model.Commande;
import root.model.ListeTournees;
import root.model.Producteur;
import root.model.SessionProducteur;
import root.model.SingleSession;
import root.model.Tournee;
import root.model.Vehicule;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une tournée.
 */
public class TourneesFormCtrl {

  private Stage fenetre;

  public TourneesFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des tournées.
   */
  public void enregistrer(String libelle, String heureMin, String heureMax, Vehicule vehicule,
                          List<Commande> commandes, int numTournee) {

    /* Validation de la saisie */
    // Vérifie si champs invalides
    if (libelle.isEmpty() || heureMin.isEmpty() || heureMax.isEmpty() || vehicule == null
        || commandes.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.", fenetre);
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    if (!Validateur.validerHeure(heureMin)) {
      messageErreur += "L'heure minimale saisie n'est pas une heure valide.\n";
    }
    if (!Validateur.validerHeure(heureMax)) {
      messageErreur += "L'heure maximale saisie n'est pas une heure valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    // Convertit les types valides
    Time heureMinValide = Time.valueOf(heureMin + ":00:00");
    Time heureMaxValide = Time.valueOf(heureMax + ":00:00");

    if (heureMinValide.equals(heureMaxValide) || heureMinValide.after(heureMaxValide)) {
      StageUtil.afficheAlerte("L'heure minimale est égale ou supérieure à l'heure maximale.",
          fenetre);
      return;
    }

    /* Après validation de la saisie */
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeTournees listeTournees = session.getListeTournees();

    Tournee tournee = new Tournee(libelle, heureMinValide, heureMaxValide, producteur, vehicule);
    tournee.getCommandes().addAll(commandes);

    if (!tournee.estValide()) {
      StageUtil.afficheAlerte("La tournée n'est pas valide.", fenetre);
      return;
    }

    // Persiste la tournée dans la base de données
    if (numTournee > 0) {
      tournee.setNumTournee(numTournee);
      listeTournees.editer(tournee);
    } else {
      listeTournees.ajouter(tournee);
    }

    fenetre.close();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void annuler() {
    fenetre.close();
  }

}
