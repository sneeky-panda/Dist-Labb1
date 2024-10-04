package se.kth.distribuerad.labb1.BO;

import java.util.Date;

public class Order {
    private int orderID;
    private int userID;
    private Date date;
    private int total_price;
    private Status status;

    public Order(int orderID, int userID, Date date, int total_price, Status status) {
        this.orderID = orderID;
        this.userID = userID;
        this.date = date;
        this.total_price = total_price;
        this.status = status;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
