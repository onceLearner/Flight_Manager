import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionAdmin extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton confirmerButton;
    private JPanel mainpn;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JTextField textField6;
    private JLabel text6;
    private JLabel text7;
    private JLabel text8;
    private JTextField textField8;
    private JTextField textField7;

    /**
     *
     * @param tab number of the current tab so we know which tables to hit in the db
     */
    public GestionAdmin(int tab,int operation) throws SQLException, ClassNotFoundException {
        add(mainpn);
        setSize(400,300);
        switch (tab) {
            case 0:
                textField6.setVisible(false);
                textField8.setVisible(false);
                textField7.setVisible(false);
                text6.setVisible(false);
                text7.setVisible(false);
                text8.setVisible(false);

                confirmerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                // case of ajouter voyageur
                //
                String VayageurQuery=String.format("insert into voyageur values('%s','%s','%s','%s','%s')",
                        textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());

                String vgModify=String.format("UPDATE voyageur SET " +
                                "passeport='%s',nom='%s',prenom='%s',adresse='%s'"+
                      "where login='%s'",textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());

                    Connection con= null;
                    try {
                        con = DbMethods.connect();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = null;
                        PreparedStatement preparedStatement2=null;
                    try {
                        preparedStmt = con.prepareStatement(VayageurQuery);
                        preparedStatement2=con.prepareStatement(vgModify);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    // execute the preparedstatement
                    boolean a = false;
                    try {
                        if(operation==0) a = preparedStmt.execute();
                        else a= preparedStatement2.execute();

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (a==false) {

                        int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                        " Actuliser  votre espace ", "Test", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if(res==0) {dispose();};
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Erreur s'est intervenue",
                                "Attention",
                                JOptionPane.WARNING_MESSAGE);}

                    }
                });
            break;


            //########### tab Avion ###########################

            case 1:
                textField4.setVisible(false);
                textField5.setVisible(false);

                textField6.setVisible(false);
                textField8.setVisible(false);
                textField7.setVisible(false);
                text6.setVisible(false);
                text7.setVisible(false);
                text8.setVisible(false);

                textField8.setVisible(false);
                text4.setVisible(false);
                text5.setVisible(false);

                text1.setText("id avion ");
                text2.setText("compagnie ");
                text3.setText("nombre de place ");


                confirmerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        // case of ajouter voyageur
                        //
                        String VayageurQuery=String.format("insert into avion values('%s','%s',"+textField3.getText()+")",
                                textField1.getText(),textField2.getText());

                        String vgModify=String.format("UPDATE avion SET compagnie='%s',nb_place=10 where idAvion='%s'",textField2.getText(),textField1.getText());
                        Connection con= null;
                        try {
                            con = DbMethods.connect();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = null;
                        PreparedStatement preparedStatement2=null;
                        try {
                            preparedStmt = con.prepareStatement(VayageurQuery);
                            preparedStatement2=con.prepareStatement(vgModify);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        // execute the preparedstatement
                        boolean a = false;
                        try {
                            if(operation==0) a = preparedStmt.execute();
                            else a= preparedStatement2.execute();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if (a==false) {

                            int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                            " Actuliser  votre espace ", "Test", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE, null, null, null);

                            if(res==0) {dispose();};
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Erreur s'est intervenue",
                                    "Attention",
                                    JOptionPane.WARNING_MESSAGE);}

                    }
                });
                break;


            //########### tab Vol ###########################

            case 2:


                text1.setText(" identifiant vol");
                text2.setText("identifiant avion ");
                text3.setText("data depart ");
                text4.setText("heure depart ");
                text5.setText("heure depart ");


                confirmerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        // case of ajouter voyageur
                        //
                        String VayageurQuery=String.format("insert into vol values('%s','%s','%s','%s','%s',"+textField6.getText()+",'%s','%s')",
                                textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField7.getText(),textField8.getText());

                        String vgModify=String.format("UPDATE vol SET compagnie='%s',nb_place=10 where idAvion='%s'",textField2.getText(),textField1.getText());
                        Connection con= null;
                        try {
                            con = DbMethods.connect();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = null;
                        PreparedStatement preparedStatement2=null;
                        try {
                            preparedStmt = con.prepareStatement(VayageurQuery);
                            preparedStatement2=con.prepareStatement(vgModify);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        // execute the preparedstatement
                        boolean a = false;
                        try {
                            if(operation==0) a = preparedStmt.execute();
                            else a= preparedStatement2.execute();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if (a==false) {

                            int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                            " Actuliser  votre espace ", "Test", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE, null, null, null);

                            if(res==0) {dispose();};
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Erreur s'est intervenue",
                                    "Attention",
                                    JOptionPane.WARNING_MESSAGE);}

                    }
                });
                break;

             // ################### taab Billet

            case 3:
                textField6.setVisible(false);
                textField8.setVisible(false);
                textField7.setVisible(false);
                text6.setVisible(false);
                text7.setVisible(false);
                text8.setVisible(false);
                text1.setText(" identifiant billet");
                text2.setText("date reservation ");
                text3.setText("data voyage ");
                textField2.setText("2020-06-26");
                text4.setText("heure Arive ");
                text5.setText("Etat de billet ");

                confirmerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        // case of ajouter voyageur
                        //
                        String VayageurQuery=String.format("insert into billet values('%s','%s','%s','%s','%s')",
                                textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());

                        String vgModify=String.format("UPDATE billet SET " +
                                "dateReservation='%s',dateVoyage='%s',dateArrive='%s',etat='%s'"+
                                "where idBillet='%s'",textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField1.getText());

                        Connection con= null;
                        try {
                            con = DbMethods.connect();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = null;
                        PreparedStatement preparedStatement2=null;
                        try {
                            preparedStmt = con.prepareStatement(VayageurQuery);
                            preparedStatement2=con.prepareStatement(vgModify);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        // execute the preparedstatement
                        boolean a = false;
                        try {
                            if(operation==0) a = preparedStmt.execute();
                            else a= preparedStatement2.execute();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        if (a==false) {

                            int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                            " Actuliser  votre espace ", "Test", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE, null, null, null);

                            if(res==0) {dispose();};
                        }
                        else {
                            JOptionPane.showMessageDialog(null,
                                    "Erreur s'est intervenue",
                                    "Attention",
                                    JOptionPane.WARNING_MESSAGE);}

                    }
                });
                break;



        }


        // listner for the confirm button

    }

}
