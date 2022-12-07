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

  /**
   * Texte à côté du champ de texte pour le libelle de la tournée.
   */
  private Label libelleLabel;
  /**
   * Champ de texte pour écrire le libelle de la tournée.
   *
   * @see TourneesFormView#getLibelle()
   */
  private TextField libelle;
  /**
   * Texte à côté du calendrier pour la date de la tournée.
   */
  private Label dateLabel;
  /**
   * Calendrier pour choisir la date de la tournée.
   *
   * @see TourneesFormView#getDate()
   */
  private DatePicker date;
  /**
   * Texte à côté du menu déroulant pour le véhicule à utiliser pour la tournée.
   */
  private Label vehiculeLabel;
  /**
   * Menu déroulant pour choisir un véhicule pour la tournée.
   *
   * @see TourneesFormView#getVehicule()
   */
  private ChoiceBox vehicule;
  /**
   * Texte à côté de la liste des commandes à mettre dans la tournée.
   */
  private Label commandesLabel;
  /**
   * Liste des commandes à choisir pour la tournée.
   *
   * @see TourneesFormView#getCommandes()
   */
  private ListView commandes;
  /**
   * Permet d'afficher le message d'erreur.
   */
  private Label message;
  /**
   * Bouton pour enregistrer les champs du formulaire.
   */
  private Button enregistrer;
  /**
   * Bouton pour annuler le formulaire.
   */
  private Button annuler;

  /**
   * TODO
   */
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
