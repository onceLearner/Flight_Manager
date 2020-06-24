import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GestionReserv extends JFrame {


    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton terminerButton;
    private JLabel text1;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JLabel text6;
    private JLabel text7;


    public GestionReserv(String idVol,String Seat, String login) throws SQLException, ClassNotFoundException {
//         JPanel mainPn=new JPanel();
//        add(mainPn);
//        setSize(700,400);
//        JButton btn1=new JButton();
//        btn1.setText("me");
//        btn1.setVisible(true);
        Connection con=DbMethods.connect();
        ArrayList<ArrayList> ars=DbMethods.query("select compagnie,heureDepart,heureArrive,aeroportDepart,aeroportArrive,duree from vol natural join Avion where idVol='"+idVol+"'",6);
        ArrayList<ArrayList> ars2=DbMethods.query("select * from vol where idVol='"+idVol+"'",8);
        text1.setText((String) ars.get(0).get(0));
        text3.setText((String) ars.get(0).get(1));
        text4.setText((String) ars.get(0).get(2));
        text5.setText((String) ars.get(0).get(3));
        text6.setText((String) ars.get(0).get(4));



        System.out.println(ars);


        add(panel1);
        setSize(600,400);
        String idbillet=idVol+"-"+Seat;






        // listner for the confirm button

        terminerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String timeNow = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    String billetQuery = String.format("insert into billet values('%s','%s','%s','%s','valid')",
                            idbillet, timeNow, ars2.get(0).get(2), ars2.get(0).get(2));


//                    String vgModify=String.format("UPDATE vol SET compagnie='%s',nb_place=10 where idAvion='%s'",textField2.getText(),textField1.getText());
                    Connection con = null;

                        con = DbMethods.connect();
                        PreparedStatement preparedStatement = con.prepareStatement(billetQuery);
                        PreparedStatement preparedStatement1=con.prepareStatement(String.format("insert into userbillet values('%s','%s','%s')",login,idbillet,idVol));
                        boolean b=preparedStatement1.execute();
                        boolean a=preparedStatement.execute();
                        System.out.println(idbillet);
                        if (a==false) {

                            int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                            " billet reserve ", "Test", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
                            VoyageurInterface vgi=new VoyageurInterface(login);
                            if(res==0) {dispose();};
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Erreur s'est intervenue",
                                    "Attention",
                                    JOptionPane.WARNING_MESSAGE);}

                    } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


            }


        });
    }

}
