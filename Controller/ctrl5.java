package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Personnes;
import Model.arbreGen;

public class ctrl5 implements ActionListener {
    /*
     * controller qui permet d'appliquer la methode getCousin
     */
    private arbreGen arbre ;
    private String nomp ;
    private JTextArea lbl;
    private JTextField txt ;
    private Personnes prsn ; 

    public ctrl5(arbreGen a ,  JTextArea labelInfo , JTextField t){
        arbre = a ; 
        //nomp = s; 
        lbl = labelInfo;
        txt = t;
    }

    //@Override
    public void actionPerformed(ActionEvent e) {

        Personnes test =  arbre.SearchPrsn(txt.getText());
        // arbre.getF_S(test);
        lbl.setText(arbre.getCousin(test));

        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

    }

    





}
