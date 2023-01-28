/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import domain.Gender;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nahuel
 */
public interface GenderDao {
    
    public List<Gender> select() throws SQLException;
}
