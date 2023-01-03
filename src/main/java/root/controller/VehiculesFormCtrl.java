package root.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.StageUtil;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.ListeVehicules;
import root.model.Producteur;
import root.model.SessionProducteur;
import root.model.SingleSession;
import root.model.Vehicule;
import root.view.ConnexionView;
import root.view.VehiculesFormView;
import root.view.VehiculesView;

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un véhicule.
 */
public class VehiculesFormCtrl implements Initializable {

  @FXML
  private Pane root;

  @FXML
  private TextField immatriculation;
  @FXML
  private TextField poidsMax;

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
   * Charge les champs du formulaire lors d'une édition.
   *
   * @param modeleObj Le véhicule à éditer.
   */
  public void chargeChamps(Object modeleObj) {
    Vehicule modele = (Vehicule) modeleObj;

    immatriculation.setText(modele.getImmat());
    poidsMax.setText(String.valueOf(modele.getPoidsMax()));
  }

  /**
   * Initialise la vue.
   *
   * @param url L'URL de la vue.
   * @param resourceBundle Les ressources de la vue.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
