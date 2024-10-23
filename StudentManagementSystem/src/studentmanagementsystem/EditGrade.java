
package studentmanagementsystem;

import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;
public class EditGrade extends JPanel{
    DefaultTableModel model;
        public EditGrade() {
             setBackground(new Color(44,62,80));
            //put components on panel(add grade)
            //LABELS
            setLayout(null);
            JLabel lblid = new JLabel(" Student ID ");
            lblid.setBounds(40, 100, 140, 40);
            lblid.setForeground(new Color(236,240,241));
            add(lblid);
            JLabel lblcode = new JLabel(" Subject Code ");
            lblcode.setBounds(40, 140, 140, 40);
            lblcode.setForeground(new Color(236,240,241));
            add(lblcode);
            JLabel lbgrade = new JLabel(" Grade ");
            lbgrade.setBounds(40, 180, 140, 40);
            lbgrade.setForeground(new Color(236,240,241));
            add(lbgrade);

            //Textfields
             final JTextField tfid = new JTextField();
            tfid.setBounds(200, 110, 140, 20);
            tfid.setForeground(new Color(228,241,254));
            tfid.setBackground(new Color(108,122,137));
            tfid.setEditable(false);
            add(tfid);
            final JTextField tfcode = new JTextField();
            tfcode.setBounds(200, 150, 140, 20);
            tfcode.setForeground(new Color(228,241,254));
            tfcode.setBackground(new Color(108,122,137));
            tfcode.setEditable(false);
            add(tfcode);
            final JTextField tfgrade = new JTextField();
            tfgrade.setBounds(200, 190, 140, 20);
            tfgrade.setForeground(new Color(228,241,254));
            tfgrade.setBackground(new Color(108,122,137));
            add(tfgrade);
            

            //create table
             model = new DefaultTableModel();// my table model for student....
            model.addColumn("Col1");
            model.addColumn("Col2");
            model.addColumn("Col2");

            model.addRow(new Object[]{"Student ID", "Subject Code", "Grade"});
            final JTable table = new JTable(model);
            table.setBounds(350, 60, 400, 400);// infotable for showing the grades detials....
            table.setForeground(new Color(228,241,254));
            table.setBackground(new Color(108,122,137));
            add(table);

            //Buttons
            JButton btnupdate = new JButton("UPDATE");
            btnupdate.setBounds(60, 250, 100, 30);
            btnupdate.setForeground(Color.WHITE);
            btnupdate.setBackground(new Color(242,38,19));
            add(btnupdate);
            JButton btndel = new JButton("DELETE");
            btndel.setBounds(210, 250, 100, 30);
            btndel.setForeground(Color.WHITE);
            btndel.setBackground(new Color(242,38,19));
            add(btndel);
            JButton btnclear = new JButton("CLEAR");
            btnclear.setBounds(130, 300, 100, 30);
            btnclear.setForeground(Color.WHITE);
            btnclear.setBackground(new Color(242,38,19));
            add(btnclear);

            JButton btnback = new JButton("GO TO MANAGE SUBJECT");
            btnback.setBounds(30, 530, 200, 30);
            btnback.setForeground(Color.WHITE);
            btnback.setBackground(new Color(242,38,19));
            add(btnback);
            

            //actions
            //load data into table 
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from studendgrade");
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    String r[] = {res.getString(1), res.getString(2), res.getString(3)};
                    model.addRow(r);
                }

                table.setModel(model);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            //select row from table
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int i = table.getSelectedRow();
                    tfid.setText(model.getValueAt(i, 0).toString());
                    tfcode.setText(model.getValueAt(i, 1).toString());
                    tfgrade.setText(model.getValueAt(i, 2).toString());
                }
            });
            //update
            btnupdate.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int i = table.getSelectedRow();
                    if (i >= 0) {

                        model.setValueAt(tfgrade.getText(), i, 2);
                        Grade.addpanel.model.setValueAt(tfgrade.getText(), i, 2);;

                    } else {
                        JOptionPane.showMessageDialog(null, "Update Error");
                    }
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");//make connection
                        PreparedStatement stmt = con.prepareStatement("update  studendgrade set grade='" + tfgrade.getText() + "' where id='" + tfid.getText() + "'");
                        stmt.executeUpdate();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
            //delete
            btndel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        model.removeRow(i);
                        Grade.addpanel.model.removeRow(i);
                        tfid.setText("");
                        tfcode.setText("");
                        tfgrade.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete Error");
                    }
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");//make connection
                        PreparedStatement stmt = con.prepareStatement("delete from studendgrade where id='" + tfid.getText() + "'");
                        stmt.executeUpdate();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
            //Clear button
            btnclear.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    tfid.setText("");
                    tfcode.setText("");
                    tfgrade.setText("");
                }
            });
            //back button
            btnback.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                      
                      Subject subf=new Subject();
                     subf.setVisible(true);
                      ControlForm.gradeform.dispose();
                }
            });

        }
    
    
}
