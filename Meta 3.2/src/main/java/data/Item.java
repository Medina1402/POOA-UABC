package data;

import java.io.Serializable;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Item implements Serializable {
    private String author;
    private String titleSong;
    private int index;

    public Item(String author, String titleSong, int index) {
        this.author = author;
        this.titleSong = titleSong;
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitleSong() {
        return titleSong;
    }

    @Override
    public String toString() {
        return String.format("%d%20s%20s", index+1, titleSong, author);
    }
}
