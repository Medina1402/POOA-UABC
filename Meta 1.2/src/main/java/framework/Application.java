package framework;

import framework.rendering.Render;

import java.util.Vector;

/**
 * Controlador de pantallas y su estado, solo puede renderizar una a la vez
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 * @see Game
 */

public abstract class Application extends Render {
    public static int timerRenderer = 5;

    private Game actual;
    private Vector<Game> screens;

    public Application() {
        screens = new Vector<>();
    }

    /**
     * Agrega la pantalla para su posible renderizacion como principal
     * @param screen Pantalla para su posible uso en cualquier otro estado
     */

    public void addScreen(Game screen) {
        screens.add(screen);
        if(screens.size() <= 1) actual = screen;
    }

    public void setScreens(Game screen) {
        for(int k=0; k<screens.size(); k++) {
            if(screens.get(k) == screen) {
                actual.setShow(); // Ocultar pantalla actual
                actual = screens.get(k); // Selecciona la siguiente pantalla a renderizar
                actual.setShow(); // Mostrar nueva pantalla actual
            }
        }
    }

    @Override
    public void renderer() {
        actual.render();
    }
}
