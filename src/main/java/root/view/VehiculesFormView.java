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
  private Label poidsLabel;
  private TextField poids;
  private Button enregistrer;
  private Button annuler;

  private Label getImmatLabel() {
    return immatLabel;
  }

  private TextField getImmat() {
    return immat;
  }

  private Label getPoidsLabel() {
    return poidsLabel;
  }

  private TextField getPoids() {
    return poids;
  }

  private Button getEnregistrer() {
    return enregistrer;
  }

  private Button getAnnuler() {
    return annuler;
  }

  private void setImmatLabel(Label immatLabel) {
    this.immatLabel = immatLabel;
  }

  private void setImmat(TextField immat) {
    this.immat = immat;
  }

  private void setPoidsLabel(Label poidsLabel) {
    this.poidsLabel = poidsLabel;
  }

  private void setPoids(TextField poids) {
    this.poids = poids;
  }

  private void setEnregistrer(Button enregistrer) {
    this.enregistrer = enregistrer;
  }

  private void setAnnuler(Button annuler) {
    this.annuler = annuler;
  }
}