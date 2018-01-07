package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener{

    Login loginRegisterC = new Login();
    MainMenu mainMenuC = new MainMenu();
    Instructions instructionsC = new Instructions();
    SelectDifficulty selectDifficultyC = new SelectDifficulty();
    CustomDifficulty customDifficultyC = new CustomDifficulty();

    JPanel loginRegisterPanel;
    JPanel mainMenuPanel;
    JPanel instructionsPanel;
    JPanel selectDifficultyPanel;
    JPanel customDifficultyPanel;

    CardLayout layout = new CardLayout();

    JPanel mainPanel = new JPanel();

    public Screen(int width, int height) {

        setListeners();

        loginRegisterPanel = loginRegisterC.getLoginRegisterPanel();
        mainMenuPanel = mainMenuC.getMainMenuPanel();
        instructionsPanel = instructionsC.getInstructionsPanel();
        selectDifficultyPanel = selectDifficultyC.getSelectDifficultyPanel();
        customDifficultyPanel = customDifficultyC.getCustomDifficultyPanel();


        mainPanel.setLayout(layout);
        layout.addLayoutComponent(mainPanel, "Screen");
        addPanels();


        setSize(width, height);
        //setResizable(false);
        //setLocationRelativeTo(null);
        setVisible(true);
        setTitle("MASTERMIND");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
    }

    private void addPanels() {

        mainPanel.add(loginRegisterPanel, "LoginRegister");
        mainPanel.add(mainMenuPanel, "MainMenu");
        mainPanel.add(instructionsPanel, "Instructions");
        mainPanel.add(selectDifficultyPanel, "SelectDifficulty");
        mainPanel.add(customDifficultyPanel, "CustomDifficulty");

        layout.show(mainPanel,"LoginRegister");

        add(mainPanel);

    }

    private void setListeners(){

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Object source = actionEvent.getSource();

                if (source == mainMenuC.getInstructionsButton()){
                    layout.show(mainPanel, "Instructions");
                } else if (source == instructionsC.getMainMenuButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == mainMenuC.getQuitButton()) {
                    System.exit(0);
                } else if (source == mainMenuC.getNewGameButton()) {
                    layout.show(mainPanel, "SelectDifficulty");
                } else if (source == mainMenuC.getScoresButton()) {

                } else if (source == selectDifficultyC.getEasyButton()) {

                } else if (source == selectDifficultyC.getMediumButton()) {

                } else if (source == selectDifficultyC.getHardButton()) {

                } else if (source == selectDifficultyC.getCustomButton()) {
                    layout.show(mainPanel, "CustomDifficulty");
                } else if (source == selectDifficultyC.getBackButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == loginRegisterC.getLoginButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == loginRegisterC.getRegisterButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == customDifficultyC.getContinueButton()) {

                } else if (source == customDifficultyC.getBackButton()) {
                    layout.show(mainPanel, "SelectDifficulty");
                }

            }
        };

        loginRegisterC.addLoginButtonActionListener(actionListener);
        loginRegisterC.addRegisterButtonActionListener(actionListener);

        mainMenuC.addInstructionsButtonActionListener(actionListener);
        mainMenuC.addLoadGameButtonActionListener(actionListener);
        mainMenuC.addNewGameButtonActionListener(actionListener);
        mainMenuC.addScoresButtonActionListener(actionListener);
        mainMenuC.addQuitButtonActionListener(actionListener);

        instructionsC.addMainMenuButtonActionListener(actionListener);

        selectDifficultyC.addEasyButtonActionListener(actionListener);
        selectDifficultyC.addMediumButtonActionListener(actionListener);
        selectDifficultyC.addHardButtonActionListener(actionListener);
        selectDifficultyC.addCustomButtonActionListener(actionListener);
        selectDifficultyC.addBackButtonActionListener(actionListener);

        customDifficultyC.addContinueButtonActionListener(actionListener);
        customDifficultyC.addBackButtonActionListener(actionListener);



    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

    }


}
