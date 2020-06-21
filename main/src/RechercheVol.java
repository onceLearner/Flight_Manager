import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class RechercheVol extends  JFrame {
    private JTextField apDepart;
    private JPanel mainPl;
    private JButton rechercherButton;
    private JTextField apArrive;
    private JTextField dDepart;
    private JTable tbVols;

    

    public RechercheVol(){
        add(mainPl);
        setTitle("hello in my first app");
        setSize(500,300);
        TableColumn avion = new TableColumn();
        tbVols.addColumn(avion);

        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qr="select * ";
                try {
                    ArrayList<?> flights=DbMethods.query(qr,1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

    }
}
