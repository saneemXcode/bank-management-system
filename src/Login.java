import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardtext;
    JPasswordField pintext;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i1 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label = new JLabel(i2);
        label.setBounds(70, 20, 100, 100);
        add(label);

        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        JLabel cardno = new JLabel(" Card No:");
        cardno.setBounds(120, 180, 150, 40);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        cardtext = new JTextField();
        cardtext.setBounds(300, 185, 250, 30);
        cardtext.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtext);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(128, 240, 150, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);

        pintext = new JPasswordField();
        pintext.setBounds(300, 240, 250, 30);
        pintext.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintext);

        login = new JButton("SIGN IN");
        login.setBounds(300, 330, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 330, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 380, 232, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setSize(800, 500);
        setLocation(250, 70);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardtext.setText("");
            pintext.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardtext.getText();
            String pinnumber = pintext.getText();
            String query = "select * from login where cardnumber='" + cardnumber + "'and pin='" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}