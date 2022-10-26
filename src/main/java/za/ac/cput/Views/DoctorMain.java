package za.ac.cput.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorMain {
    private JTabbedPane tabbedPane1;
    private JButton sendTestToLabButton;
    private JButton viewTestResultsButton;
    private JButton prescribeMedicationButton;
    private JButton scheduleButton;
    private JButton signOutButton;

    public DoctorMain() {
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sendTestToLabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        prescribeMedicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        viewTestResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        DoctorMain doctorMain = new DoctorMain();
    }
}
