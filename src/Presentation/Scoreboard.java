package Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Scoreboard {

    private JPanel ScoreboardPanel;
    private JButton backButton;
    private JTable scoreTable;
    private JScrollPane scorePane;

    public JTable getScoreTable() {
        return scoreTable;
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


    private void createUIComponents() {
        String[] columnNames = {"Position", "Name and Score"};
        Object[][] data = {
                {"1: ", null},
                {"2: ", null},
                {"3: ", null},
                {"4: ", null},
                {"5: ", null},
                {"6: ", null},
                {"7: ", null},
                {"8: ", null},
                {"9: ", null},
                {"10: ", null},
        };
        scoreTable = new JTable(data, columnNames);
        scoreTable.getTableHeader().setReorderingAllowed(false);
        scoreTable.setEnabled(false);

    }
}
