package za.ac.cput.Views;

import za.ac.cput.Entity.Receptionist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verificationPage extends JFrame{
    private JPanel verificationPanel;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JLabel lblAdmin;

    public verificationPage(){
        setTitle("Verification Page");
        setContentPane(verificationPanel);
        setMinimumSize(new Dimension(450, 474));
        setSize(450, 474);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//           boolean hasRegisteredReceptionist = connectToDatabase();
//           if(hasRegisteredReceptionist){
//               Login login = new Login(this);
//               Receptionist receptionist = login.receptionist;
//
//               if(receptionist != null){
//                   lblAdmin.setText("User:  " + receptionist.getReceptionistName());
//                   setLocationRelativeTo(null);
//                   setVisible(true);
//               }
//               else{
//                   dispose();
//               }
//           }

           btnLogin.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                Login login = new Login(verificationPage.this);
                Receptionist receptionist = login.receptionist;
                dispose();
               }
           });
           btnSignUp.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   RegistrationForm registrationForm = new RegistrationForm(verificationPage.this);
                   Receptionist receptionist = registrationForm.receptionist;

                   if(receptionist != null){
                       JOptionPane.showMessageDialog(verificationPage.this,
                               "New User: " + receptionist.getReceptionistUserName(),
                               "Successful Registration",
                               JOptionPane.INFORMATION_MESSAGE);
                   }
               }
           });

           setVisible(true);
       }

//       private boolean connectToDatabase(){
//           boolean hasRegisteredReceptionist = false;
//
//           final String MYSQL_SERVER_URL = "";
//           final String DB_URL = "";
//           final String USERNAME = "root";
//           final String PASSWORD = "password";
//
//           try{
//               Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
//               Statement statement = conn.createStatement();
//               statement.executeUpdate("CREATE DATABASE IF NOT EXISTS DBCredentials");
//               statement.close();
//               conn.close();
//
//
//           }catch (Exception e){
//               e.printStackTrace();
//           }
//
//           return hasRegisteredReceptionist;
//       }


    public static void main(String[] args) {
            verificationPage verificationPage = new verificationPage();
    }
}
