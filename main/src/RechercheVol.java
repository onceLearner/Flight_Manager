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

    // function to  populate the data inside the table
    public void resultSetToTableModel(ResultSet rs, JTable table, String [] columns_header) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();

        // adding the header
        tableModel.addRow(columns_header);


        //Retrieve meta data from ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);

            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(columns_header);
            tableModel.addRow(row);

        }


        //Now add that table model to your table and you are done :D

        table.setModel(tableModel);
    }




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
                    ArrayList<?> flights=DbMethods.query(qr,7);
                    System.out.println(flights);

                    Connection con=DbMethods.connect();
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(qr);

                    resultSetToTableModel(rs,tbVols,columns_header);

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