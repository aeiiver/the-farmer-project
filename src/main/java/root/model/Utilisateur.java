/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package root.model;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAGEqnMZcd7iGQI= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqnMZcd7iGQI= >>
// ----------- >>
public abstract class Utilisateur {
    // ----------- << attribute.annotations@AAAAAAGEqnzMVOANnjU= >>
    // ----------- >>
    private String mail;

    // ----------- << attribute.annotations@AAAAAAGEqnmsQt+KfRE= >>
    // ----------- >>
    private String mdp;

    private String getMail() {
        return mail;
    }

    private String getMdp() {
        return mdp;
    }

    private void setMail(String mail) {
        this.mail = mail;
    }

    private void setMdp(String mdp) {
        this.mdp = mdp;
    }

    // ----------- << method.annotations@AAAAAAGEqnneEd+REYE= >>
    // ----------- >>
    public abstract boolean verifieIdentifiants();
    // ----------- << method.annotations@AAAAAAGEw2KsUDSYFWg= >>
    // ----------- >>
    public String getMail() {
    // ----------- << method.body@AAAAAAGEw2KsUDSYFWg= >>
    // ----------- >>
    }
    // ----------- << method.annotations@AAAAAAGEw2Ku2DXWrd4= >>
    // ----------- >>
    public String getMdp() {
    // ----------- << method.body@AAAAAAGEw2Ku2DXWrd4= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAGEqnMZcd7iGQI= >>
// ----------- >>
}