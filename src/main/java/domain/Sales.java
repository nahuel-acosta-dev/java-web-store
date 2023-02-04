/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class Sales {
    
    private int idSales;
    private int product;
    private int user;
    private boolean state;
    private boolean delivery_status;
    private int quantity;
    private String date;
    

    public Sales() {
    }

    public Sales(int idSales) {
        this.idSales = idSales;
    }

    public Sales(int product, int user, boolean state, boolean delivery_status, int quantity, String date) {
        this.product = product;
        this.user = user;
        this.state = state;
        this.delivery_status = delivery_status;
        this.quantity = quantity;
        this.date = date;
    }

    public Sales(int idSales, int product, int user, boolean state, boolean delivery_status, int quantity, String date) {
        this.idSales = idSales;
        this.product = product;
        this.user = user;
        this.state = state;
        this.delivery_status = delivery_status;
        this.quantity = quantity;
        this.date = date;
    }

    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(boolean delivery_status) {
        this.delivery_status = delivery_status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sales{" + "idSales=" + idSales + ", product=" + product + ", user=" + user + ", state=" + state + ", delivery_status=" + delivery_status + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
}
