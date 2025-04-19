package universitiess.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ApplyyLeaveFaculty extends JFrame implements ActionListener {
    JButton Submit,Cancel;
    JDateChooser dcDOB;
    JTextField txtempId;
    JComboBox cbType;
    public ApplyyLeaveFaculty() {
        setSize(800,600);
        setLocation(300,100);
        setLayout(null);

        JLabel header = new JLabel("Apply For Leave (Faculty)");
        header.setFont(new Font("Arial",Font.BOLD,25));
        header.setBounds(250, 30, 400, 50);
        add(header);
        
        JLabel empId = new JLabel("Employee ID. of Faculty");
        empId.setFont(new Font("Arial",Font.PLAIN,20));
        empId.setBounds(50, 120, 200, 50);
        add(empId);
        
        txtempId= new JTextField();
        //txtempId.setFont(new Font("Arial",Font.PLAIN,20));
        txtempId.setBounds(300, 122, 200, 40);
        add(txtempId);

        JLabel Date = new JLabel("Leave Date");
        Date.setFont(new Font("Arial",Font.PLAIN,20));
        Date.setBounds(50, 210, 200, 50);
        add(Date);

        dcDOB=new JDateChooser();
        dcDOB.setBounds(300, 212, 200, 40);
        add(dcDOB);

        JLabel Type = new JLabel("Leave Type");
        Type.setFont(new Font("Arial",Font.PLAIN,20));
        Type.setBounds(50, 300, 200, 50);
        add(Type);
        
        String[] opt={"Half Day","Full Day"};
        cbType= new JComboBox(opt);
        cbType.setBounds(300, 302, 200, 36);
        add(cbType);
        
        Submit=new JButton("Submit");
        Submit.addActionListener(this);
        Submit.setBounds(200, 420, 100, 30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        add(Submit);

        Cancel=new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(50, 420, 100, 30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        add(Cancel);

        
        

        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Submit){
        
            String strempId=txtempId.getText();
            String strLeaveDate=((JTextField)dcDOB.getDateEditor().getUiComponent()).getText();
            String strLeaveType= (String)cbType.getSelectedItem();
            String query1="SELECT * FROM faculty_details WHERE id='"+strempId+"'";
            String query2="INSERT INTO faculty_leave VALUES ('"+strempId+"','"+strLeaveDate+"','"+strLeaveType+"')";
            txtempId.setText("");
            dcDOB.setDate(null);
            try {
                Conn c =new Conn();
                ResultSet rs=c.s.executeQuery(query1);
                if(rs.next()){
                    c.s.executeUpdate(query2);
                    setVisible(false);
                    new ApplyyLeaveFaculty();
                }else{
                    JOptionPane.showMessageDialog(null, "Employee ID is not Present in Data");
                }
            } catch (Exception e) {
            }
        }else{
           setVisible(false);
        }
     }

    public static void main(String[] args){
       new ApplyyLeaveFaculty();
    }
}

