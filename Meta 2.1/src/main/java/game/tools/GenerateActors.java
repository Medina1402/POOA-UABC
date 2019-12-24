package game.tools;

import game.components.Actor;
import game.components.CreateActors;

import java.awt.*;
import java.util.Random;

public class GenerateActors {
    public static int Random(int number) {
        return new Random().nextInt(number);
    }

    private final static String[] images = {
            "Barbara.png",
            "Sniffler.png",
            "Scrub.png",
            "Gumgum.png"
    };

    public static String randomImageName() {
        final String path = "Images/Actors/";
        final int number = Random(images.length);
        return path + "" + images[number];
    }

    public static class Actors {
        private CreateActors actors = new CreateActors();

        public void addActor(Actor actor) {
            actors.getActors().add(actor);
        }

        public CreateActors getActors() {
            return actors;
        }

        public void render(Graphics g) {
            for (Actor x : actors.getActors()) {
                g.drawImage(x.getImage(), x.getImage().getWidth(null), x.getImage().getHeight(null), x.getPosition().getX(), x.getPosition().getY(), null);
            }
        }
    }
}
