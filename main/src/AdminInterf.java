import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminInterf extends JFrame {
    private JPanel mainPn;
    private JTabbedPane tabbedPane1;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton suppButton;
    private JButton afficherButton;
    private JTable VgeurTable;
    private JTextField textField1;
    private JPanel modiffierPnl;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton confirmerButton;
    private JButton actualiserButton;


    public AdminInterf() throws SQLException, ClassNotFoundException {
        add(mainPn);
        setSize(900,600);
        setTitle("espace Admin");

        Connection con=DbMethods.connect();
        Statement stmt=con.createStatement();

        String Qvoygeurs="select * from voyageur";
        String[] headers={"passeport", "nom", "prenom","adresse", "login"};
        modiffierPnl.setVisible(false);




        DbMethods.resultSetToTableModel(stmt.executeQuery(Qvoygeurs),VgeurTable,headers);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp().setVisible(true);
            }
        });
        actualiserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DbMethods.resultSetToTableModel(stmt.executeQuery(Qvoygeurs),VgeurTable,headers);
                } catch (SQLException throwables) {


                }

            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
