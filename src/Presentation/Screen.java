package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener{

    private ControladorPresentacion cp = new ControladorPresentacion();

    private String username = new String();

    private Login loginRegisterC = new Login();
    private MainMenu mainMenuC = new MainMenu();
    private Instructions instructionsC = new Instructions();
    private SelectDifficulty selectDifficultyC = new SelectDifficulty();
    private CustomDifficulty customDifficultyC = new CustomDifficulty();
    private ChoseRole choseRoleC = new ChoseRole();
    private LoadGame loadGameC = new LoadGame();

    private char[] pinColorLetters = new char[]{'R', 'G', 'B', 'O', 'Y', 'P'};
    private int maxTurns = 10;
    private int pinNumber = 4;
    private Color[] pinColors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, new Color(150, 0, 255)};
    private GameBoard board = new GameBoard(pinNumber, pinColorLetters, pinColors);


    private JPanel loginRegisterPanel;
    private JPanel mainMenuPanel;
    private JPanel instructionsPanel;
    private JPanel selectDifficultyPanel;
    private JPanel customDifficultyPanel;
    private JPanel choseRolePanel;
    private JPanel loadGamePanel;

    private CardLayout layout = new CardLayout();

    private JPanel mainPanel = new JPanel();

    public Screen(int width, int height) {

        setListeners();

        loginRegisterPanel = loginRegisterC.getLoginRegisterPanel();
        mainMenuPanel = mainMenuC.getMainMenuPanel();
        instructionsPanel = instructionsC.getInstructionsPanel();
        selectDifficultyPanel = selectDifficultyC.getSelectDifficultyPanel();
        customDifficultyPanel = customDifficultyC.getCustomDifficultyPanel();
        choseRolePanel = choseRoleC.getChoseRolePanel();
        loadGamePanel = loadGameC.getLoadGamePanel();


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
        mainPanel.add(choseRolePanel, "ChoseRole");
        mainPanel.add(loadGamePanel, "LoadGame");
        mainPanel.add(board, "GameBoard");

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

                } else if (source == mainMenuC.getLoadGameButton()) {
                    layout.show(mainPanel, "LoadGame");
                } else if (source == selectDifficultyC.getEasyButton()) {
                    layout.show(mainPanel, "ChoseRole");
                    cp.setDifficult("easy");
                } else if (source == selectDifficultyC.getMediumButton()) {
                    layout.show(mainPanel, "ChoseRole");
                    cp.setDifficult("medium");
                } else if (source == selectDifficultyC.getHardButton()) {
                    layout.show(mainPanel, "ChoseRole");
                    cp.setDifficult("hard");
                } else if (source == selectDifficultyC.getCustomButton()) {
                    layout.show(mainPanel, "CustomDifficulty");
                } else if (source == selectDifficultyC.getBackButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == loginRegisterC.getLoginButton()) {
                    String user = loginRegisterC.getUsernameLogin().getText();
                    String pass = loginRegisterC.getPasswordLogin().getPassword().toString();
                    if(cp.exists(user) && cp.checkPW(user,pass)) {
                        username = user;
                        layout.show(mainPanel, "MainMenu");
                    }
                } else if (source == loginRegisterC.getRegisterButton()) {
                    String user = loginRegisterC.getUsernameRegister().getText();
                    String pass = loginRegisterC.getPasswordRegister().getPassword().toString();
                    if (!cp.exists(user)) {
                        cp.registrar(user, pass);
                        username = user;
                        mainMenuC.getUserLabel().setText(username);
                        layout.show(mainPanel, "MainMenu");
                    }

                } else if (source == customDifficultyC.getContinueButton()) {
                    layout.show(mainPanel, "ChoseRole");
                } else if (source == customDifficultyC.getBackButton()) {
                    layout.show(mainPanel, "SelectDifficulty");
                } else if (source == choseRoleC.getCodeBreakerButton()) {
                    layout.show(mainPanel, "GameBoard");
                } else if (source == choseRoleC.getCodeMasterButton()) {
                    layout.show(mainPanel, "GameBoard");
                } else if (source == choseRoleC.getBackButton()) {
                    layout.show(mainPanel, "SelectDifficulty");
                } else if (source == loadGameC.getSaveSlot1Button()) {
                    //layout.show(mainPanel, "SelectDifficulty");
                } else if (source == loadGameC.getSaveSlot2Button()) {
                    //layout.show(mainPanel, "SelectDifficulty");
                } else if (source == loadGameC.getSaveSlot3Button()) {
                    //layout.show(mainPanel, "SelectDifficulty");
                } else if (source == loadGameC.getBackButton()) {
                    layout.show(mainPanel, "MainMenu");
                } else if (source == board.getSaveButton()) {
                    layout.show(mainPanel, "MainMenu");
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

        choseRoleC.addCodeBreakerButtonActionListener(actionListener);
        choseRoleC.addCodeMasterButtonActionListener(actionListener);
        choseRoleC.addBackButtonActionListener(actionListener);

        loadGameC.addSaveSlot1ButtonActionListener(actionListener);
        loadGameC.addSaveSlot2ButtonActionListener(actionListener);
        loadGameC.addSaveSlot3ButtonActionListener(actionListener);
        loadGameC.addBackButtonActionListener(actionListener);

        board.addSaveButtonActionListener(actionListener);



    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

    }


}
