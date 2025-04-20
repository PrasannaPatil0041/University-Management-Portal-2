package universitiess.management.system;

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

public class GetResult extends JFrame implements ActionListener {
    JComboBox cbSem;
    JButton Results,Back;
    JLabel sub1 ,sub2,sub3,sub4,sub5,lblRollNo;
    GetResult(String roll) {
       setSize(750, 800);
       setLocation(400,50);
       setLayout(null);

       //header
       JLabel header = new JLabel("Prasanna University, Pune");
       header.setBounds(210, 20, 500, 40);
       header.setFont(new Font("Arial",Font.BOLD,28));
       header.setForeground(Color.BLACK);
       add(header);

       //subHeader
       JLabel subHeader = new JLabel("Results");
       subHeader.setBounds(310, 60, 500, 40);
       subHeader.setFont(new Font("Arial",Font.BOLD,23));
       subHeader.setForeground(Color.DARK_GRAY);
       add(subHeader);

       // ROLL  number of student display
       JLabel rollNo = new JLabel("Roll Number");
       rollNo.setBounds(290, 150, 330, 30);
       rollNo.setFont(new Font("Arial",Font.BOLD,18));
       rollNo.setForeground(Color.black);
       add(rollNo);

       lblRollNo = new JLabel(roll);
       lblRollNo.setBounds(290, 170, 330, 30);
       lblRollNo.setFont(new Font("Arial",Font.BOLD,18));
       lblRollNo.setForeground(Color.GRAY);
       add(lblRollNo);


       //choose semester
       JLabel sem = new JLabel("Choose Semester");
       sem.setBounds(270, 230, 330, 30);
       sem.setFont(new Font("Arial",Font.BOLD,18));
       sem.setForeground(Color.black);
       add(sem);

       String[] ele={"Sem 1","Sem 2","Sem 3","Sem 4","Sem 5","Sem 6","Sem 7","Sem 8",};
       cbSem = new JComboBox(ele);
       cbSem.setBounds(200, 260, 330, 40);
       cbSem.setFont(new Font("Arial",Font.BOLD,15));
       cbSem.setForeground(Color.GRAY);
       add(cbSem);

       // Showing Result
       sub1 = new JLabel();
       sub1.setBounds(200, 320, 330, 30);
       sub1.setFont(new Font("Arial",Font.PLAIN,18));
       sub1.setForeground(Color.black);
       add(sub1);

       sub2 = new JLabel();
       sub2.setBounds(200, 350, 330, 30);
       sub2.setFont(new Font("Arial",Font.PLAIN,18));
       sub2.setForeground(Color.black);
       add(sub2);

       sub3 = new JLabel();
       sub3.setBounds(200, 380, 330, 30);
       sub3.setFont(new Font("Arial",Font.PLAIN,18));
       sub3.setForeground(Color.black);
       add(sub3);

       sub4 = new JLabel();
       sub4.setBounds(200, 410, 330, 30);
       sub4.setFont(new Font("Arial",Font.PLAIN,18));
       sub4.setForeground(Color.black);
       add(sub4);

       sub5 = new JLabel();
       sub5.setBounds(200, 440, 330, 30);
       sub5.setFont(new Font("Arial",Font.PLAIN,18));
       sub5.setForeground(Color.black);
       add(sub5);
       
        Results=new JButton("Result");
        Results.addActionListener(this);
        Results.setBounds(320, 620, 100, 30);
        Results.setBackground(Color.BLACK);
        Results.setForeground(Color.WHITE);
        add(Results);

        Back=new JButton("Back");
        Back.addActionListener(this);
        Back.setBounds(320, 660, 100, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        add(Back);       
       setVisible(true);
    }
     

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==Results){
          String strSem= (String)cbSem.getSelectedItem();
          String strRollNo=lblRollNo.getText();
          
          String query1="SELECT * FROM subjects WHERE roll='"+strRollNo+"' AND sem ='"+strSem+"'";
          String query2="SELECT * FROM marks WHERE roll='"+strRollNo+"' AND sem ='"+strSem+"'";
          
          try {
              Conn c= new Conn();
              ResultSet rs1= c.s.executeQuery(query1);
              Conn cm= new Conn();
              ResultSet rs2= cm.s.executeQuery(query2);
              if(rs2.next()&&rs1.next()){
           
                 sub1.setText(rs1.getString("sub1")+"------------"+rs2.getString("mark1"));
                 sub2.setText(rs1.getString("sub2")+"------------"+rs2.getString("mark2"));
                 sub3.setText(rs1.getString("sub3")+"------------"+rs2.getString("mark3"));
                 sub4.setText(rs1.getString("sub4")+"------------"+rs2.getString("mark4"));
                 sub5.setText(rs1.getString("sub5")+"------------"+rs2.getString("mark5"));
              }else{
                JOptionPane.showMessageDialog(null, "Result Not arrived yet");
              }
          } catch (Exception e) {
          }
       }else{
        setVisible(false);
       }
    }

    public static void main(String[] args) {
        new GetResult("20258123");
    }
}
