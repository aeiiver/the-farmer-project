package root.view;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Classe de vue pour le formulaire d'ajout d'une tournée.
 */
public class TourneesFormView {
  private TextField id;
  private TextField mdp;
  private Label idLbl;
  private Label libelleLabel;
  private Label idMdp;
  private TextField libelle;
  private Label dateLabel;
  private DatePicker date;
  private Label vehiculeLabel;
  private ChoiceBox vehicule;

  private TextField getId() {
    return id;
  }

  private TextField getMdp() {
    return mdp;
  }

  private Label getIdLbl() {
    return idLbl;
  }

  private Label getLibelleLabel() {
    return libelleLabel;
  }

  private Label getIdMdp() {
    return idMdp;
  }

  private TextField getLibelle() {
    return libelle;
  }

  private Label getDateLabel() {
    return dateLabel;
  }

  private DatePicker getDate() {
    return date;
  }

  private Label getVehiculeLabel() {
    return vehiculeLabel;
  }

  private ChoiceBox getVehicule() {
    return vehicule;
  }

  private void setId(TextField id) {
    this.id = id;
  }

  private void setMdp(TextField mdp) {
    this.mdp = mdp;
  }

  private void setIdLbl(Label idLbl) {
    this.idLbl = idLbl;
  }

  private void setLibelleLabel(Label libelleLabel) {
    this.libelleLabel = libelleLabel;
  }

  private void setIdMdp(Label idMdp) {
    this.idMdp = idMdp;
  }

  private void setLibelle(TextField libelle) {
    this.libelle = libelle;
  }

  private void setDateLabel(Label dateLabel) {
    this.dateLabel = dateLabel;
  }

  private void setDate(DatePicker date) {
    this.date = date;
  }

  private void setVehiculeLabel(Label vehiculeLabel) {
    this.vehiculeLabel = vehiculeLabel;
  }

  private void setVehicule(ChoiceBox vehicule) {
    this.vehicule = vehicule;
  }
}