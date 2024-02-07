package TP2D;
import java.awt.Image;
public class Tile {
    private Image image;
    private int width;
    private int height;

    public Tile(Image image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

