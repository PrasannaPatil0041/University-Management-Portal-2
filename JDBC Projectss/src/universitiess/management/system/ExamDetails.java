package universitiess.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.*;
//import net.proteanit.sql;

public class ExamDetails extends JFrame implements ActionListener{
    
    JButton Search,Refresh,Exit,Print, Update;
    JTextField rollNo;
    JTable table;
    ExamDetails(){
        setSize(900,600);
        setLocation(50,50);
        setLayout(null);

        JLabel header = new JLabel("Roll Number");
        header.setBounds(10, 10, 200, 20);
        header.setFont(new Font("Arial",Font.BOLD,18));
        add(header);

        rollNo = new JTextField();
        rollNo.setBounds(240, 10, 200, 20);
        add(rollNo);

        Search = new JButton("Search");
        Search.addActionListener(this);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.white);
        Search.setBounds(500,10,100,20);
        add(Search);

        Exit = new JButton("Exit");
        Exit.addActionListener(this);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.white);
        Exit.setBounds(650,10,100,20);
        add(Exit);

      

        table = new JTable();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                 int row=table.getSelectedRow();
                 String rollFromTable=table.getModel().getValueAt(row, 2).toString();
                 rollNo.setText(rollFromTable);

            }
        });
        //Now understand that table in JFrame is not scrolable automatically
        //like html css here u have to tell the sysytem that make this element data scrolable
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0, 60, 900, 450);
        jsp.setBackground(Color.BLACK);
        add(jsp);
        setVisible(true);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student_details");
            //Class.forName("net.proteanit.sql.DbUtils");

            // setModel to set the table using rs
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==Search){
             new GetResult(rollNo.getText());
            
         }else{
            setVisible(false);
         }
    }

    public static void main(String[] args) {
        new ExamDetails();
    }
}

