package com.projectwebshop;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import repository.WheelsMockup;
import repository.DecksMockup;
import repository.Product;

/**
 *
 * @author proffskod
 */
public class StoreController implements Controller {

    AjaxCart cart = new AjaxCart();
    
    @Override
    public void process(TemplateEngine engine,
            HttpServletRequest request,
            HttpServletResponse response,
            WebContext context) throws IOException {

        // Create products
        DecksMockup decks = new DecksMockup();
        WheelsMockup wheels = new WheelsMockup();
        ArrayList<Product> allDecks = decks.getDecks();
        ArrayList<Product> allWheels = wheels.getWheels();
        
        context.setVariable("size", cart.getCart(request).getCartSize());
        context.setVariable("decks", allDecks);
        context.setVariable("wheels", allWheels);
        engine.process("store", context, response.getWriter());
    }

}
