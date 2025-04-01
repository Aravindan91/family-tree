package Vue;
import java.util.Date;


//import javax.swing.*;

//import Controller.ControleurArbre;
import Model.Femme;
import Model.Homme;
import Model.Personnes;
import Model.arbreGen;
// import Vue.FenetreArbre;
import Vue.fntrMain;
public class Main {
    // public static arbreGen trs;


    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        int transit = 0 ;
        

         arbreGen arbre = new arbreGen();

        // Ajout de quelques personnes à l'arbre

    //       Homme princePhilip = new Homme("Philip", "Mountbatten", new Date(1921, 6, 10));
    // Femme reineElizabeth = new Femme("Elizabeth", "Windsor", new Date(1926, 4, 21));
    // Homme princeCharles = new Homme("Charles", "Windsor", new Date(1948, 11, 14));
    // Femme princesseDiana = new Femme("Diana", "Spencer", new Date(1961, 7, 1));


    Homme princePhilip = new Homme("Philip", "Mountbatten", new Date(1921, 6, 10));
    Femme reineElizabeth = new Femme("Elizabeth", "Windsor", new Date(1926, 4, 21));

        
        Homme princeCharles = new Homme("Charles", "Windsor", new Date(1948, 11, 14));
        Femme princesseDiana = new Femme("Diana", "Spencer", new Date(1961, 7, 1));
        Femme duchesseCamilla = new Femme("Camilla", "Parker-Bowles", new Date(1947, 7, 17));
        
            Homme princeWilliam = new Homme("William", "Windsor", new Date(1982, 6, 21));
            Femme duchesseKate = new Femme("Kate", "Middleton", new Date(1982, 1, 9));

                Homme princeGeorge = new Homme("George", "Windsor", new Date(2013, 7, 22));
                Femme princesseCharlotte = new Femme("Charlotte", "Windsor", new Date(2015, 5, 2));
                Homme princeLouis = new Homme("Louis", "Windsor", new Date(2018, 4, 23));
        
            Homme princeHarry = new Homme("Harry", "Windsor", new Date(1984, 9, 15));
            Femme duchesseMeghan = new Femme("Meghan", "Markle", new Date(1981, 8, 4));
            
                Homme archieHarrison = new Homme("Archie", "Mountbatten-Windsor", new Date(2019, 5, 6));
                Femme lilibetDiana = new Femme("Lilibet", "Mountbatten-Windsor", new Date(2021, 6, 4));
                Homme sako = new Homme("Mamadou", "sako ", new Date(2019, 5, 6));
                Femme Jel = new Femme("light", "Jel ", new Date(2019, 5, 6));    


                arbre.ajoutPersonne(princePhilip);
                arbre.ajoutPersonne(reineElizabeth);
            
                    arbre.ajoutPersonne(princeCharles);
                    arbre.ajoutPersonne(princesseDiana);
                    arbre.ajoutPersonne(duchesseCamilla);
            
                        arbre.ajoutPersonne(princeWilliam);
                        arbre.ajoutPersonne(duchesseKate);
                        
                            arbre.ajoutPersonne(princeGeorge);
                            arbre.ajoutPersonne(princesseCharlotte);
                            arbre.ajoutPersonne(princeLouis);
            
                        arbre.ajoutPersonne(princeHarry);
                        arbre.ajoutPersonne(duchesseMeghan);
            
                            arbre.ajoutPersonne(archieHarrison);
                            arbre.ajoutPersonne(lilibetDiana);
                            arbre.ajoutPersonne(sako);
                            arbre.ajoutPersonne(Jel);
            


        

        // echarles 
    princeCharles.setPere(princePhilip);
    princeCharles.setMere(reineElizabeth);
    arbre.getParents(princeCharles);

    princeWilliam.setPere(princeCharles);
    princeWilliam.setMere(princesseDiana);

    princeHarry.setPere(princeCharles);
    princeHarry.setMere(princesseDiana);

    princePhilip.ajoutEnfant(princeCharles);
    reineElizabeth.ajoutEnfant(princeCharles);

    princeCharles.ajoutEnfant(princeHarry);
    princesseDiana.ajoutEnfant(princeHarry);

    princeCharles.ajoutEnfant(princeWilliam);
    princesseDiana.ajoutEnfant(princeWilliam);


 ////////////////////////
    // lien de parenté 
    //////*********sako */
    // enfnat.setPere(pere)
    sako.setPere(princeHarry);
    Jel.setMere(duchesseMeghan);

    // echarles 
    princeCharles.setPere(princePhilip);
    princeCharles.setMere(reineElizabeth);
    // william
    // princeWilliam.setPere(princeCharles);
    //  princeWilliam.setMere(princesseDiana);

