package game.components;

import game.tools.ImageTool;
import game.typeData.Vector2;

import java.awt.*;
import java.io.Serializable;

public class Actor implements Serializable {
    private Vector2 position;
    private String image;

    public Actor(Vector2 position, String image) {
        this.position = position;
        this.image = image;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Image getImage() {
        return ImageTool.getImage(image);
    }

    public void render(Graphics g, int width, int height, int posX, int posY) {
        g.drawImage(getImage(), posX, posY, width, height, null);
    }
}
