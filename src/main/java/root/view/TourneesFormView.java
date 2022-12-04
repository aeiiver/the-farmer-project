package root.view;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

  public TourneesFormView() {

  }

  public String getLibelle() {
    return null;
  }

  public String getDate() {
    return null;
  }

  public String getVehicule() {
    return null;
  }

  public ArrayList<String> getCommandes() {
    // hint: commandes.getSelectionModel().getSelectedItems() stuff...
    return null;
  }

  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
