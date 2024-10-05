package se.kth.distribuerad.labb1.DB.DAO;

import java.sql.Connection;

public class OrderDAO {

    private Connection con = null;

    public OrderDAO(Connection con) {
        this.con = con;
    }



}
