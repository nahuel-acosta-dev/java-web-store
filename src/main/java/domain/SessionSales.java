/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Nahuel
 */
public class SessionSales {
    private int salesOfTheDay;
    private double earningsOfTheDay;
    private int totalSales;
    private double totalEarnings;

    public SessionSales() {
    }

    public SessionSales(int salesOfTheDay, double earningsOfTheDay, int totalSales, double totalEarnings) {
        this.salesOfTheDay = salesOfTheDay;
        this.earningsOfTheDay = earningsOfTheDay;
        this.totalSales = totalSales;
        this.totalEarnings = totalEarnings;
    }

    public int getSalesOfTheDay() {
        return salesOfTheDay;
    }

    public void setSalesOfTheDay(int salesOfTheDay) {
        this.salesOfTheDay = salesOfTheDay;
    }

    public double getEarningsOfTheDay() {
        return earningsOfTheDay;
    }

    public void setEarningsOfTheDay(double earningsOfTheDay) {
        this.earningsOfTheDay = earningsOfTheDay;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    @Override
    public String toString() {
        return "SessionSales{" + "salesOfTheDay=" + salesOfTheDay + ", earningsOfTheDay=" + earningsOfTheDay + ", totalSales=" + totalSales + ", totalEarnings=" + totalEarnings + '}';
    }

    
    
    
    
}
