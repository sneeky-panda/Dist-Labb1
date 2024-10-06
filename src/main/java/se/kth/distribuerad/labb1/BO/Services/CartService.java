package se.kth.distribuerad.labb1.BO.Services;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * CartService hanterar logiken för varukorgen i webbutiken.
 * Klassen använder sessionshantering för att lagra och manipulera produkter i varukorgen för varje användare.
 */
public class CartService {

    /**
     * Lägger till en produkt i varukorgen baserat på produktens ID.
     * Om varukorgen inte existerar skapas den och produkten läggs till. Om produkten redan finns i varukorgen ökas kvantiteten med ett.
     *
     * @param session HttpSession-objektet som används för att hålla reda på varukorgen.
     * @param productID Produktens ID som ska läggas till i varukorgen.
     */
    public static void addToCart(HttpSession session, int productID) {
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            cart.put(productID, 1);
        } else {
            if (cart.containsKey(productID)) {
                cart.put(productID, cart.get(productID) + 1);
            } else {
                cart.put(productID, 1);
            }
        }
        session.setAttribute("cart", cart);
    }

    /**
     * Tar bort en produkt från varukorgen baserat på produktens ID.
     * Om varukorgen inte existerar händer ingenting. Om produkten finns i varukorgen tas den bort.
     *
     * @param session HttpSession-objektet som används för att hålla reda på varukorgen.
     * @param productID Produktens ID som ska tas bort från varukorgen.
     */
    public static void removeFromCart(HttpSession session, int productID) {
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        if (cart != null) {
            cart.remove(productID);
        }
        session.setAttribute("cart", cart);
    }
}
