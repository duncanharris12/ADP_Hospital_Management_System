package za.ac.cput.View;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static za.ac.cput.View.OkHttp.readById;

public class PatietReadForm extends JDialog implements ActionListener {

    private JTextField textField1;
    private JTextArea textArea1;
    private JButton SAVEButton;
    private JPanel PanelMain;


    public PatietReadForm(JFrame parent){
        super(parent);
        setTitle("Patient");
        setContentPane(PanelMain);
        setMinimumSize(new Dimension(800,474));
        setModal(true);
        setLocationRelativeTo(parent);

        SAVEButton.addActionListener(this);

        setVisible(true);

    }

    public void patientMain(){
        try{
            String patientID = textField1.getText();

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == SAVEButton){
            try {
                readById(textField1.getText());
                JOptionPane.showMessageDialog(null, "Patient found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error- Patient not found!");
            }


        }


    }



    public static void main(String[] args) {
        PatietReadForm prf = new PatietReadForm(null);
    }


}
