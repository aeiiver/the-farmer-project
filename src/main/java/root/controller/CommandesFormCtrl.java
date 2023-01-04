package root.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.model.Client;
import root.model.Commande;
import root.model.ListeCommandes;
import root.model.Producteur;
import root.model.SessionProducteur;
import root.model.SingleSession;


/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'une commande.
 */
public class CommandesFormCtrl {

  private Stage fenetre;

  public CommandesFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des commandes.
   */
  public void enregistrer(String libelleSaisi, String poidsSaisi, Client clientChoisi,
                          LocalDate dateChoisie, String heureDebSaisie, String heureFinSaisie,
                          int numCom) {
    /* Validation de la saisie */
    // Vérifie si champs vides
    if (libelleSaisi.isEmpty() || poidsSaisi.isEmpty() || clientChoisi == null ||
        dateChoisie == null || heureDebSaisie.isEmpty() || heureFinSaisie.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.", fenetre);
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    if (!Validateur.validerNombre(poidsSaisi)) {
      messageErreur += "Le poids saisi n'est pas un nombre entier.\n";
    }
    if (!Validateur.validerHeure(heureDebSaisie)) {
      messageErreur += "L'heure de départ saisie n'est pas une heure valide.\n";
    }
    if (!Validateur.validerHeure(heureFinSaisie)) {
      messageErreur += "L'heure de fin saisie n'est pas une heure valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    // Tous les types de valeur sont corrects
    int poidsValide = Integer.parseInt(poidsSaisi);
    Date dateValide = Date.valueOf(dateChoisie);
    Time heureDebValide = Time.valueOf(heureDebSaisie + ":00:00");
    Time heureFinValide = Time.valueOf(heureFinSaisie + ":00:00");

    if (heureDebValide.equals(heureFinValide) || heureDebValide.after(heureFinValide)) {
      StageUtil.afficheAlerte("L'heure de départ est égale ou supérieure à l'heure de fin.",
          fenetre);
      return;
    }

    // Après validation de la saisie
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeCommandes listeCommandes = session.getListeCommandes();

    Commande commande =
        new Commande(libelleSaisi, poidsValide, dateValide, heureDebValide, heureFinValide,
            producteur, clientChoisi);

    if (numCom > 0) {
      commande.setNumCom(numCom);
      listeCommandes.editer(commande);
    } else {
      listeCommandes.ajouter(commande);
    }

    fenetre.close();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void annuler() {
    fenetre.close();
  }

}
