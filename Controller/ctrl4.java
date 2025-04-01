package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Personnes;
import Model.arbreGen;

public class ctrl4 implements ActionListener {
    /*
     * controller qui permet d'appliquer la methode getF_S ( donne les frr srr et demi )
     */
    private arbreGen arbre ;
    private JTextArea lbl;
    private JTextField txt ;

    public ctrl4(arbreGen a ,  JTextArea labelInfo , JTextField t){
        arbre = a ; 
        lbl = labelInfo;
        txt = t;
    }

    public void actionPerformed(ActionEvent e){

        Personnes test =  arbre.SearchPrsn(txt.getText());
        // arbre.getF_S(test);
        lbl.setText(arbre.getF_S(test));

        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

        //Personnes prsn = arbre.SearchPrsn(princePhilip.getNomComplet());

    }
    
}
