import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VoyageurInterface extends  JFrame {
    private JButton rechercherUnVolButton;
    private JButton reserverUnVolButton;
    private JPanel mainPl;
    private JTable table1;
    private JButton actualiserButton;
    RechercheVol rechercheVol;

    public VoyageurInterface(String login) throws SQLException, ClassNotFoundException {
        add(mainPl);
        setTitle("hello in my first app");
        setSize(600,400);
        Connection con=DbMethods.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select billet.idbillet,datereservation,datevoyage,datearrive,etat from billet natural join userBillet  where login='"+login+"'");
        String[] headers_billet={"identifiant  billet", "date reservation", "date voyage","date arrive", "etat"};
        DbMethods.resultSetToTableModel(rs,table1,headers_billet);

        rechercherUnVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new RechercheVol(0,login).setVisible(true);
            }
        });
        reserverUnVolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RechercheVol(1,login).setVisible(true);

            }
        });
        actualiserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con=DbMethods.connect();
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select billet.idbillet,datereservation,datevoyage,datearrive,etat from billet natural join userBillet  where login='"+login+"'");
                    String[] headers_billet={"identifiant  billet", "date reservation", "date voyage","date arrive", "etat"};
                    DbMethods.resultSetToTableModel(rs,table1,headers_billet);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
}
