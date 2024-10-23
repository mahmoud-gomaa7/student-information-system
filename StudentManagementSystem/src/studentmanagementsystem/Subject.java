/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mahmoud
 */
public class Subject extends JFrame {
    static AddSubject addpanel=new AddSubject();
    static EditSubject editpanel=new EditSubject();

    Subject() {

         // create frame
        setTitle("myframe");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //Create panels(ADD grade & EDIT grade)
        //create tabs 
        JTabbedPane t = new JTabbedPane();
        t.insertTab("Add subject", null, addpanel, "tip1", 0);
        t.insertTab("Edit subject", null, editpanel, "tip1", 1);
        add(t);
    }

   

    
}
