import javax.swing.*;
import javax.swing.table.TableColumn;

public class RechercheVol extends  JFrame {
    private JTextField apDepart;
    private JPanel mainPl;
    private JButton rechercherButton;
    private JTextField apArrive;
    private JTextField dDepart;
    private JTextField dArrive;
    private JTable tbVols;
    

    public RechercheVol(){
        add(mainPl);
        setTitle("hello in my first app");
        setSize(500,300);
        TableColumn avion = new TableColumn();
        tbVols.addColumn(avion);
    }
}
