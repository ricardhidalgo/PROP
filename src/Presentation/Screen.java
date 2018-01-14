package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener{

    private ControladorPresentacion cp = new ControladorPresentacion();

    private String username;

    private Login loginRegisterC;
    private MainMenu mainMenuC;
    private Instructions instructionsC;
    private SelectDifficulty selectDifficultyC;
    private CustomDifficulty customDifficultyC;
    private ChoseRole choseRoleC;
    private LoadGame loadGameC;

    private char[] pinColorLetters = new char[]{'R', 'G', 'B', 'O', 'Y', 'P'};
    private int pinNumber = 4; //provisional
    private Color[] pinColors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, new Color(150, 0, 255)};
    private GameBoard board = new GameBoard(pinNumber, pinColorLetters, pinColors);

    /*private JPanel loginRegisterPanel;
    private JPanel mainMenuPanel;
    private JPanel instructionsPanel;
    private JPanel selectDifficultyPanel;
    private JPanel customDifficultyPanel;
    private JPanel choseRolePanel;
    private JPanel loadGamePanel;*/

    private CardLayout layout;

    private JPanel mainPanel;

    public Screen(int width, int height) {

        initializePanelClasses();

        setListeners();

        /*loginRegisterPanel = loginRegisterC.getLoginRegisterPanel();
        mainMenuPanel = mainMenuC.getMainMenuPanel();
        instructionsPanel = instructionsC.getInstructionsPanel();
        selectDifficultyPanel = selectDifficultyC.getSelectDifficultyPanel();
        customDifficultyPanel = customDifficultyC.getCustomDifficultyPanel();
        choseRolePanel = choseRoleC.getChoseRolePanel();
        loadGamePanel = loadGameC.getLoadGamePanel();*/

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

        mainPanel.add(loginRegisterC.getLoginRegisterPanel(), "LoginRegister");
        mainPanel.add(mainMenuC.getMainMenuPanel(), "MainMenu");
        mainPanel.add(instructionsC.getInstructionsPanel(), "Instructions");
        mainPanel.add(selectDifficultyC.getSelectDifficultyPanel(), "SelectDifficulty");
        mainPanel.add(customDifficultyC.getCustomDifficultyPanel(), "CustomDifficulty");
        mainPanel.add(choseRoleC.getChoseRolePanel(), "ChoseRole");
        mainPanel.add(loadGameC.getLoadGamePanel(), "LoadGame");
        mainPanel.add(board, "GameBoard");

        layout.show(mainPanel,"LoginRegister");

        add(mainPanel);

    }

    private void initializePanelClasses() {

        loginRegisterC = new Login();
        mainMenuC = new MainMenu();
        instructionsC = new Instructions();
        selectDifficultyC = new SelectDifficulty();
        customDifficultyC = new CustomDifficulty();
        choseRoleC = new ChoseRole();
        loadGameC = new LoadGame();

        layout = new CardLayout();

        mainPanel = new JPanel();
    }

    private void setListeners(){

        loginRegisterC.addLoginButtonActionListener(this);
        loginRegisterC.addRegisterButtonActionListener(this);

        mainMenuC.addInstructionsButtonActionListener(this);
        mainMenuC.addLoadGameButtonActionListener(this);
        mainMenuC.addNewGameButtonActionListener(this);
        mainMenuC.addScoresButtonActionListener(this);
        mainMenuC.addQuitButtonActionListener(this);

        instructionsC.addMainMenuButtonActionListener(this);

        selectDifficultyC.addEasyButtonActionListener(this);
        selectDifficultyC.addMediumButtonActionListener(this);
        selectDifficultyC.addHardButtonActionListener(this);
        selectDifficultyC.addCustomButtonActionListener(this);
        selectDifficultyC.addBackButtonActionListener(this);

        customDifficultyC.addContinueButtonActionListener(this);
        customDifficultyC.addBackButtonActionListener(this);

        choseRoleC.addCodeBreakerButtonActionListener(this);
        choseRoleC.addCodeMasterButtonActionListener(this);
        choseRoleC.addBackButtonActionListener(this);

        loadGameC.addSaveSlot1ButtonActionListener(this);
        loadGameC.addSaveSlot2ButtonActionListener(this);
        loadGameC.addSaveSlot3ButtonActionListener(this);
        loadGameC.addBackButtonActionListener(this);

        board.addSaveButtonActionListener(this);
        board.addSubmitButtonActionListener(this);


    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        if (source == mainMenuC.getInstructionsButton()) {

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

            cp.setDifficult("easy", selectDifficultyC.getActivateTipsCheckBox().isSelected());
            layout.show(mainPanel, "ChoseRole");

        } else if (source == selectDifficultyC.getMediumButton()) {
            cp.setDifficult("medium");
            layout.show(mainPanel, "ChoseRole");

        } else if (source == selectDifficultyC.getHardButton()) {

            cp.setDifficult("hard", selectDifficultyC.getActivateTipsCheckBox().isSelected());
            layout.show(mainPanel, "ChoseRole");

        } else if (source == selectDifficultyC.getCustomButton()) {

            cp.setDifficult("custom", selectDifficultyC.getActivateTipsCheckBox().isSelected());
            layout.show(mainPanel, "CustomDifficulty");

        } else if (source == selectDifficultyC.getBackButton()) {

            layout.show(mainPanel, "MainMenu");

        } else if (source == loginRegisterC.getLoginButton()) { //Login

            String user = loginRegisterC.getUsernameLogin().getText();
            String pass = String.valueOf(loginRegisterC.getPasswordLogin().getPassword());

            if (cp.loginUser(user, pass)) {
                username = user;
                mainMenuC.getUserLabel().setText("Welcome, " + username + "!");
                layout.show(mainPanel, "MainMenu");
            }

        } else if (source == loginRegisterC.getRegisterButton()) { //Register

            String user = loginRegisterC.getUsernameRegister().getText();
            String pass = String.valueOf(loginRegisterC.getPasswordRegister().getPassword());

            if (cp.registerUser(user, pass)) {
                username = user;
                mainMenuC.getUserLabel().setText("Welcome, " + username + "!");
                layout.show(mainPanel, "MainMenu");
            }

        } else if (source == customDifficultyC.getContinueButton()) {

            layout.show(mainPanel, "ChoseRole");

        } else if (source == customDifficultyC.getBackButton()) {

            layout.show(mainPanel, "SelectDifficulty");

        } else if (source == choseRoleC.getCodeBreakerButton()) {

            cp.breaker(true);
            cp.setAnswerCB();
            cp.begin();
            layout.show(mainPanel, "GameBoard");

        } else if (source == choseRoleC.getCodeMasterButton()) {

            cp.breaker(false);
            cp.begin();
            layout.show(mainPanel, "GameBoard");

        } else if (source == choseRoleC.getBackButton()) {

            layout.show(mainPanel, "SelectDifficulty");

        } else if (source == loadGameC.getSaveSlot1Button()) {

            ArrayList<String> arr = cp.loadMatch(username, 0);
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getSaveSlot2Button()) {

            ArrayList<String> arr = cp.loadMatch(username, 1);
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getSaveSlot3Button()) {

            ArrayList<String> arr = cp.loadMatch(username, 2);
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getBackButton()) {

            layout.show(mainPanel, "MainMenu");

        } else if (source == board.getSaveButton()) {

            cp.saveMatch();
            layout.show(mainPanel, "MainMenu");

        } else if (source == board.getSubmit()) {

            String play = board.getSubmitGuessString();
            cp.setGuess(play);
            int col = cp.getCorrectColors();
            int pos = cp.getCorrectPosition();
            board.displayResult(col, pos, board.getCurrentTurn() + 1);
            if(cp.isEnd(pos)){
                cp.saveScore(username);
                layout.show(mainPanel, "MainMenu");
            }
        }

    }


}
