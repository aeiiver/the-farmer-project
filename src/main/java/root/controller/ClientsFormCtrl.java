package root.controller;

import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.model.*;

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
    if (nom.isEmpty() || prenom.isEmpty() || numTel.isEmpty() || gps.isEmpty() || pays.isEmpty() ||
            ville.isEmpty() || codePostal.isEmpty() || nomVoie.isEmpty()) {
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
    if (!Validateur.validerNomPropre(pays)) {
      messageErreur += "Le pays indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerNomPropre(ville)) {
      messageErreur += "La ville indiqué n'est pas valide.\n";
    }
    if (!Validateur.validerNombre(codePostal)) {
      messageErreur += "Le code postal indiqué n'est pas valide.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    /* Après validation de la saisie */
    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    ListeClients listeClients = session.getListeClients();

    Adresse adresse = new Adresse(pays, codePostal, ville, typeVoie, nomVoie, numeroAdresse, mention, complementAdresse);
    Client client = new Client(nom, prenom, numTel, gps, adresse);

    // Persiste la tournée dans la base de données
    if (idClient > 0) {
      client.setIdClient(idClient);
      listeClients.editer(client);
    } else {
      listeClients.ajouter(client);
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
