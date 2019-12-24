package game.components;

import java.io.Serializable;
import java.util.Vector;

public class CreateActors implements Serializable {
    private Vector<Actor> actors = new Vector<Actor>();

    public Vector<Actor> getActors() {
        return actors;
    }
}
