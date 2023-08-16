import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        JLabel text = new JLabel();
        add(text);

        JLabel bankname = new JLabel("Indian Bank");
        bankname.setBounds(130, 20, 100, 20);
        bankname.setFont(new Font("Raleway", Font.BOLD, 14));
        add(bankname);

        JLabel mini = new JLabel();
        mini.setBounds(20, 150, 400, 200);
        // mini.setFont(new Font("Raleway", Font.BOLD, 14));
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 14));
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 455, 300, 20);
        // balance.setFont(new Font("Raleway", Font.BOLD, 14));
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin ='" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number:" + rs.getString("cardnumber").substring(0, 4) + "-XXXX-XXXX-"
                        + rs.getString("cardnumber").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your currnent account balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("Mini Statement");
        setLayout(null);
        setBounds(210, 0, 400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

}
