package root.controller;


import root.model.ListeCommandes;
import root.model.ListeTournees;
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

  /**
   * Listes des tournées sur le tableau de bord.
   *
   * @see TableaudebordCtrl#TableaudebordCtrl(ListeTournees, ListeCommandes,
   * TableaudebordView, CommandesView, TourneesView, CompteView, ClientsView,
   * VehiculesView)
   */
  private ListeTournees listeTournees;

  /**
   * Liste des commandes sur le tableau de bord.
   *
   * @see TableaudebordCtrl#TableaudebordCtrl(ListeTournees, ListeCommandes,
   * TableaudebordView, CommandesView, TourneesView, CompteView, ClientsView,
   * VehiculesView)
   */
  private ListeCommandes listeCommandes;

  /**
   * Vue du tableau de bord.
   *
   * @see TableaudebordCtrl#TableaudebordCtrl(ListeTournees, ListeCommandes,
   * TableaudebordView, CommandesView, TourneesView, CompteView, ClientsView,
   * VehiculesView)
   */
  private TableaudebordView tableaudebordView;

  /**
   * Vue de la liste des commandes.
   */
  private CommandesView commandesView;

  /**
   * Vue de la liste des tournées.
   */
  private TourneesView tourneesView;

  /**
   * Vue du compte.
   */
  private CompteView compteView;

  /**
   * Vue de la liste des clients.
   */
  private ClientsView clientsView;

  /**
   * Vue de la liste des véhicules.
    */
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
   * @param tourneesView      La vue sur la liste des tournées
   * @param compteView        La vue sur l'écran du compte.
   * @param clientsView       La vue sur la liste des clients.
   * @param vehiculesView     La vue sur la liste des véhicules.
   */
  public TableaudebordCtrl(ListeTournees listeTournees, ListeCommandes listeCommandes,
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
