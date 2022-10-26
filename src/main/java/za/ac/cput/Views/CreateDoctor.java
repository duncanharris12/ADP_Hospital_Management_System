//package za.ac.cput.Views;
//
//import com.google.gson.Gson;
//import okhttp3.*;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import za.ac.cput.Entity.Administration;
//import za.ac.cput.Entity.Department;
//import za.ac.cput.Entity.Doctor;
//import za.ac.cput.Factory.AdministrationFactory;
//import za.ac.cput.Factory.DoctorFactory;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class CreateDoctor extends JFrame implements ActionListener
//{
//    public static final MediaType JSON
//            = MediaType.get("application/JSON; charset=utf-8");
//
//    private static OkHttpClient client = new OkHttpClient();
//
//    private GridLayout centerLayout = new GridLayout(3,2);
//    private Font  f1;
//
//    private ArrayList<String> depratmentIDs;
//    private DefaultListCellRenderer listRenderer;
//
//    private JLabel lblDoctorId;
//    private JTextField txtDoctorId;
//
//    private JLabel lblDoctorName;
//    private JTextField txtDoctorName;
//
//    private JLabel lblDoctorPassword;
//    private JPasswordField txtDoctorPassword;
//
//    private JLabel lblDoctorDepartment;
//    private JComboBox cmbDoctorDepartment;
//
//    private JLabel lblDoctorSpecialty;
//    private JTextField txtDoctorSpecialty;
//
//    private JButton btnSave;
//    private JButton btnCancel;
//
//    private JPanel pnlCenter;
//    private JPanel pnlSouth;
//
//    public CreateDoctor()
//    {
//        super("Create Doctor Account");
//
//        lblDoctorId = new JLabel("Doctor ID :");
//        txtDoctorId = new JTextField();
//
//        lblDoctorName = new JLabel("Doctor Name :");
//        txtDoctorName = new JTextField();
//
//        lblDoctorPassword = new JLabel("Doctor Password :");
//        txtDoctorPassword = new JPasswordField();
//
//        lblDoctorDepartment = new JLabel("Department Id:");
//        cmbDoctorDepartment = new JComboBox();
//
//        lblDoctorSpecialty = new JLabel("Doctor Specialty :");
//        txtDoctorSpecialty = new JTextField();
//
//        btnSave = new JButton("Save");
//        btnCancel = new JButton("Cancel");
//
//        pnlCenter = new JPanel();
//        pnlSouth = new JPanel();
//
//        f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 50);
//    }
//
//    public void setGui()
//    {
//        add(pnlCenter, BorderLayout.NORTH);
//        add(pnlSouth, BorderLayout.SOUTH);
//        pnlCenter.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.insets = new Insets(10, 10, 10, 10);
//        c.weighty = 1;
//        pnlCenter.setFont(f1);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.4;
//        c.gridx = 0;
//        c.gridy = 0;
//        pnlCenter.add(lblDoctorId, c);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.6;
//        c.gridx = 1;
//        c.gridy = 0;
//        pnlCenter.add(txtDoctorId, c);
//        txtDoctorId.setBorder(BorderFactory.createEmptyBorder());
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.4;
//        c.gridx = 0;
//        c.gridy = 1;
//        pnlCenter.add(lblDoctorName, c);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.6;
//        c.gridx = 1;
//        c.gridy = 1;
//        pnlCenter.add(txtDoctorName, c);
//        txtDoctorName.setBorder(BorderFactory.createEmptyBorder());
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.4;
//        c.gridx = 0;
//        c.gridy = 2;
//        pnlCenter.add(lblDoctorPassword, c);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.6;
//        c.gridx = 1;
//        c.gridy = 2;
//        pnlCenter.add(txtDoctorPassword, c);
//        txtDoctorPassword.setBorder(BorderFactory.createEmptyBorder());
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.4;
//        c.gridx = 0;
//        c.gridy = 3;
//        pnlCenter.add(lblDoctorDepartment, c);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.6;
//        c.gridx = 1;
//        c.gridy = 3;
//        pnlCenter.add(cmbDoctorDepartment, c);
//        cmbDoctorDepartment.setBorder(BorderFactory.createEmptyBorder());
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.4;
//        c.gridx = 0;
//        c.gridy = 4;
//        pnlCenter.add(lblDoctorSpecialty, c);
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.6;
//        c.gridx = 1;
//        c.gridy = 4;
//        pnlCenter.add(txtDoctorSpecialty, c);
//        txtDoctorSpecialty.setBorder(BorderFactory.createEmptyBorder());
//
//
//        pnlSouth.setLayout(new GridLayout());
//        pnlSouth.add(btnSave);
//        pnlSouth.add(btnCancel);
//        btnSave.addActionListener(this);
//        btnCancel.addActionListener(this);
//        listRenderer = new DefaultListCellRenderer();
//        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
//        cmbDoctorDepartment.setRenderer(listRenderer);
//        this.setFont(f1);
//        this.setSize(400, 400);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//        getAll();
//        populate();
//    }
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getSource() == btnSave)
//        {
//            store(txtDoctorId.getText(), txtDoctorName.getText(), String.valueOf(txtDoctorPassword.getPassword()), cmbDoctorDepartment.getSelectedIndex(),txtDoctorSpecialty.getText());
//        }
//        else if(e.getSource()==btnCancel)
//        {
//            System.exit(0);
//        }
//    }
//
//    public void store(String doctorId, String doctorName, String password, Department index, String specialty )
//    {
//        try
//        {
//            final String URL
//                    ="http://localhost:8080/hospital-management/administration/save/admin";
//            Doctor doctor = DoctorFactory.createDoctor(doctorId,doctorName,password,index,specialty);
//            Gson g = new Gson();
//            String jsonString = g.toJson(doctor);
//            String request = post(URL, jsonString);
//            if(request != null)
//            {
//                JOptionPane.showMessageDialog(null, "Doctor Saved");
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Error- Doctor not saved");
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
//    public String post(final String url, String json) throws IOException
//    {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        try(Response response = client.newCall(request).execute())
//        {
//            return response.body().string();
//        }
//    }
//
//    private static String run(final String url) throws IOException
//    {
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        try(Response response = client.newCall(request).execute())
//        {
//            return response.body().string();
//        }
//    }
//
//    public void getAll()
//    {
//        try
//        {
//            final String URL
//                    = "http://localhost:8080/hospital-management/department/getAll/department";
//            String responseBody = run(URL);
//            JSONArray departmentArray = new JSONArray(responseBody);
//            for(int i=0; i < departmentArray.length(); i++)
//            {
//                JSONObject departmentObject = departmentArray.getJSONObject(i);
//                Gson g = new Gson();
//                Department department = g.fromJson(departmentObject.toString(), Department.class);
//                depratmentIDs.add(department.getDepartmentID());
//            }
//
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
//
//    public class ComboKeyValue {
//        private String key;
//        private String value;
//
//        public ComboKeyValue(String key, String value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public String toString(){
//            return key;
//        }
//
//        public String getKey() {
//            return key;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public void populate()
//    {
//        DefaultComboBoxModel dm = new DefaultComboBoxModel();
//
//        dm.addElement("--Select Department ID--");
//        for (int i = 0; i < departmentIDs.size(); i++) {
//            dm.addElement(departmentIDs.get(i));
//        }
//        cmbDoctorDepartment.setModel(dm);
//    }
//
//    public static void main(String[] args) {
//        new CreateDoctor().setGui();
//    }
//}
//
//
