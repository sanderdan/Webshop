package repository;

import java.util.Objects;

/**
 *
 * @author proffskod
 */
public class Deck extends Product {
    
    private final int id;
    private String name;
    private int price;
    private String imagePath;
        
    public Deck(int id, int price, String name, String imagePath){
        this.id = id;
        this.price = price;
        this.name = name;Objects.requireNonNull(name, "Name cannot be null");
        this.imagePath = Objects.requireNonNull(imagePath, "imagePath cannot be null");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
    
    
}
