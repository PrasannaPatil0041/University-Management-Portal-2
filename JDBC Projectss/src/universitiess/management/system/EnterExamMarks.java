package universitiess.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EnterExamMarks extends JFrame implements  ActionListener{
    JTextField txtSub1,txtMark1,txtSub2,txtMark2,txtMark4,txtSub3,txtMark3,txtSub4,txtSub5,txtMark5,txtRollNo;
    JButton Submit,Cancel;
    JLabel lblName;
    JComboBox cbSem;

     EnterExamMarks(){
        setLocation(100,100);
        setSize(600,800);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image scaled_Image= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(scaled_Image);
        JLabel i3=new JLabel(image);
        i3.setBounds(300, 130, 200, 200);
        add(i3);
        
        JLabel header = new JLabel("Enter marks Details");
        header.setBounds(200, 30, 300, 30);
        header.setFont(new Font("Arial",Font.BOLD, 21));
        add(header);

        JLabel rollNo= new JLabel("Enter Roll Number");
        rollNo.setBounds(60, 100, 300, 30);
        rollNo.setFont(new Font("Arial",Font.BOLD, 16));
        add(rollNo);
        
        txtRollNo= new JTextField();
        txtRollNo.setBounds(60, 130, 200, 30);
        txtRollNo.setFont(new Font("Arial",Font.BOLD, 16));
        add(txtRollNo);
        
        

        txtRollNo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                String strRollNo = txtRollNo.getText();
                String query1= "SELECT * FROM student_details WHERE roll='"+strRollNo+"'";
                // Dummy logic: You can replace this with your DB call or logic
                
                try {
                    Conn c = new Conn();
                    ResultSet rs= c.s.executeQuery(query1);
                    if(rs.next()){
                        lblName.setText(rs.getString("name"));
                    }else{
                        lblName.setText("");
                    }
                } catch(Exception el){
                    el.printStackTrace();
                }
                
                
            }
        });
        

        //Fetch Name of Student
        JLabel name= new JLabel("Name of Student");
        name.setBounds(60, 170, 300, 30);
        name.setFont(new Font("Arial",Font.BOLD, 16));
        add(name);
        
        lblName= new JLabel("");
        lblName.setBounds(60, 200, 200, 30);
        lblName.setForeground(Color.GRAY);
        lblName.setFont(new Font("Arial",Font.BOLD, 13));
        add(lblName);

        JLabel Sem= new JLabel("Select Semester");
        Sem.setBounds(60, 270, 300, 30);
        Sem.setFont(new Font("Arial",Font.BOLD, 16));
        add(Sem);
        
        String[] ele={"Sem 1","Sem 2","Sem 3","Sem 4","Sem 5","Sem 6","Sem 7","Sem 8",};
        cbSem= new JComboBox(ele);
        cbSem.setBounds(60, 300, 200, 30);
        cbSem.setFont(new Font("Arial",Font.PLAIN, 14));
        add(cbSem);
        
        //header for marks and subject
        JLabel Subject = new JLabel("Subject");
        Subject.setBounds(60, 360, 200, 30);
        Subject.setFont(new Font("Arial",Font.BOLD, 18));
        add(Subject);

        JLabel Mark= new JLabel("Marks");
        Mark.setBounds(300, 360, 200, 30);
        Mark.setFont(new Font("Arial",Font.BOLD, 18));
        add(Mark);

        //Marks and sub entry

        //Line 1
        txtSub1 = new JTextField();
        txtSub1.setBounds(60, 390, 200, 30);
        txtSub1.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtSub1);

        txtMark1 = new JTextField();
        txtMark1.setBounds(300, 390, 200, 30);
        txtMark1.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtMark1);

        //Line 2
        txtSub2 = new JTextField();
        txtSub2.setBounds(60, 430, 200, 30);
        txtSub2.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtSub2);

        txtMark2 = new JTextField();
        txtMark2.setBounds(300, 430, 200, 30);
        txtMark2.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtMark2);

        //Line 3
        txtSub3 = new JTextField();
        txtSub3.setBounds(60, 470, 200, 30);
        txtSub3.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtSub3);

        txtMark3= new JTextField();
        txtMark3.setBounds(300, 470, 200, 30);
        txtMark3.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtMark3);
        
        //Line 4
        txtSub4 = new JTextField();
        txtSub4.setBounds(60, 510, 200, 30);
        txtSub4.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtSub4);

        txtMark4= new JTextField();
        txtMark4.setBounds(300, 510, 200, 30);
        txtMark4.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtMark4);

        //Line 5
        txtSub5 = new JTextField();
        txtSub5.setBounds(60, 550, 200, 30);
        txtSub5.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtSub5);

        txtMark5= new JTextField();
        txtMark5.setBounds(300, 550, 200, 30);
        txtMark5.setFont(new Font("Arial",Font.PLAIN, 16));
        add(txtMark5);
        
         Submit=new JButton("Submit");
         Submit.addActionListener(this);
         Submit.setBounds(60, 620, 100, 30);
         Submit.setBackground(Color.BLACK);
         Submit.setForeground(Color.WHITE);
         add(Submit);

         Cancel=new JButton("Cancel");
         Cancel.addActionListener(this);
         Cancel.setBounds(200, 620, 100, 30);
         Cancel.setBackground(Color.BLACK);
         Cancel.setForeground(Color.WHITE);
         add(Cancel);
        


        
        

        setVisible(true);
     }

      

     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==Submit){
            String strCheckRoll=lblName.getText();
            if(strCheckRoll==""){
                JOptionPane.showMessageDialog(null, "Wrong Roll Number. Please Check Roll Number");
            }else{
                String strRollNo = txtRollNo.getText();
                String strName = lblName.getText();
                String strSem = (String)cbSem.getSelectedItem();
                String strMark1 = txtMark1.getText();
                String strMark2 = txtMark2.getText();
                String strMark3 = txtMark3.getText();
                String strMark4 = txtMark4.getText();
                String strMark5 = txtMark5.getText();

                String strSub1 = txtSub1.getText();
                String strSub2 = txtSub2.getText();
                String strSub3 = txtSub3.getText();
                String strSub4 = txtSub4.getText();
                String strSub5 = txtSub5.getText();
                
                String query2="INSERT INTO marks VALUES ('"+strName+"','"+strRollNo+"','"+strSem+"','"+strMark1+"','"+strMark2+"','"+strMark3+"','"+strMark4+"','"+strMark5+"')";
                String query3="INSERT INTO subjects VALUES ('"+strName+"','"+strRollNo+"','"+strSem+"','"+strSub1+"','"+strSub2+"','"+strSub3+"','"+strSub4+"','"+strSub5+"')";
                try {
                    Conn ca = new Conn();
                    ca.s.executeUpdate(query2);
                    ca.s.executeUpdate(query3);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            setVisible(false);
         }else{
            setVisible(false);
         }
     }
    public static void main (String[] args){
        new EnterExamMarks();
    }
}
