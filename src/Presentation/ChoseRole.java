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


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        ChoseRolePanel = new JPanel();
        ChoseRolePanel.setLayout(new GridBagLayout());
        ChoseRolePanel.setBackground(new Color(-12501697));
        ChoseRolePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Mastermind", TitledBorder.CENTER, TitledBorder.BELOW_TOP, this.$$$getFont$$$("DejaVu Sans Mono", Font.BOLD | Font.ITALIC, 28, ChoseRolePanel.getFont()), new Color(-4737097)));
        codeMasterButton = new JButton();
        codeMasterButton.setText("CodeMaster");
        codeMasterButton.setToolTipText("As the CodeMaster, set a secret code that the CodeBreaker can't find");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 1);
        ChoseRolePanel.add(codeMasterButton, gbc);
        codeBreakerButton = new JButton();
        codeBreakerButton.setText("CodeBreaker");
        codeBreakerButton.setToolTipText("As the CodeBreaker, your goal is to find the CodeMasters' secret code");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 1, 5, 5);
        ChoseRolePanel.add(codeBreakerButton, gbc);
        backButton = new JButton();
        backButton.setText("Back");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.insets = new Insets(0, 0, 5, 5);
        ChoseRolePanel.add(backButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return ChoseRolePanel;
    }
}
