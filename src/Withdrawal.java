import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField textField;
    JButton withdrawal, back;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 845, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 740);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(200, 235, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        textField = new JTextField();
        textField.setBounds(185, 285, 320, 30);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(textField);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355, 385, 150, 30);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setFont(new Font("system", Font.BOLD, 16));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

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
        if (ae.getSource() == withdrawal) {
            String amount = textField.getText();
            Date date = new Date();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                } else {

                    String query = " insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount
                            + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + "  Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Withdrawal("");

    }
}
