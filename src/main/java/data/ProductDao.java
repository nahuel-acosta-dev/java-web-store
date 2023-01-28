/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public interface ProductDao {
    public List<Product> select() throws SQLException;
    public List<Product> select_limit(int offset, int count) throws SQLException;
    public int select_count() throws SQLException;
    public Product select_by_id(Product product) throws SQLException;
    public int insert(Product product) throws SQLException;
    public int update(Product product) throws SQLException;
    public int delete(Product product) throws SQLException;
}
