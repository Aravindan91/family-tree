package Model;


import java.io.*;
import java.util.*;


/**
 * Classe arbreGen qui à les methode princpale pour le traitement d'une famille telle que :
 * creation d'un tableau de perssone d'une Famille 
 * identification des liens ( cousin , frere et soeur , demi frere et soeur , ancestre , petit fils )
 */


public class arbreGen {
    public Vector<Personnes> lstprsn;

    public arbreGen() {
        lstprsn = new Vector<>();
    }

    public Vector <Personnes> getArbreT(){
        return lstprsn;
    }   
    // ajouter prsn 
    // methode d'ajou de PRSN   d'une d'une famille 
    public void ajoutPersonne(Personnes personne) {
        lstprsn.add(personne);
    }

     

//////////////////////////////////////////

//___________________qst 1 afficher l'arbre 
/*
 * methode pour remplir ma table Jtable à partir d'une famile 'arbre' et entete 
 * elle de type de Object , permet d'avoir une flexiblitié sur le type recu , elle prend tout type
 * 
 */

public  Object[][] getDataPrsn(arbreGen arbre, String[] entetes) {
    // tableau à 2 dim
    Object[][] tableData = new Object[arbre.lstprsn.size()][entetes.length];
    // [ prsn , pere , mere , enfants]
    
    int Ligne = 0;
    // boucle qui va parcourir notre lst de prsn , c'est un tableau de Personnes
    // c pk le i est de ce type 
    for (Personnes personne : arbre.lstprsn) {
        tableData[Ligne][0] = personne.getNomComplet();
        Personnes pere = personne.getPere();
        Personnes mere = personne.getMere();
       
        if(pere != null){
            tableData[Ligne][1]=pere.getNomComplet();
        }
        else {
            tableData[Ligne][1]= " ";
        }

        if(mere != null){
            tableData[Ligne][2]=mere.getNomComplet();
        }
        else {
            tableData[Ligne][2]= " ";
        }

        List<Personnes> enfants = personne.getEnfant();
        tableData[Ligne][3] = "";

        if (!enfants.isEmpty()) {
            StringBuilder enfantsString = new StringBuilder();
            for (Personnes enfant : enfants) {
                enfantsString.append(enfant.getNomComplet()).append(", ");
            }
            enfantsString.delete(enfantsString.length() - 2, enfantsString.length()); 
            // permet de supprimer la zone à supprimer , ici on supp la virgu et l'espace 
            //enfantsString.delete(i,j) entre i et j-1 c pk on fait pas enfantsString.length()-1
            tableData[Ligne][3] = enfantsString.toString();

        

        }
        Ligne++;
    }
    return tableData;
}



public Personnes SearchPrsn(String np) {
    np = np.trim(); 
    // suppr le surplus d'espace au DEB et FIn  
    for (Personnes personne : lstprsn) {
        String prsnfd = personne.getNomComplet().trim();
        //System.out.println(" --pour debug--comparé a : '" + nomComplet + "' avc notre prsn  '" + np + "'");
        if (prsnfd.equalsIgnoreCase(np)) {
            // verifie si c egale en ignorant les diff entre Maj et Miniscule
            // System.out.println("Personne trouvée : " + nomComplet);
            System.out.println("yesss trvé bro ");

            return personne;
        }
    }
    System.out.println("Personne non trouvée pour: '" + np + "'");
    return null; // Personne non trouvée
}





//___________________qst 2 afficher l'ancestre de qqun  


public String afficherAnce(Personnes personne) {
    /*
     * methode qui va afficher les ancestre d'une prsn dansl'ordre du plus vieux au plus jeune 
     */
    StringBuilder str = new StringBuilder("Les ancêtres sont:\n");
    //CollectAnc(personne, str);
    List<String> ancetres = new ArrayList<>();
        CollectAnc(personne, ancetres);

    for (int i = ancetres.size() - 1; i >= 0; i--) {// pour inverser 
        str.append(ancetres.get(i)).append("\n");
    }
    
    return str.toString();
}

