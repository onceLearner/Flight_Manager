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
            ArrayList<String> rows=new ArrayList<String>();

            for(int j=1;j<=Number_of_collumn;j++)  rows.add(rs.getString(j));
            returned_array.add(rows);
        }
        con.close();
        return returned_array;



    }




}
