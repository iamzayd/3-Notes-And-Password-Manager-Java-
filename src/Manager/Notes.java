package Manager;
import Manager.buildtable.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

import static Manager.buildtable.buildtable.buildTableModel;
import java.awt.Color;

public class Notes {
    private JTable table1;
    private JPanel notesPanel;
    private JLabel descLabel;
    private JButton showNotesButton;

    public String notesData="";
    JFrame notesF=new JFrame();

public Notes(){
    notesPanel.setBackground(new Color(187, 227,237));
    notesF.setVisible(true);
    notesF.setContentPane(notesPanel);
    notesF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

    showNotesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        tableData();
        }
    });

    table1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int column = table1.getSelectedColumn();
            notesData = table1.getValueAt(table1.getSelectedRow(), column).toString();
           try{
               String str = notesData;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","root");
            PreparedStatement st = con.prepareStatement("select description from notes where notes=?");
            st.setString(1, str);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s = rs.getString(1);
                descLabel.setText(s);
            } else {
                JOptionPane.showMessageDialog(null, "ID not found");
            }
           }catch (Exception ex1){
               //JOptionPane.showMessageDialog(null,"Table data exception");
               ex1.printStackTrace();

           }
            //descLabel.setText(notesData);
        }
    });
}

    public void tableData() {
        try{
            String a= "Select notes from notes";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(a);

            table1.setModel(buildTableModel(rs));
        }catch (Exception ex1){
            //JOptionPane.showMessageDialog(null,"Table data exception");
            ex1.printStackTrace();

        }
    }
}
