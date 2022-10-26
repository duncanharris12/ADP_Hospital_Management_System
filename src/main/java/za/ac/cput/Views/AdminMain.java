package za.ac.cput.Views;
//Author: Duncan, 220110530
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMain extends JFrame implements ActionListener
{
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;

    private JTabbedPane tp;

    private JButton btnSaveAdmin;
    private JButton btnDeleteAdmin;
    private JButton btnViewAdmin;

    private JButton btnSaveDepartment;
    private JButton btnDeleteDepartment;
    private JButton btnViewDepartment;

    private JButton btnSaveDoctor;
    private JButton btnDeleteDoctor;
    private JButton btnViewDoctor;

    private JButton btnSavePatient;
    private JButton btnDeletePatient;
    private JButton btnViewPatient;

    private JButton btnViewRecords;

    public AdminMain()
    {
        super("Administration");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();

        tp = new JTabbedPane();

        btnSaveAdmin = new JButton("Save Administrator");
        btnDeleteAdmin = new JButton("Delete Administrator");
        btnViewAdmin = new JButton("View All Administrator");

        btnSaveDepartment = new JButton("Save Department");
        btnDeleteDepartment = new JButton("Delete Department");
        btnViewDepartment = new JButton("View Department");

        btnSaveDoctor = new JButton("Save Doctor");
        btnDeleteDoctor = new JButton("Delete Doctor");
        btnViewDoctor = new JButton("View Doctor");

        btnSavePatient = new JButton("Save Patient");
        btnDeletePatient = new JButton("Delete Patient");
        btnViewPatient = new JButton("View Patient");

        btnViewRecords = new JButton("View Records");
    }

    public void setGUI()
    {
        tp.addTab("Admin",p1);
        tp.addTab("Department", p2);
        tp.addTab("Doctor", p3);
        tp.addTab("Patient", p4);
        tp.addTab("Medical Record", p5);
        add(tp);

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        btnSaveAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeleteAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);

        p1.add(btnSaveAdmin);
        p1.add(btnDeleteAdmin);
        p1.add(btnViewAdmin);

        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        btnSaveDepartment.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeleteDepartment.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewDepartment.setAlignmentX(Component.CENTER_ALIGNMENT);

        p2.add(btnSaveDepartment);
        p2.add(btnDeleteDepartment);
        p2.add(btnViewDepartment);


        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));

        btnSaveDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeleteDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);

        p3.add(btnSaveDoctor);
        p3.add(btnDeleteDoctor);
        p3.add(btnViewDoctor);

        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));

        btnSavePatient.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDeletePatient.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewPatient.setAlignmentX(Component.CENTER_ALIGNMENT);

        p4.add(btnSavePatient);
        p4.add(btnDeletePatient);
        p4.add(btnViewPatient);

        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));

        btnViewRecords.setAlignmentX(Component.CENTER_ALIGNMENT);
        p5.add(btnViewRecords);

        btnSaveAdmin.addActionListener(this);
        btnDeleteAdmin.addActionListener(this);
        btnViewAdmin.addActionListener(this);

        btnSaveDepartment.addActionListener(this);
        btnDeleteDepartment.addActionListener(this);
        btnViewDepartment.addActionListener(this);

        btnSaveDoctor.addActionListener(this);
        btnDeleteDoctor.addActionListener(this);
        btnViewDoctor.addActionListener(this);

        btnSavePatient.addActionListener(this);
        btnDeletePatient.addActionListener(this);
        btnViewPatient.addActionListener(this);

        btnViewRecords.addActionListener(this);

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnSaveAdmin)
        {
            dispose();
            CreateAdmin ca = new CreateAdmin();
            ca.setGui();
        }
        if(e.getSource() == btnDeleteAdmin)
        {
            dispose();
            DeleteAdmin da = new DeleteAdmin();
            da.setGUI();
        }
        if(e.getSource() == btnViewAdmin)
        {
            dispose();
            ViewAdmin va = new ViewAdmin();
            va.setGUI();
        }
        if(e.getSource() == btnSaveDepartment)
        {
            dispose();
            CreateDepartment cd = new CreateDepartment();
            cd.setGui();
        }
        if(e.getSource() == btnDeleteDepartment)
        {
            dispose();
            DeleteDepartment dd = new DeleteDepartment();
            dd.setGUI();
        }
        if(e.getSource() == btnViewDepartment)
        {
            dispose();
            ViewDepartment vd = new ViewDepartment();
            vd.setGUI();
        }
        if(e.getSource() == btnSaveDoctor)
        {
            JOptionPane.showMessageDialog(null, "Feature Unavailable");
        }
        if(e.getSource() == btnViewDoctor)
        {
            dispose();
            ViewDoctor vd = new ViewDoctor();
            vd.setGUI();
        }
        if(e.getSource() == btnDeleteDoctor)
        {
            dispose();
            DeleteDoctor dd = new DeleteDoctor();
            dd.setGUI();
        }
        if(e.getSource() == btnSavePatient)
        {
            dispose();
            Registration1 registration1 = new Registration1( null);
        }
        if(e.getSource() == btnDeletePatient)
        {
            dispose();
            PatientMain pm = new PatientMain();
            pm.setGUI();
        }
        if(e.getSource() == btnViewPatient)
        {
            dispose();
            ViewPatient vp = new ViewPatient();
            vp.setGUI();
        }
        if(e.getSource() == btnViewRecords)
        {
            dispose();
            ViewMedicalRecords vm = new ViewMedicalRecords();
            vm.setGUI();
        }
    }

}
