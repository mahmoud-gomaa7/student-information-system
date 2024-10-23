
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
public class AddGrade extends JPanel {
    DefaultTableModel model;
    public AddGrade() {
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
            final JTextField tfsearch = new JTextField();
            tfsearch.setBounds(400, 15, 140, 20);
            tfsearch.setForeground(new Color(228,241,254));
            tfsearch.setBackground(new Color(108,122,137));
            add(tfsearch);

            //create table
            // my table model for student...
             model = new DefaultTableModel();
            model.addColumn("Col1");
            model.addColumn("Col2");
            model.addColumn("Col2");

            model.addRow(new Object[]{"Student ID", "Subject Code", "Grade"});
            final JTable table = new JTable(model);
            table.setBounds(350, 60, 400, 400);// infotable for showing the grades detials....
            table.setForeground(Color.WHITE);
            table.setForeground(new Color(228,241,254));
            table.setBackground(new Color(108,122,137));
            add(table);

            //Buttons
            JButton btnsave = new JButton("SAVE");
            btnsave.setBounds(60, 250, 100, 30);
            btnsave.setForeground(Color.WHITE);
            btnsave.setBackground(new Color(242,38,19));
            add(btnsave);
            JButton btnclear = new JButton("CLEAR");
            btnclear.setBounds(210, 250, 100, 30);
            btnclear.setForeground(Color.WHITE);
            btnclear.setBackground(new Color(242,38,19));
            add(btnclear);
            JButton btnsearch = new JButton("SEARCH ID ");
            btnsearch.setBounds(600, 10, 100, 30);
            btnsearch.setForeground(Color.WHITE);
            btnsearch.setBackground(new Color(242,38,19));
            add(btnsearch);

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

            final Object[] row = new Object[3];

            //shearch for id & subjectcode
            btnsearch.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Function f = new Function();
                    ResultSet res = null;
                   
                    res = f.find(tfsearch.getText());
                    try {
                        if (res.next()) {
                            tfid.setText(tfsearch.getText());
                            tfcode.setText(res.getString(2));
                        } else {
                            tfid.setText("");
                            tfcode.setText("");
                            JOptionPane.showMessageDialog(null, "This ID isn't found");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
            //ADD button
            btnsave.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    row[0] = tfid.getText();
                    row[1] = tfcode.getText();
                    row[2] = tfgrade.getText();
                    model.addRow(row);
                    Grade.editpanel.model.addRow(row);

                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                        PreparedStatement s = c.prepareStatement("insert into studendgrade values ('" + tfid.getText() + "','" + tfcode.getText() + "','" + tfgrade.getText() + "')");
                         s.executeUpdate();
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
                    tfsearch.setText("");
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

        public class Function {

            Connection con = null;
            ResultSet res = null;
            PreparedStatement pst = null;

            public ResultSet find(String s) {
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                    pst = con.prepareStatement("select * from studentsubject where id=?");
                    pst.setString(1, s);
                    res = pst.executeQuery();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                return res;
            }
        }
    
    
}
