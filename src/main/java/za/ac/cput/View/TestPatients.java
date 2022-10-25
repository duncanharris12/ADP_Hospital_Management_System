package za.ac.cput.View;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.TestPatientFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static za.ac.cput.View.OkHttp.storeTest;

public class TestPatients extends JDialog implements ActionListener {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    private JPanel TestPanel;
    private JTextField txtTestID;
    private JTextField txtPatientID_3;
    private JComboBox cTestName;
    private JButton addTestButton;

    public TestPatients(JFrame parent){
        super(parent);
        setTitle("Test");
        setContentPane(TestPanel);
        setMinimumSize(new Dimension(800,474));
        setModal(true);
        setLocationRelativeTo(parent);

        addTestButton.addActionListener(this);

        setVisible(true);


    }

    private void registerPatient() {
        try {
            String testID = txtTestID.getText();
            //String patientID = txtPatientID_3.getText();
            String testName;

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTestButton){
            String testName = null;
            if(cTestName.getSelectedItem() != null){
                testName = cTestName.getSelectedItem().toString();
            }

            try {
                storeTest(txtTestID.getText(),testName);
                JOptionPane.showMessageDialog(null,"Test successfully added");

                JOptionPane.showMessageDialog(null,"Error- Test could not be added");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



    }



    public static void main(String[] args) {
        TestPatients tp = new TestPatients(null);
    }


}

