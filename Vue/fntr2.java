package Vue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class fntr2 extends JFrame{
   /*
    * fenetre tableau 
    */
    
    

       public static int transit;
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       int trst = 0 ;

        public fntr2(Object[][] data) {
            super("Table TESST");
    
            // Données du tableau
            String[] columnNames = {"Personne", "Père", "Mère", "Enfant"};
            // Object[][] data = {
            //     {"Alice", "Bob", "Charlie", "David"},
            //     {"Eve", "Frank", "Grace", "Hannah"},
            //     {"Isaac", "Jack", "Karen", "Liam"}
            // };
    
            // creation  de la table
            JTable table = new JTable(data, columnNames);

            //  hauteur des lignes    
            table.setRowHeight(25); 

            //  largeur des colonnes
            table.getColumnModel().getColumn(0).setPreferredWidth(100); 
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
    
            // Ajout de la table à un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);

    
            add(scrollPane);
    
            
            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            setSize(700, 300);
            setLocationRelativeTo(null); // Centrage de la fenêtre sur l'écran
            //setVisible(true);




        }

        
   

}














////::::
 // Création du tableau pour afficher l'arbre
        // String[] entetes = {"Personne", "Père", "Mère", "Enfants"};
        //  Object[][] donnees = {{}} ;
          // Les données seront mises à jour lors de l'actualisation
        
            

       
        
    //     tableau = new JTable(donnees, entetes);
    //     JScrollPane scrollPane = new JScrollPane(tableau);
    //     getContentPane().add(scrollPane);
    //     getContentPane().add(tableau.getTableHeader(), BorderLayout.CENTER);//
    //     getContentPane().add(tableau);


    //     // Create a new JScrollPane and add the JTable to it
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     getContentPane().add(scrollPane);

    // //     getContentPane().add(tableau.getTableHeader(), BorderLayout.CENTER);//
    //     ///getContentPane().add(tableau);
    //     frame.add(scrollPane, BorderLayout.CENTER);

        // Set the frame size and make it visible
        // frame.setSize(300, 200);
        // frame.setVisible(true);