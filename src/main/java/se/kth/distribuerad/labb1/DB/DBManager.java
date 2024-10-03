package se.kth.distribuerad.labb1.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;
    private static DBManager getInstance(){
        if(instance==null)
            instance = new DBManager();
        return instance;
    }
    private DBManager(){
        try {
            Class.forName("").newInstance();
            Class.forName("se.kth").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labb1", "root","root");
        }catch(Exception e){e.printStackTrace();}
    }
    public static Connection getConnection(){
        return getInstance().con;
    }



}
