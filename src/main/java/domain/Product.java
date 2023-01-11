/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class Product {
    private int idProduct;
    private String name;
    private String description;
    private double price;
    private double compare_price; 
    private int category;
    private int quantity; 
    private String date;

    public Product() {
    }

    public Product(int idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String name, String description, double price, double compare_price, int category, int quantity, String date) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.compare_price = compare_price;
        this.category = category;
        this.quantity = quantity;
        this.date = date;
    }

    public Product(int idProduct, String name, String description, double price, double compare_price, int category, int quantity, String date) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.compare_price = compare_price;
        this.category = category;
        this.quantity = quantity;
        this.date = date;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCompare_price() {
        return compare_price;
    }

    public void setCompare_price(double compare_price) {
        this.compare_price = compare_price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price=" + price + ", compare_price=" + compare_price + ", category=" + category + ", quantity=" + quantity + ", date=" + date + '}';
    }
    
}
