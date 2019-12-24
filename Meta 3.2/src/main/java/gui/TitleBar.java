package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class TitleBar extends JPanel {
    private Button close;

    public TitleBar(int x, int y, int width, int height) {
        setBounds(x, y, width, 35);
        setBackground(ColorFlat.ImperialPrime);
        setLayout(null);

        close = new Button("x");
        close.setBounds(width - getHeight(), 0, getHeight(), getHeight());
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(close);
    }
}
