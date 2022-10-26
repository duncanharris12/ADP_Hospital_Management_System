package za.ac.cput.Views;

import za.ac.cput.Entity.Receptionist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog{
    private JTextField tfUserName;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel loginPanel;

    public Login(JFrame parent){
        super(parent);
        setTitle("LOGIN");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 350));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = tfUserName.getText();
                String password = String.valueOf(pfPassword.getPassword());

                //receptionist = getAuthenticatedUser(userName, password);

                if(userName.equals("Davin") && password.equals("password")){
                    JOptionPane.showMessageDialog(null, "Login Succesful");
                    ReceptionistPage receptionistPage = new ReceptionistPage(null);
                }
                else
                    JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
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

    public Receptionist receptionist;

    public static void main(String[] args) {
            Login login = new Login(null);

    }
}

//            Receptionist receptionist = login.receptionist;
//            if(receptionist != null){
//                System.out.println("Succesful authentication of: " + receptionist.getReceptionistUserName());
//                System.out.println("        ID: " + receptionist.getReceptionistID());
//                System.out.println("        Name: " + receptionist.getReceptionistUserName());
//                System.out.println("        Tel Number: " + receptionist.getReceptionistTelephoneNumber());
//            }
//            else{
//                System.out.println("Authentication failed");
//            }


//                if(receptionist != null)
//                {
//                    dispose();
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(Login.this,
//                            "Username or password Is iInvalid",
//                            "Try Again",
//                            JOptionPane.ERROR_MESSAGE);
//                }