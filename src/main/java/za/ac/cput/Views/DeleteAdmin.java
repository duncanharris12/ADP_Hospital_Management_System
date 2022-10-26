package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeleteAdmin extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private ArrayList<String> adminIDs;
    private DefaultListCellRenderer listRenderer;
    private JLabel lblAdminID;
    private JComboBox boxAdminID;

    private JButton btnDelete;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public DeleteAdmin()
    {
        super("Delete Administration Account");

        lblAdminID = new JLabel("Admin ID");
        boxAdminID = new JComboBox();
        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        adminIDs = new ArrayList<>();
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
            if((String) boxAdminID.getSelectedItem() == "--Select Admin ID--")
            {
                JOptionPane.showMessageDialog(null, "Select a valid admin ID if available");
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
                    ="http://localhost:8080/hospital-management/administration/deleteAdmin/"+adminID;
            String request = deleteMethod(URL);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Admin Deleted");
                boxAdminID.removeItemAt(index);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Admin not deleted");
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
                    = "http://localhost:8080/hospital-management/administration/getAll/admin";
            String responseBody = run(URL);
            JSONArray adminArray = new JSONArray(responseBody);
            for(int i=0; i < adminArray.length(); i++)
            {
                JSONObject adminObject = adminArray.getJSONObject(i);
                Gson g = new Gson();
                Administration admin = g.fromJson(adminObject.toString(), Administration.class);
                adminIDs.add(admin.getAdminID());
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
        dm.addElement("--Select Admin ID--");
        for (int i = 0; i < adminIDs.size(); i++) {
            dm.addElement(adminIDs.get(i));
        }
        boxAdminID.setModel(dm);
    }
    public static void main(String[] args) {
        new DeleteAdmin().setGUI();
    }
}