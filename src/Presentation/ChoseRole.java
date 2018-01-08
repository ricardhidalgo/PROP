package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChoseRole {
    private JPanel ChoseRolePanel;
    private JButton codeMasterButton;
    private JButton codeBreakerButton;
    private JButton backButton;

    public JPanel getChoseRolePanel() {
        return ChoseRolePanel;
    }

    public JButton getCodeMasterButton() {
        return codeMasterButton;
    }

    public JButton getCodeBreakerButton() {
        return codeBreakerButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void addCodeBreakerButtonActionListener(ActionListener listener) {
        codeBreakerButton.addActionListener(listener);
    }

    public void addCodeMasterButtonActionListener(ActionListener listener) {
        codeMasterButton.addActionListener(listener);
    }

    public void addBackButtonActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

}
