package root.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Classe de vue pour l'ajout de producteurs.
 */
public class ProducteursFormView {
  private Label siretLabel;
  private TextField siret;
  private Label nomLabel;
  private TextField nom;
  private Label prenomLabel;
  private TextField prenom;
  private Label numTelLabel;
  private TextField numTel;
  private TextField adresseVoie;
  private Label adresseLabel;
  private TextField adresse;
  private Button enregistrer;
  private Button annuler;

  private Label getSiretLabel() {
    return siretLabel;
  }

  private TextField getSiret() {
    return siret;
  }

  private Label getNomLabel() {
    return nomLabel;
  }

  private TextField getNom() {
    return nom;
  }

  private Label getPrenomLabel() {
    return prenomLabel;
  }

  private TextField getPrenom() {
    return prenom;
  }

  private Label getNumTelLabel() {
    return numTelLabel;
  }

  private TextField getNumTel() {
    return numTel;
  }

  private TextField getAdresseVoie() {
    return adresseVoie;
  }

  private Label getAdresseLabel() {
    return adresseLabel;
  }

  private TextField getAdresse() {
    return adresse;
  }

  private Button getEnregistrer() {
    return enregistrer;
  }

  private Button getAnnuler() {
    return annuler;
  }

  private void setSiretLabel(Label siretLabel) {
    this.siretLabel = siretLabel;
  }

  private void setSiret(TextField siret) {
    this.siret = siret;
  }

  private void setNomLabel(Label nomLabel) {
    this.nomLabel = nomLabel;
  }

  private void setNom(TextField nom) {
    this.nom = nom;
  }

  private void setPrenomLabel(Label prenomLabel) {
    this.prenomLabel = prenomLabel;
  }

  private void setPrenom(TextField prenom) {
    this.prenom = prenom;
  }

  private void setNumTelLabel(Label numTelLabel) {
    this.numTelLabel = numTelLabel;
  }

  private void setNumTel(TextField numTel) {
    this.numTel = numTel;
  }

  private void setAdresseVoie(TextField adresseVoie) {
    this.adresseVoie = adresseVoie;
  }

  private void setAdresseLabel(Label adresseLabel) {
    this.adresseLabel = adresseLabel;
  }

  private void setAdresse(TextField adresse) {
    this.adresse = adresse;
  }

  private void setEnregistrer(Button enregistrer) {
    this.enregistrer = enregistrer;
  }

  private void setAnnuler(Button annuler) {
    this.annuler = annuler;
  }
}