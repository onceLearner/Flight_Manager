import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame{

    JTable jt;
    public Table() throws SQLException, ClassNotFoundException {

        String [] header={"name","age"};
        String [][] data={{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};

        Connection con=DbMethods.connect();
        Statement stmt=con.createStatement();


        String Qvoygeurs="select * from voyageur";




        DefaultTableModel model = new DefaultTableModel(data,header);

        JTable table = new JTable(model);


//        table.setPreferredScrollableViewportSize(new Dimension(450,63));
//        table.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        add(js);
        setTitle("hamid lmath");
        setSize(500,399);



    }


}