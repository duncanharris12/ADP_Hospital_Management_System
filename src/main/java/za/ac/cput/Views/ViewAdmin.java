package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ViewAdmin  extends JFrame
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private String col[] = {"Admin ID", "Admin Name"};
    private ArrayList<Administration> rows;
    private JTable tblAdmin;

    private JPanel pnlCenter;

    private DefaultTableModel dm;
    //
    public ViewAdmin()
    {
        super("View Admins");
        rows = new ArrayList<>();
        dm = new DefaultTableModel(col,0);
        tblAdmin = new JTable(dm);
        pnlCenter = new JPanel();
    }

    public void setGUI()
    {
        add(new JScrollPane(tblAdmin));
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
                    = "http://localhost:8080/hospital-management/administration/getAll/admin";
            String responseBody = run(URL);
            JSONArray adminArray = new JSONArray(responseBody);
            for(int i=0; i < adminArray.length(); i++)
            {
                JSONObject adminObject = adminArray.getJSONObject(i);
                Gson g = new Gson();
                Administration admin = g.fromJson(adminObject.toString(), Administration.class);
                rows.add(admin);
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
            String id = rows.get(i).getAdminID();
            String name = rows.get(i).getAdminName();

            Object[] data = {id, name};

            dm.addRow(data);
        }
    }

    public static void main(String[] args) {
        new ViewAdmin().setGUI();
    }
}
