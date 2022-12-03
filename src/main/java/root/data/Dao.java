/*
 * This code has been generated by the Rebel: a code generator for modern Java.
 *
 * Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
 */

package root.data;

import java.sql.Connection;
import java.util.ArrayList;

// ----------- << imports@AAAAAAGEqwdypvtiijw= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqwdypvtiijw= >>
// ----------- >>
public abstract class Dao<Model, IdType> {
  // ----------- << attribute.annotations@AAAAAAGEqwoCcfvmxto= >>
  // ----------- >>
  private Connection connexion;

  private Connection getConnexion() {
    return connexion;
  }

  private void setConnexion(Connection connexion) {
    this.connexion = connexion;
  }

  /**
   * @param connexion
   */

  // ----------- << method.annotations@AAAAAAGEq4uUuWuUTFQ= >>
  // ----------- >>
  public Dao(Connection connexion) {
    // ----------- << method.body@AAAAAAGEq4uUuWuUTFQ= >>
    // ----------- >>
  }
  /**
   * @param model
   */

  // ----------- << method.annotations@AAAAAAGEqwsK/vvtcX0= >>
  // ----------- >>
  public abstract boolean insert(Model model);
  /**
   * @param id
   */

  // ----------- << method.annotations@AAAAAAGEqxPR7/3rnfY= >>
  // ----------- >>
  public abstract Model get(IdType id);
  // ----------- << method.annotations@AAAAAAGEqwsRWPv5vW8= >>
  // ----------- >>

  public abstract ArrayList<Model> getAll();
  /**
   * @param model
   */

  // ----------- << method.annotations@AAAAAAGEqwsStvv//Eo= >>
  // ----------- >>
  public abstract boolean update(Model model);
  /**
   * @param model
   */

  // ----------- << method.annotations@AAAAAAGEqw1CdPwvL+Y= >>
  // ----------- >>
  public abstract boolean delete(Model model);


}