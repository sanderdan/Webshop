package com.projectwebshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import repository.Product;

/**
 *
 * @author proffskod
 */
public class BillingInformation {

    ArrayList<String> inputs = new ArrayList<>();

    public BillingInformation(HttpServletRequest req) {

        try {
            req.setCharacterEncoding("UTF-8");

            String firstNameInput = req.getParameter("firstName");
            String lastNameInput = req.getParameter("lastName");
            String addressInput = req.getParameter("address");
            String cityInput = req.getParameter("city");
            String zipcodeInput = req.getParameter("zipcode");
            String countryInput = req.getParameter("country");
            String mailInput = req.getParameter("mail");
            String messageTextarea = req.getParameter("message");

            inputs.add(firstNameInput);
            inputs.add(lastNameInput);
            inputs.add(addressInput);
            inputs.add(cityInput);
            inputs.add(zipcodeInput);
            inputs.add(countryInput);
            inputs.add(mailInput);
            inputs.add(messageTextarea);

        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    protected ArrayList<String> getInputs() {
        return inputs;
    }

    public void writeReceiptToJSON(HttpServletRequest request) {

        AjaxCart ajax = new AjaxCart();

        HashMap<Product, Integer> cart = ajax.getCart(request).viewCart();

        JSONObject input = new JSONObject();
        input.put("First Name", request.getParameter("firstName"));
        input.put("Last Name", request.getParameter("lastName"));
        input.put("Address", request.getParameter("address"));
        input.put("City", request.getParameter("city"));
        input.put("Zip Code", request.getParameter("zipcode"));
        input.put("Country", request.getParameter("country"));
        input.put("E-mail", request.getParameter("mail"));
//        input.put("Payment Method", request.getParameter("firstName"));
        input.put("Message", request.getParameter("message"));

        JSONArray receipt = new JSONArray();
        receipt.add(input);
        receipt.add(cart);

        String path = request.getServletContext().getRealPath("/WEB-INF/receipts/receipt.json");
        
        try (PrintWriter file = new PrintWriter(new FileOutputStream(path, true))) {
            file.println(receipt.toJSONString());
            file.flush();
            System.out.println("wrote to " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
