package za.ac.cput.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static za.ac.cput.View.OkHttp.save;


public class Registration1 extends JDialog implements ActionListener{

    private JTextField txtPatientID;
    private JTextField txtPatientName;
    private JTextField txtPhone_number;
    private JTextField txtAge;
    private JTextArea tAddress;
    private JPasswordField pPatientPassword;
    private JPasswordField pConfirmPassword;
    private JButton btnRegister;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    private ButtonGroup gender_gp;

    private JButton btnCancel;
    private JPanel registerPanel;


    public Registration1(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(500,474));
        setModal(true);
        setLocationRelativeTo(parent);

        btnRegister.addActionListener(this);
        btnCancel.addActionListener(this);

        gender_gp = new ButtonGroup();
        gender_gp.add(maleRadioButton);
        gender_gp.add(femaleRadioButton);

        setVisible(true );
    }

    private void registerPatient() {
        try{
            String patientID = txtPatientID.getText();
            String patientName = txtPatientName.getText();
            long phone_number = Long.parseLong(txtPhone_number.getText());
            int age = Integer.parseInt(txtAge.getText());
            String address = tAddress.getText();
            String patientPassword = String.valueOf(pPatientPassword.getPassword());
            String confirmPassword = String.valueOf(pConfirmPassword.getPassword());

            if(patientID.isEmpty()||patientName.isEmpty()|| address.isEmpty()|| patientPassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill all fields","Try again", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!patientPassword.equals(confirmPassword)){
                JOptionPane.showMessageDialog(this, "Confirm password does not match","Try again", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch(Exception e){
            e.printStackTrace();
        }






    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnRegister){

            String sex = null;
            if(maleRadioButton.isSelected()){
                sex = "Male";
            }else if(femaleRadioButton.isSelected()){
                sex = "Female";
            }


            try {
                save(txtPatientID.getText(), txtPatientName.getText(), Long.parseLong(txtPhone_number.getText()),Integer.parseInt(txtAge.getText()),sex,tAddress.getText(), String.valueOf(pPatientPassword.getPassword()));
                    JOptionPane.showMessageDialog(null, "Successfully registered");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error-could not register");
            }
            new PatientMainForm(null);


        }
        else if(e.getSource() == btnCancel)
        {
            System.exit(0);
        }



    }


    public static void main(String[] args) {
        Registration1 registration1 = new Registration1( null);
    }


}
