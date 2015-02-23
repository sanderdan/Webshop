package com.projectwebshop;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import repository.DecksMockup;
import repository.Product;
import repository.WheelsMockup;

/**
 *
 * @author proffskod
 */
public class Cart {

    private final HashMap<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addProduct(Product product, HttpServletResponse resp) {
        try {
            if (cart.containsKey(product)) {
                int existingAmount = cart.get(product);
                cart.put(product, existingAmount + 1);
            } else {
                cart.put(product, 1);
            }
            HashMap<String, String> response = new HashMap<>();
            response.put("success", "true");
            response.put("itemsInCart", String.valueOf(getCartSize()));
            resp.getWriter().println(new Gson().toJson(response));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Product> getContents() {
        ArrayList<Product> allProducts = new ArrayList<>();
        DecksMockup decks = new DecksMockup();
        WheelsMockup wheels = new WheelsMockup();
        allProducts.addAll(decks.getDecks());
        allProducts.addAll(wheels.getWheels());

        return allProducts;
    }

    public HashMap<Product, Integer> viewCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public void removeProduct(Product product, HttpServletResponse resp) {
        try {
            cart.remove(product);

            HashMap<String, String> response = new HashMap<>();
            response.put("success", "true");
            response.put("itemsInCart", String.valueOf(getCartSize()));
            resp.getWriter().println(new Gson().toJson(response));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int getCartTotal() {

        int total = 0;
        for (Product product : cart.keySet()) {
            total = total + product.getPrice() * cart.get(product);
        }
        return total;
    }

    public int getCartSize() {
        int size = 0;
        for (Integer i : cart.values()) {
            size = size + i;
        }
        return size;
    }
    
}
