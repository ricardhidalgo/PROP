//package Presentation;

import javax.swing.*;
import java.awt.*;

import Presentation.Screen;

/**
 * @author ricard.hidalgo
 */

public class Mastermind {

    public static void main(String args[]) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Screen screen = new Screen(200, dim.height - 30);
        //screen.setLocation(dim.width / 2 - screen.getSize().width / 2, dim.height / 2 - screen.getSize().height / 2);
        screen.pack();
        screen.setVisible(true);
    }
}
