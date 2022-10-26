package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ViewTestPatient extends JFrame implements ActionListener

{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private String col[] = {"Test ID", "Test Name", "Patient ID"};
    private ArrayList<TestPatient> rows;
    private JTable tblTestPatient;

    private JPanel pnlCenter;
    private JButton btnBack;

    private JPanel pnlSouth;

    private DefaultTableModel dm;
    //
    public ViewTestPatient()
    {
        super("View Test for Patients");
        rows = new ArrayList<>();
        dm = new DefaultTableModel(col,0);
        btnBack = new JButton("Back");
        pnlSouth = new JPanel();
        tblTestPatient = new JTable(dm);
        pnlCenter = new JPanel();
    }

    public void setGUI()
    {
        add(new JScrollPane(tblTestPatient));
        add(pnlSouth, BorderLayout.SOUTH);
        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnBack);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populateTable();

        btnBack.addActionListener(this);
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
                    = "http://localhost:8080/hospital-management/patient/all";
            String responseBody = run(URL);
            JSONArray testArray = new JSONArray(responseBody);
            for(int i=0; i < testArray.length(); i++)
            {
                JSONObject testObject = testArray.getJSONObject(i);
                Gson g = new Gson();
                TestPatient test = g.fromJson(testObject.toString(), TestPatient.class);
                rows.add(test);
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void populateTable()
    {
        for(int i=0; i < rows.size(); i++)
        {
            String id = rows.get(i).getTestID();
            String name = rows.get(i).getTestName();
            //String patientId= rows.get(i).getPatient().getPatientID();


            Object[] data = {id, name };//patientId };

            dm.addRow(data);
        }
    }

    public static void main(String[] args) {
        new ViewTestPatient().setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            new TestPatientMain().setGUI();
            new ViewTestPatient().dispose();

        }
    }
}
