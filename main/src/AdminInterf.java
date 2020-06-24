
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminInterf extends JFrame {
    private JPanel mainPn;
    private JTabbedPane tabbedPane1;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton suppButton;
    private JButton afficherButton;
    private JTable VgeurTable;
    private JTextField textField1;
    private JPanel modiffierPnl;
    private JButton actualiserButton;
    private JTable tableAvion;
    private JTable tableVol;
    private JTable tableBillet;
    private JButton actualiserAvion;
    private JButton actualiserVol;
    private JButton actualiser3Button;
    private JButton ajouterAvion;
    private JButton modifierAvion;
    private JButton suppAvion;
    private JButton ajouterVol;
    private JButton modierVol;
    private JButton suppVol;
    private JTextField BillettextField1;
    private JTextField idVolTct;
    private JTextField idAvionTxt;
    private JButton supp3Button;
    private JButton modifier3Button;
    private JButton ajouter3Button;


    public AdminInterf() throws SQLException, ClassNotFoundException {
        add(mainPn);
        setSize(900,600);
        setTitle("espace Admin");

        Connection con=DbMethods.connect();
        Statement stmt=con.createStatement();

        String Qvoygeurs="select * from voyageur";
        String QAvion="select * from avion";
        String QVol="select * from vol";
        String QBillet="select * from billet";

        String[] headers_voyageur={"passeport", "nom", "prenom","adresse", "login"};
        String[] headers_avion={"identifient avion", "Compagnie", "nb de place"};
        String[] headers_vol={"identifiant  Vol", "identifiant avion", "date depart","heure Depart", "heure Arrive","duree","aeroport depart","aeroport Arrive"};
        String[] headers_billet={"identifiant  billet", "date reservation", "date voyage","date arrive", "etat"};




        DbMethods.resultSetToTableModel(stmt.executeQuery(Qvoygeurs),VgeurTable,headers_voyageur);
        DbMethods.resultSetToTableModel(stmt.executeQuery(QAvion),tableAvion,headers_avion);
        DbMethods.resultSetToTableModel(stmt.executeQuery(QVol),tableVol,headers_vol);
        DbMethods.resultSetToTableModel(stmt.executeQuery(QBillet),tableBillet,headers_billet);


        // tab voyagerur
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,0).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,1).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        suppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int res = JOptionPane.showOptionDialog(null, "Attentin! \n" +
                                    "supprimer voyageur identifie par: ? " +textField1.getText(), "Warning", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, null);

                    if(res==0) {
                        String delete_query =String.format("delete from voyageur where login='%s'",textField1.getText());
                        Connection con=DbMethods.connect();
                        PreparedStatement preparedStmt = con.prepareStatement(delete_query);
                        preparedStmt.execute();
                        con.prepareStatement("delete from utilisateur where login='"+textField1.getText()+"'").execute();
                    };




                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,2).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });



        actualiserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    DbMethods.resultSetToTableModel(stmt.executeQuery(Qvoygeurs),VgeurTable,headers_voyageur);


                } catch (SQLException throwables) {


                }

            }
        });



        //############################### tab Avion ########################


        ajouterAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(1,0).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        modifierAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(1,1).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        suppAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int res = JOptionPane.showOptionDialog(null, "Attentin! \n" +
                                    "supprimer Avion  identifie par: ? " +idAvionTxt.getText(), "Warning", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, null);

                    if(res==0) {
                        String delete_query =String.format("delete from Avion where idAvion='%s'",idAvionTxt.getText());
                        Connection con=DbMethods.connect();
                        PreparedStatement preparedStmt = con.prepareStatement(delete_query);
                        preparedStmt.execute();
                    };




                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,2).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });



        actualiserAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    DbMethods.resultSetToTableModel(stmt.executeQuery(QAvion),tableAvion,headers_avion);



                } catch (SQLException throwables) {


                }

            }
        });

        // ###########tab Vol #####################

        ajouterVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(2,0).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        modierVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(2,1).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        suppVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int res = JOptionPane.showOptionDialog(null, "Attentin! \n" +
                                    "supprimer vol identifie par: ? " +idVolTct.getText(), "Warning", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, null);

                    if(res==0) {
                        String delete_query =String.format("delete from vol where idVol='%s'",idVolTct.getText());
                        Connection con=DbMethods.connect();
                        PreparedStatement preparedStmt = con.prepareStatement(delete_query);
                        preparedStmt.execute();
                    };




                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,2).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });



        actualiserVol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    DbMethods.resultSetToTableModel(stmt.executeQuery(QVol),tableVol,headers_vol);



                } catch (SQLException throwables) {


                }

            }
        });



        // ################## tab billet###########
        ajouter3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(3,0).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        modifier3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(3,1).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });

        supp3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int res = JOptionPane.showOptionDialog(null, "Attentin! \n" +
                                    "supprimer billet identifie par: ? " +BillettextField1.getText(), "Warning", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, null, null);
                    if(res==0) {
                        String delete_query =String.format("delete from billet where idBillet='%s'",BillettextField1.getText());
                        Connection con=DbMethods.connect();
                        PreparedStatement preparedStmt = con.prepareStatement(delete_query);
                        preparedStmt.execute();
                    };




                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });


        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new GestionAdmin(0,2).setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }

            }
        });



        actualiser3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    DbMethods.resultSetToTableModel(stmt.executeQuery(QBillet),tableBillet,headers_billet);


                } catch (SQLException throwables) {


                }

            }
        });




    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
