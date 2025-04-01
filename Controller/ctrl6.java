package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Personnes;
import Model.arbreGen;

public class ctrl6 implements ActionListener{
    private arbreGen arbre ;
    private String nomp ;
    private JTextArea lbl;
    private JTextField txt ;
    private Personnes prsn ;
    
    public ctrl6(arbreGen a ,  JTextArea labelInfo , JTextField t){
        /*
        * controller qui permet d'afficher les ancetre 
        */
        arbre = a ; 
        //nomp = s; 
        lbl = labelInfo;
        txt = t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        
        Personnes test =  arbre.SearchPrsn(txt.getText());
        // arbre.getF_S(test);
        lbl.setText(arbre.afficherAnce(test));


        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    } 

}
