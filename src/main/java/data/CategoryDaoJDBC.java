/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import domain.Category;
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
public class CategoryDaoJDBC implements CategoryDao{
    
    private static final String SQL_SELECT = "SELECT id_category, name" + " FROM category";
    
    public List<Category> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Category category = null;
        List<Category> categories = new ArrayList<>();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("id_category");
                String name = rs.getString("name");

                category = new Category(idCategory, name);

                categories.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
        }

        return categories;
    }
    
}
