
package studentmanagementsystem;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class AddStudent extends JPanel {
    
    final DefaultTableModel dm1 = new DefaultTableModel();//the Model for the table
    JPanel addStudent=new JPanel();
     AddStudent(){
        
/************************** SPEACIAL Part That Work With The Adding student panel*****************************************/
        //اضافةلوضعها علي التاب بانل الخاصة باضافة تلميذ Pane  
        addStudent.setLayout(null);
        addStudent.setBackground(new Color(44,62,80));
        

        
        /* الجزء الخاص بال                   ................................ lables.....................*/
        JLabel id=new JLabel("ID");
        id.setBounds(50, 150, 15, 10);// id label....
        id.setForeground(new Color(236,240,241));
        addStudent.add(id);
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 200, 50, 10);// name label....
        name.setForeground(new Color(236,240,241));
        addStudent.add(name);
        
        
        JLabel age=new JLabel("AGE");
        age.setBounds(50, 250, 50, 15);//age label....
        age.setForeground(new Color(236,240,241));
        addStudent.add(age);
        
        JLabel phone=new JLabel("PHONE");
        phone.setBounds(50, 300, 70, 15);// phone label....
        phone.setForeground(new Color(236,240,241));
        addStudent.add(phone);
        
        JLabel address=new JLabel("ADDRESS");
        address.setBounds(50, 350, 90, 10);// address label....
        address.setForeground(new Color(236,240,241));
        addStudent.add(address);
       
        JLabel email=new JLabel("E_MAIL");
        email.setBounds(50, 400, 80, 10);// email label....
        email.setForeground(new Color(236,240,241));
        addStudent.add(email);
        
        JLabel gender=new JLabel("GENDER");
        gender.setBounds(50, 460, 80, 10);// sex label....
        gender.setForeground(new Color(236,240,241));
        addStudent.add(gender);
        
        final JComboBox sex=new JComboBox();
        sex.addItem("MALE");
        sex.addItem("FEMALE");
        sex.addItem("OTHER");
        sex.setBounds(110, 455, 100, 20);// sex ComboBox....
        sex.setForeground(new Color(236,240,241));
        sex.setBackground(new Color(108,122,137));
        addStudent.add(sex);
        
        /*................................. الجزء الخاص بالتكست بوكس................................*/
        final JTextField idt=new JTextField();
        idt.setBounds(110, 145, 120, 20);// id TextField....
        idt.setForeground(new Color(228,241,254));
        idt.setBackground(new Color(108,122,137));
        addStudent.add(idt);
        
        final JTextField namet=new JTextField();
        namet.setBounds(110, 195, 120, 20);//name TextField....
        namet.setForeground(new Color(228,241,254));
        namet.setBackground(new Color(108,122,137));
        addStudent.add(namet);
        
        final JTextField aget=new JTextField();
        aget.setBounds(110, 245, 120, 20);// age TextField....
        aget.setForeground(new Color(228,241,254));
        aget.setBackground(new Color(108,122,137));
        addStudent.add(aget);
        
        final JTextField phonet=new JTextField();
        phonet.setBounds(110, 295, 120, 20);// phone TextField....
        phonet.setForeground(new Color(228,241,254));
        phonet.setBackground(new Color(108,122,137));
        addStudent.add(phonet);
        
        final JTextField addresst=new JTextField();
        addresst.setBounds(110, 345, 120, 20);// address TextField....
        addresst.setForeground(new Color(228,241,254));
        addresst.setBackground(new Color(108,122,137));
        addStudent.add(addresst);
        
        final JTextField emailt=new JTextField();
        emailt.setBounds(110, 395, 120, 20);// email TextField....
        emailt.setForeground(new Color(228,241,254));
        emailt.setBackground(new Color(108,122,137));
        addStudent.add(emailt);
        
       
        
        
        dm1.addColumn("Col1"); 
        dm1.addColumn("Col2"); 
        dm1.addColumn("Col2");
        dm1.addColumn("Col2");
        dm1.addColumn("Col2");
        dm1.addColumn("Col2");
        dm1.addColumn("Col2");
        dm1.addRow(new Object[]{"ID", "NAME","sex","AGE","PHONE","ADDRESS","E_MAIL"});
        JTable t=new JTable();    
        t.setForeground(new Color(228,241,254));
        t.setBackground(new Color(108,122,137));
        t.setBounds(260, 145, 500, 270);
        
        
        addStudent.add(t);
        t.setModel(dm1);
        
        try {
            
            
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");//make connection
            PreparedStatement stmt1 = con1.prepareStatement("select ID,Name,Sex,Age,Phone,Address,E_Mail from student");
            ResultSet set1 = stmt1.executeQuery();
            
            while (set1.next()) {
                String r[] = {set1.getString(1), set1.getString(2), set1.getString(3), set1.getString(4), set1.getString(5), set1.getString(6), set1.getString(7)};
                dm1.addRow(r);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        //................. SPEACIAL Part That Work With The Buttons..................//
        JButton addStu = new JButton("ADD THE STUDENT");
        addStu.setForeground(Color.WHITE);
        addStu.setBackground(new Color(242,38,19));
        addStu.setBounds(320, 500, 150, 30);// addstu button foe adding new student....
        
        
        addStu.addActionListener(new ActionListener() {//add action to the addstu button

            @Override
            public void actionPerformed(ActionEvent ae) {
                
        try {
                String nn=null;
                String d_id = idt.getText();
                String d_name = namet.getText();
                String d_age = aget.getText();
                String d_phone = phonet.getText();
                String d_address = addresst.getText();
                String d_email = emailt.getText();
                int d_sex = sex.getSelectedIndex();
                if(d_sex==0)
                    nn= "MALE";
                if(d_sex==1)
                    nn= "FEMAlE";
                if(d_sex==2)
                    nn="OTHER";
                String m[] = {d_id, d_name, nn, d_age, d_phone, d_address, d_email};
                Inhearit.edit.dm1.addRow(m);
                
                dm1.addRow(m);
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                PreparedStatement s = c.prepareStatement("insert into student(ID,Name,Sex,Age,Phone,Address,E_Mail) values(?,?,?,?,?,?,?)");
                s.setString(1, d_id);
                s.setString(2, d_name);
                if(d_sex==0)
                    s.setString(3, "MALE");
                if(d_sex==1)
                    s.setString(3, "FEMAlE");
                if(d_sex==2)
                    s.setString(3, "OTHER");
                s.setString(4, d_age);
                s.setString(5, d_phone);
                s.setString(6, d_address);
                s.setString(7, d_email);
                s.executeUpdate();


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }  
            }
        });
        addStudent.add(addStu);
        
        
        
        
        
        JButton nextFrame = new JButton("GO TO MANGE THE SUBJECTS");
        nextFrame.setBounds(530, 570, 230, 30);// nextframe button GO TO the next frame that MANGE THE SUBJECTS....
        nextFrame.setForeground(Color.WHITE);
        nextFrame.setBackground(new Color(242,38,19));
        addStudent.add(nextFrame);
        
        
        nextFrame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Subject subf=new Subject();
                subf.setVisible(true);
                
                ControlForm.stuform.dispose();
                
            }
        });
        
        JButton oldFrame = new JButton("GO TO THE SYSTEM");
        oldFrame.setBounds(30, 570, 230, 30);// oldFrame button back me to the system frame....
        oldFrame.setForeground(Color.WHITE);
        oldFrame.setBackground(new Color(242,38,19));
        addStudent.add(oldFrame);
        
        oldFrame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ControlForm ctrf=new ControlForm();
                ctrf.setVisible(true);
                ControlForm.stuform.dispose();     
            }
        });
        
         
    }       
    
}
    
