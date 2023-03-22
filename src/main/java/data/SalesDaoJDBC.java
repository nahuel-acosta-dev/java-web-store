/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Sales;
import domain.SalesExtends;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public class SalesDaoJDBC implements SalesDao {
    
    private static final String SQL_SELECT = "SELECT product, state, quantity FROM sales";
    private static final String SQL_SELECT_LIMIT = "SELECT * FROM sales ORDER BY date DESC LIMIT ?";
    
    private static final String SQL_SELECT_MAX_LIMIT_JOIN = "SELECT s.id_sales, s.product, s.user, s.state, " + 
            "s.delivery_status, s.quantity, s.date, u.email, u.phone, u.first_name, " + 
            "u.last_name, u.address_line_1, " + "u.address_line_2, u.city, u.state_province_region, u.zipcode, " + 
            "p.name, p.description, " + "p.price, p.compare_price, p.category, p.sold " + "FROM sales s " + 
            "INNER JOIN user u ON s.user = u.id_user INNER JOIN product p " +
            "ON s.product = p.id_product ORDER BY date DESC LIMIT ?"; 
    
    private static final String SQL_SELECT_LIMIT_JOIN = "SELECT s.id_sales, s.product, s.user, s.state, " + 
            "s.delivery_status, s.quantity, s.date, u.email, u.phone, u.first_name, " + 
            "u.last_name, u.address_line_1, " + "u.address_line_2, u.city, u.state_province_region, u.zipcode, " + 
            "p.name, p.description, " + "p.price, p.compare_price, p.category, p.sold " + "FROM sales s " + 
            "INNER JOIN user u ON s.user = u.id_user INNER JOIN product p " +
            "ON s.product = p.id_product ORDER BY date DESC LIMIT ?, ?"; 
    
    private static final String SQL_SELECT_SALES_OF_THE_DAY = "SELECT product, state, quantity FROM sales" + 
            " WHERE date BETWEEN CURDATE() and CURDATE() + INTERVAL 1 DAY";
    private static final String SQL_SELECT_COUNT = "SELECT COUNT(id_sales)" + " FROM sales";
    private static final String SQL_SELECT_COUNT_OF_DAY = "SELECT COUNT(id_sales) FROM sales WHERE date "
            + "BETWEEN CURDATE() and CURDATE()" + " + INTERVAL 1 DAY";
    
    
    public List<SalesExtends> select_max_limit(int limit) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SalesExtends sale = null;
        List<SalesExtends> sales = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MAX_LIMIT_JOIN);
            stmt.setInt(1, limit);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idSales = rs.getInt("id_sales");
                int product = rs.getInt("product");
                int user = rs.getInt("user");
                boolean state = rs.getBoolean("state");
                boolean delivery_status = rs.getBoolean("delivery_status");
                int quantity = rs.getInt("quantity");
                String date = rs.getString("date");
                
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int sold = rs.getInt("sold");

                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String addressLine1 = rs.getString("address_line_1");
                String addressLine2 = rs.getString("address_line_2");
                String city = rs.getString("city");
                String stateProvinceRegion = rs.getString("state_province_region");
                String zipcode = rs.getString("zipcode");
                

                sale = new SalesExtends(idSales, product, user, state, delivery_status, quantity, date,
                name, description, price, sold, email, phone, firstName, lastName, addressLine1, addressLine2,
                city, stateProvinceRegion, zipcode);

                sales.add(sale);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return sales;
    }
    
    public List<SalesExtends> select_limit(int offset, int count) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SalesExtends sale = null;
        List<SalesExtends> sales = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_LIMIT_JOIN);
            stmt.setInt(1, offset);
            stmt.setInt(2, count);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idSales = rs.getInt("id_sales");
                int product = rs.getInt("product");
                int user = rs.getInt("user");
                boolean state = rs.getBoolean("state");
                boolean delivery_status = rs.getBoolean("delivery_status");
                int quantity = rs.getInt("quantity");
                String date = rs.getString("date");
                
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int sold = rs.getInt("sold");

                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String addressLine1 = rs.getString("address_line_1");
                String addressLine2 = rs.getString("address_line_2");
                String city = rs.getString("city");
                String stateProvinceRegion = rs.getString("state_province_region");
                String zipcode = rs.getString("zipcode");
                

                sale = new SalesExtends(idSales, product, user, state, delivery_status, quantity, date,
                name, description, price, sold, email, phone, firstName, lastName, addressLine1, addressLine2,
                city, stateProvinceRegion, zipcode);

                sales.add(sale);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return sales;
    }
    
    
    public double select_all_entries() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double entries = 0;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idProduct = rs.getInt("product");
                boolean state = rs.getBoolean("state");
                int quantity = rs.getInt("quantity");

                Product product = new ProductDaoJDBC().select_by_id(new Product(idProduct));
                
                if(state == true){
                    entries += (product.getPrice() * quantity);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }
        
        return entries;
    }
    
    
    public double select_entries_of_the_day() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double entries = 0;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SALES_OF_THE_DAY);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idProduct = rs.getInt("product");
                boolean state = rs.getBoolean("state");
                int quantity = rs.getInt("quantity");

                Product product = new ProductDaoJDBC().select_by_id(new Product(idProduct));
                if(state == true){
                    entries += (product.getPrice() * quantity);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }
        
        return entries;
    }
    
    public int select_count() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int rows = 0;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_COUNT);
            rs = stmt.executeQuery();

            while(rs.next()){
                rows = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
    };
    
    public int select_count_of_day() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int rows = 0;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_COUNT_OF_DAY);
            rs = stmt.executeQuery();

            while(rs.next()){
                rows = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
    }
}
