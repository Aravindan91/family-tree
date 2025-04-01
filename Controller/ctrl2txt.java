
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ctrl2txt implements ActionListener {
    /*
     * controller permettant de faire un choix dans le combobox 
     */
    private JComboBox<String> comboBox;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panelBoutons;

    public ctrl2txt(JComboBox<String> comboBox, JTextField txt1, JTextField txt2, JPanel pb) {
        this.comboBox = comboBox;
        this.textField1 = txt1;
        this.textField2 = txt2;
        this.panelBoutons = pb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Option = (String) comboBox.getSelectedItem();
        // ca renvoi l'element slectioné dans la lst deroualnate ( de base type Object )

        if ("1 TextField".equals(Option)) {
            textField1.setVisible(true);
            textField2.setVisible(false);
        } else if ("2 TextFields".equals(Option)) {
            textField1.setVisible(true);
            textField2.setVisible(true);
        } else {
            textField1.setVisible(false);
            textField2.setVisible(false);
        }
        /*
         * redefini la taille et à l'app en fonction des choix prise
         */
        panelBoutons.revalidate();
        panelBoutons.repaint();
    }
}
