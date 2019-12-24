package game.screen;

import game.components.Actor;
import game.components.CreateActors;
import game.components.GButton;
import game.tools.FileManager;
import game.tools.GenerateActors;
import game.typeData.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class PopUp extends JPanel {
    public static boolean isVisible = false;
    public static String pathFile = "data.dat";

    private GenerateActors.Actors actors;

    private GButton back;
    private JPanel _root;

    public PopUp(JPanel root) throws IOException, ClassNotFoundException {
        actors = new GenerateActors.Actors();
        CreateActors x = FileManager.Load(pathFile);
        for (Actor actor : x.getActors()) actors.addActor(actor);

        _root = this;
        setLayout(null);
        setDefaultLocale(null);
        setBounds(0, 0, root.getWidth(), root.getHeight());
        setBackground(Color.ORANGE);

        init();
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                final Actor actor = new Actor(new Vector2(e.getX(), e.getY()), GenerateActors.randomImageName());
                actors.addActor(actor);
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        setVisible(false);
    }

    public GenerateActors.Actors getActors() {
        return actors;
    }

    private void init() {
        back = new GButton(new Vector2(150, 50), "");
        back.setText("REGRESAR");
        back.setBackground(Color.WHITE);
        back.setContentAreaFilled(true);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (PopUp.isVisible) {
                    back.setBackground(Color.WHITE);
                    _root.setVisible(false);
                    PopUp.isVisible = false;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (PopUp.isVisible) back.setBackground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (PopUp.isVisible) back.setBackground(Color.WHITE);
            }
        });
        add(back);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Actor x : actors.getActors().getActors()) {
            final int width = x.getImage().getWidth(null) / 5;
            final int height = x.getImage().getHeight(null) / 5;

            final int pox = x.getPosition().getX() - (width / 2);
            final int poy = x.getPosition().getY() - (height / 2);

            x.render(g, width, height, pox, poy);
        }
        back.paint(g);
    }
}
