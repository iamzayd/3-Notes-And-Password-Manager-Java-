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

public class PasswordManager{
    private JTable table1;
    private JPanel passwordPanel;
    private JButton showPasswordsButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;

    public String passwordData;
    JFrame passwordF=new JFrame();
public PasswordManager() {
    passwordPanel.setBackground(new Color(187, 227,237));
    passwordF.setVisible(true);
    passwordF.setContentPane(passwordPanel);
    passwordF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    showPasswordsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tableData();
        }
    });

    table1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            int column = table1.getSelectedColumn();
            passwordData = table1.getValueAt(table1.getSelectedRow(), column).toString();
            try{
                String str = passwordData;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager","root","root");
                PreparedStatement st = con.prepareStatement("select password,username1 from password where accounts=?");
                st.setString(1, str);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString(1);
                    String s1 = rs.getString(2);
                    passwordLabel.setText(s1);
                    usernameLabel.setText(s);
                } else {
                    JOptionPane.showMessageDialog(null, "ID not found");
                }
            }catch (Exception ex1){
                //JOptionPane.showMessageDialog(null,"Table data exception");
                ex1.printStackTrace();

            }
            //descLabel.setText(notesData);
        }

        }
    );
}

    public void tableData() {
        try{
            String a= "Select accounts from password";
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
