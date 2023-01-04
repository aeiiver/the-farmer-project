package root.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import root.StageUtil;
import root.controller.ClientsFormCtrl;
import root.model.Client;

/**
 * Classe de vue pour le formulaire d'ajout d'un client.
 */
public class ClientsFormView implements Initializable, FormView<Client> {

  /**
   * L'élément racine du fichier FXML chargé.
   */
  @FXML
  private Pane root;
  /**
   * Champ de texte pour écrire le nom du client.
   */
  @FXML
  private TextField nom;
  /**
   * Champ de texte pour écrire le prénom du client.
   */
  @FXML
  private TextField prenom;
  /**
   * Champ de texte pour écrire le numéro de téléphone du client.
   */
  @FXML
  private TextField numTel;
  /**
   * Champ de texte pour écrire la latitude des coordonnées du client.
   */
  @FXML
  private TextField gps;
  /**
   * Champ de texte pour écrire le pays du client.
   */
  @FXML
  private TextField pays;
  /**
   * Champ de texte pour écrire le nom de la ville du client.
   */
  @FXML
  private TextField ville;
  /**
   * Champ de texte pour écrire le code postal du client.
   */
  @FXML
  private TextField codePostal;
  /**
   * Champ de texte pour écrire l'adresse du client.
   */
  @FXML
  private TextField adresse;

  /**
   * Contrôleur de la vue.
   */
  private ClientsFormCtrl ctrl;

  @FXML
  private void valider() {
    // TODO
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    StageUtil.onWindowLoad(root, () -> {
      Stage fenetre = StageUtil.getFenetre(root);
      ctrl = new ClientsFormCtrl(fenetre);
    });
  }

  @Override
  public void chargeChamps(Client client) {
    // TODO
  }

}
