package framework;

import src.App;

/**
 * Clase principal que contiene los metodos principales como Render
 * @author <a href="https://github.com/medina1402">Abraham Medina Carrillo</a>
 * @see framework.rendering.Render
 * @see App
 */

public abstract class Game {
    private boolean isShow = false;
    private App app;

    // Se requiere a la clase que administra a las hijas
    // por ellos se crea una instancia en cada pantalla
    // con ello podemos acceder a sus propiedades sin que
    // estas sean estaticas
    public Game(App app) {
        this.app = app;
        if(getShow()) show();
    }

    public App getApp() {
        return app;
    }

    public void setShow() {
        isShow = !isShow;
    }

    public boolean getShow() {
        return isShow;
    }

    /**
     * Reemplazara al constructor, si es la pantalla actual se renderizara
     */

    public abstract void show();

    /**
     * Tendra todos nuestros objetos que se actualizaran constantemente
     */

    public abstract void render();
}
