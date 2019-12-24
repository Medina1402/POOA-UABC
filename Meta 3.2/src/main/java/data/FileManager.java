package data;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class FileManager {
    public static String PATHName = "assets.txt";

    public static boolean loadFileClass(String path) {
        File archivo = new File(path);
        if(archivo.exists()) return true;
        return false;
    }

    public static ItemList loadClass(String path) {
        if(!loadFileClass(path)) return new ItemList();

        ItemList temp = null;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);

            temp = (ItemList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static void Save(ItemList vector, String path) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(vector);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static java.awt.Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    public static Icon resizeImage(final String pathAndFileName, int width, int height) {
        final ImageIcon imageLogo = new ImageIcon(pathAndFileName);
        return new ImageIcon(imageLogo.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
