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
  private Label lblVoiture;
  private ChoiceBox client;
  private ChoiceBox voitureForm;
  private Label dateLabel;
  private DatePicker date;
  private Label heureDebLabel;
  private TextField heureDeb;
  private Label heureFinLabel;
  private TextField heureFin;
  private Button enregistrer;
  private Button annuler;

  private Label getLibelleLabel() {
    return libelleLabel;
  }

  private TextField getLibelle() {
    return libelle;
  }

  private Label getPoidsLabel() {
    return poidsLabel;
  }

  private TextField getPoids() {
    return poids;
  }

  private Label getClientLabel() {
    return clientLabel;
  }

  private Label getLblVoiture() {
    return lblVoiture;
  }

  private ChoiceBox getClient() {
    return client;
  }

  private ChoiceBox getVoitureForm() {
    return voitureForm;
  }

  private Label getDateLabel() {
    return dateLabel;
  }

  private DatePicker getDate() {
    return date;
  }

  private Label getHeureDebLabel() {
    return heureDebLabel;
  }

  private TextField getHeureDeb() {
    return heureDeb;
  }

  private Label getHeureFinLabel() {
    return heureFinLabel;
  }

  private TextField getHeureFin() {
    return heureFin;
  }

  private Button getEnregistrer() {
    return enregistrer;
  }

  private Button getAnnuler() {
    return annuler;
  }

  private void setLibelleLabel(Label libelleLabel) {
    this.libelleLabel = libelleLabel;
  }

  private void setLibelle(TextField libelle) {
    this.libelle = libelle;
  }

  private void setPoidsLabel(Label poidsLabel) {
    this.poidsLabel = poidsLabel;
  }

  private void setPoids(TextField poids) {
    this.poids = poids;
  }

  private void setClientLabel(Label clientLabel) {
    this.clientLabel = clientLabel;
  }

  private void setLblVoiture(Label lblVoiture) {
    this.lblVoiture = lblVoiture;
  }

  private void setClient(ChoiceBox client) {
    this.client = client;
  }

  private void setVoitureForm(ChoiceBox voitureForm) {
    this.voitureForm = voitureForm;
  }

  private void setDateLabel(Label dateLabel) {
    this.dateLabel = dateLabel;
  }

  private void setDate(DatePicker date) {
    this.date = date;
  }

  private void setHeureDebLabel(Label heureDebLabel) {
    this.heureDebLabel = heureDebLabel;
  }

  private void setHeureDeb(TextField heureDeb) {
    this.heureDeb = heureDeb;
  }

  private void setHeureFinLabel(Label heureFinLabel) {
    this.heureFinLabel = heureFinLabel;
  }

  private void setHeureFin(TextField heureFin) {
    this.heureFin = heureFin;
  }

  private void setEnregistrer(Button enregistrer) {
    this.enregistrer = enregistrer;
  }

  private void setAnnuler(Button annuler) {
    this.annuler = annuler;
  }
}