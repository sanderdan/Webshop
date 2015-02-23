package com.projectwebshop;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author sander
 */
public interface Controller {

    public void process(
            TemplateEngine engine,
            HttpServletRequest request,
            HttpServletResponse response,
            WebContext context) throws IOException;

}
