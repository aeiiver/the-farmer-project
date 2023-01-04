package root.controller;

/**
 * Interface d'une vue de formulaire pour un modèle T.
 */
public interface FormView<T> {

  /**
   * Charge dans les champs du formulaire les données d'un modèle.
   *
   * @param modele Le modèle à charger dans le formulaire.
   */
  void chargeChamps(T modele);

}
