package repository;

import java.util.ArrayList;

/**
 *
 * @author proffskod
 */
public class WheelsMockup {

    private final ArrayList<Product> wheelList = new ArrayList<>();

    private void createDecks() {

        // order : Brand, name, price, imagePath
        Wheel wheel1 = new Wheel(13, 400, "Soft D´s 95 Du", "/img/decks/decks1.jpg", 52);
        Wheel wheel2 = new Wheel(14, 280, "100 s P.P. Assorted ", "img/decks/decks2.jpg", 53);
        Wheel wheel3 = new Wheel(15, 400, "Spf Tony Hawk Eye ", "img/decks/decks3.jpg", 56);
        Wheel wheel4 = new Wheel(16, 280, "100 s P.P. Black", "img/decks/decks4.jpg", 52);
        Wheel wheel5 = new Wheel(17, 549, "SFT Bingaman", "img/decks/decks5.jpg", 54);
        Wheel wheel6 = new Wheel(18, 549, "SFT Gustavo", "img/decks/decks6.jpg", 52);
        Wheel wheel7 = new Wheel(19, 280, "Bones 100´S P.P Wheels", "img/decks/decks7.jpg", 52);
        Wheel wheel8 = new Wheel(20, 280, "Bones 100´S P.P Wheels", "img/decks/decks8.jpg", 51);
        Wheel wheel9 = new Wheel(21, 549, "STF Ryan Decenzo", "img/decks/decks9.jpg", 54);
        Wheel wheel10 = new Wheel(22, 549, "SFT Bingaman", "img/decks/decks10.jpg", 51);
        Wheel wheel11 = new Wheel(23, 499, "STF Chad Bartie", "img/decks/decks11.jpg", 53);
        Wheel wheel12 = new Wheel(24, 499, "SPF Pat Ngoho", "img/decks/decks12.jpg", 56);

        wheelList.add(wheel1);
        wheelList.add(wheel2);
        wheelList.add(wheel3);
        wheelList.add(wheel4);
        wheelList.add(wheel5);
        wheelList.add(wheel6);
        wheelList.add(wheel7);
        wheelList.add(wheel8);
        wheelList.add(wheel9);
        wheelList.add(wheel10);
        wheelList.add(wheel11);
        wheelList.add(wheel12);

    }

    public ArrayList<Product> getWheels() {
        if (wheelList.isEmpty()) {
            createDecks();
        }
        return wheelList;
    }
}
