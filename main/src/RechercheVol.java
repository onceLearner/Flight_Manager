import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RechercheVol extends  JFrame {
    private JTextField apDepart;
    private JPanel mainPl;
    private JButton rechercherButton;
    private JTextField apArrive;
    private JTextField dDepart;
    private JTable tbVols;
    private JTextField idVolAresever;
    private JButton reserverBtn;
    private JLabel idVollable;


    public RechercheVol(int isShown,String login){
        add(mainPl);
        setTitle("hello in my first app");
        setSize(700,450);
        dDepart.setText("2020-06-30");

        String[] columns_header = {"idVol","Depart","Destination","date Depart","heure depart","heure arrive","duree","compagnie"};

        if(isShown==0){
            reserverBtn.setVisible(false);
            idVolAresever.setVisible(false);
            idVollable.setVisible(false);
        }



        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qr=String.format("select idVol,aeroportDepart,aeroportArrive,dateDepart,heureDepart, heureArrive, duree,compagnie from vol natural join avion " +
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

        reserverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Place(idVolAresever.getText(),login).setVisible(true);

            }
        });
    }
}
// TODO: 21/06/2020 you have to add headings to tables