    public  void CollectAnc(Personnes personne, List<String> ancetres) {
        // remplir ma lst des ancestre de la prsn 
    Homme pere = personne.getPere();
    Femme mere = personne.getMere();

    if (pere != null || mere != null) {
        if (pere != null && mere != null) {
            ancetres.add("-"+pere.getprenom() + " " + pere.getnom() + ", " + mere.getprenom() + " " + mere.getnom()+"\n");
        } else if (pere != null) {
            ancetres.add("-"+pere.getprenom() + " " + pere.getnom()+"\n");
        } else {
            ancetres.add("-"+mere.getprenom() + " " + mere.getnom()+"\n");
        }

        // les appl recursif 
        if (pere != null) {
            CollectAnc(pere, ancetres);
        }
        if (mere != null) {
            CollectAnc(mere, ancetres);
        }
    }
}

//----------------------ççççç



    public String getF_S(Personnes personne)   {
        /*
         * methode qui fournit les frere et soeur et demi frerr et demi soeur 
         */
        String gg = " ";
        String df = " ";
        String ds = " ";
        Homme pere = personne.getPere();
        Femme mere = personne.getMere();
        //Femme dmere;
        gg+=" les frere sont : \n";
        df += " \nles demi frere sont : \n ";
        ds += " \nles demi soeur sont : \n ";
        if (pere != null) {
           
            if(mere!= null){// important cas prsn same parent 
            for (Personnes enfant : pere.getEnfant()) {// lst enfnat du pere  , c pk on chek mere 
                if (!enfant.equals(personne) && enfant instanceof Homme && mere.getEnfant().contains(enfant)) {

                    //dmere=enfant.getMere();
                    // 1 verifie qu'on traite ps le meme enfants mais bin un autre enfants 
                    // 2 verifie si enfnat est un homm 
                    // 3 verifie si la mere a aussi cet enfnat 

                    gg+= "-"+enfant.getNomComplet() +"\n";

                    //System.out.println(enfant.getprenom() + " " + enfant.getnom()+"\n");
                }
            }
        }
            // cas contraire ( partit demi frer soeur du pere ) 
            // pareille pour 
            //gg+=" \n les demi frere sont : \n";
            for (Personnes enfant : pere.getEnfant()) {// lst enfnat du pere  , c pk on chek mere 
                if (!enfant.equals(personne) && (mere == null || !mere.getEnfant().contains(enfant))) {
                    if(enfant instanceof Homme ) {
                        df+="-"+enfant.getNomComplet();
                    }
                    else {
                        ds+="-"+enfant.getNomComplet();
                    }
                    // 1 verifie qu'on traite le meme enfants mais bin un autre enfants 
                    // 2 verifie si enfnat est un homm 
                    // 3 verifie si ils ont la meme mere avc contains
                    //gg+= enfant.getNomComplet() +"\n";
                    //System.out.println(enfant.getprenom() + " " + enfant.getnom()+"\n");
                }
            }
    
            //gg+=df+"\n"+ds+"\n";
    
    
        }
    
    
        if (mere != null) {
            gg+=" \n les soeur  sont : \n";
            if(pere!= null){
            //System.out.println("Seurs de " + personne.getprenom() + " :");
            for (Personnes enfant : mere.getEnfant()) {// ici inverse , enfnat de mere , on chek pere 
                if (!enfant.equals(personne) && enfant instanceof Femme && pere.getEnfant().contains(enfant)) {
                    //System.out.println(enfant.getprenom() + " " + enfant.getnom()+"\n");
                    gg+="-"+enfant.getNomComplet()+"\n";
    
                }
            }
        }
    
    
            for (Personnes enfant : mere.getEnfant()) {// lst enfnat du pere  , c pk on chek mere 
                if (!enfant.equals(personne) && (pere == null || !pere.getEnfant().contains(enfant))) {
                    if(enfant instanceof Homme ) {
                        df+="-"+enfant.getNomComplet()+"\n";
                    }
                    else {
                        ds+="-"+enfant.getNomComplet()+"\n";
                    }
                    // 1 verifie qu'on traite le meme enfants mais bin un autre enfants 
                    // 2 verifie si enfnat est un homm 
                    // 3 verifie si ils ont la meme mere avc contains
                    //gg+= enfant.getNomComplet() +"\n";
                    //System.out.println(enfant.getprenom() + " " + enfant.getnom()+"\n");
                }
            }
    
    
            
        }


        gg+=df+"\n"+ds+"\n";
    
    
        return gg;
    
    }






