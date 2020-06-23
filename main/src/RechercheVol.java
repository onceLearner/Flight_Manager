import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
        setSize(600,400);
        dDepart.setText("2020-06-30");

        String[] columns_header = {"Depart","Destination","date Depart","heure depart","heure arrive","duree","compagnie"};




        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qr=String.format("select aeroportDepart,aeroportArrive,dateDepart,heureDepart, heureArrive, duree,compagnie from vol natural join avion " +
                        "where dateDepart='%s'and aeroportDepart='%s' and aeroportArrive='%s'",dDepart.getText(),apDepart.getText().toLowerCase(),apArrive.getText().toLowerCase());
                try {


                    Connection con=DbMethods.connect();
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(qr);

                    DbMethods.resultSetToTableModel(rs,tbVols,columns_header);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

    }
}
// TODO: 21/06/2020 you have to add headings to tables