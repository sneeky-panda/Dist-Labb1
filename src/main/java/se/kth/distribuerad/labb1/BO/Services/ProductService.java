package se.kth.distribuerad.labb1.BO.Services;

import se.kth.distribuerad.labb1.BO.Product;
import se.kth.distribuerad.labb1.DB.DAO.ProductDAO;
import se.kth.distribuerad.labb1.UI.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * ProductService hanterar logiken relaterad till produkter.
 * Den fungerar som en brygga mellan databasen och presentationslagret, vilket gör det möjligt att hämta och manipulera produktinformation.
 */
public class ProductService {

    /**
     * Dataåtkomstobjekt (DAO) för produkter som möjliggör interaktion med databasen.
     */
    private ProductDAO productDAO;

    /**
     * Skapar en ny instans av ProductService och initierar DAO med en databasanslutning.
     *
     * @param con Databasanslutningen som används för att kommunicera med produktdatabasen.
     */
    public ProductService(Connection con) {
        this.productDAO = new ProductDAO(con);
    }

    /**
     * Hämtar en specifik produkt baserat på dess ID och omvandlar den till en DTO.
     *
     * @param id Produktens unika ID.
     * @return En ProductDTO av den produkten om den hittar, annars returneras null.
     */
    public ProductDTO getProductDTO(int id) {
        ProductDTO product = null;
        try {
            return productDAO.getProductByID(id).makeDTO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    /**
     * Hämtar alla produkter från databasen och omvandlar dem till en lista av DTO.
     *
     * @return En lista av ProductDTO av alla produkter i databasen, eller null om ett fel inträffar.
     */
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
