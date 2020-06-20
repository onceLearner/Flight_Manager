

import javax.swing.*;

public class LandingPage  extends  JFrame {
    private JRadioButton radio_voyageur=new JRadioButton();
    private JRadioButton radio_admin=new JRadioButton();
    private  ButtonGroup bgUserType=new ButtonGroup();


    private JPasswordField passwordField1;

    private JTextField textField1;
    private JPanel root_pannel;
    private JButton AuthBtn;


    public LandingPage(){
        add(root_pannel);
        setTitle("hello in my first app");
        setSize(500,300);

        bgUserType.add(radio_admin);
        bgUserType.add(radio_voyageur);

    }

}
