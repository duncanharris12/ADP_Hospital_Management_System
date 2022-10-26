package za.ac.cput.Views;
//Author: Duncan, 220110530
import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class LoginMain extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private String[] data = {"Administrator", "Doctor", "Patient", "Receptionist"};
    private DefaultListCellRenderer listRenderer;
    private JLabel lblUser;
    private JComboBox boxUser;

    private JButton btnSubmit;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public LoginMain()
    {
        super("Login");
        lblUser = new JLabel("Users");
        boxUser = new JComboBox<>(data);

        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        btnSubmit = new JButton("Submit");
    }

    public void setGUI()
    {
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

        pnlCenter.setLayout(new FlowLayout());

        pnlCenter.add(lblUser);
        pnlCenter.add(boxUser);

        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnSubmit);

        btnSubmit.addActionListener(this);

        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        boxUser.setRenderer(listRenderer);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        store();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnSubmit)
        {
            if(boxUser.getSelectedItem() == "Administrator")
            {
                dispose();
                AdminLogin la = new AdminLogin();
                la.setGui();
            }
            if(boxUser.getSelectedItem() == "Patient")
            {
                dispose();
                PatientLogin pl = new PatientLogin();
                pl.setGui();
            }
        }
    }

    public void store()
    {
        try
        {
            String adminName = "Admin";
            String adminPassword = "password";
            final String URL
                    ="http://localhost:8080/hospital-management/administration/save/admin";
            Administration administration = AdministrationFactory.createAdministration(adminName,adminPassword);
            JOptionPane.showMessageDialog(null, "admin ID: "+administration.getAdminID()+" Password: "+adminPassword);
            Gson g = new Gson();
            String jsonString = g.toJson(administration);
            String request = post(URL, jsonString);
            if(request != null)
            {

            }
            else
            {

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public String post(final String url, String json) throws IOException
    {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }

    public static void main(String[] args) {
        new LoginMain().setGUI();
    }
}
