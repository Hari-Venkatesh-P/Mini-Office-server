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
class AdminLogin extends JFrame {
    JLabel l1, l2, l3;
    JButton but;
    JTextField tf1;
    JPasswordField tf2;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    AdminLogin() {
        setSize(500, 200);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Login Page");
        setLayout(new BorderLayout());
        l1 = new JLabel("Welcome To Admin Login Page");
        l2 = new JLabel("Admin ID :");
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
            public void actionPerformed(ActionEvent ae) {
                try {
                    String rpassword = "";
                    String uid = tf1.getText();
                    String pass = tf2.getText();
                    String query = "select password from admincredentials where adminid='" + uid + "'";
                    rs = st.executeQuery(query);
                    if (rs.next()) {
                        rpassword = (rs.getString("password"));
                    }
                    if (rpassword.equals(pass)) {
                        System.out.println("Valid Login");
                        setVisible(false);
                        AdminZone az = new AdminZone(uid,rpassword);
                    } else {
                        System.out.println("InvalidLogin");
                    }
                } catch (Exception ex) {
                }
            }
        });
    }
}
