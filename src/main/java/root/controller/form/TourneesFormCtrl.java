package root.controller.form;

import java.sql.Time;
import java.util.Comparator;
import java.util.List;
import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.model.Commande;
import root.model.Producteur;
import root.model.Tournee;
import root.model.Vehicule;
import root.model.list.ListeTournees;
import root.model.session.SessionUtilisateur;
import root.model.session.SingleSession;

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
  public void enregistrer(String libelle, Vehicule vehicule,
                          List<Commande> commandes, int numTournee) {

    /* Validation de la saisie */
    // Vérifie si champs invalides
    if (libelle.isEmpty() || vehicule == null || commandes.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.", fenetre);
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    /* Après validation de la saisie */
    SessionUtilisateur session = SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeTournees listeTournees = new ListeTournees(producteur);

    // On peut assurément get() puisque la sélection n'est pas vide
    Time heureMin =
        Time.valueOf(commandes.stream()
            .min(Comparator.comparing(Commande::getHeureDeb))
            .get()
            .getHeureDeb()
            .toLocalTime());
    Time heureMax =
        Time.valueOf(commandes.stream()
            .max(Comparator.comparing(Commande::getHeureFin))
            .get()
            .getHeureFin()
            .toLocalTime());

    Tournee tournee = new Tournee(libelle, heureMin, heureMax, producteur, vehicule);
    tournee.getCommandes().addAll(commandes);

    if (!tournee.validePoids()) {
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
    SceneChanger.voirListeTournees(fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void annuler() {
    fenetre.close();
  }

}
