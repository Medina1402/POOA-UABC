package framework.rendering;

import framework.Application;

import java.util.Timer;

/** Clase encargada de llamar al metodo renderizador, aplicando intervalos de tiempo para ello
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 */

public class Render extends Timer {
    private Task task;

    public Render() {
        task = new Task() {
            @Override
            public void render() {
                renderer();
            }
        };
        schedule(task, 0, 100 * Application.timerRenderer);
    }

    public void renderer() {

    }
}
