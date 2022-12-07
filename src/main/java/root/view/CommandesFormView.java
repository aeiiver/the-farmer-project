package root.view;

import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import root.controller.CommandesFormCtrl;

/**
 * Classe de vue pour le formulaire d'ajout d'une commande.
 */
public class CommandesFormView {

  /**
   * Texte à côté du champ de texte pour le libelle.
   */
  private Label libelleLabel;
  /**
   * Champ de texte pour écrire le nom de la commande.
   *
   * @see CommandesFormView#getLibelle()
   */
  private TextField libelle;
  /**
   * Texte à côté du champ de texte pour le poids.
   */
  private Label poidsLabel;
  /**
   * Champ de texte pour écrire le poids maximum de la commande.
   *
   * @see CommandesFormView#getPoids()
   */
  private TextField poids;
  /**
   * Texte à côté du menu déroulant pour choisir le client à livrer.
   */
  private Label clientLabel;
  /**
   * Menu déroulant pour choisir à quel client appartient la commande.
   *
   * @see CommandesFormView#getClient()
   */
  private ChoiceBox client;
  /**
   * Texte à côté du calendrier pour choisir la date.
   */
  private Label dateLabel;
  /**
   * Calendrier pour choisir la date de la commande.
   *
   * @see CommandesFormView#getDate()
   */
  private DatePicker date;
  /**
   * Texte à côté du champ de texte pour l'heure minimale de livraison.
   */
  private Label heureDebLabel;
  /**
   * Champ de texte pour écrire l'heure minimale de livraison.
   *
   * @see CommandesFormView#getHeureDeb()
   */
  private TextField heureDeb;
  /**
   * Texte à côté du champ de texte pour l'heure maximale de livraison.
   */
  private Label heureFinLabel;
  /**
   * Champ de texte pour écrire l'heure maximale de livraison.
   *
   * @see CommandesFormView#getHeureFin()
   */
  private TextField heureFin;
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
  private CommandesFormCtrl ctrl;

  /**
   * Constructeur de classe.
   *
   * @param ctrl Le contrôleur de cette vue.
   */
  public CommandesFormView(CommandesFormCtrl ctrl) {
    this.ctrl = ctrl;
  }

  /**
   * Retourne la saisie du libelle.
   *
   * @return Le libelle saisi.
   */
  public String getLibelle() {
    return null;
  }

  /**
   * Retourne la saisie du poids.
   *
   * @return Le poids saisie.
   */
  public double getPoids() {
    return 0;
  }

  /**
   * Retourne la saisie du client à qui délivrer la commande.
   *
   * @return Le client saisi.
   */
  public String getClient() {
    return null;
  }

  /**
   * Retourne la saisie de la date de livraison.
   *
   * @return La date de livraison saisie.
   */
  public LocalDate getDate() {
    return date.getValue();
  }

  /**
   * Retourne la saisie de l'heure de livraison minimale.
   *
   * @return L'heure de livraison minimale saisie.
   */
  public int getHeureDeb() {
    return 0;
  }

  /**
   * Retourne la saisie de l'heure de livraison maximale.
   *
   * @return L'heure de livraison maximale saisie.
   */
  public int getHeureFin() {
    return 0;
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
