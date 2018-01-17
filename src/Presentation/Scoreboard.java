package Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Scoreboard {
    private JPanel ScoreboardPanel;
    private JLabel scoreLabel1;
    private JLabel scoreLabel2;
    private JLabel scoreLabel3;
    private JLabel scoreLabel4;
    private JLabel scoreLabel5;
    private JLabel scoreLabel6;
    private JLabel scoreLabel7;
    private JLabel scoreLabel8;
    private JLabel scoreLabel9;
    private JLabel scoreLabel10;
    private JButton backButton;


    public JLabel getScoreLabel1() {
        return scoreLabel1;
    }

    public JLabel getScoreLabel2() {
        return scoreLabel2;
    }

    public JLabel getScoreLabel3() {
        return scoreLabel3;
    }

    public JLabel getScoreLabel4() {
        return scoreLabel4;
    }

    public JLabel getScoreLabel5() {
        return scoreLabel5;
    }

    public JLabel getScoreLabel6() {
        return scoreLabel6;
    }

    public JLabel getScoreLabel7() {
        return scoreLabel7;
    }

    public JLabel getScoreLabel8() {
        return scoreLabel8;
    }

    public JLabel getScoreLabel9() {
        return scoreLabel9;
    }

    public JLabel getScoreLabel10() {
        return scoreLabel10;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JPanel getScoreboardPanel() {
        return ScoreboardPanel;
    }

    public void addBackButtonActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
