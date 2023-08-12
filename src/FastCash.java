
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 845, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 740);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215, 235, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(159, 328, 150, 22);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("system", Font.BOLD, 16));
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(345, 328, 170, 22);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("system", Font.BOLD, 16));
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(159, 361, 150, 22);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("system", Font.BOLD, 16));
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(345, 361, 170, 22);
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("system", Font.BOLD, 16));
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(159, 395, 150, 22);
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("system", Font.BOLD, 16));
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(345, 395, 170, 22);
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("system", Font.BOLD, 16));
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("Back");
        b7.setBounds(345, 429, 170, 22);
        b7.setForeground(Color.BLACK);
        b7.setFont(new Font("system", Font.BOLD, 16));
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setBounds(280, 0, 900, 845);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b7) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount
                        + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs ." + amount + "  Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
