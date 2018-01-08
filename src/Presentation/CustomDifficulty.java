package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomDifficulty {
    private JPanel CustomDifficultyPanel;
    private JSpinner lengthSpinner;
    private JSpinner turnSpinner;
    private JRadioButton allowRepeatedRadioButton;
    private JRadioButton noRepeatedRadioButton;
    private JLabel turnsLabel;
    private JLabel lengthLabel;
    private JButton backButton;
    private JButton continueButton;
    private JCheckBox tipsCheckBox;

    public JPanel getCustomDifficultyPanel() {
        return CustomDifficultyPanel;
    }

    public JSpinner getLengthSpinner() {
        return lengthSpinner;
    }

    public JSpinner getTurnSpinner() {
        return turnSpinner;
    }

    public JRadioButton getAllowRepeatedRadioButton() {
        return allowRepeatedRadioButton;
    }

    public JRadioButton getNoRepeatedRadioButton() {
        return noRepeatedRadioButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void addContinueButtonActionListener(ActionListener listener) {
        continueButton.addActionListener(listener);
    }

    public void addBackButtonActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
