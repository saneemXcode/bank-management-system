import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinText, rePinText;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 845, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 745);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 235, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(165, 300, 150, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system", Font.BOLD, 14));
        image.add(pintext);

        pinText = new JPasswordField();
        pinText.setBounds(300, 300, 200, 25);
        pinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinText);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(165, 350, 125, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("system", Font.BOLD, 14));
        image.add(repintext);

        rePinText = new JPasswordField();
        rePinText.setBounds(300, 350, 200, 25);
        rePinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(rePinText);

        back = new JButton("BACK");
        back.setBounds(350, 435, 150, 25);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("system", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);

        change = new JButton("CHANGE");
        change.setBounds(160, 435, 150, 25);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("system", Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change);

        setLayout(null);
        setBounds(250, 0, 900, 845);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pinText.getText();
                String rpin = rePinText.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enetr PIN ");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update  bank set pin='" + rpin + "'where pin ='" + pinnumber + "'";
                String query2 = "update  login set pin='" + rpin + "'where pin ='" + pinnumber + "'";
                String query3 = "update  signupThree set pincard='" + rpin + "'where pincard ='" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN  changed Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);

    }
}
