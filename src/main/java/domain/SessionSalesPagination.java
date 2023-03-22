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
public class SessionSalesPagination {
    private List<SalesExtends> sales;
    private int sections;
    
    public SessionSalesPagination(){}

    public SessionSalesPagination(List<SalesExtends> sales, int sections) {
        this.sales = sales;
        this.sections = sections;
    }

    public List<SalesExtends> getProducts() {
        return sales;
    }

    public void setProducts(List<SalesExtends> sales) {
        this.sales = sales;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "SessionProducts{" + "sales=" + sales + ", sections=" + sections + '}';
    }
}
