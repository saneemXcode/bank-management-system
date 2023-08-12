import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    public SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3:Account Details ");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 35, 400, 40);
        add(l1);

        JLabel actype = new JLabel("Account Type");
        actype.setFont(new Font("Raleway", Font.BOLD, 22));
        actype.setBounds(100, 135, 220, 30);
        add(actype);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 200, 20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100, 300, 220, 30);
        add(cardno);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-9562");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 500, 30);
        add(number);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 340, 300, 20);
        add(cardDetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 220, 30);
        add(pin);

        JLabel demopinnumber = new JLabel("XXXX");
        demopinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        demopinnumber.setBounds(330, 370, 500, 30);
        add(demopinnumber);

        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 410, 300, 20);
        add(pinDetails);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 450, 500, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 490, 200, 20);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 490, 200, 20);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 530, 200, 20);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 530, 200, 20);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 570, 200, 20);
        add(c5);

        c6 = new JCheckBox("E Statment");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 570, 200, 20);
        add(c6);

        c7 = new JCheckBox("I Hereby declares that and above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 600, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(200, 640, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(400, 640, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(350, 0, 820, 820);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = "";
            if (r1.isSelected()) {

                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Curreny Account";
            } else if (r3.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 9000000l) + 5040936000000000l);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000l) + 1000l);
            System.out.println("random number" + random);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";

            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E statement";
            }
            try {
                if (accountType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();

                    String query1 = "insert into signupThree values ('" + formno + "','" + accountType + "','"
                            + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values ('" + formno + "','"
                            + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Account as been Created Sucessfully\t \n\n Card Number :"
                            + cardnumber + "\n pin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new SignupThree(" ");
    }
}
