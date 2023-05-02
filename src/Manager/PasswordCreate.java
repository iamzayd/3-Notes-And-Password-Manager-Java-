package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PasswordCreate extends UserLogin{
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JButton submitButton;
    private JTextField textField3;
    private JPanel passwordPanel;
    JFrame selectF= new JFrame();

    public PasswordCreate() {
        passwordPanel.setBackground(new Color(187, 227,237));
        selectF.setVisible(true);
        selectF.setContentPane(passwordPanel);
        selectF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = "insert into password (username,accounts,password,username1)"+"values (?,?,?,?)";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","root");
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(4,textField1.getText());
                statement.setString(2,textField2.getText());
                statement.setString(3,textField3.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Password added successfully");
                new Password();
            }
            catch (Exception ex){
                // JOptionPane.showMessageDialog(null,"add item exception");
                ex.printStackTrace();
            }
            /*
            } catch (SQLException ex) {
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
      } catch (ClassNotFoundException ex) {
         System.out.println("Driver not found");
             */
        }
    });
}
}
