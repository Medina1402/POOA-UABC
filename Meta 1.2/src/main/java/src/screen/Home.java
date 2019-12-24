package src.screen;

import framework.Game;
import src.App;

public class Home extends GameScreen {
    private int contador = 0;

    public Home(App app) {
        super(app);
    }

    public void render() {
        System.out.println("Home " + contador++);
        if(contador >= 10) getApp().setScreens(getApp().juego);
    }
}
