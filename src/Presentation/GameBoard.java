package Presentation;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel {


    private Color backgroundColor = new Color(-12501697);
    private String guessString = "";
    private String submitGuessString = "";
    private boolean hasGuessString = false;

    private boolean playerRole; //True para CodeBreaker
    private int pinNumber;
    private boolean canRepeat;
    private Color[] pinColors;
    private char[] pinColorLetters;
    private int currentTurn;

    private JPanel buttonsPanel;
    private JPanel pinPanel;
    private Pin[] pins;
    private JPanel currentGuessPanel;
    private JButton clearButton;
    private JButton submitButton;
    private JButton saveButton;
    private JButton exitButton;
    private JPanel secretCodePanel;


    private JScrollPane guessScrollPane;
    private JPanel guessPanel;


    private JPanel titlePanel;
    private JLabel titleText;


    private final Dimension buttonDimension = new Dimension(130, 30);
    private final Dimension pinDimension = new Dimension(40, 40);
    private final Dimension pinSmallDimension;


    public GameBoard(int pinNumber, boolean canRepeat, boolean playerRole, char[] pinColorLetters, Color[] pinColors) {

        currentTurn = 0;

        setSize(new Dimension(400, 800));
        setBackground(backgroundColor);
        setForeground(backgroundColor);
        setLayout(new BorderLayout());

        this.pinNumber = pinNumber;
        this.canRepeat = canRepeat;
        this.playerRole = playerRole;
        this.pinColors = pinColors;
        this.pinColorLetters = pinColorLetters;
        pinSmallDimension = new Dimension((int) (140 / (pinNumber + 2)), (int) (140 / (pinNumber + 2)));

        assembleButtonsPanel();

        assembleGuessPanel();

        assembleTitlePanel();

        add(titlePanel, BorderLayout.NORTH);
        add(guessScrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    public void addSaveButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addSubmitButtonActionListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addExitButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
    public JButton getSaveButton() {
        return saveButton;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void increaseTurn() {
        ++currentTurn;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String getSubmitGuessString() {
        return submitGuessString;
    }


    private void assembleButtonsPanel() {

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 3));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Button Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        buttonsPanel.setPreferredSize(new Dimension(150, 500));
        buttonsPanel.setBackground(backgroundColor);
        buttonsPanel.setForeground(backgroundColor);

        pinPanel = new JPanel();
        pinPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //pinPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "mastermind.swing.Pin Panel"));
        pinPanel.setPreferredSize(new Dimension(140,
                ((int) (Math.ceil(pinColorLetters.length / 3) + 1) * (pinDimension.width + 5))));
        pinPanel.setBackground(backgroundColor);
        pinPanel.setForeground(backgroundColor);


        pins = new Pin[pinColors.length];
        for (int i = 0; i < pins.length; i++) {
            pins[i] = new Pin(pinColors[i], pinColorLetters[i], pinDimension);
            pins[i].addActionListener(new PinActionListener(pinColorLetters[i]));
            pinPanel.add(pins[i]);
        }

        currentGuessPanel = new JPanel();
        currentGuessPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        currentGuessPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Guess", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        currentGuessPanel.setPreferredSize(new Dimension(140, 80));
        currentGuessPanel.setBackground(backgroundColor);
        currentGuessPanel.setForeground(backgroundColor);


        if (playerRole) submitButton = new JButton("Submit Guess");
        else submitButton = new JButton("Submit Secret Code");
        submitButton.setPreferredSize(buttonDimension);
        submitButton.addActionListener((ActionEvent e) -> {
            setGuessStringAvailable(true);
        });


        clearButton = new JButton("Clear Guess");
        clearButton.setPreferredSize(buttonDimension);
        clearButton.addActionListener((ActionEvent e) -> {
            setGuessString("");
            setGuessStringAvailable(false);
            submitGuessString = "";
            displayCurrentGuess();
        });

        if (playerRole) {
            saveButton = new JButton(("Save"));
            saveButton.setPreferredSize(buttonDimension);
        } else {
            exitButton = new JButton(("Exit"));
            exitButton.setPreferredSize(buttonDimension);
        }

        buttonsPanel.add(pinPanel);
        buttonsPanel.add(currentGuessPanel);
        buttonsPanel.add(submitButton);
        buttonsPanel.add(clearButton);
        if (playerRole) buttonsPanel.add(saveButton);
        else buttonsPanel.add(exitButton);

        if (!playerRole) {
            secretCodePanel = new JPanel();
            secretCodePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            secretCodePanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Secret Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
            secretCodePanel.setPreferredSize(new Dimension(140, 80));
            secretCodePanel.setBackground(backgroundColor);
            secretCodePanel.setForeground(backgroundColor);
            buttonsPanel.add(secretCodePanel);
        }
    }

    private void assembleGuessPanel() {

        guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        guessPanel.setMinimumSize(new Dimension(200, 600));
        guessPanel.setPreferredSize(new Dimension(200, 800));
        guessPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Guess Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        guessPanel.setBackground(backgroundColor);
        guessPanel.setForeground(new Color(-4737097));


        guessScrollPane = new JScrollPane(guessPanel);
        guessScrollPane.setBorder(null);
        guessScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        guessScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        guessScrollPane.setBackground(backgroundColor);
        guessScrollPane.setForeground(new Color(-4737097));
    }


    private void assembleTitlePanel() {


        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(backgroundColor);
        titlePanel.setForeground(new Color(-4737097));

        titleText = new JLabel("Mastermind");
        titleText.setFont(new Font("Arial", Font.ITALIC, 28));
        titleText.setBackground(backgroundColor);
        titleText.setForeground(new Color(-4737097));

        titlePanel.add(titleText);
    }

    public void setSecretCodeOnPanel() {

        char[] letters = getGuessString().toCharArray();

        currentGuessPanel.removeAll();

        Pin[] smallPins = new Pin[letters.length];
        for (int i = 0; i < smallPins.length; i++) {
            int index = -1;
            for (int j = 0; j < pinColorLetters.length; j++) {
                if (letters[i] == pinColorLetters[j]) {
                    index = j;
                    break;
                }
            }
            smallPins[i] = new Pin(pinColors[index], pinSmallDimension);
            secretCodePanel.add(smallPins[i]);
        }
        secretCodePanel.repaint();
        secretCodePanel.revalidate();

        currentGuessPanel.repaint();
        currentGuessPanel.revalidate();
    }

    public void displayResult(int correctColor, int correctPlace, int turn) {


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Turn " + turn, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        resultPanel.setBackground(backgroundColor);
        resultPanel.setForeground(new Color(-4737097));


        char[] letters = getGuessString().toCharArray();
        JPanel pinPanel = new JPanel();
        Pin[] smallPins = new Pin[letters.length];
        for (int i = 0; i < smallPins.length; i++) {
            int index = -1;
            for (int j = 0; j < pinColorLetters.length; j++) {
                if (letters[i] == pinColorLetters[j]) {
                    index = j;
                    break;
                }
            }
            smallPins[i] = new Pin(pinColors[index], pinSmallDimension);
            pinPanel.add(smallPins[i]);
            pinPanel.setBackground(backgroundColor);
            pinPanel.setForeground(new Color(-4737097));
        }


        JLabel resultText = new JLabel("C: " + correctColor + " P: " + correctPlace);
        resultText.setBackground(backgroundColor);
        resultText.setForeground(new Color(-4737097));

        resetGuessString();

        resultPanel.add(pinPanel);
        resultPanel.add(resultText);
        guessPanel.add(resultPanel);
        guessPanel.revalidate();
        guessPanel.repaint();

    }


    public void displayCurrentGuess() {

        char[] letters = getGuessString().toCharArray();

        currentGuessPanel.removeAll();

        Pin[] smallPins = new Pin[letters.length];
        for (int i = 0; i < smallPins.length; i++) {
            int index = -1;
            for (int j = 0; j < pinColorLetters.length; j++) {
                if (letters[i] == pinColorLetters[j]) {
                    index = j;
                    break;
                }
            }
            smallPins[i] = new Pin(pinColors[index], pinSmallDimension);
            currentGuessPanel.add(smallPins[i]);
        }
        currentGuessPanel.repaint();
        currentGuessPanel.revalidate();
    }


    public void displayMessage(String message) {

        JLabel label = new JLabel(message);
        guessPanel.add(label);
    }

    private synchronized void setGuessString(String guessString) {
        this.guessString = guessString;
    }

    private synchronized boolean willBeRepeated(char colorLetter) {
        if (guessString.indexOf(colorLetter) != -1) return true;
        else return false;
    }

    public synchronized String getGuessString() {
        return guessString;
    }

    public synchronized boolean hasGuessStringAvailable() {

        return hasGuessString;
    }

    public synchronized void setGuessStringAvailable(boolean availability) {
        hasGuessString = availability;
    }

    public synchronized void resetGuessString() {
        setGuessString("");
        submitGuessString = "";
        hasGuessString = false;
        displayCurrentGuess();
    }


    private class PinActionListener implements ActionListener {

        private char colorLetter;

        public PinActionListener(char colorLetter) {
            this.colorLetter = Character.toUpperCase(colorLetter);
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            if (!(willBeRepeated(colorLetter) && !canRepeat)) {
                if (getGuessString().length() < pinNumber) {

                    setGuessString(getGuessString() + colorLetter);

                    if (getGuessString().length() == pinNumber) submitGuessString = getGuessString();

                    displayCurrentGuess();
                }
            }
        }
    }
}
