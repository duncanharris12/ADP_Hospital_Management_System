package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.TestPatient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TestPatientMain extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private ArrayList<String> testIDs;
    private DefaultListCellRenderer listRenderer;
    private JLabel lblTestID;
    private JComboBox boxTestID;

    private JButton btnViewTest;

    private JButton btnDelete;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public TestPatientMain()
    {
        super("Read Patient Account");

        lblTestID = new JLabel("Test ID");
        boxTestID = new JComboBox();
        btnViewTest = new JButton("View Test");
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        testIDs = new ArrayList<>();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

    }

    public void setGUI()
    {
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.setLayout(new FlowLayout());
        pnlCenter.add(lblTestID);
        pnlCenter.add(boxTestID);
        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnViewTest);
        pnlSouth.add(btnCancel);
        pnlSouth.add(btnDelete);
        btnViewTest.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCancel.addActionListener(this);
        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        boxTestID.setRenderer(listRenderer);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populate();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnViewTest)
        {
            new ViewTestPatient().setGUI();

        }else if(e.getSource() == btnDelete)
        {
            if((String) boxTestID.getSelectedItem() == "--Select Test ID--")
            {
                JOptionPane.showMessageDialog(null, "Select a valid test ID if available");
            }
            else
            {
                delete((String) boxTestID.getSelectedItem(), boxTestID.getSelectedIndex());
            }

        }
        else if(e.getSource() == btnCancel)
        {
            System.exit(0);
        }
    }


    public void delete(String testID, int index)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/testPatient/deleteTestPatient/"+testID;
            String request = deleteMethod(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Test Deleted");
                boxTestID.removeItemAt(index);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Test not deleted");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }



    public void readById(String testID, int index)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/testPatient/readTestPatient/"+testID;
            String request = readRequest(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Test found");
                boxTestID.getSelectedItem();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Test not found");
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
                    = "http://localhost:8080/hospital-management/testPatient/getTestPatients";
            String responseBody = run(URL);
            JSONArray testArray = new JSONArray(responseBody);
            for(int i=0; i < testArray.length(); i++)
            {
                JSONObject adminObject = testArray.getJSONObject(i);
                Gson g = new Gson();
                TestPatient tp = g.fromJson(adminObject.toString(), TestPatient.class);
                testIDs.add(tp.getTestID());
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
        dm.addElement("--Select Test ID--");
        for (int i = 0; i < testIDs.size(); i++) {
            dm.addElement(testIDs.get(i));
        }
        boxTestID.setModel(dm);
    }
    public static void main(String[] args) {
        new TestPatientMain().setGUI();
        TestPatientMain tpm = new TestPatientMain();
    }
}
