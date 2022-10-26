package za.ac.cput.Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel lblPatientID;
    private JTextField txtPatientID;
    private JLabel lblTestType;
    private JComboBox testType;
    private JTextArea tOut;

    private JButton save;
    private JButton delete;
    private JButton getTest;
    //private JButton read;
    private JButton newTest;


    private String testTypes[]
            = {"Blood Analysis", "Gastric Fluid Analysis", "Kidney Function Test", "Liver Function Test",
            "Malabsorption Test", "Pap Smear", "Prenatal Testing", "Protein-bound iodine test", "Syphilis Test", "Thyroid Function Test",
            "Urinalysis/Uroscopy", "Autopsy", "Palpation"};

    public TestPatient() {
        setTitle("Test Patient");
        setBounds(600, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);


        title = new JLabel("Test Service For Patient");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(400, 35);
        title.setLocation(300, 30);
        c.add(title);

        lblPatientID = new JLabel("Patient ID");
        lblPatientID.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPatientID.setSize(100, 20);
        lblPatientID.setLocation(100, 100);
        c.add(lblPatientID);

        txtPatientID = new JTextField();
        txtPatientID.setFont(new Font("Arial", Font.PLAIN, 15));
        txtPatientID.setSize(190, 20);
        txtPatientID.setLocation(200, 100);
        c.add(txtPatientID);


        lblTestType = new JLabel("Test Type");
        lblTestType.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTestType.setSize(200, 20);
        lblTestType.setLocation(100, 150);
        c.add(lblTestType);

        testType = new JComboBox(testTypes);
        testType.setFont(new Font("Arial", Font.PLAIN, 15));
        testType.setSize(200, 45);
        testType.setLocation(200, 150);
        c.add(testType);


        tOut = new JTextArea();
        tOut.setFont(new Font("Arial", Font.PLAIN, 15));
        tOut.setSize(300, 400);
        tOut.setLocation(500, 100);
        tOut.setLineWrap(true);
        tOut.setEditable(false);
        c.add(tOut);


        save = new JButton("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 15));
        save.setSize(80, 20);
        save.setLocation(100, 475);
        save.addActionListener(this);
        c.add(save);

        delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(80, 20);
        delete.setLocation(180, 475);
        delete.addActionListener(this);
        c.add(delete);

        getTest = new JButton("Get Tests");
        getTest.setFont(new Font("Arial", Font.PLAIN, 15));
        getTest.setSize(120, 20);
        getTest.setLocation(260, 475);
        getTest.addActionListener(this);
        c.add(getTest);


        newTest = new JButton("New Test");
        newTest.setFont(new Font("Arial", Font.PLAIN, 15));
        newTest.setSize(120, 20);
        newTest.setLocation(370, 475);
        newTest.addActionListener(this);
        c.add(newTest);


        setVisible(true);

    }

    public static void main(String[] args) {
        TestPatient tp = new TestPatient();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            String data1 = "Patient ID: " + txtPatientID.getText() + "\n";

            String data2 = "Test Type: " + testType.getSelectedItem();

            tOut.setText(data1 + data2);

            tOut.setEditable(false);


        }

        if (e.getSource() == newTest) {
            String def = "";
            txtPatientID.setText(def);
            testType.setSelectedIndex(0);
            tOut.setText(def);

        }
    }
}

