package Presentation;

import javax.swing.*;
import java.awt.*;

public class Mastermind {

    public static void main(String args[]) {
        Screen screen = new Screen(600, 800);
        screen.pack();
        screen.setVisible(true);

        /*
        char[] pinColorLetters = new char[]{'R', 'G', 'B', 'O', 'Y', 'P'};
        int maxTurns = 10;
        int pinNumber = 4;

        JFrame frame = new JFrame();
        Color[] pinColors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW, new Color(150, 0, 255)};
        GameBoard gui = new GameBoard(pinNumber, pinColorLetters, pinColors);
        frame.add(gui);
        frame.pack();
        frame.setVisible(true);
        */
    }
}
