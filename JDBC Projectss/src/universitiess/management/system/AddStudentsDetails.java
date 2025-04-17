package universitiess.management.system;

import com.toedter.calendar.*;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AddStudentsDetails extends JFrame {
     
     Random ran = new Random();
     int ranNo= ran.nextInt(10000);
     String strRanNo="2025"+String.valueOf(ranNo);

     JLabel txtRollno;
     JDateChooser dcDOB;
     AddStudentsDetails() {
        setSize(900,700);
        setVisible(true);
        setLocation(350,50);
        
        //Remeber u want to crete layout according to u then off the auto layout
        //also add the setBound to elements 
        setLayout(null);
        JLabel header = new JLabel("New Student Details");
        header.setBounds(310, 30, 500, 50);
        header.setFont(new Font("Arial",Font.BOLD,30));
        add(header);


        //Line 1
        JLabel Name = new JLabel("Name");
        Name.setBounds(50,150,100,30);
        Name.setFont(new Font("Arial",Font.PLAIN,18));
        add(Name);

        JTextArea txtName = new JTextArea();
        txtName.setBounds(200, 150, 150, 30);
        txtName.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtName);

        JLabel FathersName = new JLabel("Father Name");
        FathersName.setBounds(400,150,200,30);
        FathersName.setFont(new Font("Arial",Font.PLAIN,18));
        add(FathersName);

        JTextArea txtFather = new JTextArea();
        txtFather.setBounds(600, 150, 150, 30);
        txtFather.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtFather);

         //Line 2
        JLabel rollNo = new JLabel("Roll No.");
        rollNo.setBounds(50,200,100,30);
        rollNo.setFont(new Font("Arial",Font.PLAIN,18));
        add(rollNo);

        txtRollno = new JLabel(strRanNo);
        txtRollno.setBounds(200, 200, 150, 30);
        txtRollno.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtRollno);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(400,200,200,30);
        DOB.setFont(new Font("Arial",Font.PLAIN,18));
        add(DOB);

        dcDOB = new JDateChooser();
        dcDOB.setBounds(600, 200, 150, 30);
        dcDOB.setFont(new Font("Arial",Font.PLAIN,18));
        add(dcDOB);

        
    }
     
    


    public static void main(String[] args){
          new AddStudentsDetails();
    }
}
