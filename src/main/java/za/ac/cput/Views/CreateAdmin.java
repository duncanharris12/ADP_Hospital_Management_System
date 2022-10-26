package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class CreateAdmin extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private GridLayout centerLayout = new GridLayout(2,2);
    private Font  f1;
    private JLabel lblAdminName;
    private JTextField txtAdminName;

    private JLabel lblAdminPassword;
    private JPasswordField txtAdminPassword;

    private JButton btnSave;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public CreateAdmin()
    {
        super("Create Administration Account");

        lblAdminName = new JLabel("Admin Name");
        txtAdminName = new JTextField();

        lblAdminPassword = new JLabel("Admin Password");
        txtAdminPassword = new JPasswordField();

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

        pnlCenter = new JPanel();
        pnlSouth = new JPanel();

        f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 50);
    }

    public void setGui()
    {
        add(pnlCenter, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.weighty = 1;
        pnlCenter.setFont(f1);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 0;
        pnlCenter.add(lblAdminName, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 0;
        pnlCenter.add(txtAdminName, c);
        txtAdminName.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 1;
        pnlCenter.add(lblAdminPassword, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 1;
        pnlCenter.add(txtAdminPassword, c);
        txtAdminPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnSave);
        pnlSouth.add(btnCancel);
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
        this.setFont(f1);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnSave)
        {
            store(txtAdminName.getText(), String.valueOf(txtAdminPassword.getPassword()));
        }
        else if(e.getSource()==btnCancel)
        {
            System.exit(0);
        }
    }

    public void store(String adminName, String adminPassword)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/administration/save/admin";
            Administration administration = AdministrationFactory.createAdministration(adminName,adminPassword);
            Gson g = new Gson();
            String jsonString = g.toJson(administration);
            String request = post(URL, jsonString);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Admin Saved");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Admin not saved");
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
        new CreateAdmin().setGui();
    }
}


