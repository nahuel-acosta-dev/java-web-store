/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public interface CategoryDao {
    public List<Category> select() throws SQLException;
}
