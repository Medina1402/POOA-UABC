package src.screen;

import framework.Game;
import framework.math.Vector2;
import framework.scene2d.Stage;
import src.App;
import src.entities.Persona1;

public class Juego extends GameScreen {
    private Stage stage;

    public Juego(App app) {
        super(app);
        stage = new Stage();
        stage.addActor(new Persona1(new Vector2(5f, 5f)));
        stage.addActor(new Persona1(new Vector2(4f, 4f)));
        stage.addActor(new Persona1(new Vector2(2f, 9f)));
    }

    public void render() {
        stage.act();
    }
}
