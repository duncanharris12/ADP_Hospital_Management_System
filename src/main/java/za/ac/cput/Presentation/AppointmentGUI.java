package za.ac.cput.Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/*
 * Book Appointment GUI.java
 * This is an updated file
 * @Author Chuma Nxazonke (219181187)
 * 25 October 2022
 */
public class AppointmentGUI extends JFrame implements ActionListener {

    private JFrame mainframe;
    private JPanel panelWest, panelCenter, panelEast, panelSouth;


    private JTextArea tOut;
    private JLabel lblAppointmentID;
    private JTextField txtAppointmentID;
    private JLabel lblError_appointmentID;

    private JLabel lblDoctorID;
    private JTextField txtDoctorID;
    private JLabel lblError_DoctorID;


    private JLabel lblAppointmentType;
    private JTextField txtAppointmentType;
    private JLabel lblError_AppointmentType;

    private JLabel lblAppointmentDescription;
    private JPasswordField txtAppointmentDescription;
    private JLabel lblError_AppointmentDescription;

    private JLabel lbl_AppointmentDay;
    private JPasswordField txtAppointmentDay;
    private JLabel lblError_AppointmentDay;

    private JLabel lblAppointmentMonth;
    private JPasswordField txtAppointmentMonth;
    private JLabel lblError_AppointmentMonth;


    private JButton btnBookAppointment;
    private JButton btnResetBooking;
    private JButton btnExit;

    public AppointmentGUI() {
        super("Book Appointment ");
        mainframe = new JFrame("Book appointment frame");
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();


        lblAppointmentID = new JLabel("Appointment ID: ");
        txtAppointmentID = new JTextField(20);
        lblError_appointmentID = new JLabel("Required"); // needs fixing
        lblError_appointmentID.setForeground(Color.red);
        lblError_appointmentID.setVisible(false);

        lblDoctorID = new JLabel("Doctor ID: ");
        txtDoctorID = new JTextField(20);
        lblError_DoctorID = new JLabel("Required"); 
        lblError_DoctorID.setForeground(Color.red);
        lblError_DoctorID.setVisible(false);



        lblAppointmentType = new JLabel("Appointment Type: ");
        txtAppointmentType = new JTextField(20);
        lblError_AppointmentType = new JLabel("Required");
        lblError_AppointmentType.setForeground(Color.red);
        lblError_AppointmentType.setVisible(false);

        lblAppointmentDescription = new JLabel("Appointment Description: ");
        txtAppointmentDescription = new JPasswordField(20);
        lblError_AppointmentDescription = new JLabel("Required");
        lblError_AppointmentDescription.setForeground(Color.red);
        lblError_AppointmentDescription.setVisible(false);

        lbl_AppointmentDay = new JLabel("Appointment Day: ");
        txtAppointmentDay = new JPasswordField(20);
        lblError_AppointmentDay = new JLabel("Required");
        lblError_AppointmentDay.setForeground(Color.red);
        lblError_AppointmentDay.setVisible(false);

        lblAppointmentMonth = new JLabel("Appointment Month");
        txtAppointmentMonth = new JPasswordField(20);
        lblError_AppointmentMonth = new JLabel("*Required");
        lblError_AppointmentMonth.setForeground(Color.red);
        lblError_AppointmentMonth.setVisible(false);

        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent E) {
                System.exit(0);
            }
        });



        btnBookAppointment = new JButton("BookAppointment");
        btnResetBooking = new JButton("ResetBooking");
        btnExit = new JButton("Exit");
        mainframe.setSize(300, 450);
        mainframe.setVisible(true);
    }

    public void setGUI() {
        mainframe.add(panelWest);
        mainframe.add(panelCenter);
        mainframe.add(panelEast);
        mainframe.add(panelSouth);
        panelWest.setLayout(new GridLayout(9, 1)); // sets first column for labels
        panelCenter.setLayout(new GridLayout(9, 1));//sets second column for input fields
        panelEast.setLayout(new GridLayout(9, 1)); //sets last column for error massages
        panelSouth.setLayout(new GridLayout(1, 3)); //sets bottum row for buttons


        panelWest.add( lblAppointmentID);
        panelCenter.add(  txtAppointmentID);
        panelEast.add( lblError_appointmentID);

        panelWest.add( lblDoctorID);
        panelCenter.add(txtDoctorID);
        panelEast.add(lblError_DoctorID);


        panelWest.add(lblAppointmentType);
        panelCenter.add(txtAppointmentType);
        panelEast.add(lblError_AppointmentType);


        panelWest.add(lblAppointmentDescription);
        panelCenter.add(txtAppointmentDescription);
        panelEast.add(lblError_AppointmentDescription);

        panelWest.add( lbl_AppointmentDay);
        panelCenter.add(txtAppointmentDay);
        panelEast.add (lblError_AppointmentDay);


        panelWest.add(lblAppointmentMonth);
        panelCenter.add(txtAppointmentMonth);
        panelEast.add(lblError_AppointmentMonth);

        panelSouth.add(btnBookAppointment);
        panelSouth.add(btnResetBooking);
        panelSouth.add(btnExit);

        btnBookAppointment.addActionListener(this);
        btnResetBooking.addActionListener(this);
        btnExit.addActionListener(this);

        mainframe.add(panelWest, BorderLayout.WEST);
        mainframe.add(panelCenter, BorderLayout.CENTER);
        mainframe.add(panelEast, BorderLayout.EAST);
        mainframe.add(panelSouth, BorderLayout.SOUTH);

        mainframe.setSize(612, 612);
        mainframe.pack();
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==  btnBookAppointment) {

            String data1 = "Appointment ID: " + txtAppointmentID.getText() + "\n";
            String data2 = "Doctor ID: " + txtDoctorID.getText() + "\n";
            String data3 = "Appointment Type: " + txtAppointmentType.getText() + "\n";
            String data4 = "Appointment Description: " + txtAppointmentDescription.getText() + "\n";
            String data5 = "Appointment Day: " + txtAppointmentDay.getText() + "\n";

            String data6 = "Appointment Month: " + txtAppointmentMonth.getText();

            tOut.setText(data1 + data2 + data3 + data4 + data5 + data6);

            tOut.setEditable(false);


        }

        if (e.getSource() == btnResetBooking) {
            String def = "";
            txtAppointmentID.setText(def);
           txtDoctorID.setText(def);
            txtAppointmentType.setText(def);
            txtAppointmentDescription.setText(def);
            txtAppointmentDay.setText(def);
            txtAppointmentMonth.setText(def);

            tOut.setText(def);

        }


        if (e.getSource() == btnExit) {
            System.exit(0);

        }
    }

    public static void main(String[] args) {
        AppointmentGUI appointmentGUI = new AppointmentGUI();
    }

}
