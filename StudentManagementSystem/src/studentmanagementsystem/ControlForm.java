package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlForm extends JFrame {
   public static JFrame stuform;
   public static JFrame gradeform;
   public static JFrame subform;
    public ControlForm() {
        setTitle("student managment");
        //setSize(704,466);
        setSize(800,700);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JButton student=new JButton("Student Info");
        student.setBounds( 450,120, 200,50);
        add (student);
        student.setBackground(new Color(71, 80, 118));
        student.setForeground(Color.WHITE);
        student.setFont(new Font ("Times", Font.BOLD, 18));
        
        JButton subject=new JButton("Subject Info");
        subject.setBounds( 450,180, 200, 50);
        add(subject);
        subject.setBackground(new Color(71, 80, 118));
        subject.setForeground(Color.WHITE);
        subject.setFont(new Font ("Times", Font.BOLD, 18));
        
        JButton grade=new JButton("Grade Info");
        grade.setBounds( 450,240, 200, 50);
        add(grade);
        grade.setBackground(new Color(71, 80, 118));
        grade.setForeground(Color.WHITE);
        grade.setFont(new Font ("Times", Font.BOLD, 18));
        
        JButton logout=new JButton("Log-Off");
        logout.setBounds( 450,300, 200, 50);  
        add(logout);
        logout.setBackground(new Color(71, 80, 118));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font ("Times", Font.BOLD, 18));
        
        JLabel welcom=new JLabel("Welcome to Student Managment");
        welcom.setBounds( 160,10, 600,50);
        add (welcom);
         welcom.setForeground(new Color(1,50,67));
        welcom.setFont(new Font ("Times", Font.ITALIC+Font.BOLD, 25));
        
        
        
        
        
        ImageIcon icon=new ImageIcon("back.png"); 
        JLabel lbl=new JLabel(icon);
        lbl.setBounds(0, 0, 800, 700);
        add(lbl);
        setVisible(true);
        student.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                stuform=new Inhearit();
                stuform.setVisible(true);
                dispose();
            }
        });
        
        subject.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 subform=new Subject();
                subform.setVisible(true);
                dispose();
            }
        });
        
        grade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 gradeform=new Grade();
                gradeform.setVisible(true);
                dispose();
            }
        });
        
        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame lgf=new LoginForm();
                lgf.setVisible(true);
                dispose();
            }
        });
    }
}
