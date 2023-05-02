package Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;


public class NoteCreate extends UserLogin{
    private JPanel noteCreatePanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    JFrame noteF=new JFrame();
public NoteCreate() {
    noteCreatePanel.setBackground(new Color(187, 227,237));
    noteF.setVisible(true);
    noteF.setContentPane(noteCreatePanel);
    noteF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = "insert into notes (username,notes,description)"+"values (?,?,?)";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","root");
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1,username);
                statement.setString(2,textField1.getText());
                statement.setString(3,textField2.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Note added successfully");}
            catch (Exception ex){
                // JOptionPane.showMessageDialog(null,"add item exception");
                ex.printStackTrace();
            }
    }
});
}}
