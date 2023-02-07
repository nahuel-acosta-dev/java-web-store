/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nahuel
 */
public class SalesDaoJDBC implements SalesDao {
    
    private static final String SQL_SELECT = "SELECT product, state, quantity FROM sales";
    private static final String SQL_SELECT_SALES_OF_THE_DAY = "SELECT product, state, quantity FROM sales" + 
            " WHERE date BETWEEN CURDATE() and CURDATE() + INTERVAL 1 DAY";
    private static final String SQL_SELECT_COUNT = "SELECT COUNT(id_sales)" + " FROM sales";
    private static final String SQL_SELECT_COUNT_OF_DAY = "SELECT COUNT(id_sales) FROM sales WHERE date "
            + "BETWEEN CURDATE() and CURDATE()" + " + INTERVAL 1 DAY";
    
    
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
