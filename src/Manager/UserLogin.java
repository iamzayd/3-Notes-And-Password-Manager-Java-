package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UserLogin {
    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    public String username;

    JFrame userLoginF=new JFrame();
public UserLogin() {
    loginPanel.setBackground(new Color(187, 227,237));
    userLoginF.setVisible(true);
    userLoginF.setContentPane(loginPanel);
    userLoginF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    username = "admin";
    String password = "admin";
   // String username1 = "admin1";
   // String password1 = "admin1";
    char[] pwd = password.toCharArray();
    //char[] pwd1 = password1.toCharArray();
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Authenticator.authenticate(textField1.getText(), passwordField1.getPassword());
                new OptionSelect();
                System.out.println("works");
            } catch (AuthenticationException ex) {
                System.out.println("error");
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    });
}
}
