package za.ac.cput.Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Patient extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel lblPatientName;
    private JTextField txtPatientName;
    private JLabel lblAddress;
    private JTextArea tAddress;
    private JLabel lblPhone_number;
    private JTextField txtPhone_number;
    private JLabel lblSex;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup sexgp;
    private JLabel lblAge;
    private JTextField txtAge;
    private JLabel lblPassword;
    private JPasswordField pPassword;
    private JButton save ;
    private JButton delete;
    private JButton getPatients;
    //private JButton read;
    private JButton newPatient;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resAdd;

    public  Patient(){
        setTitle("Patient");
        setBounds(600, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Patient Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(400, 35);
        title.setLocation(300, 30);
        c.add(title);


        lblPatientName = new JLabel("Patient Name");
        lblPatientName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPatientName.setSize(100, 20);
        lblPatientName.setLocation(100, 100);
        c.add(lblPatientName);

        txtPatientName = new JTextField();
        txtPatientName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtPatientName.setSize(190, 20);
        txtPatientName.setLocation(200, 100);
        c.add(txtPatientName);



        lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        lblAddress.setSize(100, 20);
        lblAddress.setLocation(100, 150);
        c.add(lblAddress);

        tAddress = new JTextArea();
        tAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        tAddress.setSize(200, 75);
        tAddress.setLocation(200, 150);
        tAddress.setLineWrap(true);
        c.add(tAddress);


        lblPhone_number = new JLabel("Phone number");
        lblPhone_number.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPhone_number.setSize(100, 20);
        lblPhone_number.setLocation(100, 250);
        c.add(lblPhone_number);

        txtPhone_number = new JTextField();
        txtPhone_number.setFont(new Font("Arial", Font.PLAIN, 15));
        txtPhone_number.setSize(190, 20);
        txtPhone_number.setLocation(200, 250);
        c.add(txtPhone_number);

        lblSex = new JLabel("Sex");
        lblSex.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSex.setSize(100, 20);
        lblSex.setLocation(100, 300);
        c.add(lblSex);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(70, 15);
        male.setLocation(250, 300);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(75, 15);
        female.setLocation(320, 300);
        c.add(female);

        sexgp = new ButtonGroup();
        sexgp.add(male);
        sexgp.add(female);

        lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Arial", Font.PLAIN, 15));
        lblAge.setSize(100, 20);
        lblAge.setLocation(100, 350);
        c.add(lblAge);

        txtAge = new JTextField();
        txtAge.setFont(new Font("Arial", Font.PLAIN, 15));
        txtAge.setSize(190, 20);
        txtAge.setLocation(200, 350);
        c.add( txtAge);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        lblPassword.setSize(100, 20);
        lblPassword.setLocation(100, 400);
        c.add(lblPassword);

        pPassword = new JPasswordField();
        pPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        pPassword.setSize(190, 20);
        pPassword.setLocation(200, 400);
        c.add(pPassword);


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

        getPatients = new JButton("Get Patients");
        getPatients.setFont(new Font("Arial", Font.PLAIN, 15));
        getPatients.setSize(120, 20);
        getPatients.setLocation(260, 475);
        getPatients.addActionListener(this);
        c.add(getPatients);


        newPatient = new JButton("New Patient");
        newPatient.setFont(new Font("Arial", Font.PLAIN, 15));
        newPatient.setSize(120, 20);
        newPatient.setLocation(370, 475);
        newPatient.addActionListener(this);
        c.add(newPatient);



        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);


        setVisible(true);








    }


    public static void main(String[] args) {
        Patient p = new Patient();
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == save){
            String data1;
            String data = "Patient Name: "+txtPatientName.getText() +"\n" + "Address: " + tAddress.getText() +"\n"+
                    "Phone number: " +  txtPhone_number.getText() + "\n";

            if(male.isSelected())
                data1 = "Sex : Male" + "\n";
            else data1 = "Sex : Female" + "\n";



            String data2 = "Age: " + txtAge.getText() + "\n" + "Password: " + pPassword.getPassword().toString();


            tout.setText(data + data1 + data2);

            tout.setEditable(false);
        }
        if(e.getSource() == newPatient){
            String def = "";
            txtPatientName.setText(def);
            tAddress.setText(def);
            txtPhone_number.setText(def);
            txtAge.setText(def);
            pPassword.setText(def);
            tout.setText(def);



        }

    }




}

