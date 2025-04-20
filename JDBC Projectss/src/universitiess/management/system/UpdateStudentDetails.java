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
import javax.swing.JTextField;

public class UpdateStudentDetails extends JFrame implements ActionListener{
     
    
     JTextField txtPhone,txtEmail,txtAddress,txtSearch;
     JLabel txtRollno,txtFather,dcDOB,txtClassXPerc,txtCLassXII,txtName,txtAdhar;
     JComboBox cbDegree,cbCourse;
     JButton Submit,Cancel,btnSearch;
      
     UpdateStudentDetails() {
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
  
        //Search Bar
        JLabel Search = new JLabel("Search By Roll No.");
        Search.setBounds(50, 120, 300, 30);
        Search.setFont(new Font("Arial",Font.PLAIN,18));
        add(Search);

        txtSearch = new JTextField();
        txtSearch.setBounds(400, 120, 200, 30);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnSearch.setBounds(650, 120, 100, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.white);
        add(btnSearch);

        //Line 1
        JLabel Name = new JLabel("Name");
        Name.setBounds(50,190,100,30);
        Name.setFont(new Font("Arial",Font.PLAIN,18));
        add(Name);

        txtName = new JLabel();
        txtName.setBounds(200, 190, 150, 30);
        txtName.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtName);

        JLabel FathersName = new JLabel("Father Name");
        FathersName.setBounds(400,190,200,30);
        FathersName.setFont(new Font("Arial",Font.PLAIN,18));
        add(FathersName);

        txtFather = new JLabel();
        txtFather.setBounds(600, 190, 150, 30);
        txtFather.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtFather);

         //Line 2
        JLabel rollNo = new JLabel("Roll No.");
        rollNo.setBounds(50,240,100,30);
        rollNo.setFont(new Font("Arial",Font.PLAIN,18));
        add(rollNo);

        txtRollno = new JLabel();
        txtRollno.setBounds(200, 240, 150, 30);
        txtRollno.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtRollno);

        JLabel DOB = new JLabel("Date of Birth");
        DOB.setBounds(400,240,200,30);
        DOB.setFont(new Font("Arial",Font.PLAIN,18));
        add(DOB);

        dcDOB = new JLabel();
        dcDOB.setBounds(600, 240, 150, 30);
        dcDOB.setFont(new Font("Arial",Font.PLAIN,18));
        add(dcDOB);
        
        //Line 3
        JLabel address = new JLabel("Address");
        address.setBounds(50,290,100,30);
        address.setFont(new Font("Arial",Font.PLAIN,18));
        add(address);

        txtAddress= new JTextField();
        txtAddress.setBounds(200, 290, 150, 30);
        txtAddress.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtAddress);

        JLabel Phone = new JLabel("Phone No.");
        Phone.setBounds(400,290,200,30);
        Phone.setFont(new Font("Arial",Font.PLAIN,18));
        add(Phone);

        txtPhone = new JTextField();
        txtPhone.setBounds(600, 290, 150, 30);
        txtPhone.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtPhone);


        //line 4;
        JLabel email = new JLabel("Email");
        email.setBounds(50,340,100,30);
        email.setFont(new Font("Arial",Font.PLAIN,18));
        add(email);

        txtEmail= new JTextField();
        txtEmail.setBounds(200, 340, 150, 30);
        txtEmail.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtEmail);

        JLabel CLassPerc = new JLabel("10th %");
        CLassPerc.setBounds(400,340,200,30);
        CLassPerc.setFont(new Font("Arial",Font.PLAIN,18));
        add(CLassPerc);

        txtClassXPerc = new JLabel();
        txtClassXPerc.setBounds(600, 340, 150, 30);
        txtClassXPerc.setFont(new Font("Arial",Font.PLAIN,18));
        add(txtClassXPerc);


         //line 5;
         JLabel CLassXII = new JLabel("12th %");
         CLassXII.setBounds(50,390,100,30);
         CLassXII.setFont(new Font("Arial",Font.PLAIN,18));
         add(CLassXII);
 
         txtCLassXII= new JLabel();
         txtCLassXII.setBounds(200, 390, 150, 30);
         txtCLassXII.setFont(new Font("Arial",Font.PLAIN,18));
         add(txtCLassXII);
 
         JLabel adhar = new JLabel("Adhar Number");
         adhar.setBounds(400,390,200,30);
         adhar.setFont(new Font("Arial",Font.PLAIN,18));
         add(adhar);
 
         txtAdhar = new JLabel();
         txtAdhar.setBounds(600, 390, 150, 30);
         txtAdhar.setFont(new Font("Arial",Font.PLAIN,18));
         add(txtAdhar);

          //line 6;
         JLabel Degree = new JLabel("Degree");
         Degree.setBounds(50,440,100,30);
         Degree.setFont(new Font("Arial",Font.PLAIN,18));
         add(Degree);

         String[] optDegrees={"B.TECH","BA","BE","MBA","BBA","BCA","NURSING"};
         cbDegree=new JComboBox(optDegrees);
         cbDegree.setBackground(Color.white);
         cbDegree.setBounds(200, 440, 150, 30);
         add(cbDegree);

         JLabel Course = new JLabel("Course");
         Course.setBounds(400,440,200,30);
         Course.setFont(new Font("Arial",Font.PLAIN,18));
         add(Course);
 

         String[] countP={"Computer Engineering","Electronics","IT","Finance","HR","Marketing","Nursing","Mechanical"};
         cbCourse = new JComboBox(countP);
         cbCourse.setBounds(600, 440, 150, 30);
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
        if(ae.getSource()==btnSearch){
            String strSearch= txtSearch.getText();
            try {
                //String query="INSERT INTO student_details VALUES('"+strName+"','"+strFather+"','"+strRollNo+"','"+strDOB+"','"+strAdd+"','"+strPhn+"','"+strEmail+"','"+strClassX+"','"+strClasXII+"','"+strAdhar+"','"+strDegree+"','"+strCourse+"'";
                //String query = "insert into student_details values('"+strName+"', '"+strFather+"', '"+strRollNo+"', '"+strDOB+"', '"+strAdd+"', '"+strPhn+"', '"+strEmail+"', '"+strClassX+"', '"+strClasXII+"', '"+strAdhar+"', '"+strDegree+"', '"+strCourse+"')";
                String query= "SELECT * FROM student_details WHERE roll ='"+strSearch+"'";
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    txtAddress.setText(rs.getString("address"));
                    txtAdhar.setText(rs.getString("adhar"));
                    txtCLassXII.setText(rs.getString("twelthM"));
                    txtClassXPerc.setText(rs.getString("tenthM"));
                    txtEmail.setText(rs.getString("email"));
                    txtFather.setText(rs.getString("father"));
                    txtPhone.setText(rs.getString("phone"));
                    txtName.setText(rs.getString("name"));
                    cbCourse.setSelectedItem(rs.getString("degree"));
                    cbDegree.setSelectedItem(rs.getString("course"));
                }else{
                    JOptionPane.showMessageDialog(null, "Roll no present in Data");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            

        }else{
            setVisible(false);
        }
    }
     
     


    public static void main(String[] args){
          new UpdateStudentDetails();
    }
}