    /////////////////

    // duchesseKate.setPere(null); // 
    // duchesseKate.setMere(null); // 
    // harry
    // princeHarry.setPere(princeCharles);
    // princeHarry.setMere(princesseDiana);
    // duchesseMeghan.setPere(null); 
    // duchesseMeghan.setMere(null); 
    //les enfants de harry : archie , libilet 
    archieHarrison.setPere(princeHarry);
    archieHarrison.setMere(duchesseMeghan);
    lilibetDiana.setPere(princeHarry);
    lilibetDiana.setMere(duchesseMeghan);

    // les enfants de william  : george , charlotte , prince 
    princeGeorge.setPere(princeWilliam);
    princeGeorge.setMere(duchesseKate); // L'information sur la mère de George n'est pas disponible dans cet exemple
    princesseCharlotte.setPere(princeWilliam);
    princesseCharlotte.setMere(duchesseKate); // L'information sur la mère de Charlotte n'est pas disponible dans cet exemple
    princeLouis.setPere(princeWilliam);
    princeLouis.setMere(duchesseKate);

   
    /////////////////: les ajouts de enfants 
    // phl et reine 
    /// enfant sakottttttttttt***
    princeHarry.ajoutEnfant(sako);
    duchesseMeghan.ajoutEnfant(Jel);


    princePhilip.ajoutEnfant(princeCharles);
    reineElizabeth.ajoutEnfant(princeCharles);
    // charles et diana 
    // princeCharles.ajoutEnfant(princeWilliam);
    // princesseDiana.ajoutEnfant(princeWilliam);
    // princeCharles.ajoutEnfant(princeHarry);
    // princesseDiana.ajoutEnfant(princeHarry);
   
    //william et kate 
    princeWilliam.ajoutEnfant(princeGeorge);
    duchesseKate.ajoutEnfant(princeGeorge);
    princeWilliam.ajoutEnfant(princesseCharlotte);
    duchesseKate.ajoutEnfant(princesseCharlotte);
    princeWilliam.ajoutEnfant(princeLouis);
    duchesseKate.ajoutEnfant(princeLouis);
    
    // harry et magan 
    princeHarry.ajoutEnfant(archieHarrison);
    duchesseMeghan.ajoutEnfant(archieHarrison);
    princeHarry.ajoutEnfant(lilibetDiana);
    duchesseMeghan.ajoutEnfant(lilibetDiana);





    //arbre.getParents(princeCharles);


    System.out.println("bhcfkz byr : \n"+princeCharles.getNomComplet());

    //System.out.println("test : \n"+arbre.getParents(princeCharles));
    //System.out.println();

    // arbreGen trs = arbre;


    // for (int i = 0; i < arbre.length; i++) {
    //     for (int j = 0; j < tabDone[i].length; j++) {
    //         table.setValueAt(tabDone[i][j], i, j);
    //     }
    // }


    System.out.println();
    Personnes[] parentsTab = arbre.getParents(princeCharles);
    if (parentsTab != null) {
        for (Personnes parent : parentsTab) {
            if (parent != null) {
                System.out.println(parent.getNomComplet());
            }
        }
    } else {
        System.out.println("Aucun parent trouvé.");
    }






    ///////////////////////

    
    String[] entetes = {"Personne    ", "Père   ", "Mère   ", "Enfants  "};

    // Object[][] data = {
    //     // {"Row 1, Col 1", "Row 1, Col 2", "Row 1, Col 3"},
    //     // {"Row 2, Col 1", "Row 2, Col 2", "Row 2, Col 3"},
    //     // {"Row 3, Col 1", "Row 3, Col 2", "Row 3, Col 3"},
    // };

    Object[][]data = arbre.getDataPrsn(arbre, entetes);

    // for (int i = 0; i < data.length; i++) {
    //     for (int j = 0; j < data[i].length; j++) {
    //         //if (data[i][j] instanceof Personne) {
    //             //Personnes personne = (Personnes) data[i][j];
    //             System.out.println("Personne [" + i + "][" + j + "] : " + data[i][j]);

    //        // }
    //     }
    // }




        // Utilisation de la méthode pour construire les données du tableau
        //Object[][] donnees = new Object[arbre.lstprsn.size()][entetes.length];

        //new Object[arbre.lstprsn.size()][entetes.length];
//new Object[arbre.length][entetes.length];

       // arbreGen.getDataPrsn(arbre, entetes);

        // Création et affichage de la fenêtre d'arbre
        System.out.println("voici trst :"+transit);
        
        fntr2 fenetre2 = new fntr2(data);
       fenetre2.setVisible(false);

