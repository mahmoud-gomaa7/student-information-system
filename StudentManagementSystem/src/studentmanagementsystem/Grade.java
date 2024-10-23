
package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Mahmoud
 */
public class Grade extends JFrame {
    static AddGrade addpanel=new AddGrade();
    static EditGrade editpanel=new EditGrade();
    
    public Grade(){
         // create frame
        setTitle("myframe");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //Create panels(ADD grade & EDIT grade)
        //create tabs 
        JTabbedPane t = new JTabbedPane();
        t.insertTab("Add grade", null, addpanel, "tip1", 0);
        t.insertTab("Edit grade", null, editpanel, "tip1", 1);
        add(t);

       
    }
    
}
