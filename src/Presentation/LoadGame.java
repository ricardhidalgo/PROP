package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoadGame {

    private JPanel LoadGamePanel;
    private JButton saveSlot1Button;
    private JButton saveSlot2Button;
    private JButton saveSlot3Button;
    private JButton backButton;

    public JPanel getLoadGamePanel() {
        return LoadGamePanel;
    }

    public JButton getSaveSlot1Button() {
        return saveSlot1Button;
    }

    public JButton getSaveSlot2Button() {
        return saveSlot2Button;
    }

    public JButton getSaveSlot3Button() {
        return saveSlot3Button;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void addSaveSlot1ButtonActionListener(ActionListener listener) {
        saveSlot1Button.addActionListener(listener);
    }

    public void addSaveSlot2ButtonActionListener(ActionListener listener) {
        saveSlot1Button.addActionListener(listener);
    }

    public void addSaveSlot3ButtonActionListener(ActionListener listener) {
        saveSlot1Button.addActionListener(listener);
    }

    public void addBackButtonActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

}
