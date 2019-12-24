package game.tools;

import game.components.Actor;
import game.components.CreateActors;

import java.io.*;
import java.util.Vector;

public class FileManager implements Serializable {
    public static void Save(CreateActors vector, String path) throws IOException, NullPointerException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(vector);
        bufferedOutputStream.flush();

        objectOutputStream.close();
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    public static CreateActors Load(String path) throws IOException, ClassNotFoundException {
        CreateActors vector = null;
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        vector = (CreateActors) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return vector;
    }
}
