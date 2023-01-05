package root.controller.form;

import java.sql.Connection;
import javafx.stage.Stage;
import root.StageUtil;
import root.Validateur;
import root.data.ProducteurDao;
import root.data.SingleConnection;
//import root.model.Admin;
import root.model.Adresse;
import root.model.Producteur;
import root.model.list.ListeProducteurs;
import root.model.session.SessionAdmin;
import root.model.session.SingleSession;
//TODO c'est quoi ce travaille de cochon là...

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
                          String numTelSaisi, String codePostSaisi,
                          String paysSaisi, String mdpSaisi, String mailSaisi,
                          String villeSaisi, String numeroAdresse, String mention,
                          String typeVoie, String nomVoie, String complement) {

    if (siretSaisi.isEmpty() || nomSaisi.isEmpty() || prenomSaisi.isEmpty()
            || numTelSaisi.isEmpty() || codePostSaisi.isEmpty()
            || paysSaisi.isEmpty() || mdpSaisi.isEmpty()
            || nomVoie.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs suivis d'une * doivent être renseigné",
              fenetre);
      return;
    }
    //Todo faire les regex pour l'adresse
    String messageErreur = "";
    if (!Validateur.validerMention(mention)) {
      messageErreur += "La mention doit faire entre 3 et 17 characters "
              + "et ne comporte pas de majuscule.\n";
    }
    if (!Validateur.validerTypeVoie(typeVoie)) {
      messageErreur += "La mention doit faire entre 4 et 11 characters "
              + "et commence par une majuscule.\n";
    }
    if (!Validateur.validerComplement(complement)) {
      messageErreur += "Le complément doit faire maximum 100 characters.\n";
    }
    if (!Validateur.validerNomPropre(nomVoie)) {
      messageErreur += "Doit commencer par une majuscule et ne doit"
              + " pas contenir plusieurs tiret ou espace d'affiler\n";
    }
    if (!Validateur.validerNombre(numeroAdresse)) {
      messageErreur += "Le Siret doit être composer de 14 chiffres.\n";
    }
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
    if (!Validateur.validerNumTel(numTelSaisi)) {
      messageErreur += "Le numéro de téléphone doit faire 10 chiffres"
              + " dont les 2 premier vont de 01 à 09 \n";
    }
    if (!Validateur.validerCodePostal(codePostSaisi)) {
      messageErreur += "Seul les département de la France métropolitaine"
              + " + corse sont autoriser.\n";
    }
    if (!Validateur.validerPays(paysSaisi)) {
      messageErreur += "La France est le seul pays autoriser pour le moment.\n";
    }
    if (!Validateur.validerMdp(mdpSaisi)) {
      messageErreur += """
              Le mot de passe doit contenir : \n- Au moins une minuscule une majuscule
              \n- Au moins un chiffre \n- Au moins un character spéciale
              \n- doit faire plus de 8 characters. \n""";
    }
    if (!Validateur.validerMail(mailSaisi)) {
      messageErreur += "Le mail ne doit contenir plusieurs points, tiret ou tiret du bas d'affiler."
              + "\nLe mail doit contenir un @ suivi d'un nom de domaine.";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }
    SessionAdmin session = (SessionAdmin) SingleSession.getSession();
    //Admin admin = (Admin) session.getUtilisateur();
    ListeProducteurs listeProducteurs = session.getListeProducteurs();



    Adresse adresse = new Adresse(paysSaisi, codePostSaisi, villeSaisi, typeVoie, nomVoie,
            Integer.parseInt(numeroAdresse), mention, complement);

    Connection singleConnection = SingleConnection.getInstance();
    Producteur edit = new ProducteurDao(singleConnection).get(siretSaisi);

    if (edit == null) {
      listeProducteurs.ajouter(new Producteur(siretSaisi,  mailSaisi, nomSaisi, prenomSaisi,
              numTelSaisi, mdpSaisi, adresse));
    } else {
      listeProducteurs.editer(new Producteur(siretSaisi,  mailSaisi, nomSaisi, prenomSaisi,
              numTelSaisi, mdpSaisi, adresse));
    }
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void cancel() {
    fenetre.close();
  }

}