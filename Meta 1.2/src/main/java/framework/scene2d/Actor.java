package framework.scene2d;

import framework.math.Vector2;

/**
 * Entidad principal, se agregara al Stage para su renderizado
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 * @see Vector2
 */

public abstract class Actor {
    private Vector2 position;

    public Actor() {
        position = new Vector2(0, 0);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public Vector2 getPosition() {
        return position;
    }
}
