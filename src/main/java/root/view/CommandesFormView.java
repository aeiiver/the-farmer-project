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
