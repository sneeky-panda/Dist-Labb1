package se.kth.distribuerad.labb1.UI;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import se.kth.distribuerad.labb1.BO.Cart;
import se.kth.distribuerad.labb1.BO.Product;
import se.kth.distribuerad.labb1.BO.Services.CartService;
import se.kth.distribuerad.labb1.BO.*;
import se.kth.distribuerad.labb1.DB.DBConnection;
import se.kth.distribuerad.labb1.BO.Services.*;

@WebServlet("/check-items")
public class Controller extends HttpServlet {

    private String message;
    private static Connection con;
    private static ProductService productService;



    static {
        try {
            con = DBConnection.getConnection();
            productService = new ProductService(con);
        } catch (SQLException e) {e.printStackTrace();}

    }

    public void init() {
        
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        doActionRequest(action, request, response);
    }

    private void doActionRequest(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing.");
            return;
        }
//user.getPassword().equals(compUser.getPassword())
        switch(action){
            case "login": {
                System.out.println("Logging in");
                UserDTO user =null;
                user = new UserDTO(request.getParameter("username"), request.getParameter("password"));
                UserDTO compUser = UserService.getUserDAO(user.getEmail());
                if(true){
                    response.sendRedirect("target/Labb1-1.0-SNAPSHOT/cart.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
                break;
            }
            case "logout":{
                System.out.println("Logging out");
                break;
            }
            case"register":{
                System.out.println("Regestring");
                break;
            }
            case "cartAdd" :{
                int productId = Integer.parseInt(request.getParameter("productID"));
                CartService.addToCart(session, productId);
                response.sendRedirect("items.jsp");
                break;
            }

            case "cartRemove":{
                int productID = Integer.parseInt(request.getParameter("productID"));
                CartService.removeFromCart(session, productID);
                response.sendRedirect("cart.jsp");

                break;
            }

            case "cartClear" : {
                request.getSession().setAttribute("cart", null);
                response.sendRedirect("cart.jsp");
                break;
            }

        }
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static Collection<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }


    public void destroy() {
    }
}