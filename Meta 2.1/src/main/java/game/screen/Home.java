package game.screen;

import game.WindowApp;
import game.components.GButton;
import game.tools.FileManager;
import game.tools.ImageTool;
import game.typeData.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class Home extends JPanel {
    private WindowApp app;

    private JLabel centerIcon;
    private PopUp popUp;

    private GButton btnAdventure;
    private GButton btnSlots;
    private GButton btnCanalRAyman;
    private GButton btnNews;
    private GButton btnClose;


    public Home(final WindowApp app, int width, int height) throws IOException, ClassNotFoundException {
        final Home root = this;
        this.app = app;
        app.audio.run();

        setLayout(null);
        setSize(width, height);
        popUp = new PopUp(root);

        centerIcon = new JLabel();
        centerIcon.setSize((int) (width * 0.75), (int) (height * 0.75));
        centerIcon.setBounds((int) (((getWidth() - centerIcon.getWidth()) / 2) * 1.25), (getHeight() - centerIcon.getHeight()) / 2, centerIcon.getWidth(), centerIcon.getHeight());
        centerIcon.setIcon(ImageTool.resizeImage("Images/iconHome.png", centerIcon.getWidth(), centerIcon.getHeight()));

        btnAdventure = new GButton(new Vector2(150, 150), "Images/icons/Adventure.png");
        btnAdventure.setBounds((int) (getWidth() - btnAdventure.getWidth()) / 2, (int) (getHeight() - 200), btnAdventure.getWidth(), btnAdventure.getHeight());
        btnAdventure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!popUp.isVisible()) {
                    popUp.setVisible(true);
                    PopUp.isVisible = true;
                    popUp.repaint();
                } else {
                    popUp.setVisible(false);
                    PopUp.isVisible = false;
                }
                repaint();
            }
        });


        btnSlots = new GButton(new Vector2(100, 100), "Images/icons/Slots.png");
        btnSlots.setBounds(30, 30, btnSlots.getWidth(), btnSlots.getHeight());
        btnSlots.setToolTipText("Borrar personajes");
        btnSlots.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) JOptionPane.showMessageDialog(root, "Se borraran los personajes agregados");
                popUp.getActors().getActors().getActors().clear();
            }
        });


        btnCanalRAyman = new GButton(new Vector2(125, 100), "Images/icons/CanalRayman.png");
        btnCanalRAyman.setBounds(30, (int) (getHeight() - 30 - btnCanalRAyman.getHeight()), btnCanalRAyman.getWidth(), btnCanalRAyman.getHeight());
        btnCanalRAyman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) JOptionPane.showMessageDialog(root, "Aun no esta habilitado");
            }
        });


        btnNews = new GButton(new Vector2(100, 100), "Images/icons/News.png");
        btnNews.setBounds(getWidth() - btnAdventure.getWidth() - 30, (int) (getHeight() - 30 - btnNews.getHeight()), btnNews.getWidth(), btnNews.getHeight());
        btnNews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) JOptionPane.showMessageDialog(root, "Aun no esta habilitado");
            }
        });


        btnClose = new GButton(new Vector2(100, 100), "Images/icons/Close.png");
        btnClose.setBounds(getWidth() - btnClose.getWidth() - 30, 30, btnClose.getWidth(), btnClose.getHeight());
        btnClose.setToolTipText("Cerrar juego");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!PopUp.isVisible) {
                    try {
                        FileManager.Save(popUp.getActors().getActors(), PopUp.pathFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    app.audio.stop();
                    app.setVisible(false);
                    app.dispose();
                }
            }
        });

        add(btnClose);
        add(btnNews);
        add(btnCanalRAyman);
        add(btnSlots);
        add(centerIcon);
        add(btnAdventure);
        add(popUp);
        repaint();

        eventMoveLogoCenter();
    }

    private void eventMoveLogoCenter() {
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                final Point point = MouseInfo.getPointerInfo().getLocation();
                final Dimension screen = app.getSize();
                final int x = ((screen.width - point.x / 20) - centerIcon.getWidth() / 2) / 4;
                final int y = ((screen.height - point.y / 20) - centerIcon.getHeight() / 2) / 4;

                centerIcon.setBounds(x, y, centerIcon.getWidth(), centerIcon.getHeight());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(ImageTool.getImage("Images/background.jpg")).getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        if (PopUp.isVisible) {
            for (Component x : getComponents()) x.setVisible(false);
            popUp.setVisible(true);
        } else {
            for (Component x : getComponents()) x.setVisible(true);
            popUp.setVisible(false);
        }
        popUp.repaint();
        super.paint(g);
    }
}