       // return pn ;
    



    // /////////////////////QST 4  zinc ///////////////
    
   //___________________qst 4 afficher COUZIN
 
        public Personnes[] getParents(Personnes personne) {// fonction satelite 
            Personnes[] parents = new Personnes[2];
            parents[0] = personne.getPere();
            parents[1] = personne.getMere();
            return parents;
        }

  
     /////////////////////////
     //methode qui Donne en Personnes tout  les frere et soeur de la prsn 
     // tt les enfnats du pere et de la mere 
     public Vector<Personnes> getBroS(Personnes personne) {
        Vector<Personnes> AllBro = new Vector<>();
        // si ya parents 
        if (personne.getPere() != null && personne.getMere() != null) {
            Vector<Personnes> enfantsPere = personne.getPere().getEnfant();// les enfnat du pere de la prsn 
            Vector<Personnes> enfantsMere = personne.getMere().getEnfant();
            
            // 1er verification 
            for (Personnes enfant : enfantsPere) {
                if (!enfant.equals(personne)) {// commee taleur , on va ejecter la prsn e eqt pour garder que ses frr et srr 
                    AllBro.add(enfant);
                }
            }
            // double verification , faire comme ca , on fait on fait U , ensuite on fait inter , N 
            // prends d'abord enfnat du coté pere , ensuite coté mere ( c pour zinc , dc besoin meme ceux "exclue") , 
            for (Personnes enfant : enfantsMere) {
                if (!enfant.equals(personne) && !AllBro.contains(enfant)) {
                    // supprime les doublon 
                    AllBro.add(enfant);
                }
            }
        }
        return AllBro;

    }
    
//// ETAPE 2 µµµµµµµµµµµµµµµµµµµµµ

// methode pour avoir les frer et soeur du parents 
public Vector<Personnes> FS_parent(Personnes personne) {
    
    Vector<Personnes> FS = new Vector<>();

    // parents de a
    Personnes[] parents = getParents(personne);

    // on va ajouter les frr et srr du PERE avc notre fonction getBroS 
    if (parents[0] != null) {
        FS.addAll(getBroS(parents[0]));
    }

    // Ajouter les frères et srr de la MERE 
    if (parents[1] != null) {
        FS.addAll(getBroS(parents[1]));
    }

    // Retire la personne elle-même de la liste des frères et sœurs
    FS.remove(personne);

    return FS;
}
// et à partir de ce tab des frerre et soeur des parents , j'extrait enfnat 

public List<Personnes> ZincLst(List<Personnes> FS) {
    /*
     * methode qui va donner les enfants de chq prsn de notre list de FS (les frr et srr des parents de la prsn ) 
     */
    List<Personnes> enfants = new ArrayList<>();

    // Parcour la liste des frr et srr
    for (Personnes personne : FS) {
        // Obtenir les enfants de chaque personne
        List<Personnes> enfantsPersonne = personne.getEnfant();
        // Ajouter les enfants à la liste générale
        enfants.addAll(enfantsPersonne);
    }

    return enfants;
}

// AFICHAGE
// que j'affiche ici 

public String getCousin(Personnes personne) {
    /*
     * methode qui renini nos 2 f satelite et envoi un msg string 
     */
    String str = "";
    List<Personnes> FS = FS_parent(personne);// f satelitte , frr et srr des parenst de personne
    List<Personnes> child = ZincLst(FS);// enfnat de ses frr et srr (voir le dessin de ton 2 eme cahier spirale , etiquette bleu pr shema)

    if (child.isEmpty()) {
        str="Aucun cousin cousine n'a été trouvé pour "+personne.getNomComplet()+"\n";
        //System.out.println("Aucun frère ou soeur des parents n'a été trouvé pour " + personne.getNomComplet());
    } else {
        str="Les cousin cousine de " +personne.getNomComplet()+"sont :\n \n";
        //System.out.println("Frères et soeurs des parents de " + personne.getNomComplet() + ":");
        for (Personnes frereSoeur : child) {
            str+="-"+frereSoeur.getNomComplet()+"\n";
            //System.out.println(frereSoeur.getNomComplet());
        }
    }
    return str;
}

public String EstChild(Personnes p1 , Personnes p2){
    /*
     * methode qui indq p1 est l'enfnat de p2 ou vice versa 
     */
    if (p1.getPere() != null && p1.getPere().equals(p2) || p1.getMere() != null && p1.getMere().equals(p2)) {
        return p1.getNomComplet() + " est l'enfant de " + p2.getNomComplet();
    }
    
    // Vérifier si p2 est l'enfant de p1
    if (p2.getPere() != null && p2.getPere().equals(p1) || p2.getMere() != null && p2.getMere().equals(p1)) {
        return p2.getNomComplet() + " est l'enfant de " + p1.getNomComplet();
    }

    return "Aucune relation directe trouvée entre " + p1.getNomComplet() + " et " + p2.getNomComplet();

}


public String GPniv(Personnes p1, Personnes p2) {
    /*
     * methode pour trouver le niv pour les grand pere 
     */
    String niv =  NivDescendent(p1, p2, 0);
    if(niv=="N0"){
        // cas ou c'est pas grand pere êtit fils , mais peti fils grand pere 
        // on le redirigie vers la f qui va traiter les petit fils 
        return PFniv(p1,p2);
    }

    if(niv.equals("N2")){
        return p1.getNomComplet() + " est le grand pere/mere de  " + p2.getNomComplet();
    }

    if (niv.startsWith("N")) {
        /*
         * cas après n3 , car ca sera des arrier arriere etc 
         */
        int niveau = Integer.parseInt(niv.substring(1));
        // convertir en int( extrait str à lindice 1 , qui correspond au chiffre  )
        StringBuilder relation = new StringBuilder(p1.getNomComplet());

        if (niveau >= 3) {
            relation.append(" est le ");
            for (int i = 3; i <= niveau; i++) {
                relation.append("arrière ");
            }
            relation.append("grand-père/mère de ");
            relation.append(p2.getNomComplet());
        }

        return relation.toString();
    }

    return "Aucune relation directe trouvée entre " + p1.getNomComplet() + " et " + p2.getNomComplet();


}

public String NivDescendent(Personnes p1, Personnes p2, int niveau) {
    
    /*
     * methode recu , qui va donner la profondeur du lien , ici nommé le lien 
     */
    // Vérifier si p1 est un parent direct de p2
    
    if ((p2.getPere() != null && p2.getPere().equals(p1)) || // ou inclusif , c pas XOR 
        (p2.getMere() != null && p2.getMere().equals(p1))) {
        return "N" + (niveau + 1); // Retourner le niveau incrémenté de 1
    }
    
    //   enfants de p1
    List<Personnes> enfantsDeP1 = p1.getEnfant();
    
    // Parcour chaque enfant de p1
    for (Personnes enfant : enfantsDeP1) {
        // apel recursive pour voir si cet enfnat est anecestre de p2 
        String resultat = NivDescendent(enfant, p2, niveau + 1);// voir dessin "depliment" , tjr cahier 2 spirale 
        if (!resultat.equals("N0")) {
            return resultat; 
        }
    }
    
    return "N0"; // p1 n'est pas un ancêtre de p2
}



public String PFniv(Personnes p1, Personnes p2){
    /*
     * meme chose que GPniv , mais ici ca sera pour les petis fils , 
     */
    String niv = NivDescendent(p2, p1, 0);
    System.out.println(" c pour test debug  voici niv:"+niv);

    // if((niv.equals("N0"))){
    //     return "Aucune relation directe trouvée entre " + p1.getNomComplet() + " et " + p2.getNomComplet();

    // }

    if(niv.equals("N1")){
        System.out.println(" c pour test debug , un tst , 1");
        return p1.getNomComplet() + " est le petit fils de " + p2.getNomComplet();

    }

    if(niv.equals("N2")){
        System.out.println(" v , un tst , 2");

        return p1.getNomComplet() + " est petit fils/fille de " + p2.getNomComplet();
    }

    if (niv.startsWith("N")&& !niv.equals("N0")) {
        System.out.println("un tst , 3");

        int niveau = Integer.parseInt(niv.substring(1));
        StringBuilder relation = new StringBuilder(p1.getNomComplet());

        if (niveau >= 3) {
            relation.append(" est l'");
            for (int i = 3; i <= niveau; i++) {
                relation.append("arrière ");
            }
            relation.append("petit fils/fille de ");
            relation.append(p2.getNomComplet());
        }

        return relation.toString();
    }
    

    return "Aucune relation directe trouvée entre " + p1.getNomComplet() + " et " + p2.getNomComplet();
    
}






public boolean chekZinc(Personnes prsn1 , Personnes prsn2){
    /*
     * methode qui verifie si une prsn est cousin de l'autre 
     */
    List<Personnes> frrParent = FS_parent(prsn1);
    List<Personnes> child = ZincLst(frrParent);

    List<Personnes> frrParent2 = FS_parent(prsn2);
    List<Personnes> child2 = ZincLst(frrParent2);

    boolean T1 = false;
    boolean t2 = false;

    if (child.isEmpty() || child2.isEmpty()) {
        //str="Aucun cousin cousine n'a été trouvé pour "+personne.getNomComplet()+"\n";
        //System.out.println("Aucun frère ou soeur des parents n'a été trouvé pour " + personne.getNomComplet());

        // return false ;
    }

    for (Personnes frereSoeur : child) {
        //str+="-"+frereSoeur.getNomComplet()+"\n";
        if(frereSoeur==prsn2){
            T1=true;
            
        }
        //System.out.println(frereSoeur.getNomComplet());
    }

    for (Personnes frereSoeur : child2) {
        //str+="-"+frereSoeur.getNomComplet()+"\n";
        if(frereSoeur==prsn1){
            t2=true;
        }
        //System.out.println(frereSoeur.getNomComplet());
    }

    return T1 && t2; // c'est un inter , vrai ssi T1 et T2 vrai 
}




public boolean EstParents(Personnes personne1, Personnes personne2) {
    /*
     * methode qui verifie si 2 prsn sont des parents , verifiant leurs enfants ont commun 
     */
    if (personne1 == null || personne2 == null) {
        return false;  
    }

    List<Personnes> enfants1 = personne1.getEnfant();
    List<Personnes> enfants2 = personne2.getEnfant();

    if (enfants1 == null || enfants2 == null) {
        return false;  // On suppose que s'il n'y a pas de liste d'enfants, il n'y a pas d'enfants
    }

    for (Personnes enfant1 : enfants1) {
        if (enfants2.contains(enfant1)) {
            return true;
        }
    }

    return false;
}

/* 
public String EstFrr(Personnes p1 , Personnes p2){
        String str ="";

    if(p1.getMere()==null & p1.getPere()==null && p2.getMere()==null & p2.getPere()==null ){
        return " erreur  les 2 prsn n'ont aucun parents ";
    }

    if (p1.getPere().equals(p2.getPere()) && p1.getMere().equals(p2.getMere())) {

        if(p1 instanceof Homme && p2 instanceof Homme ){
            str = p1.getNomComplet()+" et "+p1.getNomComplet()+" sont des frere et ";

        }
        if(p1 instanceof Femme && p2 instanceof Femme ){
            str = p1.getNomComplet()+" et "+p2.getNomComplet()+" sont des soeur et ";

        }
        else if ((p1 instanceof Homme && p2 instanceof Femme ||
        p1 instanceof Femme && p2 instanceof Homme)) {
            str=p1.getNomComplet()+" et "+p2.getNomComplet()+" sont des  frere et soeur et ";

        }
    }
    return str +p1.getPere().getNomComplet() + " et " + p2.getMere().getNomComplet() + " sont leurs parents  ";

}
*/


public String EstFrr(Personnes p1, Personnes p2) {
    /*
     * methode qui verifie si 2 prsn sont des frr
     */
    String str = "";

   

            // les 3 cas possible 
        if (p1 instanceof Homme && p2 instanceof Homme) {
            str = p1.getNomComplet() + " et " + p2.getNomComplet() + " sont des frères et ";
        } else if (p1 instanceof Femme && p2 instanceof Femme) {
            str = p1.getNomComplet() + " et " + p2.getNomComplet() + " sont des sœurs et ";
        } else if ((p1 instanceof Homme && p2 instanceof Femme) || (p1 instanceof Femme && p2 instanceof Homme)) {
            str = p1.getNomComplet() + " et " + p2.getNomComplet() + " sont frère et sœur et ";
        }
        
        return str + p1.getPere().getNomComplet() + " et " + p2.getMere().getNomComplet() + " sont leurs parents.";
    // } else {
    //     return p1.getNomComplet() + " et " + p2.getNomComplet() + " ne sont pas frères et sœurs.";
    // }
}



