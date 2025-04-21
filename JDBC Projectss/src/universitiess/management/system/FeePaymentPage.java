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

public class FeePaymentPage extends JFrame implements ActionListener{

    JTextField txtRollno,txtAmount;
    JComboBox cbYear;
    JLabel lblAmount;
    JButton CheckP,Pay,Back;

    FeePaymentPage() {
        setSize(500,700);
        setLocation(70, 30);
        setLayout(null);
        
        JLabel header = new JLabel("Fee Payment");
        header.setBounds(30, 30, 300, 50);
        header.setFont(new Font("Tahoma",Font.BOLD,28));
        header.setForeground(Color.BLACK);
        add(header);

        JLabel rollNo = new JLabel("Select Roll Number");
        rollNo.setBounds(30, 120, 300, 30);
        rollNo.setFont(new Font("Tahoma",Font.PLAIN,18));
        rollNo.setForeground(Color.BLACK);
        add(rollNo);
        
        txtRollno = new JTextField();
        txtRollno.setBounds(30, 150, 300, 30);
        txtRollno.setFont(new Font("Tahoma",Font.PLAIN,15));
        txtRollno.setForeground(Color.gray);
        add(txtRollno);
        
        JLabel year = new JLabel("Select Academic Year");
        year.setBounds(30, 200, 300, 30);
        year.setFont(new Font("Tahoma",Font.PLAIN,18));
        year.setForeground(Color.BLACK);
        add(year);
        
        String[] ele={"First","Second","Third","Fourth",};
        cbYear = new JComboBox(ele);
        cbYear.setBounds(30, 230, 300, 30);
        cbYear.setFont(new Font("Tahoma",Font.PLAIN,15));
        cbYear.setForeground(Color.gray);
        add(cbYear);

         //Check Payable
         JLabel payable = new JLabel("Payable Amount");
         payable.setBounds(30, 280, 200, 30);
         payable.setFont(new Font("Tahoma",Font.PLAIN,18));
         payable.setForeground(Color.BLACK);
         add(payable);
         
         CheckP=new JButton("Check");
         CheckP.addActionListener(this);
         CheckP.setBounds(240, 280, 80, 30);
         CheckP.setBackground(Color.BLACK);
         CheckP.setForeground(Color.WHITE);
         add(CheckP);
 
         lblAmount = new JLabel();
         lblAmount.setBounds(30, 310, 300, 30);
         lblAmount.setFont(new Font("Tahoma",Font.PLAIN,15));
         lblAmount.setForeground(Color.gray);
         add(lblAmount);

        //amount
        JLabel amount = new JLabel("Enter Amount");
        amount.setBounds(30, 360, 200, 30);
        amount.setFont(new Font("Tahoma",Font.PLAIN,18));
        amount.setForeground(Color.BLACK);
        add(amount);
        
        txtAmount = new JTextField("0");
        txtAmount.setBounds(30, 390, 300, 30);
        txtAmount.setFont(new Font("Tahoma",Font.PLAIN,15));
        txtAmount.setForeground(Color.gray);
        add(txtAmount);

        //Last Buttons
         Pay=new JButton("Pay");
         Pay.addActionListener(this);
         Pay.setBounds(30, 500, 100, 30);
         Pay.setBackground(Color.BLACK);
         Pay.setForeground(Color.WHITE);
         Pay.setFont(new Font("Tahora",Font.BOLD,17));
         add(Pay);

         Back=new JButton("Back");
         Back.addActionListener(this);
         Back.setBounds(160, 500, 100, 30);
         Back.setBackground(Color.BLACK);
         Back.setForeground(Color.WHITE);
         Back.setFont(new Font("Tahora",Font.BOLD,17));
         add(Back);
       
        


        

        setVisible(true);
    }
     

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==CheckP){
             String strRollNo= txtRollno.getText();
             String strYear=(String)cbYear.getSelectedItem();
             String query1= "SELECT * FROM student_details WHERE roll='"+strRollNo+"'";
             String query2= "SELECT * FROM fee_paid WHERE roll='"+strRollNo+"'";
             
             String strDegree;
             try {
                 Conn c1= new Conn();
                 ResultSet rs1= c1.s.executeQuery(query1);
                 if(rs1.next()){
                    strDegree=rs1.getString("degree");
                    
                
                    Conn c2= new Conn();
                    ResultSet rs2= c2.s.executeQuery(query2);
                    int intPaidFee=0;
                    if(rs2.next()){
                        String paid_fees=rs2.getString(strYear);
                        intPaidFee=Integer.parseInt(paid_fees);
                    }
                    
                    
                    String query3= "SELECT * FROM fee_structures WHERE degree='"+strDegree+"'";
                    Conn c3= new Conn();
                    ResultSet rs3= c3.s.executeQuery(query3);
                    
                    int intTotalFee=0;
                    if(rs3.next()){
                        String total_fees=rs3.getString(strYear);
                        intTotalFee=Integer.parseInt(total_fees);
                    }
                    
                    int payable_val=intTotalFee-intPaidFee;

                    lblAmount.setText(Integer.toString(payable_val));
           
                 }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Roll Number");
                    lblAmount.setText("");
                 }

             } catch (Exception e) {
                e.printStackTrace();
             }

        }else if(ae.getSource()==Pay){
           String strRollNo=txtRollno.getText();
           String query4="SELECT * FROM fee_paid WHERE roll='"+strRollNo+"' ";
           if(txtAmount.getText()=="") txtAmount.setText("0");
            try {
                Conn c4 = new Conn();
                ResultSet rs4=c4.s.executeQuery(query4);
                if(rs4.next()){
                    String strAmount= txtAmount.getText();
                    String strYear=(String) cbYear.getSelectedItem();
                    String strPrevAmount=rs4.getString(strYear);
                    int intAmt=Integer.parseInt(strAmount);
                    int intPrev=Integer.parseInt(strPrevAmount);
                    int combi=intAmt+intPrev;
                    String finAmt=Integer.toString(combi);

                    String query5 ="Update fee_paid SET "+strYear+"='"+finAmt+"' WHERE roll='"+strRollNo+"'";
                    Conn c5 = new Conn();
                    c5.s.executeUpdate(query5);
               }else{
                JOptionPane.showMessageDialog(null, "Incorrect Roll Number");
               }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FeePaymentPage();
    }
}
