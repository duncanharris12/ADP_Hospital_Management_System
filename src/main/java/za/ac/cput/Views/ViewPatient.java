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
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class ViewPatient extends JFrame
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private String col[] = {"Patient ID", "Patient Name", "Phone number", "Age", "Gender", "Address", "Password"};
    private ArrayList<Patient> rows;
    private JTable tblPatient;

    private JPanel pnlCenter;

    private DefaultTableModel dm;
    //
    public ViewPatient()
    {
        super("View Patients");
        rows = new ArrayList<>();
        dm = new DefaultTableModel(col,0);
        tblPatient = new JTable(dm);
        pnlCenter = new JPanel();
    }

    public void setGUI()
    {
        add(new JScrollPane(tblPatient));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        getAll();
        populateTable();
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
            JSONArray patientArray = new JSONArray(responseBody);
            for(int i=0; i < patientArray.length(); i++)
            {
                JSONObject patientObject = patientArray.getJSONObject(i);
                Gson g = new Gson();
                Patient patient = g.fromJson(patientObject.toString(), Patient.class);
                rows.add(patient);
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
            String id = rows.get(i).getPatientID();
            String name = rows.get(i).getPatientName();
            long phone_number = rows.get(i).getPhone_number();
            int age = rows.get(i).getAge();
            String gender = rows.get(i).getSex();
            String address = rows.get(i).getAddress();
            String password = rows.get(i).getPatientPassword();

            Object[] data = {id, name, phone_number,age,  gender, address,password };

            dm.addRow(data);
        }
    }

    public static void main(String[] args) {
        new ViewPatient().setGUI();
    }
}
