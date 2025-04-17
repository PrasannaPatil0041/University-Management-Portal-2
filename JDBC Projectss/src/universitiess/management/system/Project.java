package universitiess.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Project extends JFrame implements  ActionListener{
    JMenu exit;
    JMenuItem LeaveApp;
    Project(){
        
        setSize(1500,700);
        setLayout(null);

        // Adding 1st image(logo)
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/colSymb.png"));
        Image scaledImage2= i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i5=new ImageIcon(scaledImage2);
        JLabel image2= new JLabel(i5);
        int xPosition = getWidth() - i5.getIconWidth() - 20; // Right side with 20px padding
        image2.setBounds(xPosition, 20, i5.getIconWidth(), i5.getIconHeight());
        add(image2);

        // Adding 2 image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/prasannaCol.png"));
        Image scaledImage= i1.getImage().getScaledInstance(1630, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(scaledImage);
        JLabel image= new  JLabel(i3);
        image.setBounds(0, 280, 1630, 700);
        add(image);
        
        //Creation of MenuBar
        JMenuBar mb = new JMenuBar();
        mb.setFont(new Font("Arial", Font.PLAIN, 25));
        //Creation of Element of menuBar
        JMenu newInfo = new JMenu("  New Information  ");
        newInfo.setForeground(Color.BLUE);
        newInfo.setFont(new Font("", Font.BOLD, 17));
        mb.add(newInfo);

        //To Create MenuItem
        JMenuItem newStd= new JMenuItem("New Student Information");
        JMenuItem newfac= new JMenuItem("New Faculty Information");
      
        newfac.setForeground(Color.BLUE);
        newStd.setForeground(Color.BLUE);
        newInfo.add(newStd);
        newInfo.add(newfac);

        // View Detail section
        JMenu viewDet = new JMenu("  View Detail  ");
        viewDet.setForeground(Color.BLUE);
        viewDet.setFont(new Font("", Font.BOLD, 17));
        mb.add(viewDet);

        JMenuItem DetStd= new JMenuItem("View Student Details");
        JMenuItem Detfac= new JMenuItem("View Faculty Details");
        Detfac.setForeground(Color.BLUE);
        DetStd.setForeground(Color.BLUE);
        viewDet.add(Detfac);
        viewDet.add(DetStd);

        //Apply Leave Section
        JMenu leave = new JMenu("  Apply Leave  ");
        leave.setFont(new Font("", Font.BOLD, 17));
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem stdLeave= new JMenuItem("Student Leave");
        JMenuItem facLeave= new JMenuItem("Faculty Leave");
        stdLeave.setForeground(Color.BLUE);
        facLeave.setForeground(Color.BLUE);
        leave.add(stdLeave);
        leave.add(facLeave);

        //Leave Detail Section
        JMenu leaveDet = new JMenu("  Leave Details  ");
        leaveDet.setFont(new Font("", Font.BOLD, 17));
        leaveDet.setForeground(Color.BLUE);
        mb.add(leaveDet);

        JMenuItem stdLeaveDet= new JMenuItem("Student Leave Details");
        JMenuItem facLeaveDet= new JMenuItem("Faculty Leave Details");
        stdLeaveDet.setForeground(Color.BLUE);
        facLeaveDet.setForeground(Color.BLUE);
        leaveDet.add(stdLeaveDet);
        leaveDet.add(facLeaveDet);

        //Examination Detail Section
        JMenu exam = new JMenu("  Examination  ");
        exam.setFont(new Font("", Font.BOLD, 17));
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examMark= new JMenuItem("Exam Marks");
        JMenuItem addMarks= new JMenuItem("Add Marks");
        examMark.setForeground(Color.BLUE);
        addMarks.setForeground(Color.BLUE);
        exam.add(examMark);
        exam.add(addMarks);

        //Update Details
        JMenu uptDetails = new JMenu("  Update Details  ");
        uptDetails.setFont(new Font("", Font.BOLD, 17));
        uptDetails.setForeground(Color.BLUE);
        mb.add(uptDetails);

        JMenuItem uptStd= new JMenuItem("Update Students Details");
        JMenuItem uptFac= new JMenuItem("Update Faculty Details");
        uptStd.setForeground(Color.BLUE);
        uptFac.setForeground(Color.BLUE);
        uptDetails.add(uptStd);
        uptDetails.add(uptFac);

        //Fee Details
        JMenu fee = new JMenu("  Fee  ");
        fee.setFont(new Font("", Font.BOLD, 17));
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feeStrt= new JMenuItem("Fee Structure");
        JMenuItem payFee= new JMenuItem("Pay Fees");
        feeStrt.setForeground(Color.BLUE);
        payFee.setForeground(Color.BLUE);
        fee.add(feeStrt);
        fee.add(payFee);

        //Utility
        JMenu utility = new JMenu("  Utility  ");
        utility.setFont(new Font("", Font.BOLD, 17));
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem Calci= new JMenuItem("Calculator");
        Calci.addActionListener(this);
        JMenuItem Notepad= new JMenuItem("Notepad");
        Notepad.addActionListener(this);
        Calci.setForeground(Color.BLUE);
        Notepad.setForeground(Color.BLUE);
        utility.add(Calci);
        utility.add(Notepad);

        //Exit
        exit = new JMenu("  Exit  ");
        ///JMenuItem LeaveApp = new JMenuItem("Leave Application");
        //AddEventListner Wont work on JMenu. So need to Add JMenuItem
        exit.setFont(new Font("", Font.BOLD, 17));
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        LeaveApp = new JMenuItem("Leave Application");
        exit.add(LeaveApp);
        LeaveApp.addActionListener(this);

        

        //add(mb);
        //Above statement is totally wrong u cant add MenuBar using add
        //Need to use setJmenuBar
        setJMenuBar(mb);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        } else if(msg.equals("Calculator")){
            try {
               Runtime.getRuntime().exec("calc.exe");  
            } catch (Exception e) {
            }
           
        }else if(msg.equals("Notepad")){
            try {
               Runtime.getRuntime().exec("notepad.exe");  
            } catch (Exception e) {
            }
        }

    }
       
    public static void main(String[] arg){
        new Project();
    }
}