import com.sun.javafx.scene.control.skin.TableHeaderRow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.*;
import java.util.ArrayList;

public class DbMethods {


    /**
     *
     * @return return the Connection oject
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/flight", "root", "");
        return  con;
    }

    /**
     *
     * @param user_query the query you want to excecute
     * @param Number_of_collumn how many columns you select in your query ( case * is number of columns in your table)
     * @return return an araylist of araylist ( [[],[]]) so use filter map ... to to iterate through them;
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static ArrayList<ArrayList> query(String user_query,int Number_of_collumn) throws SQLException, ClassNotFoundException {
        ArrayList<ArrayList> returned_array=new ArrayList<>();
        Connection con=connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(user_query);

        while (rs.next()){
            ArrayList<String> row=new ArrayList<>();


            for(int j=0;j<Number_of_collumn;j++)  row.add(rs.getString(j+1));
            returned_array.add(row);



        }
        con.close();
        return returned_array;



    }

    // function to  populate the data inside the table
    public static void resultSetToTableModel(ResultSet rs, JTable table, String [] columns_header) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();


        // adding the header


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

        tableModel.addRow(columns_header);

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);

            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);

        }



        //Now add that table model to your table and you are done :D

        table.setModel(tableModel);

    }





}
