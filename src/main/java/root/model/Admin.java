/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package root.model;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAGEqm5/kt2d7Rg= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqm5/kt2d7Rg= >>
// ----------- >>
public class Admin extends Utilisateur {
    // ----------- << attribute.annotations@AAAAAAGEqnzsbuAVvTg= >>
    // ----------- >>
    private int idAdmin;

    // ----------- << attribute.annotations@AAAAAAGEqnzv+OAbaCc= >>
    // ----------- >>
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
    // ----------- << method.annotations@AAAAAAGEqnneEd+REYE= >>
    // ----------- >>
    public boolean verifieIdentifiants() {
    // ----------- << method.body@AAAAAAGEqnneEd+REYE= >>
    // ----------- >>
        return false;
    }
// ----------- << class.extras@AAAAAAGEqm5/kt2d7Rg= >>
// ----------- >>
}