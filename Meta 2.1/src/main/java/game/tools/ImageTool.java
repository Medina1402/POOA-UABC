package game.tools;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageTool {
    public static java.awt.Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    public static Icon resizeImage(final String pathAndFileName, int width, int height) {
        final ImageIcon imageLogo = new ImageIcon(ImageTool.getImage(pathAndFileName));
        return new ImageIcon(imageLogo.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
