package universitiess.management.system;

import com.toedter.calendar.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStudentsDetails extends JFrame implements ActionListener{
     
     Random ran = new Random();
     int ranNo= ran.nextInt(10000);
     String strRanNo="2025"+String.valueOf(ranNo);
     JTextField txtPhone,txtEmail,txtClassXPerc,txtAddress,txtAdhar,txtCLassXII,txtName,txtFather;
     JLabel txtRollno;
     JDateChooser dcDOB;
     JComboBox cbDegree,cbCourse;
     JButton Submit,Cancel;
      
     AddStudentsDetails() {
        setSize(900,700);
        setVisible(true);
        setLocation(350,50);
        getContentPane().setBackground(Color.GRAY);
        //setBackground(Color.BLACK);
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

        txtName = new JTextField();
        txtName.setBounds(200, 150, 150, 30);
        txtName.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtName);

        JLabel FathersName = new JLabel("Father Name");
        FathersName.setBounds(400,150,200,30);
        FathersName.setFont(new Font("Arial",Font.PLAIN,18));
        add(FathersName);

        txtFather = new JTextField();
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
        
        //Line 3
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,100,30);
        address.setFont(new Font("Arial",Font.PLAIN,18));
        add(address);

        txtAddress= new JTextField();
        txtAddress.setBounds(200, 250, 150, 30);
        txtAddress.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtAddress);

        JLabel Phone = new JLabel("Phone No.");
        Phone.setBounds(400,250,200,30);
        Phone.setFont(new Font("Arial",Font.PLAIN,18));
        add(Phone);

        txtPhone = new JTextField();
        txtPhone.setBounds(600, 250, 150, 30);
        txtPhone.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtPhone);


        //line 4;
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,100,30);
        email.setFont(new Font("Arial",Font.PLAIN,18));
        add(email);

        txtEmail= new JTextField();
        txtEmail.setBounds(200, 300, 150, 30);
        txtEmail.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtEmail);

        JLabel CLassPerc = new JLabel("10th %");
        CLassPerc.setBounds(400,300,200,30);
        CLassPerc.setFont(new Font("Arial",Font.PLAIN,18));
        add(CLassPerc);

        txtClassXPerc = new JTextField();
        txtClassXPerc.setBounds(600, 300, 150, 30);
        txtClassXPerc.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtClassXPerc);


         //line 5;
         JLabel CLassXII = new JLabel("12th %");
         CLassXII.setBounds(50,350,100,30);
         CLassXII.setFont(new Font("Arial",Font.PLAIN,18));
         add(CLassXII);
 
         txtCLassXII= new JTextField();
         txtCLassXII.setBounds(200, 350, 150, 30);
         txtCLassXII.setFont(new Font("Arial",Font.PLAIN,18));
         add(txtCLassXII);
 
         JLabel adhar = new JLabel("Adhar Number");
         adhar.setBounds(400,350,200,30);
         adhar.setFont(new Font("Arial",Font.PLAIN,18));
         add(adhar);
 
         txtAdhar = new JTextField();
         txtAdhar.setBounds(600, 350, 150, 30);
         txtAdhar.setFont(new Font("Arial",Font.PLAIN,18));
         add(txtAdhar);

          //line 6;
         JLabel Degree = new JLabel("Degree");
         Degree.setBounds(50,400,100,30);
         Degree.setFont(new Font("Arial",Font.PLAIN,18));
         add(Degree);

         String[] optDegrees={"B.TECH","BA","BE","MBA","BBA","BCA","NURSING"};
         cbDegree=new JComboBox(optDegrees);
         cbDegree.setBackground(Color.white);
         cbDegree.setBounds(200, 400, 150, 30);
         add(cbDegree);

         JLabel Course = new JLabel("Course");
         Course.setBounds(400,400,200,30);
         Course.setFont(new Font("Arial",Font.PLAIN,18));
         add(Course);
 

         String[] countP={"Computer Engineering","Electronics","IT","Finance","HR","Marketing","Nursing","Mechanical"};
         cbCourse = new JComboBox(countP);
         cbCourse.setBounds(600, 400, 150, 30);
         cbCourse.setFont(new Font("Arial",Font.BOLD,14));
         add(cbCourse);

         Submit=new JButton("Submit");
         Submit.addActionListener(this);
         Submit.setBounds(250, 520, 100, 30);
         Submit.setBackground(Color.BLACK);
         Submit.setForeground(Color.WHITE);
         add(Submit);

         Cancel=new JButton("Cancel");
         Cancel.addActionListener(this);
         Cancel.setBounds(450, 520, 100, 30);
         Cancel.setBackground(Color.BLACK);
         Cancel.setForeground(Color.WHITE);
         add(Cancel);

         revalidate();
         repaint();
         setVisible(true);


        



        
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==Submit){
            String strName= txtName.getText();
            String strFather= txtFather.getText();
            String strAdd= txtAddress.getText();
            String strPhn= txtPhone.getText();
            String strEmail= txtEmail.getText();
            String strRollNo= txtRollno.getText();
            String strClasXII= txtCLassXII.getText();
            String strAdhar= txtAdhar.getText();
            String strClassX= txtClassXPerc.getText();
            
            //From dcDOB first we get the object by getUIComponent()
            //Then we convert it into textField and get the text
            String strDOB= ((JTextField)dcDOB.getDateEditor().getUiComponent()).getText();

            //Here to it gets object so need to convert it to String
            String strDegree=(String)cbCourse.getSelectedItem();
            String strCourse=(String)cbDegree.getSelectedItem();
            txtAddress.setText("");
            txtAdhar.setText("");
            txtCLassXII.setText("");
            txtClassXPerc.setText("");
            txtEmail.setText("");
            txtFather.setText("");
            txtPhone.setText("");
            txtPhone.setText("");
            txtName.setText("");
            dcDOB.setDate(null);
            Random ran2= new Random();
            int ranNo= ran.nextInt(10000);
            String strRanNo2="2025"+String.valueOf(ranNo);
            txtRollno.setText(strRanNo2);

            try {
                //String query="INSERT INTO student_details VALUES('"+strName+"','"+strFather+"','"+strRollNo+"','"+strDOB+"','"+strAdd+"','"+strPhn+"','"+strEmail+"','"+strClassX+"','"+strClasXII+"','"+strAdhar+"','"+strDegree+"','"+strCourse+"'";
                String query = "insert into student_details values('"+strName+"', '"+strFather+"', '"+strRollNo+"', '"+strDOB+"', '"+strAdd+"', '"+strPhn+"', '"+strEmail+"', '"+strClassX+"', '"+strClasXII+"', '"+strAdhar+"', '"+strDegree+"', '"+strCourse+"')";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
     
     


    public static void main(String[] args){
          new AddStudentsDetails();
    }
}
