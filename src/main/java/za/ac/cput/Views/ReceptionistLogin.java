package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Receptionist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReceptionistLogin extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private JLabel lblReceptionistID;
    private JTextField txtReceptionistID;

    private JLabel lblReceptionistPassword;
    private JPasswordField txtReceptionistPassword;

    private JButton btnLogin;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public ReceptionistLogin()
    {
        super("Receptionist Login");

        lblReceptionistID = new JLabel("Receptionist ID");
        txtReceptionistID = new JTextField();

        lblReceptionistPassword = new JLabel("Receptionist Password");
        txtReceptionistPassword = new JPasswordField();

        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
    }

    public void setGui()
    {
        add(pnlCenter, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
        pnlCenter.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.weighty = 1;
//        pnlCenter.setFont(f1);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 0;
        pnlCenter.add(lblReceptionistID, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 0;
        pnlCenter.add(txtReceptionistID, c);
        txtReceptionistID.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 1;
        pnlCenter.add(lblReceptionistPassword, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 1;
        pnlCenter.add(txtReceptionistPassword, c);
        txtReceptionistPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        pnlSouth.setLayout(new GridLayout());
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnCancel);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnLogin)
        {
            getByID(txtReceptionistID.getText(), String.valueOf(txtReceptionistPassword.getPassword()));
        }
        if(e.getSource() == btnCancel)
        {
            dispose();
            LoginMain lm = new LoginMain();
            lm.setGUI();
        }
    }

    public void getByID(String id, String password)
    {
        try {
            final String URL
                    = "http://localhost:8080/hospital-management/receptionist-type/read/"+id;
            String request = run(URL);
            Gson g = new Gson();
            Receptionist receptionist = g.fromJson(request.toString(), Receptionist.class);
            System.out.println(receptionist.getReceptionistID());
            if(receptionist.getReceptionistID().equals(id) && receptionist.getReceptionistPassword().equals(password))
            {
                dispose();

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    public static void main(String[] args) {
        new ReceptionistLogin().setGui();
    }
}
