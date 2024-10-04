package se.kth.distribuerad.labb1.DB.DAO;

import se.kth.distribuerad.labb1.BO.Category;
import se.kth.distribuerad.labb1.BO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDAO{

    private Connection con = null;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public void addProduct(Product product)throws SQLException {

        String query = "INSERT INTO products (product_name, product_description, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getInStock());
            preparedStatement.executeUpdate();
            System.out.println("En ny produkt har lagts till.");
        }
    }

    public Product getProductByID(int id) throws SQLException {
        Product result = null;
        String query = "SELECT product_name, price, stock, category FROM products WHERE product_ID = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                Category category = Category.valueOf(resultSet.getString("category"));
                result = new Product(id, name, price, stock, category);
            }
            else System.out.println("No product found with id " + id);
        }
        catch (SQLException e) {e.printStackTrace();}
        return result;
    }

    public Collection<Product> getProductsByCategory(Category category ){
        Collection<Product> collection = new ArrayList<>();
        String query = "SELECT product_ID, product_name, price, stock FROM products WHERE category = ?";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1, category.name());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("product_ID");
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                Product product = new Product(id, name, price, stock, category);
                collection.add(product);
            }
        }catch (SQLException e) {e.printStackTrace();}

        return collection;
    }

    public Product getProductByName(String productName) throws SQLException{
        String query = "SELECT * FROM products WHERE product_name = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Product(
                        resultSet.getInt("product_ID"),
                        resultSet.getString("product_name"),
                        resultSet.getString("product_description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("stock"),
                        Category.valueOf(resultSet.getString("category"))
                );
            }
        }
        return null;
    }
    
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("product_ID"),
                        resultSet.getString("product_name"),
                        resultSet.getString("product_description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("stock"),
                        Category.valueOf(resultSet.getString("category"))
                ));
            }
        }
        return products;}

    
    public void updateProduct(Product product) throws SQLException{
        String query = "UPDATE products SET product_name = ?, product_description = ?, price = ?, stock = ? WHERE product_ID = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getInStock());
            preparedStatement.setInt(5, product.getProductID());
            preparedStatement.executeUpdate();
            System.out.println("Produkten har uppdaterats.");
        }
    }

    
    public void deleteProduct(String productName) throws SQLException{
        String query = "DELETE FROM products WHERE product_name = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            preparedStatement.executeUpdate();
            System.out.println("Produkten har tagits bort.");
        }
    }
}
