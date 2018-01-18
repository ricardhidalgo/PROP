package Presentation;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author ricard.hidalgo
 */

public class Pin extends JPanel {

    private Color color;
    private char colorLetter;
    private Dimension dimension;
    private int diameter;
    private EventListenerList listenerList;

    public Pin(Color color, Dimension dimension) {
        this(color, '#', dimension);
    }

    public Pin(Color color, char colorLetter, Dimension dimension) {
        super();
        this.color = color;
        this.colorLetter = colorLetter;
        this.dimension = dimension;
        diameter = dimension.width - 2;
        setPreferredSize(dimension);
        listenerList = new EventListenerList();
        addMouseListener(new PinMouseAdapter());
        setBackground(new Color(-12501697));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Paint circle
        g.setColor(color);
        g.fillOval(0, 0, dimension.width - 2, dimension.height - 2);

        //Paint stroke
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, dimension.width - 2, dimension.height - 2);
    }

    public Color getColor() {
        return color;
    }

    public char getColorLetter() {
        return colorLetter;
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    private void fireActionEvent(ActionEvent e) {

        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == ActionListener.class) {
                ((ActionListener) listeners[i + 1]).actionPerformed(e);
            }
        }
    }

    private class PinMouseAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            fireActionEvent(new ActionEvent(this, ActionEvent.ACTION_FIRST, ""));
        }
    }
}
