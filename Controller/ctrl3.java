
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ctrl3 implements ActionListener {
    /*
     * controller qui va afficher ma fenetre table 
     */
    private JFrame fenetre2;

    public ctrl3(JFrame fenetre2){
        this.fenetre2 = fenetre2;
    }

    public void actionPerformed(ActionEvent e){
        //System.out.println(" -- pr debug--yes ta cliqué pr ta table ");
        fenetre2.setVisible(true);
    }
}
