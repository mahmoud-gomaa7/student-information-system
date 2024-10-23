
package studentmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.border.Border;


public class LoginForm extends JFrame {
    public LoginForm(){
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setUndecorated(true);
        
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        p1.setLayout(null);
        p2.setLayout(null);
        p1.setBounds(0, 0, 400, 60);
        p2.setBounds(0, 61, 400, 360);
        p1.setBackground(new Color(248,148,6));
        p2.setBackground(new Color(44,62,80));
        
        JLabel lbllog=new JLabel();
        JLabel lblclose=new JLabel();
        JLabel lblmin=new JLabel();
        //manage panel 1
        lbllog.setText("Login Form");
        lblclose.setText("X");
        lblmin.setText("-");
        lblclose.setCursor(new Cursor(HAND_CURSOR));
        lblmin.setCursor(new Cursor(HAND_CURSOR));
        Font myfont=new Font("Tahoma", Font.BOLD, 24);
        lbllog.setBounds(40, 12, 180,30 );
        lblclose.setBounds(370, 18, 100,20 );
        lblmin.setBounds(345, 18, 100,20 );
        lbllog.setFont(myfont);
        lblclose.setFont(myfont);
        lblmin.setFont(myfont);
        lbllog.setForeground(Color.WHITE);
        lblclose.setForeground(Color.WHITE);
        lblmin.setForeground(Color.WHITE);
        //panel 2
        JLabel lbluser=new JLabel();
        JLabel lblpass=new JLabel();
        JLabel lblreg=new JLabel();
        final JTextField tfuser=new JTextField();
        final JPasswordField pass=new JPasswordField();
        JButton btnlog=new JButton();
        JButton btncancel=new JButton();
        
        lbluser.setText("Username:");
        lblpass.setText("Password:");
        btnlog.setText("Login");
        btncancel.setText("Cancel");
        lblreg.setText("click here to create a new account");
        btnlog.setBorder(null);
        btncancel.setBorder(null);
        lblreg.setCursor(new Cursor(HAND_CURSOR));
        lbluser.setBounds(30, 150, 100, 30);
        lblpass.setBounds(30, 220, 100, 30);
        tfuser.setBounds(130, 155, 190, 25);
        pass.setBounds(130, 225, 190, 25);
        btnlog.setBounds(240,280,80,30);
        btncancel.setBounds(140,280,80,30);
        lblreg.setBounds(125,320,220,25);
        tfuser.setBorder(null);
        pass.setBorder(null);
        Font f2=new Font("Tahoma", Font.PLAIN, 18);
        Font f3=new Font("Tahoma", Font.PLAIN, 14);
        lbluser.setFont(f2);
        lblpass.setFont(f2);
        lblreg.setFont(f3);
        tfuser.setFont(f3);
        pass.setFont(f3);
        lbluser.setForeground(new Color(236,240,241));
        lblpass.setForeground(new Color(236,240,241));
        lblreg.setForeground(Color.WHITE);
        tfuser.setForeground(new Color(228,241,254));
        pass.setForeground(new Color(228,241,254));
        btnlog.setForeground(Color.WHITE);
        btncancel.setForeground(Color.WHITE);
        tfuser.setBackground(new Color(108,122,137));
        pass.setBackground(new Color(108,122,137));
        btnlog.setBackground(new Color(89,171,227));
        btncancel.setBackground(new Color(242,38,19));
        
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
         lblreg.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   RegisterForm rgf=new RegisterForm();
                   rgf.setVisible(true);
                   dispose();
                    
                }
            });
         btnlog.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                    PreparedStatement pst = con.prepareStatement("select * from user_info where UserName=? and passwords=?");
                    pst.setString(1,tfuser.getText() );
                    pst.setString(2,pass.getText() );
                    ResultSet res = pst.executeQuery();
                     if (res.next()) {
                           ControlForm cf=new ControlForm();
                           cf.setVisible(true);
                           dispose();
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Invalid username or password","Access Denied",JOptionPane.ERROR_MESSAGE);
                        }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
         btncancel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    tfuser.setText("");
                    pass.setText("");
                    System.exit(0);
                }
            });
        
                
        p1.add(lbllog);
        p1.add(lblclose);
        p1.add(lblmin);
        p2.add(lbluser);
        p2.add(lblpass);
        p2.add(tfuser);
        p2.add(pass);
        p2.add(btnlog);
        p2.add(btncancel);
        p2.add(lblreg);
        add(p1);
        add(p2);
        
        setVisible(true);
    }
    
}
