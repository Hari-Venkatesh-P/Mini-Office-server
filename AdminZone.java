package studentapplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AdminZone extends JFrame {

    private String adminid;
    private String password;
    JTabbedPane myTab = new JTabbedPane();
    JPanel selectPanel, deletePanel, updatePanel, insertPanel;
    JLabel insmsg, delmsg, updmsg, searmsg;
    JButton select, insert, delete, update;
    JTextField tn1, tn2, ts1, ts2, ts3, ts4, ts5, ti1, ti2, ti3, ti4, ti5, td1, tu1, tu2;
    Connection con;
    Statement st;
    ResultSet rs;

    AdminZone(String a,String b) {
        adminid = a;
        password =b;
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Zone");

        //Add Student
        JLabel li1 = new JLabel("Roll No");
        JLabel li2 = new JLabel("Name");
        JLabel li3 = new JLabel("Year");
        JLabel li4 = new JLabel("Department");
        JLabel li5 = new JLabel("CGPA");
        ti1 = new JTextField(20);
        ti2 = new JTextField(20);
        ti3 = new JTextField(20);
        ti4 = new JTextField(20);
        ti5 = new JTextField(20);
        JPanel i = new JPanel();
        i.setLayout(new BorderLayout());
        insmsg = new JLabel();
        insertPanel = new JPanel();
        insertPanel.setLayout(new GridLayout(5, 10, 5, 10));
        insertPanel.add(li1);
        insertPanel.add(ti1);
        insertPanel.add(li2);
        insertPanel.add(ti2);
        insertPanel.add(li3);
        insertPanel.add(ti3);
        insertPanel.add(li4);
        insertPanel.add(ti4);
        insertPanel.add(li5);
        insertPanel.add(ti5);
        insert = new JButton("Add Student");
        i.add(insmsg, BorderLayout.NORTH);
        i.add(insertPanel, BorderLayout.CENTER);
        i.add(insert, BorderLayout.SOUTH);
        myTab.add("Add Student", i);

        //seach student
        JLabel ls1 = new JLabel("Roll No");
        JLabel ls2 = new JLabel("Name");
        JLabel ls3 = new JLabel("Year");
        JLabel ls4 = new JLabel("Department");
        JLabel ls5 = new JLabel("CGPA");
        JTextField ts1 = new JTextField(20);
        JTextField ts2 = new JTextField(20);
        JTextField ts3 = new JTextField(20);
        JTextField ts4 = new JTextField(20);
        JTextField ts5 = new JTextField(20);
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
        select = new JButton("Search");
        s.add(searmsg, BorderLayout.NORTH);
        s.add(selectPanel, BorderLayout.CENTER);
        s.add(select, BorderLayout.SOUTH);
        myTab.add("Search Student", s);

        //update
        JLabel lu1 = new JLabel("Roll No");
        JTextField tu1 = new JTextField(20);
        JLabel lu2 = new JLabel("CGPA");
        JTextField tu2 = new JTextField(20);
        JPanel u = new JPanel();
        u.setLayout(new BorderLayout());
        JLabel updmsg = new JLabel();
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(2, 2));
        updatePanel.add(lu1);
        updatePanel.add(tu1);
        updatePanel.add(lu2);
        updatePanel.add(tu2);
        update = new JButton("Update CGPA");
        u.add(updmsg, BorderLayout.NORTH);
        u.add(updatePanel, BorderLayout.CENTER);
        u.add(update, BorderLayout.SOUTH);
        myTab.add("Update CGPA", u);

        //delete
        JLabel ld1 = new JLabel("Roll No");
        JTextField td1 = new JTextField(20);
        JPanel d = new JPanel();
        d.setLayout(new BorderLayout());
        JLabel del = new JLabel();
        JPanel deletePanel = new JPanel();
        deletePanel.add(ld1);
        deletePanel.add(td1);
        JLabel delmsg = new JLabel();
        delete = new JButton("Delete Student");
        d.add(delmsg, BorderLayout.NORTH);
        d.add(deletePanel, BorderLayout.CENTER);
        d.add(delete, BorderLayout.SOUTH);
        myTab.add("Delete Student", d);
        add(myTab);
        //admin profile

        JLabel lp1 = new JLabel("Your ID:");
        JLabel lp2 = new JLabel("Your Password:");
        JLabel tp1 = new JLabel(a);
        JLabel tp2 = new JLabel(b);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel pmsg = new JLabel("Your Profile");
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(2, 10, 2, 10));
        profilePanel.add(lp1);
        profilePanel.add(tp1);
        profilePanel.add(lp2);
        profilePanel.add(tp2);;
        JButton logout = new JButton("Logout");
        p.add(pmsg, BorderLayout.NORTH);
        p.add(profilePanel, BorderLayout.CENTER);
        p.add(logout, BorderLayout.SOUTH);
        myTab.add("Admin Profile", p);

        //connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdb", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //insert 
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String rollnum = ti1.getText();
                    String name = ti2.getText();
                    String x = ti3.getText();
                    int year = Integer.parseInt(x);
                    String dept = ti4.getText();
                    String y = ti5.getText();
                    float cgpa = Float.parseFloat(y);
                    String query = "insert into student values('" + rollnum + "','" + name + "'," + year + ",'" + dept + "'," + cgpa + ")";
                    int z = st.executeUpdate(query);
                    if (z != 0) {
                        insmsg.setText("Inserted successfully");
                    } else {
                        insmsg.setText("unable to add Student");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //searchstudent
        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String temp = "";
                    String uid = ts1.getText();
                    String query = "select* from student where rno='" + uid + "'";
                    rs = st.executeQuery(query);
                    if (rs.next()) {
                        String name = (rs.getString("name"));
                        String year = rs.getString("year");
                        String dept = (rs.getString("dept"));
                        String cgpa = (rs.getString("cgpa"));
                        ts2.setText(name);
                        ts3.setText(year);
                        ts4.setText(dept);
                        ts5.setText(cgpa);
                    } else {
                        searmsg.setText("Unable to search the Student");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //update cgpa
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String num = tu1.getText();
                    int cgpa = Integer.parseInt(tu2.getText());
                    String query = "update student set cgpa= " + cgpa + " where rno = " + num + "";
                    int x = st.executeUpdate(query);
                    if (x != 0) {
                        updmsg.setText("CGPA Updated");
                    } else {
                        updmsg.setText("Invalid Roll No");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //delete student
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String num = td1.getText();
                    String query = "delete from student where rno=" + num + "";
                    int x = st.executeUpdate(query);
                    if (x != 0) {
                        delmsg.setText("Student Deleted Successfully");;
                    } else {
                        delmsg.setText("Roll Number does not exist");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //profile 
        logout.addActionListener(new ActionListener() {
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
