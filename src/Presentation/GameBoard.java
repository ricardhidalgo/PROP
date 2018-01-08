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
    private int pinNumber;
    private Color[] pinColors;
    private char[] pinColorLetters;
    private int currentTurn;


    private JPanel buttonsPanel;
    private JPanel pinPanel;
    private Pin[] pins;
    private JPanel currentGuessPanel;
    private JButton clear;
    private JButton submit;
    private JButton saveButton;


    private JScrollPane guessScrollPane;
    private JPanel guessPanel;


    private JPanel titlePanel;
    private JLabel titleText;


    private final Dimension buttonDimension = new Dimension(130, 30);
    private final Dimension pinDimension = new Dimension(40, 40);
    private final Dimension pinSmallDimension;


    public GameBoard(int pinNumber, char[] pinColorLetters, Color[] pinColors) {

        currentTurn = 0;

        setSize(new Dimension(400, 600));
        setBackground(backgroundColor);
        setForeground(backgroundColor);
        setLayout(new BorderLayout());

        this.pinNumber = pinNumber;
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
        submit.addActionListener(listener);
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public JButton getSubmit() {
        return submit;
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
        currentGuessPanel.setPreferredSize(new Dimension(140, 60));
        currentGuessPanel.setBackground(backgroundColor);
        currentGuessPanel.setForeground(backgroundColor);


        submit = new JButton("Submit Guess");
        submit.setPreferredSize(buttonDimension);
        submit.addActionListener((ActionEvent e) -> {
            setGuessStringAvailable(true);
        });


        clear = new JButton("Clear Guess");
        clear.setPreferredSize(buttonDimension);
        clear.addActionListener((ActionEvent e) -> {
            setGuessString("");
            setGuessStringAvailable(false);
            submitGuessString = "";
            displayCurrentGuess();
        });

        saveButton = new JButton(("Save"));
        saveButton.setPreferredSize(buttonDimension);


        buttonsPanel.add(pinPanel);
        buttonsPanel.add(currentGuessPanel);
        buttonsPanel.add(submit);
        buttonsPanel.add(clear);
        buttonsPanel.add(saveButton);
    }

    private void assembleGuessPanel() {


        guessPanel = new JPanel();
        guessPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        guessPanel.setPreferredSize(new Dimension(200, 800));
        guessPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Guess Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        guessPanel.setBackground(backgroundColor);


        guessScrollPane = new JScrollPane(guessPanel);
        guessScrollPane.setBorder(null);
        guessScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        guessScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        guessScrollPane.setBackground(backgroundColor);
    }


    private void assembleTitlePanel() {


        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(backgroundColor);

        titleText = new JLabel("Mastermind");
        titleText.setFont(new Font("Arial", Font.ITALIC, 28));
        titleText.setBackground(backgroundColor);
        titleText.setForeground(new Color(-4737097));

        titlePanel.add(titleText);
    }


    public void displayResult(int correctColor, int correctPlace, int turn) {


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Turn " + turn));
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
        }


        JLabel resultText = new JLabel("C: " + correctColor + " P: " + correctPlace);

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

            if (getGuessString().length() < pinNumber) {

                setGuessString(getGuessString() + colorLetter);

                if (getGuessString().length() == pinNumber) submitGuessString = getGuessString();

                displayCurrentGuess();
            }
        }
    }
}
