package se.kth.distribuerad.labb1.BO.Services;

import se.kth.distribuerad.labb1.BO.Product;
import se.kth.distribuerad.labb1.DB.DAO.ProductDAO;
import se.kth.distribuerad.labb1.UI.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(Connection con) {
        this.productDAO = new ProductDAO(con);
    }

    public ProductDTO getProductDTO(int id) {
        ProductDTO product = null;
        try {
            return productDAO.getProductByID(id).makeDTO();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Collection<ProductDTO> getAllProducts() {
        Collection<ProductDTO> products = null;
        try {
            return productDAO.getAllProducts().stream().map(Product::makeDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
