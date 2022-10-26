package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteDoctor extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private ArrayList<String> doctorIDs;
    private DefaultListCellRenderer listRenderer;
    private JLabel lblAdminID;
    private JComboBox boxAdminID;

    private JButton btnDelete;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public DeleteDoctor()
    {
        super("Delete Doctor Account");

        lblAdminID = new JLabel("Doctor ID");
        boxAdminID = new JComboBox();
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        doctorIDs = new ArrayList<>();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

    }

    public void setGUI()
    {
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(lblAdminID);
        pnlCenter.add(boxAdminID);
        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnDelete);
        pnlSouth.add(btnCancel);
        btnDelete.addActionListener(this);
        btnCancel.addActionListener(this);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        boxAdminID.setRenderer(listRenderer);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populate();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnDelete)
        {
            if((String) boxAdminID.getSelectedItem() == "--Select Doctor ID--")
            {
                JOptionPane.showMessageDialog(null, "Select a valid doctor ID if available");
            }
            else
            {
                delete((String) boxAdminID.getSelectedItem(), boxAdminID.getSelectedIndex());
            }

        }
        else if(e.getSource() == btnCancel)
        {
            System.exit(0);
        }
    }

    public void delete(String adminID, int index)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/doctor/deleteDoctor/"+doctorIDs;
            String request = deleteMethod(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Doctor Deleted");
                boxAdminID.removeItemAt(index);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Doctor not deleted");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    public void getAll()
    {
        try
        {
            final String URL
                    = "http://localhost:8080/hospital-management/doctor/getAll/doctor";
            String responseBody = run(URL);
            JSONArray adminArray = new JSONArray(responseBody);
            for(int i=0; i < adminArray.length(); i++)
            {
                JSONObject adminObject = adminArray.getJSONObject(i);
                Gson g = new Gson();
                Doctor doctor = g.fromJson(adminObject.toString(), Doctor.class);
                doctorIDs.add(doctor.getDoctorID());
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

        dm.addElement("--Select Admin ID--");
        for (int i = 0; i < doctorIDs.size(); i++) {
            dm.addElement(doctorIDs.get(i));
        }
        boxAdminID.setModel(dm);
    }
    public static void main(String[] args) {
        new DeleteDoctor().setGUI();
    }
}