package Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login {
    private JPanel LoginRegisterPanel;
    private JTabbedPane TabbedLoginRegister;
    private JPanel LoginPanel;
    private JPanel RegisterPanel;
    private JTextField usernameLogin;
    private JPasswordField passwordLogin;
    private JButton loginButton;
    private JTextField usernameRegister;
    private JPasswordField PasswordRegister;
    private JButton registerButton;
    private JLabel psLoginLabel;
    private JLabel usLoginLabel;
    private JLabel usRegLabel;
    private JLabel psRegLabel;

    public JPanel getLoginRegisterPanel() {
        return LoginRegisterPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void addLoginButtonActionListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addRegisterButtonActionListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }
}
