package Model ; 


import java.io.*;
import java.util.*;
import java.util.Date;
import java.util.Vector;



/**
 * Classe perssone , comme attribut les info d'une persson ( nom prenom , date naisance , date de deces )
 * // il y a aussi des methode pour dire cette prsn a telle mere/pere
 */
public class Personnes {
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private Date dateDeces;
    public arbreGen arbre;
    public Femme mere;
    public Homme pere ; 

    //**sur le code generer par UML , y avait pas lstEnfant et 
    //lstprsn dans la classe 
    Vector <Personnes> LstEnfant =  new Vector <Personnes>();
    // Vector <Personnes> Lstpersonnes =  new Vector <Personnes>();



    /**
     * Default constructor
     */
    public Personnes() {
    }

    // cas prsn vivant  
    public Personnes(String p ,String n , Date dn ){
        prenom = p ;
        nom = n ; 
        dateNaissance = dn ; 
        dateDeces = null; // default à null


    }

    // cas prsn mort   
    public Personnes(String p ,String n , Date dn , Date dd ){
        prenom = p ;
        nom = n ; 
        dateNaissance = dn ; 
        dateDeces = dd ; 

    }

    //pour cas prsn vivant , mais mort ensuite 

    public void setdateN(Date dn) {
        dateNaissance = dn;
    }
    public void setdateND(Date dd) {
        dateDeces = dd;
    }

    public String getnom(){
        return nom  ; 
    }

    public Date getdateN(){
        return dateNaissance ;
    }

    public String getprenom(){
        return prenom  ; 
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }


    public Date getdateND(){
            return dateDeces ;
    }


    
    public void setPere(Homme pere) {
        this.pere = pere;
    }

    public void setMere(Femme mere) {
        this.mere = mere;
    }

    public Homme getPere() {
        return pere;
    }

    public Femme getMere() {
        return mere;
    }


    





    // ajouter enfant 
    // methode d'ajou d'ENFANTS  d'une personne 
    public void ajoutEnfant(Personnes enfant) {
        LstEnfant.add(enfant);
    }
    // avoir lst enfant 
    public Vector <Personnes> getEnfant() {
        return LstEnfant;
    }

   
    ///////////////////

  
    



    
    


}