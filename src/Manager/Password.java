package Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
public class Password {
    private JPanel passwordSelectPanel;
    private JButton createAnEntryButton;
    private JButton showPasswordsButton;
    JFrame selectF= new JFrame();
public Password() {
    passwordSelectPanel.setBackground(new Color(187, 227,237));
    selectF.setVisible(true);
    selectF.setContentPane(passwordSelectPanel);
    selectF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    createAnEntryButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new PasswordCreate();
        }
    });
    showPasswordsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new PasswordManager();
        }
    });
}
}
