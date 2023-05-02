package Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
public class OptionSelect {
    private JPanel optionPanel;
    private JButton notesButton;
    private JButton passwordManagerButton;
    JFrame selectF= new JFrame();
public OptionSelect() {
    optionPanel.setBackground(new Color(187, 227,237));

    selectF.setVisible(true);
    selectF.setContentPane(optionPanel);
    selectF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    passwordManagerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Password();

        }
    });
    notesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            new NoteSelect();
        }
    });
}
}
