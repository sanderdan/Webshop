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
public class ContactController implements Controller {

    AjaxCart cart = new AjaxCart();

    @Override
    public void process(TemplateEngine engine,
            HttpServletRequest request,
            HttpServletResponse response,
            WebContext context) throws IOException {

        context.setVariable("size", cart.getCart(request).getCartSize());
        engine.process("contact", context, response.getWriter());
    }

}
