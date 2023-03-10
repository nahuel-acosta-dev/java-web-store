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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public class ProductDaoJDBC implements ProductDao {
    
    private static final String SQL_SELECT = "SELECT id_product, name, description, price, compare_price, category, quantity, sold, date_created, gender" + " FROM product";

    private static final String SQL_SELECT_LIMIT = "SELECT id_product, name, description, price, compare_price, category, quantity, sold, date_created, gender" + " FROM product LIMIT ?, ?";
    
    private static final String SQL_SELECT_COUNT = "SELECT COUNT(id_product)" + " FROM product";
    
                
    private static final String SQL_SELECT_BY_ID = "SELECT id_product, name, description, price, compare_price, category, quantity, sold, date_created, gender " + " FROM product WHERE id_product = ?";

    private static final String SQL_INSERT = "INSERT INTO product(name, description, price, compare_price, category, quantity, sold, date_created, gender) " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE product "
            + " SET name=?, description = ?, price = ?, compare_price = ?, category = ?, quantity = ?, sold = ?, gender = ? WHERE id_product=?";
    
    private static final String SQL_DELETE = "DELETE FROM product WHERE id_product = ?";
    
    public List<Product> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                double compare_price = rs.getDouble("compare_price");
                int category = rs.getInt("category");
                int quantity = rs.getInt("quantity");
                int sold = rs.getInt("sold");
                String dateCreated = rs.getString("date_created");
                int gender = rs.getInt("gender");

                product = new Product(idProduct, name, description, price, compare_price, category, quantity, sold, dateCreated, gender);

                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return products;
    }
    
    public List<Product> select_limit(int offset, int count) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_LIMIT);
            stmt.setInt(1, offset);
            stmt.setInt(2, count);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                double compare_price = rs.getDouble("compare_price");
                int category = rs.getInt("category");
                int quantity = rs.getInt("quantity");
                int sold = rs.getInt("sold");
                String dateCreated = rs.getString("date_created");
                int gender = rs.getInt("gender");

                product = new Product(idProduct, name, description, price, compare_price, category, quantity, sold, dateCreated, gender);

                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return products;
    }
    
    
    public int select_count() throws SQLException {
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
    }
    
    public Product select_by_id(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, product.getIdProduct());
            rs = stmt.executeQuery();
            //rs.absolute(1);//nos posicionamos en el primer registro
            
            
            while(rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                double comparePrice = rs.getDouble("compare_price");
                int category = rs.getInt("category");
                int quantity = rs.getInt("quantity");
                int sold = rs.getInt("sold");
                String dateCreated = rs.getString("date_created");
                int gender = rs.getInt("gender");
                
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                product.setComparePrice(comparePrice);
                product.setCategory(category);
                product.setQuantity(quantity);
                product.setSold(sold);
                product.setDateCreated(dateCreated);
                product.setGender(gender);
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("ERROR EN PRODUCT DAO");
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }
        
        return product;
    }
    
    public int insert(Product product){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getComparePrice());
            stmt.setInt(5, product.getCategory());
            stmt.setInt(6, product.getQuantity());
            stmt.setInt(7, product.getSold());
            stmt.setString(8, product.getDateCreated());
            stmt.setInt(9, product.getGender());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
    }
    
    public int update(Product product){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        System.out.println("ESTE ES EL PRODUCTO: " + product
        );
        
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getComparePrice());
            stmt.setInt(5, product.getCategory());
            stmt.setInt(6, product.getQuantity());
            stmt.setInt(7, product.getSold());
            stmt.setInt(8, product.getGender());
            stmt.setInt(9, product.getIdProduct());
            
            rows = stmt.executeUpdate();
            
            System.out.println("EXITO AL ACTUALIZAR PRODUCTO");
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("FALLO AL ACTUALIZAR PRODUCTO");
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
        
    }
    
    public int delete(Product product)throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, product.getIdProduct());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return rows;
    }

}
