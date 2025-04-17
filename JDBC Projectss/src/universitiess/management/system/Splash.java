/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package universitiess.management.system;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author prasa
 */


public class Splash extends JFrame implements Runnable{
     
     Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image = new JLabel(scaledIcon);
        add(image);
         
        setLocation(250, 50);
        setVisible(true);
        for(int i=0;i<700;i=i+50){
            setSize(i,i);

            try {
               Thread.sleep(0);  
            } catch (Exception e) {
            }
        }

        //setSize(600, 700);
         // Don't forget this
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        setVisible(false);
     }


     // The abstract fnc run() in runnable tells that the code written in run fnc 
     //will run diffrent thread and it will no disturb other process

      public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //Assigning it new thread will make other process run parallel when it is on sleep mode
        
        
        Splash splash = new Splash(); // creates the splash
        Thread t = new Thread(splash); // gives the splash to a thread
        t.start();
        System.out.println("Hello World!");
    }
}
