import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdrawal, fastcash, mimistatement, pinchange, balance, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 845, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 740);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215, 235, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(159, 328, 150, 22);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("system", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawl");
        withdrawal.setBounds(345, 328, 170, 22);
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setFont(new Font("system", Font.BOLD, 16));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(159, 361, 150, 22);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("system", Font.BOLD, 16));
        fastcash.addActionListener(this);
        image.add(fastcash);

        mimistatement = new JButton("Mini Statement");
        mimistatement.setBounds(345, 361, 170, 22);
        mimistatement.setForeground(Color.BLACK);
        mimistatement.setFont(new Font("system", Font.BOLD, 16));
        mimistatement.addActionListener(this);
        image.add(mimistatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(159, 395, 150, 22);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("system", Font.BOLD, 16));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(345, 395, 170, 22);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("system", Font.BOLD, 16));
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(345, 429, 170, 22);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("system", Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);
        setBounds(280, 0, 900, 845);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);

        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == mimistatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
