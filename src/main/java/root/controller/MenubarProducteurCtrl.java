package root.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import root.Main;
import root.StageUtil;
import root.data.ClientDao;
import root.data.CommandeDao;
import root.data.SingleConnection;
import root.data.VehiculeDao;
import root.model.*;

/**
 * Contrôleur associé à la barre de menus.
 */
public class MenubarProducteurCtrl {

  @FXML
  private MenuBar root;

  @FXML
  private void gotoTableaudebord() {
    changeScene("/root/controller/fxml/Tableaudebord.fxml");
  }

  @FXML
  private void gotoListeCommandes() {

    // On définit les colonnes qu'on veut afficher...
    TableColumn<Commande, String> numero = new TableColumn<>("Numéro");
    TableColumn<Commande, String> libelle = new TableColumn<>("Libellé");
    TableColumn<Commande, String> poids = new TableColumn<>("Poids");
    TableColumn<Commande, String> date = new TableColumn<>("Date");
    TableColumn<Commande, String> heureDeb = new TableColumn<>("Heure de départ");
    TableColumn<Commande, String> heureFin = new TableColumn<>("Heure de fin");
    TableColumn<Commande, String> client = new TableColumn<>("Client");

    final List<TableColumn<Commande, String>> colonnes =
        List.of(numero, libelle, poids, date, heureDeb, heureFin, client);
    final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    // On définit pour chaque colonne quelle partie de l'objet "Commande" on veut afficher...
    numero.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNumCom())));
    libelle.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getLibelle())));
    poids.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPoids())));
    date.setCellValueFactory(
        cell -> new SimpleStringProperty(dateFormatter.format(cell.getValue().getDateCom())));
    heureDeb.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureDeb())));
    heureFin.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getHeureFin())));
    client.setCellValueFactory(
        cell -> new SimpleStringProperty(cell.getValue().getClient().getPrenomNom()));

    ObservableList<Commande> commandes =
        (ObservableList<Commande>) ((SessionProducteur) SingleSession.getSession())
            .getListeCommandes()
            .getCommandes();
    CommandeDao dao = new CommandeDao(SingleConnection.getInstance());
    String ressourceForm = "/root/controller/fxml/FormCommande.fxml";

    TableauDonneesCtrl ctrl =
        (TableauDonneesCtrl) changeScene("/root/controller/fxml/TableauDonnees.fxml");
    ctrl.initialiseDonnees("Mes commandes", commandes, colonnes, dao, ressourceForm);
  }

  @FXML
  private void gotoListeTournees() {
    // Change la scène vers liste des tournées
    throw new RuntimeException("Not implemented");
  }

  @FXML
  private void gotoListeVehicules() {
    TableColumn<Vehicule, String> immat = new TableColumn<>("Immatriculation");
    TableColumn<Vehicule, String> poidsMax = new TableColumn<>("Charge maximale supportée");

    final List<TableColumn<Vehicule, String>> colonnes = List.of(immat, poidsMax);

    immat.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getImmat())));
    poidsMax.setCellValueFactory(
        cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPoidsMax())));

    ObservableList<Vehicule> vehicules =
        (ObservableList<Vehicule>) ((SessionProducteur) SingleSession.getSession())
        .getListeVehicules()
        .getVehicules();
    VehiculeDao dao = new VehiculeDao(SingleConnection.getInstance());
    String ressourceForm = "/root/controller/fxml/FormVehicule.fxml";

    TableauDonneesCtrl ctrl =
        (TableauDonneesCtrl) changeScene("/root/controller/fxml/TableauDonnees.fxml");
    ctrl.initialiseDonnees("Mes véhicules", vehicules, colonnes, dao, ressourceForm);
  }

  @FXML
  private void gotoListeClients() {
    // On définit les colonnes qu'on veut afficher...
    TableColumn<Client, String> nom = new TableColumn<>("Nom");
    TableColumn<Client, String> prenom = new TableColumn<>("Prénom");
    TableColumn<Client, String> numTel = new TableColumn<>("Numéro de Téléphone");
    TableColumn<Client, String> gps = new TableColumn<>("Coordonnées GPS");
    TableColumn<Client, String> adresse = new TableColumn<>("Adresse");

    final List<TableColumn<Client, String>> colonnes =
            List.of(nom, prenom, numTel, gps, adresse);
    final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    // On définit pour chaque colonne quelle partie de l'objet "Client" on veut afficher...
    nom.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNom())));
    prenom.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPrenom())));
    numTel.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getNumTel())));
    gps.setCellValueFactory(
            cell -> new SimpleStringProperty(String.format(cell.getValue().getGps())));
    adresse.setCellValueFactory(
            cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getAdresse())));

    ObservableList<Client> clients =
            (ObservableList<Client>) ((SessionProducteur) SingleSession.getSession())
                    .getListeClients()
                    .getClients();
    ClientDao dao = new ClientDao(SingleConnection.getInstance());
    String ressourceForm = "/root/controller/fxml/FormClient.fxml";

    TableauDonneesCtrl ctrl =
            (TableauDonneesCtrl) changeScene("/root/controller/fxml/TableauDonnees.fxml");
    ctrl.initialiseDonnees("Mes clients", clients, colonnes, dao, ressourceForm);
  }

  @FXML
  private void gotoFormCommande() {
    StageUtil.afficheDialogue("/root/controller/fxml/FormCommande.fxml",
        StageUtil.getFenetre(root));
  }

  @FXML
  private void gotoFormTournee() {
    // Change la scène vers le formulaire "Tournée"
    throw new RuntimeException("Not implemented");
  }

  @FXML
  private void gotoFormVehicule() {
    StageUtil.afficheDialogue("/root/controller/fxml/FormVehicule.fxml",
        StageUtil.getFenetre(root));
  }

  @FXML
  private void gotoFormClient() {
    StageUtil.afficheDialogue("/root/controller/fxml/FormClient.fxml", StageUtil.getFenetre(root));
  }

  @FXML
  private void gotoCompte() {
    // Change la scène vers le compte producteur
    throw new RuntimeException("Not implemented");
  }

  @FXML
  private void deconnexion() {
    SingleSession.fermeSession();
    changeScene("/root/controller/fxml/Connexion.fxml");
  }

  /**
   * Change de scène et retourne le contrôleur associé à la vue chargée.
   *
   * <p>Le contrôleur est retourné pour permettre d'agir dessus si besoin.</p>
   *
   * @param ressourceFxml Chemin vers la ressource FXML.
   * @return Le contrôleur qui a été associé à la vue.
   */
  private Object changeScene(String ressourceFxml) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource(ressourceFxml));

    Parent newRoot;
    try {
      newRoot = loader.load();

    } catch (IOException e) {
      System.out.println("Quelque chose de très fondamental vient de casser...");
      System.out.printf("Voir : %s.changeScene()", getClass());
      throw new RuntimeException(e);
    }

    // Changement de scène sur la fenêtre courante
    Stage fenetre = StageUtil.getFenetre(root);
    fenetre.setScene(new Scene(newRoot));

    return loader.getController();
  }

}
