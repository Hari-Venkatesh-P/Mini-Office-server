/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

class StudentLogin extends JFrame {

    JLabel l1, l2, l3;
    JButton but;
    JTextField tf1;
    JPasswordField tf2;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    StudentLogin() {
        setSize(500, 200);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Login Page");
        setLayout(new BorderLayout());
        l1 = new JLabel("Welcome To Student Login Page");
        l2 = new JLabel("USER ID :");
        l3 = new JLabel("Password :");
        but = new JButton("***Login In***");
        tf1 = new JTextField(20);
        tf2 = new JPasswordField(20);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2, 2, 10, 10));
        pane.add(l2);
        pane.add(tf1);
        pane.add(l3);
        pane.add(tf2);
        add(l1, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(but, BorderLayout.SOUTH);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdb", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        but.addActionListener(new ActionListener() {
             
            String name = null,year = null,cgpa = null,dept = null;
            String uid;
            public void actionPerformed(ActionEvent ae) {
                try {
                         uid = tf1.getText();
                        System.out.println(uid);
                        String query1 = "select * from student where rno='" + uid + "'";
                        ResultSet rs1 = st.executeQuery(query1);
                        System.out.println("#########");
                        if (rs1.next()) {
                           name = (rs1.getString("name"));
                           year = rs1.getString("year");
                           dept = (rs1.getString("dept"));
                           cgpa = (rs1.getString("cgpa"));
                        } else {
                            
                            System.out.println("Error   "+uid);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                try {
                    String rpassword = "";
                    String pass = tf2.getText();
                    String query = "select password from studentcredentials where userid='" + uid + "'";
                    rs = st.executeQuery(query);
                    if (rs.next()) {
                        rpassword = (rs.getString("password"));
                    }
                    if (rpassword.equals(pass)) {
                        System.out.println("Valid Login");
                        setVisible(false);
                        StudentZone az = new StudentZone(uid,name,year,dept,cgpa);
                    } else {
                        System.out.println("InvalidLogin"+rpassword);
                    }
                } catch (Exception ex) {
                }
            }
        });
    }
}