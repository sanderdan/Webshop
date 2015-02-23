package com.projectwebshop;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author proffskod
 */
public class CartController implements Controller {

    AjaxCart ajax = new AjaxCart();

    @Override
    public void process(TemplateEngine engine,
            HttpServletRequest request,
            HttpServletResponse response,
            WebContext context) throws IOException {

        context.setVariable("size", ajax.getCart(request).getCartSize());
        context.setVariable("cart", ajax.getCart(request).viewCart());
        context.setVariable("total", ajax.getCart(request).getCartTotal());
        engine.process("cart", context, response.getWriter());
    }

}
