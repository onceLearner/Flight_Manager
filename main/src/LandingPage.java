

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class LandingPage  extends  JFrame {
    private JRadioButton radio_voyageur;
    private JRadioButton radio_admin;
    private  ButtonGroup bgUserType;


    private JPasswordField pwdTxt;

    private JTextField loginTxt;
    private JPanel root_pannel;
    private JButton AuthBtn;
    private JButton creerUnCompteButton;
    private JButton AutkBtn;


    public LandingPage(){
        radio_voyageur.setSelected(true);
        add(root_pannel);
        setTitle("hello in my first app");
        setSize(500,350);



        AuthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Role=radio_voyageur.isSelected()==true ?"voyageur":"admin";


                    String  qr="select login from utilisateur where login='"+loginTxt.getText()+"' and pwd='"+pwdTxt.getText()+"' and role='"+Role+"'";

                    ArrayList<?> users=DbMethods.query(qr,1);
                    if (users.isEmpty())  {
                    JOptionPane.showMessageDialog(null,
                            "utilisateur inexistant",
                            "Attention",
                            JOptionPane.WARNING_MESSAGE);}
                    else {
                        int res = JOptionPane.showOptionDialog(null, "Hello", "Test", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);
                      VoyageurInterface vgi=new VoyageurInterface();
                      if(res==0) {dispose(); vgi.setVisible(true);};
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        creerUnCompteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUp().setVisible(true);
            }
        });
    }

}
