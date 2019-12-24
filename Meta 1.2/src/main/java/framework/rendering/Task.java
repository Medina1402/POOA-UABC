package framework.rendering;

import java.util.TimerTask;

/**
 * Clase encargada de la ejecucion del metodo run() al heredarse de Game
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 * @see framework.Game
 */

public abstract class Task extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        render();
    }

    public abstract void render();
}
