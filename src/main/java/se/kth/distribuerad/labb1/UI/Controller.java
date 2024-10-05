package se.kth.distribuerad.labb1.UI;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import se.kth.distribuerad.labb1.BO.Cart;
import se.kth.distribuerad.labb1.BO.Product;
import se.kth.distribuerad.labb1.BO.Services.ProductService;
import se.kth.distribuerad.labb1.DB.DBConnection;

@WebServlet("/check-items")
public class Controller extends HttpServlet {

    private String message;
    private static Connection con;
    private static ProductService productService;



    static {
        try {
            con = DBConnection.getConnection();
            productService = new ProductService(con);
        } catch (SQLException e) {}

    }

    public void init() {
        
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        //Product item = getItemFromRequest(request);
    }

    public static Collection<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    public void destroy() {
    }
}