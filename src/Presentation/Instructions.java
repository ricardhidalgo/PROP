package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author ricard.hidalgo
 */

public class Instructions extends JPanel {
    private JPanel InstructionsPanel;
    private JButton mainMenuButton;
    private JTextPane instructionsTextPane;

    public Instructions() {

    }

    public JPanel getInstructionsPanel() {
        return InstructionsPanel;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void addMainMenuButtonActionListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

}
