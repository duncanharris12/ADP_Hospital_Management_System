package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.AdministrationFactory;
import za.ac.cput.Factory.DepartmentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateDepartment extends JFrame implements ActionListener
{
    public static final MediaType JSON
            = MediaType.get("application/JSON; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    private GridLayout centerLayout = new GridLayout(2,2);
    private Font  f1;
    private JLabel lblDepartmentId;
    private JTextField txtDepartmentId;

    private JLabel lblDepartmentName;
    private JTextField txtDepartmentName;

    private JLabel lblDepartmentSize;
    private JTextField txtDepartmentSize;

    private JButton btnSave;
    private JButton btnCancel;

    private JPanel pnlCenter;
    private JPanel pnlSouth;

    public CreateDepartment()
    {
        super("Create Administration Account :");

        lblDepartmentId = new JLabel("Department Id :");
        txtDepartmentId = new JTextField();

        lblDepartmentName = new JLabel("Department Name :");
        txtDepartmentName = new JTextField();

        lblDepartmentSize = new JLabel("Department Size :");
        txtDepartmentSize = new JTextField();

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
        pnlCenter.add(lblDepartmentId, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 0;
        pnlCenter.add(txtDepartmentId, c);
        txtDepartmentId.setBorder(BorderFactory.createEmptyBorder());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 1;
        pnlCenter.add(lblDepartmentName, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 1;
        pnlCenter.add(txtDepartmentName, c);
        txtDepartmentName.setBorder(BorderFactory.createEmptyBorder());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.4;
        c.gridx = 0;
        c.gridy = 2;
        pnlCenter.add(lblDepartmentSize, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 1;
        c.gridy = 2;
        pnlCenter.add(txtDepartmentSize, c);
        txtDepartmentSize.setBorder(BorderFactory.createEmptyBorder());

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
            store(txtDepartmentId.getText(), txtDepartmentName.getText(), Integer.parseInt(txtDepartmentSize.getText()));
        }
        else if(e.getSource()==btnCancel)
        {
            dispose();
            AdminMain am = new AdminMain();
            am.setGUI();
        }
    }

    public void store(String departmentId, String departmentName, int departmentSize)
    {
        try
        {
            final String URL
                    ="http://localhost:8080/hospital-management/department/save";
            Department department = DepartmentFactory.createDepartment(departmentId,departmentName, departmentSize);
            Gson g = new Gson();
            String jsonString = g.toJson(department);
            String request = post(URL, jsonString);
            if(request != null)
            {
                JOptionPane.showMessageDialog(null, "Department Saved");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error- Department not saved");
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

}


