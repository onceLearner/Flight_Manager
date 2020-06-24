import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp  extends JFrame {

    private JTextField login;
    private JTextField pwd1;
    private JTextField pwd2;
    private JTextField pssport;
    private JTextField prenom;
    private JTextField nom;
    private JTextField adress;
    private JButton enregistrerButton;
    private JPanel mainPn;

    public SignUp() {
        add(mainPn);
        setTitle("registration");
        setSize(500,400);
        enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userquer=String.format("insert into utilisateur values ('%s','%s','voyageur')",login.getText(),pwd1.getText());
                String VayageurQuery=String.format("insert into voyageur values('%s','%s','%s','%s','%s')",
                        pssport.getText(),prenom.getText(),nom.getText(),adress.getText(),login.getText());
                try {
                    Connection con=DbMethods.connect();
                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = con.prepareStatement(userquer);
                    PreparedStatement preparedStmt2 = con.prepareStatement(VayageurQuery);



                    // execute the preparedstatement
                    boolean a = preparedStmt.execute();
                     boolean b = preparedStmt2.execute();
                     if (a==false && b==false) {

                         int res = JOptionPane.showOptionDialog(null, "Succes! \n" +
                                         "veuillez vous connecter ", "Test", JOptionPane.DEFAULT_OPTION,
                                 JOptionPane.INFORMATION_MESSAGE, null, null, null);

                         if(res==0) {dispose();  new LandingPage().setVisible(true);};
                     }
                     else {
                         System.out.println(a +"and b is :"+b);
                    JOptionPane.showMessageDialog(null,
                            "Erreur s'est intervenue",
                            "Attention",
                            JOptionPane.WARNING_MESSAGE);}


                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
}

