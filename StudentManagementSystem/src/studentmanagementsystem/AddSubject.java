
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
public class AddSubject extends JPanel{
     DefaultTableModel model;
    public AddSubject(){
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
            JLabel lblname = new JLabel(" Name ");
            lblname.setBounds(40, 180, 140, 40);
            lblname.setForeground(new Color(236,240,241));
            add(lblname);
            JLabel lblhour = new JLabel(" NO.Of Hours ");
            lblhour.setBounds(40, 220, 140, 40);
            lblhour.setForeground(new Color(236,240,241));
            add(lblhour);

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
            add(tfcode);
            final JTextField tfname = new JTextField();
            tfname.setBounds(200, 190, 140, 20);
            tfname.setForeground(new Color(228,241,254));
            tfname.setBackground(new Color(108,122,137));
            add(tfname);
            final JTextField tfhour = new JTextField();
            tfhour.setBounds(200, 230, 140, 20);
            tfhour.setForeground(new Color(228,241,254));
            tfhour.setBackground(new Color(108,122,137));
            add(tfhour);
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
            model.addColumn("Col2");

            model.addRow(new Object[]{"Student ID", "Subject Code", "Subject Name","NO.OfHours"});
            final JTable table = new JTable(model);
            table.setBounds(350, 60, 400, 400);// infotable for showing the grades detials....
            table.setForeground(new Color(228,241,254));
            table.setBackground(new Color(108,122,137));
            add(table);

            //Buttons
            JButton btnsave = new JButton("SAVE");
            btnsave.setBounds(60, 290, 100, 30);
            btnsave.setForeground(Color.WHITE);
            btnsave.setBackground(new Color(242,38,19));
            add(btnsave);
            JButton btnclear = new JButton("CLEAR");
            btnclear.setBounds(210, 290, 100, 30);
            btnclear.setForeground(Color.WHITE);
            btnclear.setBackground(new Color(242,38,19));
            add(btnclear);
            JButton btnsearch = new JButton("SEARCH ID ");
            btnsearch.setBounds(600, 10, 100, 30);
            btnsearch.setForeground(Color.WHITE);
            btnsearch.setBackground(new Color(242,38,19));
            add(btnsearch);

            JButton btnback = new JButton("GO TO MANAGE STUDENT");
            btnback.setBounds(30, 530, 200, 30);
            btnback.setForeground(Color.WHITE);
            btnback.setBackground(new Color(242,38,19));
            add(btnback);
            JButton btnnext = new JButton("GO TO MANAGE GRADE");
            btnnext.setBounds(570, 530, 180, 30);
            btnnext.setForeground(Color.WHITE);
            btnnext.setBackground(new Color(242,38,19));
            add(btnnext);
            
            //actions
            //load data into table 
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                PreparedStatement stmt = con.prepareStatement("select * from subject");
                ResultSet res = stmt.executeQuery();

                while (res.next()) {
                    String r[] = {res.getString(1), res.getString(2), res.getString(3),res.getString(4)};
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
                    tfname.setText(model.getValueAt(i, 2).toString());
                    tfhour.setText(model.getValueAt(i, 3).toString());
                }
            });

            final Object[] row = new Object[4];

            //shearch for student id 
            btnsearch.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Function f = new Function();
                    ResultSet res = null;
                   
                    res = f.find(tfsearch.getText());
                    try {
                        if (res.next()) {
                            tfid.setText(tfsearch.getText());
                            
                        } else {
                            tfid.setText("");
                            
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
                    row[2] = tfname.getText();
                    row[3] = tfhour.getText();
                    model.addRow(row);
                    Subject.editpanel.model.addRow(row);

                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                        PreparedStatement s = c.prepareStatement("insert into subject values ('" + tfid.getText() + "','" + tfcode.getText() + "','" + tfname.getText() + "','"+tfhour.getText()+"')");
                        PreparedStatement s2 = c.prepareStatement("insert into studentsubject values ('" + tfid.getText() + "','" + tfcode.getText() + "')"); 
                        s.executeUpdate();
                        s2.executeUpdate();
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
                    tfname.setText("");
                    tfhour.setText("");
                    tfsearch.setText("");
                }
            });
            //back button (go to student form)
            btnback.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                      
                      Inhearit stuf=new Inhearit();
                      stuf.setVisible(true);
                      ControlForm.subform.dispose();
                }
            });
            //next button (go to grade form)
            btnnext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Grade gradef=new Grade();
                gradef.setVisible(true);
                ControlForm.subform.dispose();
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
                    pst = con.prepareStatement("select * from student where id=?");
                    pst.setString(1, s);
                    res = pst.executeQuery();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                return res;
            }
    }
    
}
