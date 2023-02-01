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
    private double comparePrice; 
    private int category;
    private int quantity;
    private int sold;
    private String dateCreated;
    private int gender;

    public Product() {
    }

    public Product(int idProduct) {
        this.idProduct = idProduct;
    }
    
    public Product(int idProduct ,String name, String description, double price, double comparePrice, int category, int quantity, int sold,  int gender) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.comparePrice = comparePrice;
        this.category = category;
        this.quantity = quantity;
        this.sold = sold;
        this.gender = gender;
    }

    public Product(String name, String description, double price, double comparePrice, int category, int quantity, int sold, String dateCreated, int gender) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.comparePrice = comparePrice;
        this.category = category;
        this.quantity = quantity;
        this.dateCreated = dateCreated;
        this.sold = sold;
        this.gender = gender;
    }

    public Product(int idProduct, String name, String description, double price, double comparePrice, int category, int quantity, int sold, String dateCreated, int gender) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.comparePrice = comparePrice;
        this.category = category;
        this.quantity = quantity;
        this.dateCreated = dateCreated;
        this.sold = sold;
        this.gender = gender;
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

    public double getComparePrice() {
        return comparePrice;
    }

    public void setComparePrice(double comparePrice) {
        this.comparePrice = comparePrice;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price=" + price + ", comparePrice=" + comparePrice + ", category=" + category + ", quantity=" + quantity + ", sold=" + sold + ", dateCreated=" + dateCreated + ", gender=" + gender + '}';
    }
    
   
    
}
