import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;
import java.util.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Deposit extends JFrame implements ActionListener {
    JTextField textField;
    JButton deposit, back;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 845, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 740);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200, 235, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        textField = new JTextField();
        textField.setBounds(185, 285, 320, 30);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(textField);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 385, 150, 30);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("system", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 432, 150, 30);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("system", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setBounds(280, 0, 900, 845);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String amount = textField.getText();
            Date date = new Date();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {

                    Conn conn = new Conn();
                    String query = " insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + amount
                            + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "  Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Deposit("");

    }
}
