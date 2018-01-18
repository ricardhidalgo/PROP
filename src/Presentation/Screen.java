package Presentation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author ricard.hidalgo
 */

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
    private Scoreboard scoreboardC;

    private GameBoard board;

    private CardLayout layout;

    private JPanel mainPanel;

    /**
     * Constructora del JFrame principal del programa
     *
     * @param width  Ancho del JFrame
     * @param height Alto del JFrame
     */
    public Screen(int width, int height) {

        initializePanelClasses();

        setListeners();

        mainPanel.setLayout(layout);
        layout.addLayoutComponent(mainPanel, "Screen");
        addPanels();

        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        //setResizable(false);
        //setLocationRelativeTo(null);
        setTitle("MASTERMIND");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        requestFocus();
    }

    /**
     * Añade los diferentes JPanels al CardLayout para formar el sistema de menus.
     */
    private void addPanels() {

        mainPanel.add(loginRegisterC.getLoginRegisterPanel(), "LoginRegister");
        mainPanel.add(mainMenuC.getMainMenuPanel(), "MainMenu");
        mainPanel.add(instructionsC.getInstructionsPanel(), "Instructions");
        mainPanel.add(selectDifficultyC.getSelectDifficultyPanel(), "SelectDifficulty");
        mainPanel.add(customDifficultyC.getCustomDifficultyPanel(), "CustomDifficulty");
        mainPanel.add(choseRoleC.getChoseRolePanel(), "ChoseRole");
        mainPanel.add(loadGameC.getLoadGamePanel(), "LoadGame");
        mainPanel.add(scoreboardC.getScoreboardPanel(), "Scores");

        layout.show(mainPanel,"LoginRegister");

        add(mainPanel);

    }

    /**
     * Inicializa las clases que definen los diferentes JPanels de los menus, así como el layout
     */
    private void initializePanelClasses() {

        loginRegisterC = new Login();
        mainMenuC = new MainMenu();
        instructionsC = new Instructions();
        selectDifficultyC = new SelectDifficulty();
        customDifficultyC = new CustomDifficulty();
        choseRoleC = new ChoseRole();
        loadGameC = new LoadGame();
        scoreboardC = new Scoreboard();

        layout = new CardLayout();

        mainPanel = new JPanel();
    }

    /**
     * Configura todos los ActionListeners de los diferentes JPanels
     */
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

        scoreboardC.addBackButtonActionListener(this);

    }

    /**
     * Define la respuesta a cualquier evento generado en funcion de su fuente
     * @param event Objeto tipo ActionEvent generado por el ActionListener.
     */
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


            ArrayList<String> scoresAr = cp.getRanking();
            for (int j = 0; j < scoresAr.size(); ++j) {
                scoreboardC.getScoreTable().setValueAt(scoresAr.get(j), j, 1);
            }
            layout.show(mainPanel, "Scores");

        } else if (source == scoreboardC.getBackButton()) {

            layout.show(mainPanel, "MainMenu");

        } else if (source == mainMenuC.getLoadGameButton()) {

            if (cp.existsMatch(username, 0)) loadGameC.getSaveSlot1Button().setEnabled(true);
            if (cp.existsMatch(username, 1)) loadGameC.getSaveSlot2Button().setEnabled(true);
            if (cp.existsMatch(username, 2)) loadGameC.getSaveSlot3Button().setEnabled(true);

            layout.show(mainPanel, "LoadGame");

        } else if (source == selectDifficultyC.getEasyButton()) {

            cp.setDifficult("easy", selectDifficultyC.getActivateTipsCheckBox().isSelected());
            layout.show(mainPanel, "ChoseRole");

        } else if (source == selectDifficultyC.getMediumButton()) {

            cp.setDifficult("medium", selectDifficultyC.getActivateTipsCheckBox().isSelected());
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

            cp.configureCustom((Integer) customDifficultyC.getLengthSpinner().getValue(), customDifficultyC.getAllowRepeatedRadioButton().isSelected());
            layout.show(mainPanel, "ChoseRole");

        } else if (source == customDifficultyC.getBackButton()) {

            layout.show(mainPanel, "SelectDifficulty");

        } else if (source == choseRoleC.getCodeBreakerButton()) {

            cp.breaker(true);
            cp.startNewGame();
            cp.setAnswerCB();


            board = new GameBoard(cp.getCombinationSize(), cp.isCanRepeat(), true, cp.PINCOLORLETTERS, cp.PINCOLORS);
            board.addSaveButtonActionListener(this);
            board.addSubmitButtonActionListener(this);
            mainPanel.add(board, "GameBoard");
            layout.show(mainPanel, "GameBoard");

        } else if (source == choseRoleC.getCodeMasterButton()) {

            cp.breaker(false);
            cp.startNewGame();

            board = new GameBoard(cp.getCombinationSize(), cp.isCanRepeat(), false, cp.PINCOLORLETTERS, cp.PINCOLORS);
            board.addExitButtonActionListener(this);
            board.addSubmitButtonActionListener(this);
            mainPanel.add(board, "GameBoard");
            layout.show(mainPanel, "GameBoard");

        } else if (source == choseRoleC.getBackButton()) {

            layout.show(mainPanel, "SelectDifficulty");

        } else if (source == loadGameC.getSaveSlot1Button()) {
            cp.loadMatch(username, 0);
            board = new GameBoard(cp.getCombinationSize(), cp.isCanRepeat(), true, cp.PINCOLORLETTERS, cp.PINCOLORS);
            board.addSaveButtonActionListener(this);
            board.addSubmitButtonActionListener(this);
            mainPanel.add(board, "GameBoard");
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getSaveSlot2Button()) {

            cp.loadMatch(username, 1);
            board = new GameBoard(cp.getCombinationSize(), cp.isCanRepeat(), true, cp.PINCOLORLETTERS, cp.PINCOLORS);
            board.addSaveButtonActionListener(this);
            board.addSubmitButtonActionListener(this);
            mainPanel.add(board, "GameBoard");
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getSaveSlot3Button()) {
            cp.loadMatch(username, 2);
            board = new GameBoard(cp.getCombinationSize(), cp.isCanRepeat(), true, cp.PINCOLORLETTERS, cp.PINCOLORS);
            board.addSaveButtonActionListener(this);
            board.addSubmitButtonActionListener(this);
            mainPanel.add(board, "GameBoard");
            layout.show(mainPanel, "GameBoard");

        } else if (source == loadGameC.getBackButton()) {

            layout.show(mainPanel, "MainMenu");

        } else if (source == board.getSaveButton()) {

            if (board.getSubmitButton().isEnabled()) cp.saveMatch();
            layout.show(mainPanel, "MainMenu");
            board.getSaveButton().setText("Save");

        } else if (source == board.getExitButton()) {

            layout.show(mainPanel, "MainMenu");

        } else if (source == board.getSubmitButton()) {

            if (board.getSubmitButton().getText() == "Submit Secret Code") {

                cp.setAnswerCM(board.getSubmitGuessString());
                board.setSecretCodeOnPanel();
                board.getClearButton().setEnabled(false);
                board.getCurrentGuessPanel().setEnabled(false);
                board.getSubmitButton().setText("Generate First Guess");

            } else if (board.getSubmitButton().getText() == "Generate First Guess") {

                String play = cp.firstGuess();
                cp.setGuess(play);
                board.setSubmitGuessString(play);
                int col = cp.getCorrectColors();
                int pos = cp.getCorrectPosition();
                board.increaseTurn();
                board.displayResult(col, pos, board.getCurrentTurn());
                if (!cp.isEnd(pos)) {
                    board.getSubmitButton().setText("Generate Next Guess");
                } else {
                    board.getSubmitButton().setEnabled(false);
                    board.displayMessage("The AI has found the secret code! Game over!");
                }

            } else if (board.getSubmitButton().getText() == "Generate Next Guess") {

                String play = cp.nextGuess();
                cp.setGuess(play);
                board.setSubmitGuessString(play);
                int col = cp.getCorrectColors();
                int pos = cp.getCorrectPosition();
                board.increaseTurn();
                board.displayResult(col, pos, board.getCurrentTurn());
                if (cp.isEnd(pos)) {
                    board.getSubmitButton().setEnabled(false);
                    board.displayMessage("The AI has found the secret code! Game over!");
                }

            } else {
                String play = board.getSubmitGuessString();
                cp.setGuess(play);
                int col = cp.getCorrectColors();
                int pos = cp.getCorrectPosition();
                board.increaseTurn();
                board.displayResult(col, pos, board.getCurrentTurn());
                if (cp.isEnd(pos)) {
                    cp.saveScore(username);
                    board.getSubmitButton().setEnabled(false);
                    board.displayMessage("Congratulations! You won!  -> Final score: " + cp.getGameScore());
                    board.getSaveButton().setText("Exit");
                }
            }
        }

    }


}
