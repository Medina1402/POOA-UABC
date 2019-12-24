package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Button extends JButton {
    private Color enterer = ColorFlat.PastelRed;
    private Color over = ColorFlat.ImperialPrime;

    public Button(String text) {
        setText(text);
        setBorder(null);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorderPainted(false);
        setFocusable(false);
        setForeground(ColorFlat.LightBlueBallerina);
        setBackground(ColorFlat.ImperialPrime);

        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                if(isEnabled()) setBackground(enterer);
            }

            public void mouseExited(MouseEvent e) {
                setBackground(over);
                setForeground(getForeground());
            }
        });
    }

    public void setColorEntered(Color color) {
        this.enterer = color;
    }

    public void setColorOver(Color color) {
        this.over = color;
    }
}
