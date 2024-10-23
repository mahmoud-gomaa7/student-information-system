
package studentmanagementsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;


public class Inhearit extends JFrame {
        static AddStudent add=new AddStudent();
        static EditStudent edit=new EditStudent();
        
    Inhearit(){
        
        JTabbedPane t=new JTabbedPane();
        t.insertTab("ADD STUDENT",/* لوضع صورة*/ null, add.addStudent, "To Add Your New Student Here", 0);//insert the add panel....
        t.insertTab("EDIT STUDENT",/* هذا البارمتر لوضع صورة */ null, edit.editStud, "To Edit Your Students Here", 1);//insert the edit panel....
        new JFrame("student details");//اضافة الفريم
        setSize(800, 700);// تحديد حجم الفريم
        this.setLocationRelativeTo(null);//وضع الفريم في منتصف الشاشة
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(t);
        
    }

    
    
}
