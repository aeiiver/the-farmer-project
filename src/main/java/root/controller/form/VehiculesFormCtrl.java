package root.controller.form;

import java.sql.Connection;
import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.Validateur;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.Producteur;
import root.model.Vehicule;
import root.model.list.ListeVehicules;
import root.model.session.SessionUtilisateur;
import root.model.session.SingleSession;


/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un véhicule.
 */
public class VehiculesFormCtrl {

  private Stage fenetre;

  public VehiculesFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void enregistrer(String immat, String poidsMax) {
    if (immat.isEmpty() || poidsMax.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseignés.", fenetre);
      return;
    }

    String messageErreur = "";
    if (!Validateur.validerImmatriculation(immat)) {
      messageErreur += "L'immatriculation doit être au format XX-000-XX.\n";
    }
    if (!Validateur.validerNombre(poidsMax)) {
      messageErreur += "Le poids doit être un nombre entier.\n";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }
    int poidsValide = Integer.parseInt(poidsMax);

    String immatriculation = immat;
    if (!immat.contains("-") && !immat.contains(" ")) {
      immatriculation = immat.substring(0, 2) + "-" + immat.substring(2, 5) + "-"
              + immat.substring(5, 7);
    }
    immatriculation.replace(" ", "-");

    SessionUtilisateur session = SingleSession.getSession();
    Producteur producteur = (Producteur) session.getUtilisateur();
    ListeVehicules listeVehicules = new ListeVehicules();

    Connection singleConnection = SingleConnection.getInstance();
    Vehicule edit = new VehiculeDao(singleConnection).get(immatriculation);
    if (edit == null) {
      listeVehicules.ajouter(new Vehicule(immatriculation, poidsValide, producteur));
    } else {
      listeVehicules.editer(new Vehicule(immatriculation, poidsValide, producteur));
    }

    fenetre.close();
    SceneChanger.voirTableaudebord(fenetre);
    SceneChanger.voirListeVehicules(fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void annuler() {
    fenetre.close();
  }

}
