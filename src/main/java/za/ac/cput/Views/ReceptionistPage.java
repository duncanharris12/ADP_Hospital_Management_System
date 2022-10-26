package za.ac.cput.Views;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.ReceptionistFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ReceptionistPage extends JDialog {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static String readRequest(String url) throws IOException {
        Request request=new Request.Builder().url(url).get().build();
        try( Response response =client.newCall(request).execute()){

            return response.body().string(); }
    }
    private JButton btnDisplay;
    private JButton btnSave;
    private JButton btnDelete;
    private JTextField txtPatientID;
    private JTextField txtPatientName;
    private JTextField txtContactNum;
    private JTextField txtAge;
    private JTextField txtGender;
    private JPanel receptionistPanel;


    public ReceptionistPage(JFrame parent){
        super(parent);
        setTitle("RECEPTIONIST HOME PAGE");
        setContentPane(receptionistPanel);
        setMinimumSize(new Dimension(500, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

//        btnSave.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource() == btnSave){
//                    save(txtPatientID.getText(), txtPatientName.getText(), Long.parseLong(txtContactNum.getText())
//                            ,txtGender.getText() );
//                }
//            }
//        });

        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnDisplay){
                    PatientMain patientMain = new PatientMain();
                    patientMain.setGUI();
                    dispose();

                }
            }
        });

        setVisible(true);
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

    public void create(String receptionistUserName, //  STORE/SAVE
                       String receptionistPassword,
                       long receptionistTelephoneNumber){
        try{
            final String URL = "http://localhost:8080/hospital-management/receptionist-type/save";
            Receptionist receptionist = ReceptionistFactory.createReceptionist(receptionistUserName, receptionistPassword, receptionistTelephoneNumber);
            Gson g = new Gson();
            String jsonString = g.toJson(receptionist);
            String c = post(URL, jsonString);
            if(c != null)
                JOptionPane.showMessageDialog(null, "Succesfully Saved");
            else JOptionPane.showMessageDialog(null, "Error - could not save");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //Saves the patient object into the database
    public static void save(String patientID, String patientName, long phone_number, int age,String sex, String address, String patientPassword) throws IOException{

        String URL="http://localhost:8080/hospital-management/patient/save";


        Patient patientObj= PatientFactory.createPatient(patientID,patientName,address,phone_number,sex,age,patientPassword);
        Gson gn =new Gson();
        String jrequestBody=gn.toJson(patientObj);
        String saved= post(URL,jrequestBody);
        String success= (saved)!=null ? "patient saved ": "Not saved";
        System.out.println(success);
        System.out.println(saved.toString());

    }

    public static String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        //RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }

    }

    public static void main(String[] args) {
            ReceptionistPage receptionistPage = new ReceptionistPage(null);

    }
}
    //public void delete(String adminID, int index)
    //    {
//        try
//        {
//            final String URL
//                    ="http://localhost:8080/hospital-management/patient/deletePatient/"+txtPatientID;
//            String request = deleteMethod(URL);
//            if(request != null)
//            {
//                JOptionPane.showMessageDialog(null, "Admin Deleted");
//                txtPatientID.remove(index);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Error- Admin not deleted");
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
    //public static String deleteMethod(final String url) throws IOException
//    {
//        Request request = new Request.Builder()
//                .url(url)
//                .delete()
//                .build();
//        try(Response response = client.newCall(request).execute())
//        {
//            return response.body().string();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void getAll(){
//        try{
//            final String URL = "";
//            String responseBody = run(URL);
//            JSONArray appointments = new JSONArray(responseBody);
//
//            for (int i = 0; i < appointments.length(); i++){
//                JSONObject appointment = appointments.getJSONObject(i);
//                Gson g = new Gson();
//                Patient a = g.fromJson(appointment.toString(), Patient.class);
//                System.out.println(a.toString());
//            }
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }

