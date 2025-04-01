package Model;

import java.sql.Date;

public class Test {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Création d'un arbre et ajout de quelques personnes
        arbreGen arbre = new arbreGen();
        Homme pere = new Homme("Jean", "Dupont", new Date(1970, 5, 15));
        Femme mere = new Femme("Marie", "Dupont", new Date(1975, 8, 20));
        Homme fils = new Homme("Luc", "Dupont", new Date(2000, 2, 10));
        Femme fille = new Femme("Emma", "Dupont", new Date(2005, 11, 25));

        arbre.ajoutPersonne(pere);
        arbre.ajoutPersonne(mere);
        arbre.ajoutPersonne(fils);
        arbre.ajoutPersonne(fille);

        // Ajout de liens entre les personnes
        fils.setPere(pere);
        fils.setMere(mere);
        fille.setPere(pere);
        fille.setMere(mere);

        pere.ajoutEnfant(fille);
        mere.ajoutEnfant(fille);

        pere.ajoutEnfant(fils);
        mere.ajoutEnfant(fils);




        // // Définition des entêtes du tableau
        // String[] entetes = {"Personne", "Père", "Mère", "Enfants"};

        // // Utilisation de la méthode pour construire les données du tableau
        // Object[][] donnees = arbreGen.construireDonneesTableau(arbre, entetes);
        // System.out.println();

        // System.out.println("aff du test ");

        // // Affichage des données
        // for (int i = 0; i < donnees.length; i++) {
        //     for (int j = 0; j < donnees[i].length; j++) {
        //         System.out.print(donnees[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
    }
}

