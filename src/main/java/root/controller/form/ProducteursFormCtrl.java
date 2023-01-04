package root.controller.form;

import java.sql.Connection;
import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.data.ProducteurDao;
import root.data.SingleConnection;
import root.model.Admin;
import root.model.Adresse;
import root.model.Producteur;
import root.model.list.ListeProducteurs;
import root.model.session.SessionAdmin;
import root.model.session.SingleSession;


/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un producteur.
 */
public class ProducteursFormCtrl {

  private Stage fenetre;

  public ProducteursFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void enregistrer(String siretSaisi, String nomSaisi, String prenomSaisi,
                          String numTelSaisi, String adresseSaisi, String codePostSaisi,
                          String paysSaisi, String mdpSaisi, String mailSaisi, String villeSaisi) {

    if (siretSaisi.isEmpty() || nomSaisi.isEmpty() || prenomSaisi.isEmpty()
            || numTelSaisi.isEmpty() || adresseSaisi.isEmpty() || codePostSaisi.isEmpty()
            || paysSaisi.isEmpty() || paysSaisi.isEmpty() || mdpSaisi.isEmpty()
            || mailSaisi.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
              fenetre);
      return;
    }

    String messageErreur = "";
    if (!Validateur.validerSiret(siretSaisi)) {
      messageErreur += "Le Siret doit être composer de 14 chiffres.\n";
    }
    if (!villeSaisi.matches("^[A-Z]([' -a-zA-Z]{2,100})$")) {
      //Todo revoir le regex de la ville et adapter le message d'erreur
      messageErreur += "La ville doit faire entre 2 et 100 characters,"
              + " commencer par une majuscule, les accent sont exclus.\n";
    }
    if (!Validateur.validerNomPropre(nomSaisi)) {
      //Todo revoir le regex du nom et adapter le message d'erreur
      messageErreur += "Le nom doit commencer par une majuscule et ne doit "
              + "pas contenir plusieurs tiret ou espace d'affiler\n";
    }
    if (!Validateur.validerNomPropre(prenomSaisi)) {
      //Todo revoir le regex du prénom et adapter le message d'erreur
      messageErreur += "Le prénom doit commencer par une majuscule et ne doit "
              + "pas contenir plusieurs tiret ou espace d'affiler\n";
    }
    if (!numTelSaisi.matches("^0[1-9]( ?[0-9]{2}){4}$")) {
      messageErreur += "Le numéro de téléphone doit faire 10 chiffres"
              + " dont les 2 premier vont de 01 à 09 \n";
    }
    if (!adresseSaisi.matches("^[0-9a-zA-Z]{10,225}$")) {
      //Todo revoir le regex de l'adresse et adapter le message d'erreur
      messageErreur += "l'adresse doit contenir au moins 10"
              + " characters et jusqu'a 225 characters.\n";
    }
    if (!codePostSaisi.matches("^([12][AB])$|^([0-9]{5})$")) {
      messageErreur += "Seul les département de la France métropolitaine"
              + " + corse sont autoriser.\n";
    }
    if (!paysSaisi.matches("^France$")) {
      messageErreur += "La France est le seul pays autoriser pour le moment.\n";
    }
    if (!mdpSaisi.matches("^(?=.*\\d)(?=.*[a-zàáâäãçéèêëìíîïñòóôöùùûüýÿ])"
            + "(?=.*[A-ZÀÁÂÄÃÇÉÈÊËÌÍÎÏÑÒÓÔÖÙÚÛÜÝŸ])"
            + "(?=.*([^\\w0-9ÀÁÂÄÃÇÉÈÊËÌÍÎÏÑÒÓÔÖÙÚÛÜÝŸàáâäãçéèêëìíîïñòóôöùùûüýÿ]|_))(.{8,})$")) {
      messageErreur += "Le mot de passe doit contenir : \n- Au moins une minuscule une majuscule "
              + "\n- Au moins un chiffre \n- Au moins un character spéciale "
              + "\n- doit faire plus de 8 characters. \n";
    }
    if (!Validateur.validerMail(mailSaisi)) {
      messageErreur += "Le mail ne doit contenir plusieurs points, tiret ou tiret du bas d'affiler."
              + "\nLe mail doit contenir un @ suivi d'un nom de domaine.";
    }

    SessionAdmin session = (SessionAdmin) SingleSession.getSession();
    Admin admin = (Admin) session.getUtilisateur();
    ListeProducteurs listeProducteurs = session.getListeProducteurs();

    String[] elementAdresse = adresseSaisi.split(" ");
    // Todo Problème sur la gestion de l'adresse
    //  (si il n'y a pas de numéro, les élément optionnel etc...)

    Adresse adresseResultante = new Adresse(paysSaisi, codePostSaisi, villeSaisi, elementAdresse[1],
            elementAdresse[2], Integer.parseInt(elementAdresse[0]), elementAdresse[3],
            elementAdresse[4]);

    Connection singleConnection = SingleConnection.getInstance();
    Producteur edit = new ProducteurDao(singleConnection).get(siretSaisi);

    if (edit == null) {
      listeProducteurs.ajouter(new Producteur(siretSaisi,  mailSaisi, nomSaisi, prenomSaisi,
              numTelSaisi, mdpSaisi, adresseResultante));
    } else {
      listeProducteurs.editer(new Producteur(siretSaisi,  mailSaisi, nomSaisi, prenomSaisi,
              numTelSaisi, mdpSaisi, adresseResultante));
    }
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void cancel() {
    fenetre.close();
  }

}
