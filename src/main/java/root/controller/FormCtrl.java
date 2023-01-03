package root.controller;

/**
 * Interface d'un contrôleur de formulaire.
 */
public interface FormCtrl<T> {

  /**
   * Charge dans les champs du formulaire les données d'un modèle.
   *
   * @param modele Le modèle à charger dans le formulaire.
   */
  public void chargeChamps(T modele);

}
