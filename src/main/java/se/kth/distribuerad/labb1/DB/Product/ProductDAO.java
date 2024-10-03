package se.kth.distribuerad.labb1.DB.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void addProduct(Product product) throws SQLException;
    Product getProductByName(String product_name) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
    void updateProduct(String product_name);
    void deleteProduct(String product_name);

}
