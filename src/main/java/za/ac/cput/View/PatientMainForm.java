package za.ac.cput.View;


import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Patient;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static za.ac.cput.View.OkHttp.*;


public class PatientMainForm extends JDialog implements ActionListener, ChangeListener {

    private JTabbedPane tabbedPane1;
    private JPanel MainPanel;
    private  JTextArea tDetails;
    private JButton searchButton;
    private JButton bookButton;
    private JTextArea tAppointment;
    private JTextArea tMedical;
    private JTextField txtAppointmentID;
    private JTextField txtPatientID_1;
    private JButton viewButton;
    private JTextField txtMedicationID;
    private JButton viewButton1;
    private JTextArea tMedication;
    private JTextField txtPatientID;
    private JButton viewButton2;
    private JTextArea tTestReport;
    private JPanel medicalRecordPanel;
    private JTextField txtPatientID_2;
    private JButton viewButton3;
    private JPanel detailsPanel;
    private JPanel appointmentPanel;
    private JPanel medicationPanel;
    private JPanel testReportPanel;


    public PatientMainForm(JFrame parent){
        super(parent);
        //JFrame frame = new JFrame();
        setTitle("Patient");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(800,474));
        setModal(true);
        setLocationRelativeTo(parent);




        tabbedPane1.addTab("My Details", detailsPanel);
        tabbedPane1.addTab("Appointment", appointmentPanel);
        tabbedPane1.addTab("Medical Record", medicalRecordPanel);
        tabbedPane1.addTab("Medication", medicationPanel);
        tabbedPane1.addTab("Test Report", testReportPanel);





        viewButton.addActionListener(this);
        viewButton1.addActionListener(this);
        viewButton2.addActionListener(this);
        viewButton3.addActionListener(this);
        bookButton.addActionListener(this);
        searchButton.addActionListener(this);

        tabbedPane1.addChangeListener(this);

        setVisible(true);


    }

    public void patientMain(){
        try{
            String patientID = txtPatientID_2.getText();

        }catch(Exception e){
            e.printStackTrace();
        }


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton3) {
            try {
                readById(txtPatientID_2.getText());
                JOptionPane.showMessageDialog(null, "Patient found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Patient not found!");
            }

        } else if (e.getSource() == searchButton) {
            try {
                readAppointmentById(txtAppointmentID.getText());
                JOptionPane.showMessageDialog(null, "Appointment found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Appointment not found!");
            }


        }else if (e.getSource() == bookButton){

        }else if(e.getSource() == viewButton){
            try{
                readMedicalRecordById(txtPatientID_1.getText());
                JOptionPane.showMessageDialog(null, "Medical Record  found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Medical Record not found!");
            }
        }else if(e.getSource() == viewButton1){
            try{
                readMedicationById(txtMedicationID.getText());
                JOptionPane.showMessageDialog(null, "Medication  found!");
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Medication not found!");
            }
        }else if(e.getSource()== viewButton2){
            try{
                readTestResultsById(txtPatientID.getText());
                JOptionPane.showMessageDialog(null, "Test Results  found!");
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Test Results not found!");
            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        int selectedIndex = tabbedPane.getSelectedIndex();
        JOptionPane.showMessageDialog(null, "Selected Index: " + selectedIndex);

    }
    public static void main(String[] args) {
        PatientMainForm pmf = new PatientMainForm(null);
    }
}
