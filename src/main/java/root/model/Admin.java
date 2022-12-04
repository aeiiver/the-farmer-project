package root.model;

/**
 * Classe de modèle pour les administrateurs.
 */
public class Admin extends Utilisateur {
  private int idAdmin;
  private String pseudo;

  private int getIdAdmin() {
    return idAdmin;
  }

  private String getPseudo() {
    return pseudo;
  }

  private void setIdAdmin(int idAdmin) {
    this.idAdmin = idAdmin;
  }

  private void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  @Override
  public boolean verifieIdentifiants() {
    return false;
  }
}