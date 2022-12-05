package root.view;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import root.controller.TourneesFormCtrl;
import root.model.Vehicule;

/**
 * Classe de vue pour le formulaire d'ajout d'une tournée.
 */
public class TourneesFormView {

  private Label libelleLabel;
  private TextField libelle;
  private Label dateLabel;
  private DatePicker date;
  private Label vehiculeLabel;
  private ChoiceBox vehicule;
  private Label commandesLabel;
  private ListView commandes;
  private Label message;
  private Button enregistrer;
  private Button annuler;

  private TourneesFormCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public TourneesFormView(TourneesFormCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne le libellé de la tournée saisi.
   *
   * @return Le libellé saisi.
   */
  public String getLibelle() {
    return null;
  }

  /**
   * Retourne la date saisie qui indique le jour où la tournée devra se réaliser.
   *
   * @return La date saisie.
   */
  public LocalDate getDate() {
    return date.getValue();
  }

  /**
   * Retourne le véhicule désigné pour la tournée.
   *
   * @return Le véhicule désigné.
   */
  public Vehicule getVehicule() {
    return null;
  }

  /**
   * Retourne les commandes à insérer dans la tournée.
   *
   * @return La liste des commandes choisies.
   */
  public ArrayList<String> getCommandes() {
    // hint: commandes.getSelectionModel().getSelectedItems() stuff...
    return null;
  }

  /**
   * Change le contenu du message à afficher en cas d'erreur.
   *
   * @param msg Le message à afficher.
   */
  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
