/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package root.model;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAGEqm6and3xDM8= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAGEqm6and3xDM8= >>
// ----------- >>
public class Producteur extends Utilisateur {
    // ----------- << attribute.annotations@AAAAAAGEqnEDdt6x9T8= >>
    // ----------- >>
    private String SIRET;

    // ----------- << attribute.annotations@AAAAAAGEqnGAV96/m5A= >>
    // ----------- >>
    private String nom;

    // ----------- << attribute.annotations@AAAAAAGEqnGWR97GIAU= >>
    // ----------- >>
    private String prenom;

    // ----------- << attribute.annotations@AAAAAAGEqnG0tN7NKV8= >>
    // ----------- >>
    private String numTel;

    // ----------- << attribute.annotations@AAAAAAGEquSMuAphPao= >>
    // ----------- >>
    private Adresse adresse;

    private String getSIRET() {
        return SIRET;
    }

    private String getNom() {
        return nom;
    }

    private String getPrenom() {
        return prenom;
    }

    private String getNumTel() {
        return numTel;
    }

    private Adresse getAdresse() {
        return adresse;
    }

    private void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    private void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    // ----------- << method.annotations@AAAAAAGEqnneEd+REYE= >>
    // ----------- >>
    public boolean verifieIdentifiants() {
    // ----------- << method.body@AAAAAAGEqnneEd+REYE= >>
    // ----------- >>

        // dummy return
        return false;
    }
// ----------- << class.extras@AAAAAAGEqm6and3xDM8= >>
// ----------- >>
}
