package src;

import framework.Application;
import src.screen.Home;
import src.screen.Juego;

public class App extends Application {
    public Home home;
    public Juego juego;

    public App() {
        home = new Home(this);
        juego = new Juego(this);

        addScreen(home);
        addScreen(juego);
    }


    public static void main(String[] args) {
        new App();
    }
}
