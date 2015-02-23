package com.projectwebshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import repository.DecksMockup;
import repository.Product;
import repository.WheelsMockup;

/**
 *
 * @author proffskod
 */
public class AjaxCart extends HttpServlet {

    private static final String SESSION_CART = "cart";
    private final ArrayList<Product> allProducts = new ArrayList<>();
    private final DecksMockup decks = new DecksMockup();
    private final WheelsMockup wheels = new WheelsMockup();

    public Cart getCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute(SESSION_CART);
        if (cart == null) {
            cart = new Cart();
            session.setAttribute(SESSION_CART, cart);
        }
        return cart;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = getCart(req);
        allProducts.addAll(decks.getDecks());
        allProducts.addAll(wheels.getWheels());

        HttpSession session = req.getSession();

        String path = req.getServletPath();
        resp.setContentType(MediaType.APPLICATION_JSON);
        if (path.equals("/cart/add")) {
            try {
                int productId = Integer.parseInt(req.getParameter("productID"));
                Product product = allProducts.get(productId - 1);
                cart.addProduct(product, resp);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } else if (path.equals("/cart/clear")) {
            cart.clearCart();
        } else if (path.equals("/cart/remove")) {
            try {
                int productId = Integer.parseInt(req.getParameter("productID"));
                Product product = allProducts.get(productId - 1);
                cart.removeProduct(product, resp);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public int getCartSize() {
        Cart cart = new Cart();
        HashMap<Product, Integer> sessionCart = cart.viewCart();
        int size = 0;
        for (Integer i : sessionCart.values()) {
            size = size + i;
        }
        return size;
    }
}
