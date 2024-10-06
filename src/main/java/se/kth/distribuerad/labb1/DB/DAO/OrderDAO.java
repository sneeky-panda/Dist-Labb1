package se.kth.distribuerad.labb1.DB.DAO;

import java.sql.Connection;


public class OrderDAO {
    /**
     * Anslutningen till databasen som används för att utföra SQL-operationer.
     */
    private Connection con = null;
    /**
     * Skapar en ny instans av OrderDAO med en specifik databasanslutning.
     * @param con Databasanslutningen som ska användas för att utföra operationer på beställningstabellen.
     */
    public OrderDAO(Connection con) {
        this.con = con;
    }

}
