package root.controller;


import root.view.ClientsView;
import root.view.CommandesView;
import root.view.CompteView;
import root.view.TableaudebordView;
import root.view.TourneesView;
import root.view.VehiculesView;

/**
 * Classe contrôleuse pour la vue et modèle du tableau de bord.
 */
public class TableaudebordCtrl {

  private root.model.listeTournees listeTournees;
  private root.model.listeCommandes listeCommandes;

  private TableaudebordView tableaudebordView;
  private CommandesView commandesView;
  private TourneesView tourneesView;
  private CompteView compteView;
  private ClientsView clientsView;
  private VehiculesView vehiculesView;

  /**
   * Constructeur de classe.
   * <p>
   * Le contrôleur a besoin de connaître les autres vues pour permettre à
   * l'utilisateur de naviguer sur le menu.
   * </p>
   *
   * @param listeTournees     Le modèle correspondant à la liste des tournées.
   * @param listeCommandes    Le modèle correspondant à la liste des commandes.
   * @param tableaudebordView La vue sur le tableau de bord.
   * @param commandesView     La vue sur la liste des commandes.
   * @param tourneesView      La vue sur le liste des tournées
   * @param compteView        La vue sur l'écran du compte.
   * @param clientsView       La vue sur la liste des clients.
   * @param vehiculesView     La vue sur la liste des véhicules.
   */
  public TableaudebordCtrl(root.model.listeTournees listeTournees, root.model.listeCommandes listeCommandes,
                           TableaudebordView tableaudebordView, CommandesView commandesView,
                           TourneesView tourneesView, CompteView compteView,
                           ClientsView clientsView, VehiculesView vehiculesView) {
    this.listeTournees = listeTournees;
    this.listeCommandes = listeCommandes;
    this.tableaudebordView = tableaudebordView;
    this.commandesView = commandesView;
    this.tourneesView = tourneesView;
    this.compteView = compteView;
    this.clientsView = clientsView;
    this.vehiculesView = vehiculesView;
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des commandes.
   */
  public void goToMenuCommandes() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des tournées.
   */
  public void goToMenuTournees() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur son compte.
   */
  public void goToMenuCompte() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des clients.
   */
  public void goToMenuClients() {
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des véhicules.
   */
  public void goToMenuVehicules() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire d'ajout d'une tournée.
   */
  public void ajouterTournee() {
  }

  /**
   * Reflète la suppression d'une tournée dans le modèle correspondant.
   */
  public void supprimerTournee() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire de modification d'une tournée.
   */
  public void editerTournee() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire d'ajout d'une commande.
   */
  public void ajouterCommande() {
  }

  /**
   * Reflète la suppression d'une commande dans le modèle correspondant.
   */
  public void supprimerCommande() {
  }

  /**
   * Redirige l'utilisateur vers la vue du formulaire de modification d'une commande.
   */
  public void editerCommande() {
  }

}
