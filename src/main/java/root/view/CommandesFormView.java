package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour le formulaire d'ajout d'une commande.
 */
public class CommandesFormView {

  private Label libelleLabel;
  private TextField libelle;
  private Label poidsLabel;
  private TextField poids;
  private Label clientLabel;
  private ChoiceBox client;
  private Label dateLabel;
  private DatePicker date;
  private Label heureDebLabel;
  private TextField heureDeb;
  private Label heureFinLabel;
  private TextField heureFin;
  private Label message;
  private Button enregistrer;
  private Button annuler;

  public CommandesFormView() {

  }

  public String getLibelle() {
    return null;
  }

  public String getPoids() {
    return null;
  }

  public String getClient() {
    return null;
  }

  public String getDate() {
    return null;
  }

  public String getHeureDeb() {
    return null;
  }

  public String getHeureFin() {
    return null;
  }

  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
