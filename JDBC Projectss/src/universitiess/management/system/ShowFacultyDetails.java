package universitiess.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.*;
//import net.proteanit.sql;

public class ShowFacultyDetails extends JFrame implements ActionListener{
    
    JButton Search,Refresh,Exit;
    JTextField empID;
    JTable table;
    ShowFacultyDetails(){
        setSize(900,600);
        setLocation(50,50);
        setLayout(null);

        JLabel header = new JLabel("Search Faculty using EmployeeID");
        header.setBounds(10, 10, 400, 20);
        header.setFont(new Font("Arial",Font.BOLD,18));
        add(header);

        empID = new JTextField();
        empID.setBounds(440, 10, 200, 20);
        add(empID);

        Search = new JButton("Search");
        Search.addActionListener(this);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.white);
        Search.setBounds(700,10,100,20);
        add(Search);

        Refresh = new JButton("Refresh");
        Refresh.addActionListener(this);
        Refresh.setBackground(Color.BLACK);
        Refresh.setForeground(Color.white);
        Refresh.setBounds(15,526,100,25);
        add(Refresh);

        Exit = new JButton("Exit");
        Exit.addActionListener(this);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.white);
        Exit.setBounds(130,526,100,25);
        add(Exit);

        table = new JTable();
        //Now understand that table in JFrame is not scrolable automatically
        //like html css here u have to tell the sysytem that make this element data scrolable
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0, 60, 900, 450);
        jsp.setBackground(Color.BLACK);
        add(jsp);
        setVisible(true);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM faculty_details");
            //Class.forName("net.proteanit.sql.DbUtils");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==Search){
             String strempId=empID.getText();
             try {
                Conn cb = new Conn();
                ResultSet rs2 = cb.s.executeQuery("SELECT * FROM faculty_details WHERE id='"+strempId+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs2));
             } catch (Exception e) {
             }
            
         }else if(ae.getSource()==Refresh){
            setVisible(false);
            new ShowFacultyDetails();
            
         }else{
            setVisible(false);
            
         }
    }

    public static void main(String[] args) {
        new ShowFacultyDetails();
    }
}
