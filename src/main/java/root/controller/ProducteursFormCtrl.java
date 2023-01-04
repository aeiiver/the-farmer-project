package root.controller;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import root.StageUtil;
import root.data.ProducteurDao;
import root.data.SingleConnection;
//import root.data.VehiculeDao;
import root.model.Admin;
import root.model.Adresse;
import root.model.ListeProducteurs;
import root.model.Producteur;
import root.model.SessionAdmin;
import root.model.SingleSession;
import root.view.ProducteursFormView;



/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un producteur.
 */
public class ProducteursFormCtrl implements FormView<Producteur> {

  @FXML
  private Pane root;
  /**
   * Modèle du formulaire d'ajout et modification d'un producteur.
   *
   * @see ProducteursFormCtrl#getModel()
   */
  private ListeProducteurs model;

  /**
   * Vue du formulaire d'ajout et modification d'un producteur.
   *
   * @see ProducteursFormCtrl#getView()
   */
  private ProducteursFormView view;

  @FXML
  private TextField siret;

  @FXML
  private TextField nom;

  @FXML
  private TextField prenom;

  @FXML
  private TextField numTel;

  @FXML
  private TextField adresse;

  @FXML
  private TextField ville;

  @FXML
  private TextField codePost;

  @FXML
  private TextField pays;

  @FXML
  private PasswordField mdp;

  @FXML
  private TextField mail;

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void enregistrer() {
    String siretSaisi = siret.getText();
    String nomSaisi = nom.getText();
    String prenomSaisi = prenom.getText();
    String numTelSaisi = numTel.getText();
    String adresseSaisi = adresse.getText();
    String codePostSaisi = codePost.getText();
    String paysSaisi = pays.getText();
    String mdpSaisi = mdp.getText();
    String mailSaisi = mail.getText();
    String villeSaisi = ville.getText();

    if (siretSaisi.isEmpty() || nomSaisi.isEmpty() || prenomSaisi.isEmpty()
            || numTelSaisi.isEmpty() || adresseSaisi.isEmpty() || codePostSaisi.isEmpty()
            || paysSaisi.isEmpty() || paysSaisi.isEmpty() || mdpSaisi.isEmpty()
            || mailSaisi.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
              StageUtil.getFenetre(root));
      return;
    }

    String messageErreur = "";
    if (!siretSaisi.matches("^([0-9] ?){14}$")) {
      messageErreur += "Le Siret doit être composer de 14 chiffres.\n";
    }
    if (!villeSaisi.matches("^[A-Z]([' -a-zA-Z]{2,100})$")) {
      //Todo revoir le regex de la ville et adapter le message d'erreur
      messageErreur += "La ville doit faire entre 2 et 100 characters,"
              + " commencer par une majuscule, les accent sont exclus.\n";
    }
    if (!nomSaisi.matches("^[A-Z](a-z)+([ -A-Z](a-z)+)*$")) {
      //Todo revoir le regex du nom et adapter le message d'erreur
      messageErreur += "Le nom doit commencer par une majuscule et ne doit "
              + "pas contenir plusieurs tiret ou espace d'affiler\n";
    }
    if (!prenomSaisi.matches("^[A-Z](a-z)+([ -A-Z](a-z)+)*$")) {
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
    if (!mailSaisi.matches("^[A-Za-z0-9]+([-_.][A-Za-z0-9]+)*@[A-Za-z0-9]+"
            + "([-_.][A-Za-z0-9]+)*\\.[a-z]{2,}$")) {
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
    StageUtil.getFenetre(root).close();
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeProducteurs getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeProducteurs model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public ProducteursFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(ProducteursFormView view) {
    this.view = view;
  }

  @Override
  public void chargeChamps(Producteur modele) {
    // TODO implémenter
  }

}
