package Vue;

import Model.Homme;
import Model.Personnes;
import Model.arbreGen;

import javax.swing.*;
import javax.swing.border.Border;

import Controller.ctrl2txt;
import Controller.ctrl3;
import Controller.ctrl4;
import Controller.ctrl5;
import Controller.ctrl6;
import Controller.ctrl7;

import java.awt.*;

public class fntrMain extends JFrame {
    private arbreGen arbre;
    private JTable tableau;
    private JButton bouttonAnc;
    private JButton bouttonarbre;
    private JButton bouttonBro;
    private JButton bouttonZinc;
    private JButton bouttonLien;

    private JTextArea labelInfo;
    private Homme prsn;
    public int transit = 0;

    // private JComboBox<String> comboBox;
    // private JTextField textField1;
    // private JTextField textField2;

    public fntrMain(arbreGen arbre, Personnes prsn, String[] entete, Object[][] tab, int transit, JFrame windo) {
        this.arbre = arbre;
        this.setTitle("Arbre Généalogique");

        labelInfo = new JTextArea("Cliquez sur le bouton pour afficher le NOM  personne");
        labelInfo.setEditable(false);
        labelInfo.setBackground(Color.GRAY);
        labelInfo.setForeground(Color.WHITE);
        labelInfo.setFont(new Font("Arial", Font.BOLD, 14));
        labelInfo.setWrapStyleWord(true);
        labelInfo.setLineWrap(true);
        

        JScrollPane scrollPane = new JScrollPane(labelInfo);
        scrollPane.setPreferredSize(new Dimension(300, 50));

        bouttonAnc = new JButton("Afficher les Ancestre ");
        bouttonarbre = new JButton("aff l'arbre genealogique  ");
        bouttonBro = new JButton("afficher les freres  ");
        bouttonZinc = new JButton("afficher les cousins ");
        bouttonLien = new JButton("afficher les liens direct  ");

        Dimension size = new Dimension(100, 40); 
        Dimension size2 = new Dimension(300, 25); 
       // JComboBox<String> comboBox;
        // private JTextField textField1;
        // private JTextField textField2;
        JComboBox<String>  comboBox = new JComboBox<>(new String[]{"Select", "1 TextField", "2 TextFields"});
        
        JTextField  textField1 = new JTextField("ecris le nom de qqun");
        JTextField textField2 = new JTextField("ecris le nom de qqun");
        

        textField1.setVisible(false);
        textField2.setVisible(false);



        JPanel panelBoutons = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();// variable qui va donner sa "config" ( rgl graph ) à mes composant 
        gbc.insets = new Insets(2, 2, 2, 2); //marge autour
        gbc.fill = GridBagConstraints.HORIZONTAL; // va occuper tt la largeur 
        gbc.gridx = 0; // collone
        gbc.gridy = 0;// ligne ds la grille
        gbc.weightx = 1.0;   //----
        panelBoutons.add(comboBox, gbc);

        gbc.gridy++;
        panelBoutons.add(textField1, gbc);

        gbc.gridy++;
        panelBoutons.add(textField2, gbc);

        gbc.gridy++;// declaalge
        panelBoutons.add(Box.createVerticalStrut(20), gbc);

        gbc.gridy++;
        panelBoutons.add(bouttonarbre, gbc);

        gbc.gridy++;
        panelBoutons.add(bouttonBro, gbc);

        gbc.gridy++;
        panelBoutons.add(bouttonZinc, gbc);

        gbc.gridy++;
        panelBoutons.add(bouttonAnc, gbc);
        
        gbc.gridy++;
        panelBoutons.add(bouttonLien, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0; //  espace vertical extensible
        panelBoutons.add(Box.createVerticalGlue(), gbc);

        gbc.gridy++;
        gbc.weighty = 0;
       // panelBoutons.add(bouttonLien, gbc);


            
        JPanel panelB2 = new JPanel(new BorderLayout());
        panelB2.add(panelBoutons);
        panelB2.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        JPanel panelMain = new JPanel(new GridLayout(1, 2));// la fenetre 
        panelMain.add(panelB2);// 1er coll
        panelMain.add(scrollPane);//2eme coll

        getContentPane().add(panelMain);

        

        //ControleurArbre controleur = new ControleurArbre(arbre, labelInfo, prsn);
        
        ctrl6 controlller6 = new ctrl6(arbre, labelInfo, textField1);
        bouttonAnc.addActionListener(controlller6);

        ctrl3 controller2 = new ctrl3(windo);
        bouttonarbre.addActionListener(controller2);

        ctrl4 controller3 = new ctrl4(arbre, labelInfo, textField1);
        bouttonBro.addActionListener(controller3);

        ctrl5 controller5 = new ctrl5(arbre, labelInfo, textField1);
        bouttonZinc.addActionListener(controller5);

        ctrl2txt comboBoxController = new ctrl2txt(comboBox, textField1, textField2, panelBoutons);
        comboBox.addActionListener(comboBoxController);

        ctrl7 coltroller2txt = new ctrl7(arbre, labelInfo, textField1, textField2);
        bouttonLien.addActionListener(coltroller2txt);

        this.setSize(490, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
