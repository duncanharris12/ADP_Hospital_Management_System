package za.ac.cput.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientMainScreen extends JDialog implements ActionListener {
    private JTabbedPane tabbedPane1;
    private JButton bookAppointmentButton;
    private JButton viewMedicationButton;
    private JButton viewTestResultsButton;
    private JButton viewMedicalRecordButton;
    private JPanel jPanel;

    public PatientMainScreen(JFrame parent) {
        super(parent);
        setTitle("Patient");
        setContentPane(jPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        bookAppointmentButton.addActionListener(this);
        viewMedicationButton.addActionListener(this);
        viewTestResultsButton.addActionListener(this);
        viewMedicalRecordButton.addActionListener(this);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bookAppointmentButton){

        }else if (e.getSource() == viewMedicationButton){

        }else if (e.getSource() == viewTestResultsButton)
        {

        }else if  (e.getSource() == viewMedicalRecordButton)
        {
            dispose();
            ViewMedicalRecords vm = new ViewMedicalRecords();
            vm.setGUI();
        }
    }

    public static void main(String[] args) {
        PatientMainScreen psm = new PatientMainScreen( null);
    }
}

