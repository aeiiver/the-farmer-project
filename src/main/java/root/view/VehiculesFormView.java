package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour l'ajout de véhicules.
 */
public class VehiculesFormView {

  private Label immatLabel;
  private TextField immat;
  private Label capacitePoidsLabel;
  private TextField capacitePoids;
  private Label message;
  private Button enregistrer;
  private Button annuler;

  public VehiculesFormView() {

  }

  public String getImmat() {
    return null;
  }

  public String getCapacitePoids() {
    return null;
  }

  public void setMessage(String msg) {
    this.message.setText(msg);
  }

}
