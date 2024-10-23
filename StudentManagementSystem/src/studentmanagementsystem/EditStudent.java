
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class EditStudent  {
    
    JPanel editStud=new JPanel();
    
    
    JLabel id=new JLabel("ID");
        JLabel name=new JLabel("Name");
        JLabel age=new JLabel("AGE");
        JLabel phone=new JLabel("PHONE");
        JLabel address=new JLabel("ADDRESS");
        JLabel email=new JLabel("E_MAIL");
        JLabel gender=new JLabel("GENDER");
        final JComboBox sex=new JComboBox();
        final JTextField idt=new JTextField();
        final JTextField namet=new JTextField();
        final JTextField aget=new JTextField();
        final JTextField phonet=new JTextField();
        final JTextField addresst=new JTextField();
        final JTextField emailt=new JTextField();
        static final DefaultTableModel dm1 = new DefaultTableModel();//the Model for the table
        JTable t=new JTable();
        
        JButton nextFrame = new JButton("GO TO MANGE THE SUBJECTS");
        JButton oldFrame = new JButton("GO TO THE SYSTEM");
       
    
     EditStudent(){
    
    
    editStud.setBackground(new Color(44,62,80));
    editStud.setLayout(null);
    
    
            id.setBounds(50, 150, 15, 10);// id label....
            id.setForeground(new Color(236,240,241));
            editStud.add(id);


           name.setBounds(50, 200, 50, 10);// name label....
           name.setForeground(new Color(236,240,241));
           editStud.add(name);



           age.setBounds(50, 250, 50, 15);//age label....
           age.setForeground(new Color(236,240,241));
           editStud.add(age);


           phone.setBounds(50, 300, 70, 15);// phone label....
           phone.setForeground(new Color(236,240,241));
           editStud.add(phone);
           
           address.setBounds(50, 350, 90, 10);// address label....
           address.setForeground(new Color(236,240,241));
           editStud.add(address);


            email.setBounds(50, 400, 80, 10);// email label....
            email.setForeground(new Color(236,240,241));
            editStud.add(email);


            gender.setBounds(50, 460, 80, 10);// sex label....
            gender.setForeground(new Color(236,240,241));
            editStud.add(gender);
            
            sex.addItem("MALE");
            sex.addItem("FEMALE");
            sex.addItem("OTHER");
            sex.setBounds(110, 455, 100, 20);// sex ComboBox....
            sex.setForeground(new Color(236,240,241));
            sex.setBackground(new Color(108,122,137));
            editStud.add(sex);

            /*................................. الجزء الخاص بالتكست بوكس................................*/

            idt.setBounds(110, 145, 120, 20);// id TextField....
            idt.setForeground(new Color(228,241,254));
            idt.setBackground(new Color(108,122,137));
            editStud.add(idt);


            namet.setBounds(110, 195, 120, 20);//name TextField....
            namet.setForeground(new Color(228,241,254));
            namet.setBackground(new Color(108,122,137));
            editStud.add(namet);
            
            aget.setBounds(110, 245, 120, 20);// age TextField....
            aget.setForeground(new Color(228,241,254));
            aget.setBackground(new Color(108,122,137));
            editStud.add(aget);


            phonet.setBounds(110, 295, 120, 20);// phone TextField....
            phonet.setForeground(new Color(228,241,254));
            phonet.setBackground(new Color(108,122,137));
            editStud.add(phonet);


            addresst.setBounds(110, 345, 120, 20);// address TextField....
            addresst.setForeground(new Color(228,241,254));
            addresst.setBackground(new Color(108,122,137));
            editStud.add(addresst);


            emailt.setBounds(110, 395, 120, 20);// email TextField....
            emailt.setForeground(new Color(228,241,254));
            emailt.setBackground(new Color(108,122,137));
            editStud.add(emailt);
            
            dm1.addColumn("Col1"); 
            dm1.addColumn("Col2"); 
            dm1.addColumn("Col2");
            dm1.addColumn("Col2");
            dm1.addColumn("Col2");
            dm1.addColumn("Col2");
            dm1.addColumn("Col2");
            dm1.addRow(new Object[]{"ID", "NAME","sex","AGE","PHONE","ADDRESS","E_MAIL"});
            t.setForeground(new Color(228,241,254));
            t.setBackground(new Color(108,122,137));
                    
            t.setBounds(260, 145, 500, 270);
            editStud.add(t);
            t.setModel(dm1);
        
        try {
            
            
            java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");//make connection
            PreparedStatement stmt1 = con1.prepareStatement("select ID,Name,Sex,Age,Phone,Address,E_Mail from student");
            ResultSet set1 = stmt1.executeQuery();
            
            while (set1.next()) {
                String r[] = {set1.getString(1), set1.getString(2), set1.getString(3), set1.getString(4), set1.getString(5), set1.getString(6), set1.getString(7)};
                dm1.addRow(r);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    
    
    
    
    final JTextField searcht=new JTextField();
    searcht.setForeground(new Color(228,241,254));
    searcht.setBackground(new Color(108,122,137));
    searcht.setBounds(150, 515, 120, 20);// email TextField....
    editStud.add(searcht);
     /*.......................................SEARCH BUTTON.......................................*/
        JButton searchstu = new JButton("SEARCH");
        searchstu.setBounds(280, 510, 100, 30);// searchstu button foe searchs a student....
        searchstu.setForeground(Color.WHITE);
        searchstu.setBackground(new Color(242,38,19));
        editStud.add(searchstu);
         
        
        searchstu.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
               
               
               Function f = new Function();
               ResultSet res = f.find(searcht.getText());
                    
                    try {
                        if (res.next()) {
                            idt.setText(res.getString(1));
                            namet.setText(res.getString(2));
                            aget.setText(res.getString(4));
                            phonet.setText(res.getString(5));
                            addresst.setText(res.getString(6));
                            emailt.setText(res.getString(7));
                            switch(res.getString(3))
                            {
                                case "MALE":sex.setSelectedIndex(0);break;
                                case "FEMALE":sex.setSelectedIndex(1);break;
                                case "OTHER":sex.setSelectedIndex(2);break;
                            
                            }
                          /* if(res.getString(3)=="MALE")
                                sex.setSelectedIndex(0);
                            else if(res.getString(3)=="FEMALE")
                                sex.setSelectedIndex(1);
                            //else
                                //sex.setSelectedIndex(2);*/
                            
                        } else 
                            JOptionPane.showMessageDialog(null, "This ID isn't found");
                        
                    } catch (Exception ex) {
                        
                    }
               
           
        }
    });
        
        /*.......................................UPDATE BUTTON.......................................*/
        JButton editstu = new JButton("UPDATE");
        editstu.setBounds(660, 520, 100, 30);// editstu button foe editting new student....
        editstu.setForeground(Color.WHITE);
        editstu.setBackground(new Color(242,38,19));
        editStud.add(editstu);
        editstu.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                Function f = new Function();
                ResultSet res = f.find(searcht.getText());
                if (res.next()){
                    String gender=null;
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");//make connection
                    PreparedStatement stmt = con.prepareStatement("update student set ID=?,Name=?,Sex=?,Age=?,Phone=?,Address=?,E_Mail=? where ID=? ");
                    stmt.setString(1, idt.getText());
                    stmt.setString(2, namet.getText());
                    stmt.setString(4, aget.getText());
                    stmt.setString(5, phonet.getText());
                    stmt.setString(6, addresst.getText());
                    stmt.setString(7, emailt.getText());
                    stmt.setString(8, searcht.getText());
                    if(sex.getSelectedIndex()==0)
                    {
                        stmt.setString(3, "MALE");
                        gender="MALE";
                    }
                    if(sex.getSelectedIndex()==1)
                    {
                        stmt.setString(3, "FEMAlE");
                        gender="FEMAlE";
                    }
                    if(sex.getSelectedIndex()==2)
                    {
                        stmt.setString(3, "OTHER");
                        gender= "OTHER";
                    }
                    stmt.executeUpdate();
                     for(int i = 0; i < dm1.getRowCount(); i++){//For each row
                        for(int j = 0; j < 1; j++){//For each column in that row
                            if(dm1.getValueAt(i, j).equals(searcht.getText())){//Search the model
                                dm1.setValueAt(idt.getText(), i, 0);
                                dm1.setValueAt(namet.getText(), i, 1);
                                dm1.setValueAt(gender, i, 2);
                                dm1.setValueAt(aget.getText(), i, 3);
                                dm1.setValueAt(phonet.getText(), i, 4);
                                dm1.setValueAt(addresst.getText(), i, 5);
                                dm1.setValueAt(emailt.getText(), i, 6);
                                Inhearit.add.dm1.setValueAt(idt.getText(), i, 0);
                                Inhearit.add.dm1.setValueAt(namet.getText(), i, 1);
                                Inhearit.add.dm1.setValueAt(gender, i, 2);
                                Inhearit.add.dm1.setValueAt(aget.getText(), i, 3);
                                Inhearit.add.dm1.setValueAt(phonet.getText(), i, 4);
                                Inhearit.add.dm1.setValueAt(addresst.getText(), i, 5);
                                Inhearit.add.dm1.setValueAt(emailt.getText(), i, 6);
                                
                                break;
                            }
                        }//For loop inner
                        
                    }//For loop outer
                    
                }else  
                   JOptionPane.showMessageDialog(null, "This ID isn't found");
                        

            }catch(SQLException ex){
                
                }
            }
            
        
    });
        
        /*.......................................delete BUTTON.......................................*/
        JButton delete = new JButton("DELETE");
        delete.setBounds(533, 520, 100, 30);// editstu button foe editting new student....
        delete.setForeground(Color.WHITE);
        delete.setBackground(new Color(242,38,19));
        editStud.add(delete);
        delete.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            PreparedStatement s = c.prepareStatement("delete from student where ID=?");
            PreparedStatement s2 = c.prepareStatement("delete from studendgrade where ID=?");
            PreparedStatement s1 = c.prepareStatement("delete from studentsubject where ID=?");
            s.setString(1, searcht.getText());
            s.executeUpdate();
            for(int i = 0; i < dm1.getRowCount(); i++){//For each row
                        for(int j = 0; j < 1; j++){//For each column in that row
                            if(dm1.getValueAt(i, j).equals(searcht.getText())){//Search the model
                                dm1.removeRow(i);
                                Inhearit.add.dm1.removeRow(i);
                                break;
                            }
                        }//For loop inner
                        
                    }//For loop outer
        } catch (SQLException ex) {
            System.out.println("Error");
        }
            
        }
    });
    /************************************ .... next frame....**********************************/
    nextFrame.setBounds(530, 570, 230, 30);// nextframe button GO TO the next frame that MANGE THE SUBJECTS....
        nextFrame.setForeground(Color.WHITE);
        nextFrame.setBackground(new Color(242,38,19));
        editStud.add(nextFrame);
        nextFrame.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    Subject subf=new Subject();
                     subf.setVisible(true);
                
                    ControlForm.stuform.dispose();
                }
            });
        
        
        
        /************************************ .... old frame....**********************************/
        
         oldFrame.setBounds(30, 570, 230, 30);// oldFrame button back me to the system frame....
         oldFrame.setForeground(Color.WHITE);
        oldFrame.setBackground(new Color(242,38,19));
        editStud.add(oldFrame);
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
