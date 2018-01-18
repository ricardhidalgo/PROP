package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author ricard.hidalgo
 */

public class SelectDifficulty {
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private JButton customButton;
    private JButton backButton;
    private JPanel SelectDifficultyPanel;
    private JCheckBox activateTipsCheckBox;

    public JPanel getSelectDifficultyPanel() {
        return SelectDifficultyPanel;
    }

    public JButton getEasyButton() {
        return easyButton;
    }

    public JButton getMediumButton() {
        return mediumButton;
    }

    public JButton getHardButton() {
        return hardButton;
    }

    public JButton getCustomButton() {
        return customButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JCheckBox getActivateTipsCheckBox() {
        return activateTipsCheckBox;
    }

    public void addEasyButtonActionListener(ActionListener listener) {
        easyButton.addActionListener(listener);
    }

    public void addMediumButtonActionListener(ActionListener listener) {
        mediumButton.addActionListener(listener);
    }

    public void addHardButtonActionListener(ActionListener listener) {
        hardButton.addActionListener(listener);
    }

    public void addCustomButtonActionListener(ActionListener listener) {
        customButton.addActionListener(listener);
    }

    public void addBackButtonActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }


}
