package Manager;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteSelect {
    private JPanel noteSelectPanel;
    private JButton createANoteButton;
    private JButton viewNotesButton;

    JFrame noteF=new JFrame();
public NoteSelect() {
    noteSelectPanel.setBackground(new Color(187, 227,237));
    noteF.setVisible(true);
    noteF.setContentPane(noteSelectPanel);
    noteF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    createANoteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new NoteCreate();
        }
    });
    viewNotesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Notes();
        }
    });
}
}
