package se.kth.distribuerad.labb1.DB.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    private Connection con = null;

    public ProductDAOImpl(Connection con) {
        this.con = con;
    }
    @Override
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

    @Override
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
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")
                );
            }
        }
        return null;
    }

    @Override
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
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")
                ));
            }
        }
        return products;}

    @Override
    public void updateProduct(String productName) {

    }

    @Override
    public void deleteProduct(String productName) {

    }
}
