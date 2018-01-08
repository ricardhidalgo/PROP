package Presentation;

import javax.swing.*;
import java.awt.*;

public class Mastermind {

    public static void main(String args[]) {
        Screen screen = new Screen(600, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setLocation(dim.width / 2 - screen.getSize().width / 2, dim.height / 2 - screen.getSize().height / 2);
        screen.pack();
        screen.setVisible(true);
    }
}
