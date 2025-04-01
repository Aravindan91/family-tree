package Model;

import java.io.*;
import java.util.*;

/*
 * 
 * une classe mariage qui donne les info concerné le Mariage 
 * ( date de mariage , divorce , prsn marié )
 */
public class Mariage   {
    
    //code generer uml 
    public Homme epoux;
    public Femme epouse;

    public Date dateM;
    public Date dateD;
    Vector <Personnes> lstMariage =  new Vector <Personnes>();
    
    /**
     * Default constructor
     */

    public Mariage() {
    }

    public Mariage(Homme m , Femme f) {
            epoux = m;
            epouse = f ;
    }
    
    

    public Mariage(Date dM){
        dateM=dM;
    }

    public Mariage(Date dM, Date dD){
        dateD=dD;
    }

    // methodes 

    public Femme getEpouse(){
        return epouse;
    }

    public Homme getEpoux(){
        return epoux;
    }

    public Date getMaraigeDate(){
        return dateM ; 
    }

    public Date getDivorceDate(){
        return dateD ; 
        
    }
    
    // methode pas sur à confirmer 
    public void ajoutPrsnMarie(Personnes personne) {
        // ca c'est faux 
        lstMariage.add(personne);
    }


    public void ajoutPrsnMarie2(Homme p1 ,Femme p2 ) {
        epoux = p1 ; 
        epouse = p2 ; 
        lstMariage.add(epoux);
        lstMariage.add(epouse);

    }


    /* qst 
     *   est ce que les divorcé sont compris dans lst ariage ? 
     *  est ce que dans mamethode au dessus est bonne car , ya une inq prsn 
     * mais ducou qui est marie avc qui 
     */

        // avoir lst marié 
    public Vector<Personnes> getPrsnMarie() {
        return lstMariage;
    }


    

    /**
     * Default mariage 
     */



}
