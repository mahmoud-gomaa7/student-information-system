package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.text.TextAction;

public class RegisterForm extends JFrame {
         private JTextField tfuser;
    public RegisterForm() {

        setSize(450, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(null);
        p2.setLayout(null);
        p1.setBounds(0, 0, 450, 60);
        p2.setBounds(0, 61, 450, 500);
        p1.setBackground(new Color(248, 148, 6));
        p2.setBackground(new Color(44, 62, 80));
        //panel 1
        JLabel lblreg = new JLabel();
        JLabel lblclose = new JLabel();
        JLabel lblmin = new JLabel();
        //manage panel 1
        lblreg.setText("Register");
        lblclose.setText("X");
        lblmin.setText("-");
        lblclose.setCursor(new Cursor(HAND_CURSOR));
        lblmin.setCursor(new Cursor(HAND_CURSOR));
        Font myfont = new Font("Tahoma", Font.BOLD, 24);
        lblreg.setBounds(40, 12, 180, 30);
        lblclose.setBounds(420, 18, 100, 20);
        lblmin.setBounds(395, 18, 100, 20);
        lblreg.setFont(myfont);
        lblclose.setFont(myfont);
        lblmin.setFont(myfont);
        lblreg.setForeground(Color.WHITE);
        lblclose.setForeground(Color.WHITE);
        lblmin.setForeground(Color.WHITE);
        //panel 2
        JLabel lblfn = new JLabel("First Name:");
        JLabel lblln = new JLabel("Last Name:");
        JLabel lbluser = new JLabel("Userame:");
        JLabel lblpass = new JLabel("Password:");
        JLabel lblrepass = new JLabel("Retype Pass:");
        JLabel lbladdress = new JLabel("Address:");
        JLabel lblbirth = new JLabel("BirthDate:");
        final JTextField tfname = new JTextField();
        final JTextField tflname = new JTextField();
         tfuser = new JTextField();
        final JPasswordField pass1 = new JPasswordField();
        final JPasswordField pass2 = new JPasswordField();
        final JTextField tfbirth = new JTextField();
        final JTextArea address = new JTextArea();
        JButton btnreg = new JButton("Register");
        JButton btncancel = new JButton("Cancel");
        JLabel lbllog = new JLabel("click here to login");
        final JLabel lblcheck = new JLabel();
        final JLabel lblusercheck = new JLabel();
        //manage panel 2
        lblfn.setBounds(60, 150, 100, 30);
        lblln.setBounds(60, 200, 100, 30);
        lbluser.setBounds(60, 250, 100, 30);
        lblpass.setBounds(60, 300, 100, 30);
        lblrepass.setBounds(40, 350, 110, 30);
        lblbirth.setBounds(60, 400, 100, 30);
        lbladdress.setBounds(60, 450, 100, 30);
        tfname.setBounds(160, 155, 190, 25);
        tflname.setBounds(160, 205, 190, 25);
        tfuser.setBounds(160, 255, 190, 25);
        pass1.setBounds(160, 305, 190, 25);
        pass2.setBounds(160, 355, 190, 25);
        tfbirth.setBounds(160, 405, 190, 25);
        address.setBounds(160, 455, 250, 55);
        btncancel.setBounds(130, 535, 80, 30);
        btnreg.setBounds(230, 535, 90, 30);
        lbllog.setBounds(180, 575, 200, 30);
        lblcheck.setBounds(160, 380, 120, 25);
        lblusercheck.setBounds(160, 280, 180, 25);
        tfname.setBorder(null);
        tflname.setBorder(null);
        tfuser.setBorder(null);
        pass1.setBorder(null);
        pass2.setBorder(null);
        address.setBorder(null);
        tfbirth.setBorder(null);
        btnreg.setBorder(null);
        btncancel.setBorder(null);
        lbllog.setCursor(new Cursor(HAND_CURSOR));
        //font
        Font f = new Font("Tahoma", Font.PLAIN, 18);
        Font f2 = new Font("Tahoma", Font.PLAIN, 14);
        lblfn.setFont(f);
        lblln.setFont(f);
        lbluser.setFont(f);
        lblpass.setFont(f);
        lblrepass.setFont(f);
        lblbirth.setFont(f);
        lbladdress.setFont(f);
        tfname.setFont(f2);
        tflname.setFont(f2);
        tfuser.setFont(f2);
        pass1.setFont(f2);
        pass2.setFont(f2);
        tfbirth.setFont(f2);
        address.setFont(f2);
        //color
        lblfn.setForeground(new Color(236, 240, 241));
        lblln.setForeground(new Color(236, 240, 241));
        lbluser.setForeground(new Color(236, 240, 241));
        lblpass.setForeground(new Color(236, 240, 241));
        lblrepass.setForeground(new Color(236, 240, 241));
        lblbirth.setForeground(new Color(236, 240, 241));
        lbladdress.setForeground(new Color(236, 240, 241));
        tfname.setForeground(new Color(228, 241, 254));
        tflname.setForeground(new Color(228, 241, 254));
        tfuser.setForeground(new Color(228, 241, 254));
        pass1.setForeground(new Color(228, 241, 254));
        pass2.setForeground(new Color(228, 241, 254));
        tfbirth.setForeground(new Color(228, 241, 254));
        address.setForeground(new Color(228, 241, 254));
        lblcheck.setForeground(new Color(242, 38, 19));
        lblusercheck.setForeground(new Color(242, 38, 19));
        lbllog.setForeground(Color.WHITE);
        btncancel.setForeground(Color.WHITE);
        btnreg.setForeground(Color.WHITE);
        tfname.setBackground(new Color(108, 122, 137));
        tflname.setBackground(new Color(108, 122, 137));
        tfuser.setBackground(new Color(108, 122, 137));
        pass1.setBackground(new Color(108, 122, 137));
        pass2.setBackground(new Color(108, 122, 137));
        tfbirth.setBackground(new Color(108, 122, 137));
        address.setBackground(new Color(108, 122, 137));
        btnreg.setBackground(new Color(89, 171, 227));
        btncancel.setBackground(new Color(242, 38, 19));
        

        //actions
        lblclose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        lblmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(JFrame.ICONIFIED);
            }
        });
        //back to login form
        lbllog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginForm lgf = new LoginForm();
                lgf.setVisible(true);
                dispose();

            }
        });
        //register button
        btnreg.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String userchecker=userCheck();
                if(userchecker.equalsIgnoreCase(tfuser.getText()))
                    lblusercheck.setText("this username already exists");
                else{
                    lblusercheck.setText("");
                if(!pass1.getText().equalsIgnoreCase(pass2.getText()))
                   lblcheck.setText("Wrong Password");
               else
               {
                lblcheck.setText("");   
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                    PreparedStatement s = c.prepareStatement("insert into user_info values(?,?,?,?,?,?)");
                    s.setString(1, tfname.getText());
                    s.setString(2, tflname.getText());
                    s.setString(3, tfuser.getText());
                    s.setString(4, pass1.getText());
                    s.setString(5, address.getText());
                    s.setString(6, tfbirth.getText());
                    s.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Successfully Registered","Registerion",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
               }

                }
            }
            
        });
        //cancel registerion and back to login form
        btncancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                LoginForm lgf = new LoginForm();
                lgf.setVisible(true);
                dispose();

            }
        });
        
       

        //put components on panel 1&2
        p1.add(lblreg);
        p1.add(lblclose);
        p1.add(lblmin);
        p2.add(lblfn);
        p2.add(lblln);
        p2.add(lbluser);
        p2.add(lblpass);
        p2.add(lblrepass);
        p2.add(lblbirth);
        p2.add(lbladdress);
        p2.add(tfname);
        p2.add(tflname);
        p2.add(tfuser);
        p2.add(pass1);
        p2.add(pass2);
        p2.add(tfbirth);
        p2.add(address);
        p2.add(btncancel);
        p2.add(btnreg);
        p2.add(lbllog);
        p2.add(lblcheck);
        p2.add(lblusercheck);
        add(p1);
        add(p2);
    }
   public String userCheck(){
       String userchecker=""; 
       try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                    PreparedStatement pst = con.prepareStatement("select * from user_info where UserName=? ");
                    pst.setString(1,tfuser.getText() );
                    ResultSet res = pst.executeQuery();
                     if (res.next())
                           userchecker=res.getString("UserName");
                     else
                         return "";
                       

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
       return userchecker;
   }
    
}
