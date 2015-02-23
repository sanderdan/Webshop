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
public class BillingController implements Controller {

    @Override
    public void process(TemplateEngine engine,
            HttpServletRequest request,
            HttpServletResponse response,
            WebContext context) throws IOException {

        AjaxCart ajax = new AjaxCart();

        BillingInformation info = new BillingInformation(request);
        info.writeReceiptToJSON(request);
        context.setVariable("total", ajax.getCart(request).getCartTotal());
        context.setVariable("cart", ajax.getCart(request).viewCart());
        context.setVariable("input", info.getInputs());
        engine.process("order", context, response.getWriter());
    }
}
