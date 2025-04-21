package universitiess.management.system;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import javax.swing.text.TableView;
import net.proteanit.sql.DbUtils;

public class FeeStructures extends JFrame {

    public FeeStructures() {
        setSize(800,500);
        setLocation(50,100);
        setLayout(null);
        
        JLabel header = new JLabel("Fee Structures");
        header.setBounds(20, 10, 300, 50);
        header.setFont(new Font("Tahora",Font.BOLD,25));
        add(header);

        JTable table = new JTable();
        String query= "SELECT * FROM fee_structures";
        try {
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery(query); 
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0, 60, 800, 445);
        add(jsp);

        setVisible(true);
    }
       
    
    public static void main(String[] args) {
        new FeeStructures();
    }
}
