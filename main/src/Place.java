import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Place extends JFrame {
    int idseat;

public Place( String idVl,String login)

{
    JFrame frame = new JFrame();
    frame.setSize(800,250);
    int i=0;

    // initialization of jbuttons:
    List<JButton> buttons = new ArrayList<JButton>();
    JButton jbutton1 = new JButton();
    while (i<120){


        buttons.add(new JButton());

        switch (i%20) {
           case 0 :
               buttons.get(i).setBackground(Color.yellow);
           case 1 :
                buttons.get(i).setBackground(Color.yellow);
           case 2 :
                buttons.get(i).setBackground(Color.yellow);
               break;

           case 8 :
                buttons.get(i).setBackground(Color.lightGray);
                break;
            default:
                buttons.get(i).setBackground(Color.WHITE);
                break;
        }

        frame.add(buttons.get(i));

        int finalI = i;
        int finalI1 = i;
        buttons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showOptionDialog(null, " sure?! \n" +
                                " Reserver cette place ? ", "Test", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if (res==0){ buttons.get(finalI).setBackground(Color.red) ;idseat= finalI1;};



            }
        });
        i++;
    }

    new JLabel().setBorder(BorderFactory.createEmptyBorder(12,33,33,5));
    JTextField txt=new JTextField();
    frame.add(txt);
//    txt.setBorder(BorderFactory.createEmptyBorder(30, 10,39, 40));
    txt.setText("siege First classe");
    txt.setBackground(Color.yellow);
    JTextField txt2=new JTextField();
    frame.add(txt2);
    txt2.setText("siege Economique");
    txt2.setBackground(Color.white);

    JTextField txt3=new JTextField();
    frame.add(txt3);
    txt3.setText("votre siege");
    txt3.setBackground(Color.red);

    JTextField txt4=new JTextField();
    frame.add(txt4);
    txt4.setText("siege reserve");
    txt4.setBackground(Color.lightGray);


  JButton confirmerBtn=new JButton();
  frame.add(confirmerBtn);
  confirmerBtn.setText("confirmer siege & continuer");

    confirmerBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String Seat="e"+idseat;
                if(idseat%20==0||idseat%20==1 || idseat%20==2) Seat="f"+idseat;
               new GestionReserv(idVl,Seat,login).setVisible(true);



            } catch (Exception en) {

            }

        }
    });




// .. set properties




//    while(i<100) {
//        JButton b1 = new JButton();
//        b1.setName("btn"+i);
//
//        b1.setVisible(true);
//        b1.setText("HelloWorld" +i);
//        b1.setSize(10,20);
//        frame.add(b1);
//        i++;
//    }
    frame.setLayout(new FlowLayout());

    frame.setVisible(true);
}


}