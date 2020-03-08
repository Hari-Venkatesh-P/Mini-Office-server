package studentapplication;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import studentapplication.*;
import java.sql.*;
import javax.swing.*;

public class StudentZone extends JFrame {

    private String userid,name,year,dept,cgpa;
    JPanel selectPanel;
    JLabel searmsg;
    JButton select;
    JLabel ts1, ts2, ts3, ts4, ts5, ts6;
    Connection con;
    Statement st;
    ResultSet rs;

    StudentZone(String a,String b,String c,String d,String e) {
        userid = a;
        name = b;
        year = c;
        dept = d;
        cgpa = e;
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Zone");

        ts6 = new JLabel("Your Profile..!!");
        JLabel ls1 = new JLabel("Roll No");
        JLabel ls2 = new JLabel("Name");
        JLabel ls3 = new JLabel("Year");
        JLabel ls4 = new JLabel("Department");
        JLabel ls5 = new JLabel("CGPA");
        ts1 = new JLabel(userid);
        ts2 = new JLabel(name);
        ts3 = new JLabel(year);
        ts4 = new JLabel(dept);
        ts5 = new JLabel(cgpa);
        
        JPanel s = new JPanel();
        s.setLayout(new BorderLayout());
        JLabel searmsg = new JLabel();
        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new GridLayout(5, 10, 5, 10));
        selectPanel.add(ls1);
        selectPanel.add(ts1);
        selectPanel.add(ls2);
        selectPanel.add(ts2);
        selectPanel.add(ls3);
        selectPanel.add(ts3);
        selectPanel.add(ls4);
        selectPanel.add(ts4);
        selectPanel.add(ls5);
        selectPanel.add(ts5);
        select = new JButton("Logout");
        s.add(ts6, BorderLayout.NORTH);
        s.add(selectPanel, BorderLayout.CENTER);
        s.add(select, BorderLayout.SOUTH);
        add(s);

        //connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdb", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        //profile 
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(con!=null)
                    {
                        con.close();
                        setVisible(false);
                        HomePage al = new HomePage();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
    }
}
