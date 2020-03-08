/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplication;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame {
    JLabel l1;
    JButton student, admin;
    HomePage() {
       Toolkit kit =Toolkit.getDefaultToolkit();
       Image i1 = kit.getImage("logo.png");
      setIconImage(i1);
        setSize(300, 200);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home Page");
        setLayout(new BorderLayout());
        l1 = new JLabel("<-----Welcome To Student Office Server----->");
        student = new JButton("Student");
        admin = new JButton("Administator");
        add(student,BorderLayout.NORTH);
	add(l1,BorderLayout.CENTER);
	add(admin,BorderLayout.SOUTH);
        
        //student
        student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    StudentLogin sl = new StudentLogin();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    AdminLogin al = new AdminLogin();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }
    
}