        fntrMain fenetre = new fntrMain(arbre , princeCharles , entetes , data, transit, fenetre2);
       // fntr2 fenetre2 = ;
       fenetre2.setVisible(false);

        //ctrl3 controlTest = new ctrl3(new fntr2(data));
       // ctrl2 controller = new ctrl2(transit);
      // ctrl2 controller2 = new ctrl2(transit); 
    //   William Windsor
        System.err.println("eee");
        //FenetreArbre fenetre = new FenetreArbre(arbre, princeCharles, entetes, data, transit);
        //fntr2 fenetre2 = new fntr2(controller);



////---------------partit frer et soeur et demi 
        System.out.println();
        //System.out.println("voici TESTtrst :"+transit);
        System.err.println("eee");
        //System.out.println(arbre.getF_S(archieHarrison));
        System.out.println(arbre.getF_S(sako));

        //sako
        //Jel
//Philip Mountbatten
        //Philip Mountbatten
       // String ttt= "Philip Mountbatten";
        //princePhilip.getNomComplet()
       //Personnes test =  arbre.SearchPrsn(ttt);
        //Archie Mountbatten-Windsor
        //System.out.println("voic la prsn en qst"+test.getNomComplet());
        //_________________:-----------------
        //archieHarrison
        System.out.println();



        String ttt= "Archie Mountbatten-Windsor";
        //princePhilip.getNomComplet()
       Personnes test =  arbre.SearchPrsn(ttt);

        //System.out.println(" voici le resultat trv"+arbre.getCousin(test));


//-----------------------------_______________

// System.out.println();
// System.out.println(arbre.afficherAnce(test));
// //arbre.afficherAncetres(test);

//-----------------------------_______________
// System.out.println();
// //test
// //princeCharles
// //Jel
// System.out.println(arbre.Lien(Jel, test));

//-----------------------------_______________| ancetre niveau |

/*
 * princePhilip = new Homme("Philip", "Mountbatten", new Date(1921, 6, 10));
    Femme reineElizabeth
 * 
 * princeGeorge = new Homme("George", "Windsor", new Date(2013, 7, 22));
                Femme princesseCharlotte = new Femme("Charlotte", "Windsor", new Date(2015, 5, 2));
                Homme princeLouis




                 princeCharles = new Homme("Charles", "Windsor", new Date(1948, 11, 14));
        Femme princesseDiana
 */

String test1 = arbre.NivDescendent(princesseDiana,sako,0);
String test2 = arbre.GPniv(princePhilip,sako);

String test3 = arbre.GPniv(archieHarrison,princesseDiana);



//duchesseCamilla

// princeHarry = new Homme("Harry", "Windsor", new Date(1984, 9, 15));
// Femme duchesseMeghan


System.out.println();
System.out.println(test3);




        // Personnes test1 = arbre.SearchPrsn(princePhilip.getNomComplet());
        // if (test1 != null) {
        //     System.out.println("Personne trouvée : " + test1);
        // } else {
        //     System.out.println("Personne non trouvée.");
        // }

        // // Test avec une chaîne de caractères directe
        // String ttt = "Philip Mountbatten";
        // Personnes test2 = arbre.SearchPrsn(ttt);
        // if (test2 != null) {
        //     System.out.println("Personne trouvée : " + test2);
        // } else {
        //     System.out.println("Personne non trouvée.");
        // }

// System.out.println();
//         Personnes test =  arbre.SearchPrsn("Archie Mountbatten-Windsor ");
        
//         System.out.println("voic la prsn en qst"+test.getNomComplet());
        


        //fenetre.setVisible(true);
        
        // if (controller.getTransit()==1){
        // fenetre2.setVisible(true);
        // System.out.println("voici TEEEEST trst :"+transit);

        // }

        // else {
        //     fenetre2.setVisible(false);

        // }




    //     Object[][] donnees = {
    //         {"Personne 1", "Père 1", "Mère 1", "Enfants 1"},
    //         {"Personne 2", "Père 2", "Mère 2", "Enfants 2"},
    //         {"Personne 3", "Père 3", "Mère 3", "Enfants 3"}
    // };

    // // Exemple d'en-têtes de colonnes
    // String[] entetes = {"Personne", "Père", "Mère", "Enfants"};

    // // Exemple d'arbre généré
    // arbreGen arbre = new arbreGen();

    // // Exemple de personne à afficher
    // //Personnes prsn = new Personnes("Personne 1");
    //           Homme princePhilip = new Homme("Philip", "Mountbatten", new Date(1921, 6, 10));


    // // Création et affichage de la fenêtre d'arbre
    // FenetreArbre fenetre = new FenetreArbre(arbre, princePhilip, entetes, donnees);
    }


  

}