    ///////////////QST 5 
   
    public String Lien(Personnes personne1, Personnes personne2) {

        // Vérifier si personne1 est l'enfant de personne2
        String str = "";

        if (personne1.getPere() != null && personne1.getPere().equals(personne2) || personne1.getMere() != null && personne1.getMere().equals(personne2)) {
            return personne1.getNomComplet() + " est l'enfant de " + personne2.getNomComplet();
        }
        
        // Vérifier si personne2 est l'enfant de personne1
        if (personne2.getPere() != null && personne2.getPere().equals(personne1) || personne2.getMere() != null && personne2.getMere().equals(personne1)) {
            return personne2.getNomComplet() + " est l'enfant de " + personne1.getNomComplet();
        }
    
        // Vérifier si les deux personnes ont le même parent
        // partit demi soeur et demi frere 
        //--- verifictaion du lien ferer et soeur 
        if (personne1.getPere() != null && personne2.getPere() != null && personne1.getPere().equals(personne2.getPere())
        && (personne1.getMere() != null && personne2.getMere() != null && personne1.getMere().equals(personne2.getMere())))
         {
            return EstFrr(personne1, personne2);
        }

        //personne1.getPere().equals(personne2.getPere()

        //--- verifictaion du lien DEMIE ferer et soeur , pour le pere 
        if (personne1.getPere() != null && personne2.getPere() != null && personne1.getPere().equals(personne2.getPere())) 
        {
            if(personne1 instanceof Homme && personne2 instanceof Homme ){
                    str = personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont demi frere et";

            }
            if(personne1 instanceof Femme && personne2 instanceof Femme ){
                str = personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont demi soeur et";

            }
            else if ((personne1 instanceof Homme && personne2 instanceof Femme ||
            personne1 instanceof Femme && personne2 instanceof Homme)) {
                str=personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont des demi frere et soeur et";

            }

            return str+" ont le même père : " + personne1.getPere().getNomComplet();
        }
        // pour la mere 
        if (personne1.getMere() != null && personne2.getMere() != null && personne1.getMere().equals(personne2.getMere())) 
        {
            if(personne1 instanceof Homme && personne2 instanceof Homme ){
                str = personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont demi frere et";

            }
            if(personne1 instanceof Femme && personne2 instanceof Femme ){
                str = personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont demi soeur et";

            }
            else if ((personne1 instanceof Homme && personne2 instanceof Femme ||
            personne1 instanceof Femme && personne2 instanceof Homme)) {
                str=personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont des demi frere et soeur et";

            }

        return str+" ont le même mère : " + personne1.getMere().getNomComplet();

        }


        if(EstParents(personne1, personne2)){
            return personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont des Parents ";

        }

        if(chekZinc(personne1, personne2)){
            return personne1.getNomComplet()+" et "+personne2.getNomComplet()+" sont des cousin ";

        }

         return GPniv(personne1, personne2);
    }
        




    
    
    
    
}




