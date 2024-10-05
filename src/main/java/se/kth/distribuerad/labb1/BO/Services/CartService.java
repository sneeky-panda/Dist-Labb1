package se.kth.distribuerad.labb1.BO.Services;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;

public class CartService {

    public static void addToCart(HttpSession session, int productID){
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        if(cart == null){
            cart = new HashMap<>();
            cart.put(productID, 1);
        }
        else{
            if(cart.containsKey(productID)){
                cart.put(productID, cart.get(productID) + 1);
            }
            else{
                cart.put(productID, 1);
            }
        }
        session.setAttribute("cart", cart);
    }

    public static void removeFromCart(HttpSession session, int productID){
        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        if(cart != null){
            cart.remove(productID);
        }
        session.setAttribute("cart", cart);
    }



}
