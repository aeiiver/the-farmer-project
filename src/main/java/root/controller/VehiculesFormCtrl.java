package root.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.*;
import root.view.ConnexionView;
import root.view.VehiculesFormView;
import root.view.VehiculesView;

import java.sql.Connection;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un véhicule.
 */
public class VehiculesFormCtrl extends MainCtrl  {

  @FXML
  private Pane root;

  /**
   * Modèle de la liste des véhicules.
   *
   * @see VehiculesFormCtrl#getModel()
   */
  private ListeVehicules model;

  /**
   * Vue du formulaire d'ajout et modification d'un véhicule.
   *
   * @see VehiculesFormCtrl#getView()
   */
  private VehiculesFormView view;

  @FXML
  private TextField immatriculation;
  @FXML
  private TextField poidsMax;

  /**
   * Constructeur de la classe.
   */
  public VehiculesFormCtrl(Stage primaryStage) {
    super(primaryStage);
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void enregistrer() {
    String immat = immatriculation.getText();
    String poids = poidsMax.getText();

    if (immat.isEmpty() || poids.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.",
          StageUtil.getFenetre(root));
      return;
    }

    String messageErreur = "";
    if (!immat.matches("[A-Z]{2}-[0-9]{3}-[A-Z]{2}")) {
      messageErreur += "L'immatriculation doit être au format XX-000-XX\n";
    }
    if (!poids.matches("[0-9]+")) {
      messageErreur += "Le poids doit être un nombre entier\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, StageUtil.getFenetre(root));
      return;
    }
    int poidsValide = Integer.parseInt(poids);

    SessionProducteur session = (SessionProducteur) SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeVehicules listeVehicules = session.getListeVehicules();

    Connection singleConnection = SingleConnection.getInstance();
    Vehicule edit = new VehiculeDao(singleConnection).get(immat);
    if (edit == null) {
      listeVehicules.ajouter(new Vehicule(immat, poidsValide, producteur));
    } else {
      listeVehicules.editer(new Vehicule(immat, poidsValide, producteur));
    }
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void cancel() {
    StageUtil.getFenetre(root).close();
  }

  /**
   * Retourne le modèle associé à ce contrôleur.
   *
   * @return Le modèle.
   */
  public ListeVehicules getModel() {
    return model;
  }

  /**
   * Change le modèle courant avec un nouveau.
   *
   * @param model Le nouveau modèle.
   */
  public void setModel(ListeVehicules model) {
    this.model = model;
  }

  /**
   * Retourne la vue associée à ce contrôleur.
   *
   * @return La vue.
   */
  public VehiculesFormView getView() {
    return view;
  }

  /**
   * Change la vue courante avec une nouvelle.
   *
   * @param view La vue nouvelle.
   */
  public void setView(VehiculesFormView view) {
    this.view = view;
  }

  public void chargeChamps(Object modeleObj) {
    Vehicule modele = (Vehicule) modeleObj;

    immatriculation.setText(modele.getImmat());
    poidsMax.setText(String.valueOf(modele.getPoidsMax()));
  }

}
