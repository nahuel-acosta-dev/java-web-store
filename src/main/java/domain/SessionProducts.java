/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;

/**
 *
 * @author Nahuel
 */
public class SessionProducts {
    private List<Product> products;
    private int sections;
    
    public SessionProducts(){}

    public SessionProducts(List<Product> products, int sections) {
        this.products = products;
        this.sections = sections;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "SessionProducts{" + "products=" + products + ", sections=" + sections + '}';
    }
    
}
