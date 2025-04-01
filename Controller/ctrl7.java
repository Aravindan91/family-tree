package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Personnes;
import Model.arbreGen;

public class ctrl7 implements ActionListener{
    private arbreGen arbre ;
    private String nomp ;
    private JTextArea lbl;
    private JTextField txt1 ;
    private JTextField txt2 ;

    private Personnes prsn ;
    
    public ctrl7(arbreGen a ,  JTextArea labelInfo , JTextField t1 , JTextField t2){
        /*
     * controller qui permet de voir le lien de 2 prsn 
     */
        arbre = a ; 
        //nomp = s; 
        lbl = labelInfo;
        txt1 = t1;
        txt2 =t2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Personnes p1 =  arbre.SearchPrsn(txt1.getText());
        Personnes p2 =  arbre.SearchPrsn(txt2.getText());

        // arbre.getF_S(test);
        lbl.setText(arbre.Lien(p1,p2));
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}