package root.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.model.Adresse;
/**
 * Classe de vue pour le formulaire d'ajout d'un client.
 */
public class ClientsFormView {
  private Label nomLabel;
  private TextField nom;
  private Label prenomLabel;
  private TextField prenom;
  private Label numTelLabel;
  private TextField numTel;
  private Label coordonneesLabel;
  private TextField latitude;
  private TextField longitude;
  private Adresse adresseLabel;
  private TextField adresse;
  private Label villeLabel;
  private TextField ville;
  private Label codePostLabel;
  private TextField codePost;
  private Button enregistrer;
  private Button annuler;

  private Label getNomLabel() {
    return nomLabel;
  }

  private TextField getNomForm() {
    return nom;
  }

  private Label getPrenomLabel() {
    return prenomLabel;
  }

  private TextField getPrenomForm() {
    return prenom;
  }

  private Label getNumTelLabel() {
    return numTelLabel;
  }

  private TextField getNumTelForm() {
    return numTel;
  }

  private Label getCoordonneesLabel() {
    return coordonneesLabel;
  }

  private TextField getLatitudeForm() {
    return latitude;
  }

  private TextField getLongitudeForm() {
    return longitude;
  }

  private Adresse getAdresseLabel() {
    return adresseLabel;
  }

  private TextField getAdresseForm() {
    return adresse;
  }

  private Label getVilleLabel() {
    return villeLabel;
  }

  private TextField getVilleForm() {
    return ville;
  }

  private Label getCodePostLabel() {
    return codePostLabel;
  }

  private TextField getCodePostForm() {
    return codePost;
  }

  private Button getEnregistrer() {
    return enregistrer;
  }

  private Button getAnnuler() {
    return annuler;
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

  private void setCoordonneesLabel(Label coordonneesLabel) {
    this.coordonneesLabel = coordonneesLabel;
  }

  private void setLatitude(TextField latitude) {
    this.latitude = latitude;
  }

  private void setLongitude(TextField longitude) {
    this.longitude = longitude;
  }

  private void setAdresseLabel(Adresse adresseLabel) {
    this.adresseLabel = adresseLabel;
  }

  private void setAdresse(TextField adresse) {
    this.adresse = adresse;
  }

  private void setVilleLabel(Label villeLabel) {
    this.villeLabel = villeLabel;
  }

  private void setVille(TextField ville) {
    this.ville = ville;
  }

  private void setCodePostLabel(Label codePostLabel) {
    this.codePostLabel = codePostLabel;
  }

  private void setCodePost(TextField codePost) {
    this.codePost = codePost;
  }

  private void setEnregistrer(Button enregistrer) {
    this.enregistrer = enregistrer;
  }

  private void setAnnuler(Button annuler) {
    this.annuler = annuler;
  }

  public void getNom() {
  }

  public void getPrenom() {
  }

  public void getNumTel() {

  }

  public void getLatitude() {
  }

  public void getLongitude() {
  }


  public void getAdresse() {
  }

  public void getVille() {
  }

  public void getCodePost() {
  }

  public void setMessageErreur() {
  }

  public void setMessageOk() {
  }
}