/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.Admin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public interface AdminDao {
    
    public List<Admin> select() throws SQLException;
    public Admin select_by_id(Admin admin) throws SQLException;
    public int insert(Admin admin) throws SQLException;
    public int update(Admin admin) throws SQLException;
    public int delete(Admin admin) throws SQLException;
}
