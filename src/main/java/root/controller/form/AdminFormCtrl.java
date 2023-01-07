package root.controller.form;

import java.sql.Connection;
import javafx.stage.Stage;
import root.SceneChanger;
import root.StageUtil;
import root.Validateur;
import root.data.AdminDao;
import root.data.SingleConnection;
import root.model.Admin;
import root.model.session.SessionUtilisateur;
import root.model.session.SingleSession;

//TODO c'est quoi ce travaille de cochon là...

/**
 * Classe contrôleuse pour la vue et modèle du formulaire d'ajout et modification d'un producteur.
 */
public class AdminFormCtrl {

  private Stage fenetre;

  public AdminFormCtrl(Stage fenetre) {
    this.fenetre = fenetre;
  }

  /**
   * Reflète l'ajout ou modification dans le modèle et redirige
   * l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void enregistrer(String mdpSaisi, String mailSaisi,
                          String pseudoSaisi) {

    if (mailSaisi.isEmpty() || pseudoSaisi.isEmpty() || mdpSaisi.isEmpty()) {
      StageUtil.afficheAlerte("Tous les champs doivent être renseigné",
              fenetre);
      return;
    }

    //Todo faire les regex pour l'adresse
    String messageErreur = "";
    if (!Validateur.validerMdp(mdpSaisi)) {
      messageErreur += "Le mot de passe doit contenir : \n- Au moins une minuscule une majuscule"
          + "\n- Au moins un chiffre \n- Au moins un character spéciale"
          + "\n- doit faire plus de 8 characters. \n";
    }
    if (!Validateur.validerMail(mailSaisi)) {
      messageErreur += "Le mail ne doit contenir plusieurs points, tiret ou tiret du bas d'affiler."
              + "\nLe mail doit contenir un @ suivi d'un nom de domaine.";
    }
    if (!Validateur.validerPseudo(pseudoSaisi)) {
      messageErreur += "Le mail ne doit contenir plusieurs points, tiret ou tiret du bas d'affiler."
              + "\nLe mail doit contenir un @ suivi d'un nom de domaine.";
    }
    if (!messageErreur.isEmpty()) {
      StageUtil.afficheAlerte(messageErreur, fenetre);
      return;
    }

    SessionUtilisateur session = SingleSession.getSession();
    Admin admin = (Admin) session.getUtilisateur();

    Connection singleConnection = SingleConnection.getInstance();
    Admin edit = null;
    if (admin != null) {
      edit = admin;
    }
    if (edit != null) {
      Admin updateAdmin = new Admin(admin.getIdAdmin(), mailSaisi, pseudoSaisi, mdpSaisi);
      updateAdmin.setIdAdmin(edit.getIdAdmin());
      AdminDao dao = new AdminDao(SingleConnection.getInstance());
      dao.update(updateAdmin);
      admin.setMail(mailSaisi);
      admin.setPseudo(pseudoSaisi);

      //Le mot de passe n'est pas modifié dans le model courant
    }
    fenetre.close();
    SceneChanger.voirListeProducteurs(fenetre);
  }

  /**
   * Redirige l'utilisateur vers la vue sur la liste des producteurs.
   */
  public void annuler() {
    fenetre.close();
  }

}
