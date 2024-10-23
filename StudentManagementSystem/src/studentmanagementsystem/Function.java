
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public  class Function {

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
