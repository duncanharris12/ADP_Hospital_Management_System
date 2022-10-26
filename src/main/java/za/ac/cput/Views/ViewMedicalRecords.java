package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.MedicalRecords;
//Author: Duncan, 220110530
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ViewMedicalRecords extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private String col[] = {"Record ID", "Test ID"};
    private ArrayList<MedicalRecords> rows;
    private JTable tblRecords;

    private JPanel pnlCenter;
    private JPanel pnlSouth;
    private JButton btnBack;

    private DefaultTableModel dm;
    //
    public ViewMedicalRecords()
    {
        super("View Medical Records");
        rows = new ArrayList<>();
        dm = new DefaultTableModel(col,0);
        tblRecords = new JTable(dm);
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        btnBack = new JButton("Back");
    }

    public void setGUI()
    {
        add(new JScrollPane(tblRecords));
        add(pnlSouth, BorderLayout.SOUTH);
        pnlSouth.add(btnBack);
        btnBack.addActionListener(this);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnBack)
        {
            dispose();
            PatientMainScreen psm = new PatientMainScreen( null);
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
                    = "http://localhost:8080//hospital-management/medicalRecords/getAll/medicalRecords";
            String responseBody = run(URL);
            JSONArray adminArray = new JSONArray(responseBody);
            for(int i=0; i < adminArray.length(); i++)
            {
                JSONObject adminObject = adminArray.getJSONObject(i);
                Gson g = new Gson();
               MedicalRecords med = g.fromJson(adminObject.toString(), MedicalRecords.class);
                rows.add(med);
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
            String id = rows.get(i).getRecordID();
            String name = rows.get(i).getTestResults().getTestResultsID();

            Object[] data = {id, name};

            dm.addRow(data);
        }
    }

}
