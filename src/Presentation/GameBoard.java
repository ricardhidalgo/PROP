package Presentation;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel {

    //This is the current guess and other related variables
    private Color backgroundColor = new Color(-12501697);
    private String guessString = "";
    private boolean hasGuessString = false;
    private int pinNumber;
    private Color[] pinColors;
    private char[] pinColorLetters;

    //Options panel to hold all the buttons
    private JPanel buttonsPanel;
    private JPanel pinPanel;
    private Pin[] pins;
    private JPanel currentGuessPanel;
    private JButton clear;
    private JButton submit;

    //Guess panel to show all of the previous guesses
    private JScrollPane guessScrollPane;
    private JPanel guessPanel;

    //The title panel to just display the title
    private JPanel titlePanel;
    private JLabel titleText;

    //Dimensions
    private final Dimension buttonDimension = new Dimension(130, 30);
    private final Dimension pinDimension = new Dimension(40, 40);
    private final Dimension pinSmallDimension;

    //Create the mastermind gui
    public GameBoard(int pinNumber, char[] pinColorLetters, Color[] pinColors) {

        setSize(new Dimension(400, 600));
        setBackground(backgroundColor);
        setForeground(backgroundColor);
        setLayout(new BorderLayout());

        //Set instance variables
        this.pinNumber = pinNumber;
        this.pinColors = pinColors;
        this.pinColorLetters = pinColorLetters;
        pinSmallDimension = new Dimension((int) (140 / (pinNumber + 2)), (int) (140 / (pinNumber + 2)));

        //Create the buttons panel
        assembleButtonsPanel();

        //Create the guessPanel
        assembleGuessPanel();

        //Create the title panel        
        assembleTitlePanel();

        //Add the panels to the main frame
        add(titlePanel, BorderLayout.NORTH);
        add(guessScrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.EAST);
    }

    //Panel assembling functions
    //Assemble the buttons panel
    private void assembleButtonsPanel() {

        //Create the components
        //Panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 3));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Button Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        buttonsPanel.setPreferredSize(new Dimension(150, 500));
        buttonsPanel.setBackground(backgroundColor);
        buttonsPanel.setForeground(backgroundColor);

        //Create the pin panel
        pinPanel = new JPanel();
        pinPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //pinPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "mastermind.swing.Pin Panel"));
        pinPanel.setPreferredSize(new Dimension(140,
                ((int) (Math.ceil(pinColorLetters.length / 3) + 1) * (pinDimension.width + 5))));
        pinPanel.setBackground(backgroundColor);
        pinPanel.setForeground(backgroundColor);

        //Create the pins
        pins = new Pin[pinColors.length];
        for (int i = 0; i < pins.length; i++) {
            pins[i] = new Pin(pinColors[i], pinColorLetters[i], pinDimension);
            pins[i].addActionListener(new PinActionListener(pinColorLetters[i]));
            pinPanel.add(pins[i]);
        }

        //Current guess panel
        currentGuessPanel = new JPanel();
        currentGuessPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        currentGuessPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Guess", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new Color(-4737097)));
        currentGuessPanel.setPreferredSize(new Dimension(140, 60));
        currentGuessPanel.setBackground(backgroundColor);
        currentGuessPanel.setForeground(backgroundColor);

        //Create the submit button
        submit = new JButton("Submit Guess");
        submit.setPreferredSize(buttonDimension);
        submit.addActionListener((ActionEvent e) -> {
            setGuessStringAvailable(true);
        });

        //Create the clear button
        clear = new JButton("Clear Guess");
        clear.setPreferredSize(buttonDimension);
        clear.addActionListener((ActionEvent e) -> {
            setGuessString("");
            setGuessStringAvailable(false);
            displayCurrentGuess();
        });

        //Add everything
        buttonsPanel.add(pinPanel);
        buttonsPanel.add(currentGuessPanel);
        buttonsPanel.add(submit);
        buttonsPanel.add(clear);
    }

    //Assemble the buttons panel
    private void assembleGuessPanel() {

        //Create the components        
        //Panel
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

    //Assemble the title panel
    private void assembleTitlePanel() {

        //Create the components
        //Panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(backgroundColor);

        //Text
        titleText = new JLabel("Mastermind");
        titleText.setFont(new Font("Arial", Font.ITALIC, 28));
        titleText.setBackground(backgroundColor);
        titleText.setForeground(new Color(-4737097));

        //Add everything
        titlePanel.add(titleText);
    }

    //Display the guesses result on the screen
    public void displayResult(int correctColor, int correctPlace, int turn) {

        //Create a base panel for result
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Turn " + turn));

        //Create the small pins
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

        //Create the result label
        JLabel resultText = new JLabel("C: " + correctColor + " P: " + correctPlace);

        //Add the new result panel
        resultPanel.add(pinPanel);
        resultPanel.add(resultText);
        guessPanel.add(resultPanel);
        guessPanel.revalidate();
        guessPanel.repaint();
    }

    //This will update the display of the current guess
    public void displayCurrentGuess() {

        //Deconstruct the string into array
        char[] letters = getGuessString().toCharArray();

        //Remove previous guess
        currentGuessPanel.removeAll();

        //Create an array of small pins based on the letters in the guess string
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

    //Display a message on the Guess panel
    public void displayMessage(String message) {

        JLabel label = new JLabel(message);
        guessPanel.add(label);
    }

    //Manage the guessString
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
        hasGuessString = false;
        displayCurrentGuess();
    }

    //Start the game
    public void start() {
        setVisible(true);
    }

    //Stop the game
    public void stop() {
        //dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    //The action listener for when a pin is clicked
    private class PinActionListener implements ActionListener {

        private char colorLetter;

        public PinActionListener(char colorLetter) {
            this.colorLetter = Character.toUpperCase(colorLetter);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            //Check if the string is max size
            if (getGuessString().length() < pinNumber) {

                //Add to the guessString
                setGuessString(getGuessString() + colorLetter);

                //Update the current pin string display
                displayCurrentGuess();
            }
        }
    }
}
