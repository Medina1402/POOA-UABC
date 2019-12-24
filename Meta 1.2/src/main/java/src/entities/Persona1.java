package src.entities;

import framework.math.Vector2;
import framework.scene2d.Actor;

public class Persona1 extends Actor {
    public Persona1() {
        setPosition(new Vector2(5f, 5f));
    }

    public Persona1(Vector2 position) {
        setPosition(position);
    }
}
