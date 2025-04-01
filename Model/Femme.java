package Model;


import java.io.*;
import java.util.*;

/**
 *  * class qui herite simplment de perssone 
 */
public class Femme extends Personnes {

    public Femme(){

    }

    public Femme(String p, String n, Date dn, Date dd) {
        super(p, n, dn, dd);
    }

    public Femme(String p, String n, Date dn) {
        super(p, n, dn);
    }

    //private Femme mere;

    // public void setMere(Femme mere) {
    //     this.mere = mere;
    // }

    

}