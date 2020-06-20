import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoyageurInterface extends  JFrame {
    private JButton rechercherUnVolButton;
    private JButton reserverUnVolButton;
    private JPanel mainPl;
    RechercheVol rechercheVol=new RechercheVol();

    public VoyageurInterface(){
        add(mainPl);
        setTitle("hello in my first app");
        setSize(500,300);

        rechercherUnVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new RechercheVol().setVisible(true);
            }
        });
    }
}
