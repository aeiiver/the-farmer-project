/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package root.data;

import java.util.*;
import java.sql.Connection;
// ----------- << imports@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>
public class ClientDao<Model, IdType> extends Dao {
    /**
     * @param connexion
     */
    public ClientDao(Connection connexion) {
        super(connexion);
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

// ----------- << class.extras@AAAAAAGEqwZTJ/qPtUw= >>
// ----------- >>
}