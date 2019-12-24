package game.components;

import game.screen.PopUp;
import game.tools.ImageTool;
import game.typeData.Vector2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GButton extends JButton {
    private JButton root;
    private String path;

    public GButton(Vector2 size, String pathImage) {
        root = this;
        path = pathImage;

        setSize(size.getX(), size.getY());
        setContentAreaFilled(false);
        setBorderPainted(false);

        setIcon(ImageTool.resizeImage(pathImage, getWidth(), getHeight()));
//        setRolloverIcon( ImageTool.resizeImage(pathImage, (int) (getWidth() * 0.75), (int) (getHeight() * 0.75)));
//        setPressedIcon( ImageTool.resizeImage(pathImage, getWidth(), getHeight()) );

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!PopUp.isVisible) setIcon(ImageTool.resizeImage(path, getWidth() / 2, getHeight() / 2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!PopUp.isVisible) setIcon(ImageTool.resizeImage(path, getWidth(), getHeight()));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setIcon(ImageTool.resizeImage(path, getWidth(), getHeight()));
            }
        });
    }
}
