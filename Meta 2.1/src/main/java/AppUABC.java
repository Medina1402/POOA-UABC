import game.WindowApp;
import game.tools.ImageTool;

import java.io.IOException;

public class AppUABC {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WindowApp app = new WindowApp("Windows");
        app.setIconImage(ImageTool.getImage("Images/d6k7z5f-88cd290d-d077-4a39-878f-8ebe97b1e0ed.png"));
    }
}
