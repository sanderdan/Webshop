package repository;

import java.util.ArrayList;

/**
 *
 * @author proffskod
 */
public class DecksMockup {

    private final ArrayList<Product> deckList = new ArrayList<>();

    private void createProducts() {

        // order : Brand, name, price, imagePath
        Deck skate1 = new Deck(1, 560, "First Name Basis Miller", "img/skateboards/skateBoard1.jpg");
        Deck skate2 = new Deck(2, 520,"Organika Homeland", "img/skateboards/skateBoard2.jpg");
        Deck skate3 = new Deck(3, 480, "New Price Point", "img/skateboards/skateBoard3.jpg");
        Deck skate4 = new Deck(4, 520, "Organika Bridge Exodus", "img/skateboards/skateBoard4.jpg");
        Deck skate5 = new Deck(5, 520, "Botanical Watson Deck","img/skateboards/skateBoard5.jpg");
        Deck skate6 = new Deck(6, 520, "Organika Love All Reed","img/skateboards/skateBoard6.jpg");
        Deck skate7 = new Deck(7, 560, "DGK Sean Cliver Girls TX", "img/skateboards/skateBoard7.jpg");
        Deck skate8 = new Deck(8, 560, "DGK Sean Cliver Girls Boo B", "img/skateboards/skateBoard8.jpg");
        Deck skate9 = new Deck(9, 560,"DGK Sean Cliver Girls Kalis", "/img/skateboards/skateBoard9.jpg");
        Deck skate10 = new Deck(10, 560, "DGK Sean Cliver Quise", "img/skateboards/skateBoard10.jpg");
        Deck skate11 = new Deck(11, 560, "DGK King Henry Deck", "img/skateboards/skateBoard11.jpg");
        Deck skate12 = new Deck(12, 560, "Ghettolicious TX", "img/skateboards/skateBoard12.jpg");

        deckList.add(skate1);
        deckList.add(skate2);
        deckList.add(skate3);
        deckList.add(skate4);
        deckList.add(skate5);
        deckList.add(skate6);
        deckList.add(skate7);
        deckList.add(skate8);
        deckList.add(skate9);
        deckList.add(skate10);
        deckList.add(skate11);
        deckList.add(skate12);

    }

    public ArrayList<Product> getDecks() {
        if (deckList.isEmpty()) {
            createProducts();
        }
        return deckList;
    }
}
