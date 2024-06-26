package root.controller;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import root.StageUtil;
import root.data.Dao;
import root.view.form.FormView;

/**
 * Contrôleur de la vue "TableauDonnees".
 *
 * <ul>
 *   <li>Le titre de la vue doit être changé pour correspondre au menu sélectionné.</li>
 *   <li>Le tableau de la vue doit être rempli avec les données correspondantes.</li>
 * </ul>
 */
public class TableauDonneesCtrl {

  @FXML
  private VBox root;
  @FXML
  private Label titre;
  @FXML
  private TableView<Object> tableau;

  private ObservableList models;
  private Dao dao;
  private String ressourceForm;

  /**
   * Initialise l'affichage de la vue.
   *
   * <p>Les colonnes du tableau doivent être préparées pour afficher les données de la façon
   * attendue.</p>
   *
   * @param titre         Le titre de la vue.
   * @param modeles       Les données du tableau.
   * @param colonnes      Les colonnes qui ont été préparées au préalable.
   * @param dao           Le DAO pour les données du tableau
   * @param ressourceForm La ressource FXML correspondant au formulaire d'ajout / modification
   */
  public void initialiseDonnees(String titre, ObservableList modeles, List colonnes, Dao dao,
                                String ressourceForm) {
    this.models = modeles;
    this.dao = dao;
    this.ressourceForm = ressourceForm;

    this.titre.setText(titre);
    tableau.getColumns().setAll(colonnes);
    tableau.setItems(modeles);
    tableau.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
  }

  /**
   * Ouvre la fenêtre de création d'un modèle.
   */
  @FXML
  private void ajouter() {
    StageUtil.afficheDialogue(ressourceForm, StageUtil.getFenetre(root));
  }

  /**
   * Ouvre la fenêtre de suppresion d'un modèle.
   */
  @FXML
  private void supprimer() {
    Object modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Supprimer" avec aucune sélection
    if (modele == null) {
      return;
    }

    models.remove(modele);
    dao.delete(modele);
  }

  /**
   * Ouvre la fenêtre de modification d'un modèle.
   */
  @FXML
  private void editer() {
    Object modele = tableau.getSelectionModel().getSelectedItem();

    // Ne rien faire si on clique sur "Editer" avec aucune sélection
    if (modele == null) {
      return;
    }

    FormView ctrl = (FormView) StageUtil.afficheDialogue(ressourceForm, StageUtil.getFenetre(root));
    ctrl.chargeChamps(modele);
  }

  /**
   * Retourne l'élément sélectionné dans le tableau.
   *
   * @return L'élément sélectionné dans le tableau.
   */
  @FXML
  public Object getSelected() {
    return tableau.getSelectionModel().getSelectedItem();
  }

}
