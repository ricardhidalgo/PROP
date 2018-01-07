package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu{
    private JButton loadGameButton;
    private JButton newGameButton;
    private JButton scoresButton;
    private JButton instructionsButton;
    private JPanel MainMenuPanel;
    private JButton quitButton;


    public JPanel getMainMenuPanel() {
        return MainMenuPanel;
    }

    public JButton getLoadGameButton() {
        return loadGameButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public JButton getScoresButton() {
        return scoresButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void addInstructionsButtonActionListener(ActionListener listener) {
        instructionsButton.addActionListener(listener);
    }
    public void addNewGameButtonActionListener(ActionListener listener) {
        newGameButton.addActionListener(listener);
    }
    public void addLoadGameButtonActionListener(ActionListener listener) {
        loadGameButton.addActionListener(listener);
    }
    public void addScoresButtonActionListener(ActionListener listener) {
        scoresButton.addActionListener(listener);
    }
    public void addQuitButtonActionListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    public MainMenu(){

    }
}



