package se.kth.distribuerad.labb1.DB.DAO;

import se.kth.distribuerad.labb1.BO.Category;
import se.kth.distribuerad.labb1.BO.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ItemDAO {

    public static Item getItem(Connection connection, int id) throws SQLException {
        Item result = null;
        try {
            String query = "SELECT product_name, price, stock, category FROM products WHERE product_ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                Category category = Category.valueOf(resultSet.getString("category"));
                result = new Item(id, name, price, stock, category);
            }
            else System.out.println("No product found with id " + id);

        }
        catch (SQLException e) {e.printStackTrace();}
    return result;
    }

    public static Collection<Item> getItemsByCategory(Connection connection, Category category ){
        Collection<Item> collection = new ArrayList<>();

        try{
            String query = "SELECT product_ID, product_name, price, stock FROM products WHERE category = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.name());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("product_ID");
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                Item item = new Item(id, name, price, stock, category);
                collection.add(item);
            }
        }catch (SQLException e) {e.printStackTrace();}

        return collection;
    }


}

