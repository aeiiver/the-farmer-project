/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package root.data;

import java.util.*;
import root.model.*;
// ----------- << imports@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>
public class ClientDAO<Model, IdType> extends DAO {
    /**
     * @param connexion
     */
    public ClientDAO(Connection connexion) {
        super(connexion);
    }

    /**
    * @param model
    */

    @Override
    // ----------- << method.annotations@AAAAAAGEqwsK/vvtcX0= >>
    // ----------- >>
    public boolean insert(Model model) {
    // ----------- << method.body@AAAAAAGEqwsK/vvtcX0= >>
    // ----------- >>
        return false;
    }
    /**
    * @param id
    */

    @Override
    // ----------- << method.annotations@AAAAAAGEqxPR7/3rnfY= >>
    // ----------- >>
    public Model get(IdType id) {
    // ----------- << method.body@AAAAAAGEqxPR7/3rnfY= >>
    // ----------- >>
        return null;
    }

    /**
     * @param o
     */
    @Override
    public boolean insert(Object o) {
        return false;
    }

    /**
     * @param id
     */
    @Override
    public Object get(Object id) {
        return null;
    }

    @Override
    // ----------- << method.annotations@AAAAAAGEqwsRWPv5vW8= >>
    // ----------- >>
    public ArrayList<Model> getAll() {
    // ----------- << method.body@AAAAAAGEqwsRWPv5vW8= >>
    // ----------- >>
        return null;
    }

    /**
     * @param o
     */
    @Override
    public boolean update(Object o) {
        return false;
    }

    /**
     * @param o
     */
    @Override
    public boolean delete(Object o) {
        return false;
    }

    /**
    * @param model
    */

    @Override
    // ----------- << method.annotations@AAAAAAGEqwsStvv//Eo= >>
    // ----------- >>
    public boolean update(Model model) {
    // ----------- << method.body@AAAAAAGEqwsStvv//Eo= >>
    // ----------- >>
        return false;
    }
    /**
    * @param model
    */

    @Override
    // ----------- << method.annotations@AAAAAAGEqw1CdPwvL+Y= >>
    // ----------- >>
    public boolean delete(Model model) {
    // ----------- << method.body@AAAAAAGEqw1CdPwvL+Y= >>
    // ----------- >>
        return false;
    }
// ----------- << class.extras@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>
}