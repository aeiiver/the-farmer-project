package root.controller.form;

import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.data.AdresseDao;
import root.data.ClientDao;
import root.data.SingleConnection;
import root.model.Adresse;
import root.model.Client;
import root.model.list.ListeClients;
import root.model.session.SessionProducteur;
import root.model.session.SingleSession;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un client.
 */
public class ClientsFormCtrl {

  private Stage fenetre;

  public ClientsFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des clients.
   */
  public void enregistrer(String nom, String prenom, String numTel, String gps,
                          String pays, String ville, String codePostal, int numeroAdresse,
                          String mention, String typeVoie, String nomVoie, String complementAdresse,
                          int idClient) {

    /* Validation de la saisie */
    // Vérifie si champs invalides
    if (nom.isEmpty() || prenom.isEmpty() || numTel.isEmpty() || gps.isEmpty() || pays.isEmpty()
        || ville.isEmpty() || codePostal.isEmpty() || nomVoie.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs avec une '*' doivent être renseignés.", fenetre);
      return;
    }

    // Vérifie si types de valeur invalides
    String messageErreur = "";

    if (!Validateur.validerPseudo(nom)) {
      messageErreur += "Le nom indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerPseudo(prenom)) {
      messageErreur += "Le prénom indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerNumTel(numTel)) {
      messageErreur += "Le numéro de téléphone indiqué n'est pas valide.\n";
    }
    // TODO gps
    if (!Validateur.validerPays(pays)) {
      messageErreur += "Le pays indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerVille(ville)) {
      messageErreur += "La ville indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerCodePostal(codePostal)) {
      messageErreur += "Le code postal indiqué n'est pas valide.\n";
    }
    if (!mention.isEmpty() && !Validateur.validerMention(mention)) {
      messageErreur += "La mention de l'adresse indiqué n'est pas valide.\n";
    }
    if (!typeVoie.isEmpty() && !Validateur.validerTypeVoie(typeVoie)) {
      messageErreur += "Le type de voie de l'adresse indiqué n'est pas valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    /* Après validation de la saisie */
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    ListeClients listeClients = session.getListeClients();

    /* Récupération de l'id de l'adresse */

    Adresse adresse = new Adresse(pays, codePostal, ville, typeVoie,
        nomVoie, numeroAdresse, mention, complementAdresse);


    Client client = new Client(nom, prenom, numTel, gps, adresse);

    Client edit = new ClientDao(SingleConnection.getInstance()).get(idClient);
    if (edit == null) {
      // Ajout
      ArrayList<Adresse> allAdresse = new AdresseDao(SingleConnection.getInstance()).getAll();
      int idMax = 1;
      if (allAdresse != null) {
        idMax = new AdresseDao(SingleConnection.getInstance()).getAll().stream()
            .max(Comparator.comparing(Adresse::getIdAdresse))
            .orElse(new Adresse(3, "", "", "", "", "", 0, "", "")).getIdAdresse();
      }
      adresse.setIdAdresse(idMax + 1);
      new AdresseDao(SingleConnection.getInstance()).insert(adresse);
      new ClientDao(SingleConnection.getInstance()).insert(client);
      listeClients.ajouter(client);
    } else {
      // Modification
      client.setIdClient(idClient);
      int idAdresse = client.getAdresse().getIdAdresse();
      adresse.setIdAdresse(idAdresse);
      new AdresseDao(SingleConnection.getInstance()).update(adresse);
      new ClientDao(SingleConnection.getInstance()).update(client);
      listeClients.editer(client);
    }

    fenetre.close();
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void annuler() {
    fenetre.close();
  }

}
