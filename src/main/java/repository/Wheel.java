package repository;

import java.util.Objects;

/**
 *
 * @author proffskod
 */
public class Wheel extends Product{

    private final int id;
    private int price;
    private String name;
    private String imagePath;
    private int size;

    public Wheel(int id, int price, String name, String imagePath, int size) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.size = size;
        this.imagePath = Objects.requireNonNull(imagePath, "imagePath cannot be null");;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
