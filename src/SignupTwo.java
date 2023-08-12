
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField panCardTextField, addharCardTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, eduComboBox, occupationalComboBox;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW APPLICATION FORM :PAGE 2");

        JLabel additionaldetails = new JLabel("PAGE 2:Additional details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 29));
        additionaldetails.setBounds(200, 50, 700, 30);
        add(additionaldetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valreligion[] = { "Muslim", "Hindu", "Sikh", "Christian", "Other" };
        religionComboBox = new JComboBox(valreligion);
        religionComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
        categoryComboBox = new JComboBox<>(valCategory);
        categoryComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = { "null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
        incomeComboBox = new JComboBox(valIncome);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeComboBox.setForeground(new Color(105, 105, 105));
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel eduaction = new JLabel("Educational");
        eduaction.setFont(new Font("Raleway", Font.BOLD, 20));
        eduaction.setBounds(100, 290, 200, 30);
        add(eduaction);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String valeduaction[] = { "Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others" };
        eduComboBox = new JComboBox(valeduaction);
        eduComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        eduComboBox.setBounds(300, 315, 400, 30);
        eduComboBox.setBackground(Color.WHITE);
        add(eduComboBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String valOccupation[] = { "Salaried", "Self Employed", "Business", "Student", "Retired", "Others" };
        occupationalComboBox = new JComboBox(valOccupation);
        occupationalComboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationalComboBox.setBounds(300, 390, 400, 30);
        occupationalComboBox.setBackground(Color.WHITE);
        add(occupationalComboBox);

        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);

        panCardTextField = new JTextField();
        panCardTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panCardTextField.setBounds(300, 440, 400, 30);
        add(panCardTextField);

        JLabel addhar = new JLabel("Addhar Number:");
        addhar.setFont(new Font("Raleway", Font.BOLD, 20));
        addhar.setBounds(100, 490, 200, 30);
        add(addhar);

        addharCardTextField = new JTextField();
        addharCardTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addharCardTextField.setBounds(300, 490, 400, 30);
        add(addharCardTextField);

        JLabel Scitizen = new JLabel("Senior Citizen:");
        Scitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        Scitizen.setBounds(100, 540, 200, 30);
        add(Scitizen);

        syes = new JRadioButton("YES");
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        syes.setBounds(300, 540, 80, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setFont(new Font("Raleway", Font.BOLD, 14));
        sno.setBounds(450, 540, 80, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(syes);
        bGroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eyes = new JRadioButton("YES");
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        eyes.setBounds(300, 590, 80, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        eno.setBounds(450, 590, 80, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup bGroup1 = new ButtonGroup();
        bGroup1.add(eyes);
        bGroup1.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 640, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religionComboBox.getSelectedItem();
        String scategory = (String) categoryComboBox.getSelectedItem();
        String sincome = (String) incomeComboBox.getSelectedItem();
        String seducation = (String) eduComboBox.getSelectedItem();
        String soccupation = (String) occupationalComboBox.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String exisitingaccount = null;
        if (eyes.isSelected()) {
            exisitingaccount = "Yes";
        } else if (eno.isSelected()) {
            exisitingaccount = "No";
        }
        String span = panCardTextField.getText();
        String saddhar = addharCardTextField.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signupTwo values('" + formno + "','" + sreligion +
                    "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" +
                    span + "','" + saddhar + "','" + exisitingaccount + "','" + seniorcitizen
                    + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
