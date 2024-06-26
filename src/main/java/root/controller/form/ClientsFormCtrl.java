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

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un client.
 */
public class ClientsFormCtrl {

  private final Stage fenetre;

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
                          Client client) {

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
    if (!Validateur.validerGps(gps)) {
      messageErreur += "Les coordonnées GPS indiquées ne sont pas valides.\n";
    }
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
    if (!typeVoie.isEmpty() && Validateur.validerTypeVoie(typeVoie)) {
      messageErreur += "Le type de voie de l'adresse indiqué n'est pas valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    /* Après validation de la saisie */
    ListeClients listeClients = new ListeClients();

    /* Récupération de l'id de l'adresse */

    Adresse adresse = new Adresse(pays, codePostal, ville, typeVoie,
        nomVoie, numeroAdresse, mention, complementAdresse);


    Client edit = new ClientDao(SingleConnection.getInstance()).get(client.getIdClient());
    if (edit == null) {
      new AdresseDao(SingleConnection.getInstance()).insert(adresse);
      Client nouveauClient = new Client(nom, prenom, numTel, gps, adresse);
      listeClients.ajouter(nouveauClient);
    } else {
      // Modification
      Client updateClient = new Client(nom, prenom, numTel, gps, adresse);
      updateClient.setIdClient(edit.getIdClient());
      adresse.setIdAdresse(edit.getAdresse().getIdAdresse());
      updateClient.setAdresse(adresse);
      listeClients.editer(updateClient);
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
