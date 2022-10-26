package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class PatientMain extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private ArrayList<String> patientIDs;
    private DefaultListCellRenderer listRenderer;
    private JLabel lblPatientID;
    private JComboBox boxPatientID;

    private JButton btnViewPatients;

    private JButton btnDelete;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public PatientMain()
    {
        super("Read Patient Account");

        lblPatientID = new JLabel("Patient ID");
        boxPatientID = new JComboBox();
        btnViewPatients = new JButton("View Patients");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        patientIDs = new ArrayList<>();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

    }

    public void setGUI()
    {
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(lblPatientID);
        pnlCenter.add(boxPatientID);
        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnViewPatients);
        pnlSouth.add(btnCancel);
        pnlSouth.add(btnDelete);
        btnViewPatients.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCancel.addActionListener(this);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        boxPatientID.setRenderer(listRenderer);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populate();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnViewPatients)
        {
            new ViewPatient().setGUI();

        }else if(e.getSource() == btnDelete)
        {
            if((String) boxPatientID.getSelectedItem() == "--Select Patient ID--")
            {
                JOptionPane.showMessageDialog(null, "Select a valid patient ID if available");
            }
            else
            {
                delete((String) boxPatientID.getSelectedItem(), boxPatientID.getSelectedIndex());
            }

        }
        else if(e.getSource() == btnCancel)
        {
            System.exit(0);
        }
    }


    public void delete(String patientID, int index)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/patient/deletePatient/"+patientID;
            String request = deleteMethod(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Patient Deleted");
                boxPatientID.removeItemAt(index);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Patient not deleted");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }



    public void readById(String patientID, int index)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/patient/readPatient/"+patientID;
            String request = readRequest(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Patient found");
                boxPatientID.getSelectedItem();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Patient not found");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static String readRequest(String url) throws IOException {
        Request request=new Request.Builder().url(url).get().build();
        try( Response response =client.newCall(request).execute()){

            return response.body().string(); }
    }
    private static String run(final String url) throws IOException
    {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }

    public static String deleteMethod(final String url) throws IOException
    {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void getAll()
    {
        try
        {
            final String URL
                    = "http://localhost:8080/hospital-management/patient/all";
            String responseBody = run(URL);
            JSONArray patientArray = new JSONArray(responseBody);
            for(int i=0; i < patientArray.length(); i++)
            {
                JSONObject adminObject = patientArray.getJSONObject(i);
                Gson g = new Gson();
                Patient p = g.fromJson(adminObject.toString(), Patient.class);
                patientIDs.add(p.getPatientID());
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public class ComboKeyValue {
        private String key;
        private String value;

        public ComboKeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return key;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public void populate()
    {
        DefaultComboBoxModel dm = new DefaultComboBoxModel();

//        DefaultComboBoxModel dm = new DefaultComboBoxModel<String>(adminIDs.toArray(new String[adminIDs.size()]));
        dm.addElement("--Select Patient ID--");
        for (int i = 0; i < patientIDs.size(); i++) {
            dm.addElement(patientIDs.get(i));
        }
        boxPatientID.setModel(dm);
    }
    public static void main(String[] args) {
        new PatientMain().setGUI();
        PatientMain pm = new PatientMain();
    }
}
