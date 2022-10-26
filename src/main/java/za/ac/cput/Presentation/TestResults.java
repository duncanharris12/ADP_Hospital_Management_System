package za.ac.cput.Presentation;
import java.awt.*;
import javax.swing.*;

public class TestResults extends JPanel {

    private JButton TestResults;
    private JLabel PatientID;
    private JTextField patientID;

    public TestResults() {
        //construct components
        TestResults = new JButton ("ViewTest Results");
        PatientID = new JLabel ("PatientID");
        patientID = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (491, 143));
        setLayout (null);

        //add components
        add (TestResults);
        add (PatientID);
        add (patientID);

        //set component bounds
        TestResults.setBounds (315, 100, 150, 25);
        PatientID.setBounds (85, 60, 100, 25);
        patientID.setBounds (145, 60, 170, 20);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TestResults());
        frame.pack();
        frame.setVisible (true);
    }
}



