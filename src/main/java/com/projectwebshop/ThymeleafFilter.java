package com.projectwebshop;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author proffskod
 */
public class ThymeleafFilter implements Filter {

    private static TemplateEngine engine;
    private static ServletContext servletContext;
    private HashMap<String, Controller> templates;

    /**
     *
     * 
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/WEB-INF/");
        templateResolver.setSuffix(".html");

        templates = new HashMap<>();
        templates.put("/", new HomeController());
        templates.put("/contact", new ContactController());
        templates.put("/cart", new CartController());
        templates.put("/store", new StoreController());
        templates.put("/order", new BillingController());

        engine = new TemplateEngine();
        engine.setTemplateResolver(templateResolver);
    }

    /**
     * 1. Get Thymeleaf's TemplateEngine 
     * 2. Identify ... 
     * 3. Call TemplateEngine with template
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("text/html");

        WebContext context = new WebContext(
                httpRequest, httpResponse,
                servletContext,
                request.getLocale()
        );

        String path = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();
        path = path.substring(contextPath.length());

        Controller controller = templates.get(path);

        if (controller != null) {
            controller.process(engine, httpRequest, httpResponse, context);
        } else {
           
            chain.doFilter(request, response);
//            engine.process("error", context, response.getWriter());
//            (httpResponse).setStatus(404);
        }
    }

    @Override
    public void destroy() {
        
    }

}