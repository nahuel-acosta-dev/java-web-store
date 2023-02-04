/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.User;
import java.sql.SQLException;

/**
 *
 * @author Nahuel
 */
public interface UserDao {
    public User select_by_id(User user) throws SQLException;
}
