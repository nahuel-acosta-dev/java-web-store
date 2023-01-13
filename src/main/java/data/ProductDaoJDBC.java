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
public class ProductDaoJDBC {
    
    private static final String SQL_SELECT = "SELECT id_product, name, description, price, compare_price, category, quantity, date_created" + " FROM product";

                
    private static final String SQL_SELECT_BY_ID = "SELECT id_product, name, description, price, compare_price, category, quantity, date_created" + "FROM product WHERE id_product = ?";

    private static final String SQL_INSERT = "INSERT INTO product(name, description, price, compare_price, category, quantity, date_created) "
            + " VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE product "
            + " SET name=?, description = ?, price = ?, compare_price = ?, category = ?, quantity = ? WHERE id_product=?";

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
                String dateCreated = rs.getString("date_created");

                product = new Product(idProduct, name, description, price, compare_price, category, quantity,dateCreated);

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

}
