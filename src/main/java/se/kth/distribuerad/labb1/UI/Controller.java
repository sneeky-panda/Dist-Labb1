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
import se.kth.distribuerad.labb1.DB.DAO.UserDAO;
import se.kth.distribuerad.labb1.DB.DBConnection;
import se.kth.distribuerad.labb1.BO.Services.*;
/**
 * Controller-klassen hanterar användarförfrågningar som inloggning, utloggning, hantering av varukorgen och navigering.
 * Klassen använder sig av servlets för att kommunicera med frontend JSP-sidor och backend-tjänster.
 */
@WebServlet("/check-items")
public class Controller extends HttpServlet {

    //private String message;
    //private static Connection con;
    /**
     * Tjänst för att hantera produktrelaterade operationer.
     */
    private static ProductService productService;
    /**
     * Tjänst för att hantera användarrelaterade operationer.
     */
    private static UserService userService;


    /**
     * Statiskt block för att initiera tjänsterna med en databasanslutning
     */
    static {
        try {
            productService = new ProductService();
            userService = new UserService();
        } catch (SQLException e) {e.printStackTrace();}

    }
    /**
     * Init-metoden körs när servleten initieras.
     */
    public void init() {
        
    }

    /**
     * Hanterar GET-förfrågningar till servleten.
     * @param request  HTTP-förfrågan.
     * @param response HTTP-svaret.
     * @throws IOException Om ett fel inträffar vid kommunikation med klienten.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    /**
     * Hanterar POST-förfrågningar till servleten.
     * @param request  HTTP-förfrågan.
     * @param response HTTP-svaret.
     * @throws IOException Om ett fel inträffar vid kommunikation med klienten.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        doActionRequest(action, request, response);
    }
    /**
     * Utför åtgärder baserat på den angivna åtgärdsparametern (action).
     * Möjliga åtgärder inkluderar inloggning, utloggning, visning av varor, hantering av varukorg och registrering.
     *
     * @param action   Åtgärden som ska utföras.
     * @param request  HTTP-förfrågan.
     * @param response HTTP-svaret.
     * @throws IOException Om ett fel inträffar vid kommunikation med klienten.
     */
    private void doActionRequest(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing.");
            return;
        }
        switch(action){
            case "login": {
                UserDTO compUser = null;

                compUser = new UserDTO(request.getParameter("username"), request.getParameter("password"));
               UserDTO user = userService.getUserDAO(compUser.getEmail());
               if(user.getPassword().equals(compUser.getPassword())){
                   session.setAttribute("loggedInUser", user);
                   response.sendRedirect("index.jsp");
                }else{
                    response.sendRedirect("login.jsp?error=invalid");
                }
                break;
            }
            case "logout":{
                if(session != null){
                    session.setAttribute("loggedInUser", null);
                    session.setAttribute("cart", null);
                }
                response.sendRedirect("login.jsp");
                break;
            }
            case "scrollItems":{
                response.sendRedirect("items.jsp");
                break;
            }
            case "showCart":{
                response.sendRedirect("cart.jsp");
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
    /**
     * Hämtar ProductService-instansen.
     * @return Instansen av ProductService.
     */
    public static ProductService getProductService() {
        return productService;
    }
    /**
     * Hämtar UserService-instansen.
     * @return Instansen av UserService.
     */
    public static UserService getUserService(){
        return userService;
    }
    /**
     * Hämtar alla produkter från databasen.
     * @return En samling av ProductDTO-objekt som representerar alla produkter.
     */
    public static Collection<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    /**
     * Metoden körs när servleten förstörs.
     */
    public void destroy() {
    }
}