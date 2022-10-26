package za.ac.cput.Views;


import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegistrationForm extends JDialog {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public Receptionist receptionist;
    private JTextField tfUserName;
    private JTextField tfTelephone;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnCreate;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent){
        super(parent);
        setTitle("REGISTER ACCOUNT");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(500, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== btnCreate){
                    //registerUser();
                    create(tfUserName.getText(), String.valueOf(pfPassword.getPassword()), Long.parseLong(tfTelephone.getText()));
                    Login login = new Login(null);
                } else if (e.getSource()==btnCancel) {
                    System.exit(0);
                }

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }


    public void create(String receptionistUserName, //  STORE/SAVE
                       String receptionistPassword,
                       long receptionistTelephoneNumber){
        try{
            Receptionist receptionist1 = null;
            final String URL = "http://localhost:8080/hospital-management/receptionist-type/save";
            Receptionist receptionist = ReceptionistFactory.createReceptionist(receptionistUserName, receptionistPassword, receptionistTelephoneNumber);
            Gson g = new Gson();
            String jsonString = g.toJson(receptionist);
            String c = post(URL, jsonString);
            registerUser();
            if(c != null)
                JOptionPane.showMessageDialog(null, "Succesfully Saved");
            else JOptionPane.showMessageDialog(null, "Error - could not save");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }

    }

    private void registerUser(){
        String userName = tfUserName.getText();
        long telephoneNumber = Long.parseLong(tfTelephone.getText());
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

        if(userName.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


    }

    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
    }
}




//
//                receptionist = addUserToDatabase(userName, TelephoneNumber,  Password );
//                if(receptionist != null){
//                dispose();
//                }
//                else{
//                JOptionPane.showMessageDialog(this, "Failed to register new user",