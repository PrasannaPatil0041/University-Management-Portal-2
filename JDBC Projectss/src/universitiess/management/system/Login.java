package universitiess.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JButton cancelButton,adButton;
     JTextField insUserField,inpass;
    //ConnectionHelper c;
    Login(){
        
        
        setSize(700,400);
        setLocation(300,150);

        // setLayout will off the default layout
        setLayout(null);

        //Genrally the JLabel is use to put text or something on the screen
        //getContentPane().setBackground(Color.BLUE);

        JLabel lblUsername=new JLabel("UserName");
        lblUsername.setFont(new Font("Tahoma",Font.BOLD,16));
        //lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(40, 20, 100, 20);
        add(lblUsername);

        insUserField= new JTextField();
        insUserField.setBounds(160, 20, 100, 20);
        add(insUserField);

        JLabel lblPassword=new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,16));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(40, 80, 100, 20);
        add(lblPassword);

        inpass=new JPasswordField();
        inpass.setBounds(160,80, 100, 20);
        add(inpass);

        adButton=new JButton("Login");
        adButton.setBackground(Color.BLACK);
        adButton.setForeground(Color.white);
        adButton.setBounds(40,140,80,20);
        adButton.addActionListener(this);
        add(adButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.setBounds(160,140,80,20);

        //addActionListner will register this class for ActionListner and 
        //actionPerformed . So it will say that ther will some action occured when u 
        // clicked on it
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel manLog = new JLabel(i3);
        manLog.setBounds(350,20,200,200);
        add(manLog);
        setVisible(true);
           
        }
        
        
    public  void actionPerformed(ActionEvent ae){
        ///getSource will get u the class name or source so u can perform action on particular button
              if(ae.getSource()==cancelButton){
                 setVisible(false);
              }else if(ae.getSource()==adButton){
                
                String uName= insUserField.getText(); 
                String Pass=inpass.getText();
                
                //To Write Query to run
                  String query = "select * from logincredential1 where UserNmae='"+uName+"' and PassWord='"+Pass+"'";
                  System.out.println(query);
                try {
                    //Establish connection using JDBC with the help of connection class Conc
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery(query);
                    if(rs.next()){
                       setVisible(false);
                       new Project();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

              }
        }
    public static void main(String[] args){
        new Login();
    }
}