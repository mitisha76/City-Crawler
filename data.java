package app2;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
  
public class data { 
    // frame 
    JFrame f; 
    // Table 
    JTable j; 
    data(String[][] a) 
    { 
        f = new JFrame(); 
        f.setTitle("Results As Per Your Selected Criteria");
        String[] columnNames = {"Name of Place", "Full-Address"}; 
        j = new JTable(a, columnNames); 
        j.setRowHeight(30);
        j.getColumnModel().getColumn(0).setPreferredWidth(500);
        j.getColumnModel().getColumn(1).setPreferredWidth(800);
        j.setBackground(Color.black);
        j.setForeground(Color.white);
        j.setFont(new Font("Verdana",0,12));
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        f.setSize(1500, 400); 
        f.setVisible(true); 
    } 
} 