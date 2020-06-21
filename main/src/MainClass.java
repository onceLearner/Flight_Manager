import java.sql.*;
import java.util.ArrayList;

public class MainClass  {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LandingPage landingPage=new LandingPage();
        VoyageurInterface voyageurInterface= new VoyageurInterface();
        SignUp signUp=new SignUp();
        voyageurInterface.setVisible(false);
        landingPage.setVisible(true);
        signUp.setVisible(false);
//        Connection con=DbMethods.connect();
//
//        ArrayList<?> result=DbMethods.query("select compagnie from avion",1);
//        System.out.println(result);
//        con.close();
    }

}



/*
*database connection and retrieving data ;
* //        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con= DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/youssef","root","");
////here sonoo is database name, root is username and password
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from personnes");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//            con.close();
//
//        } catch (Exception e){System.out.println(e);}
* */