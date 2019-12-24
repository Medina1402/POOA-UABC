package framework.scene2d;

import java.util.Vector;

/**
 * Contendra a los actores para su renderizacion
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 * @see Actor
 */

public class Stage {
    private Vector<Actor> actors;

    public Stage() {
        actors = new Vector<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void act() {
        actors.forEach( e -> System.out.println(e.getPosition().x++));
        System.out.println("\nPantalla de Juego");
    }
}
